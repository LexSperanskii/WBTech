package com.example.domain.interactors.eventDescrption

import com.example.domain.interactors.eventDescription.InteractorGetEventDescriptionImpl
import com.example.domain.models.CommunityModelDomain
import com.example.domain.models.EventDescriptionModelDomain
import com.example.domain.models.EventLocationModelDomain
import com.example.domain.models.MetroModelDomain
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

class InteractorGetEventDescriptionTest {

    private lateinit var useCase: EventsUseCase
    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetEventDescriptionImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubId = "0"
    private val stubData = EventDescriptionModelDomain(
        id = "0",
        name = "0",
        time = "0",
        day = 0,
        month = "0",
        year = 0,
        city = "",
        street = "",
        building = "",
        imageURL = "0",
        listOfTags = listOf(),
        description = "0",
        pitcher = UserModelDomain(),
        location = EventLocationModelDomain(),
        metroStation = MetroModelDomain(),
        listOfParticipants = listOf(),
        organizer = CommunityModelDomain(),
        availableCapacity = 5,
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
    fun `invoke should return Event Description by id from network repository`() = runTest {

        whenever(useCase.observeEventId()).thenReturn(flowOf(stubId))
        whenever(networkRepository.getEventDescription(stubId)).thenReturn(flowOf(stubData))

        systemUnderTest = InteractorGetEventDescriptionImpl(useCase, networkRepository)

        val result = systemUnderTest.invoke().first()

        verify(useCase).observeEventId()
        verify(networkRepository).getEventDescription(stubId)
        assertEquals(stubData, result)
    }
}