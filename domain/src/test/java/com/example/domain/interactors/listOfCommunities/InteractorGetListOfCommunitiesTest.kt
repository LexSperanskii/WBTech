package com.example.domain.interactors.listOfCommunities

import com.example.domain.models.CommunityModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.whenever

class InteractorGetListOfCommunitiesTest {

    private lateinit var useCase: EventsUseCase
    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetListOfCommunitiesImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubData = listOf(
        CommunityModelDomain(
            id = "0",
            name = "0",
            description = "0",
            imageURL = "0"
        ),
        CommunityModelDomain(
            id = "1",
            name = "1",
            description = "1",
            imageURL = "1"
        )
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        useCase = mock()
        networkRepository = mock()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun reset() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `invoke should return list of communities from network repository`() = runTest {

        whenever(useCase.observeListOfCommunities()).thenReturn(flowOf(Unit))
        whenever(networkRepository.getListOfCommunities()).thenReturn(flowOf(stubData))

        systemUnderTest = InteractorGetListOfCommunitiesImpl(useCase, networkRepository)

        val result = systemUnderTest.invoke().first()

        verify(useCase).observeListOfCommunities()
        verify(networkRepository).getListOfCommunities()
        assertEquals(stubData, result)
    }
}