package com.example.domain.interactors.communityDescription

import com.example.domain.interactors.communitiesDescription.InteractorGetCommunitiesDescriptionImpl
import com.example.domain.models.CommunityDescriptionModelDomain
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

class InteractorGetCommunitiesDescriptionTest {

    private lateinit var useCase: EventsUseCase
    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetCommunitiesDescriptionImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubId = "0"
    private val stubData = CommunityDescriptionModelDomain(
        id = "0",
        name = "0",
        description = "0",
        imageURL = "0",
        listOfTags = listOf(),
        listOfParticipants = listOf(),
        listOfEvents = listOf(),
        listOfPastEvents = listOf()
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
    fun `invoke should return Community Description by id from network repository`() = runTest {

        whenever(useCase.observeCommunityId()).thenReturn(flowOf(stubId))
        whenever(networkRepository.getCommunityDescription(stubId)).thenReturn(flowOf(stubData))

        systemUnderTest = InteractorGetCommunitiesDescriptionImpl(useCase, networkRepository)

        val result = systemUnderTest.invoke().first()

        verify(useCase).observeCommunityId()
        verify(networkRepository).getCommunityDescription(stubId)
        assertEquals(stubData, result)
    }
}