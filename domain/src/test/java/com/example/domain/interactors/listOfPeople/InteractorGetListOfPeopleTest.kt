package com.example.domain.interactors.listOfPeople

import com.example.domain.models.UserModelDomain
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

class InteractorGetListOfPeopleTest {

    private lateinit var useCase: EventsUseCase
    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetListOfPeopleImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubData = listOf(
        UserModelDomain(
            id = "0",
            nameSurname = "0",
            city = "0",
            listOfTags = listOf(),
            description = "0",
            imageURL = "0",
            listOfSocialMedia = listOf(),
            userEventsList = listOf(),
            userCommunitiesList = listOf(),
        ),
        UserModelDomain(
            id = "1",
            nameSurname = "1",
            city = "1",
            listOfTags = listOf(),
            description = "1",
            imageURL = "1",
            listOfSocialMedia = listOf(),
            userEventsList = listOf(),
            userCommunitiesList = listOf(),
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
    fun `invoke should return list of people from network repository`() = runTest {

        whenever(useCase.observeListOfPeople()).thenReturn(flowOf(Unit))
        whenever(networkRepository.getListOfPeople()).thenReturn(flowOf(stubData))

        systemUnderTest = InteractorGetListOfPeopleImpl(useCase, networkRepository)

        val result = systemUnderTest.invoke().first()

        verify(useCase).observeListOfPeople()
        verify(networkRepository).getListOfPeople()
        assertEquals(stubData, result)
    }
}