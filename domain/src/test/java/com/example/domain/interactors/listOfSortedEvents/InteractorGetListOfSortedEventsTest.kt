package com.example.domain.interactors.listOfSortedEvents

import com.example.domain.models.EventModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.drop
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
import org.mockito.Mockito.never
import org.mockito.Mockito.verify
import org.mockito.kotlin.whenever

class InteractorGetListOfSortedEventsTest {

    private lateinit var useCase: EventsUseCase
    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetListOfSortedEventsImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubSearch = "search"
    private val stubData = listOf(
        EventModelDomain(
            id = "0",
            name = "QA Talks - Global tech forum",
            time = "13:00",
            day = 1,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Невский проспект",
            building = "11",
            imageURL = "https://i.pinimg.com/736x/e5/3b/90/e53b900fe55028bd1305716aaac3602d.jpg",
            listOfTags = listOf(
                "Тестирование", "Разработка", "BackEnd", "Гачи"
            )
        ),
        EventModelDomain(
            id = "1",
            name = "Python days 2024",
            time = "14:00",
            day = 2,
            month = "января",
            year = 2024,
            city = "Санкт-Петербург",
            street = "Инженерная улица",
            building = "10А",
            imageURL = "https://i.pinimg.com/564x/e0/59/1d/e0591de77b707dbac61e29394b725ff4.jpg",
            listOfTags = listOf("Тестирование", "Разработка")
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
    fun `invoke should return empty list of Sorted Events from network repository before emitting search`() =
        runTest {

            whenever(useCase.observeUserSearch()).thenReturn(flowOf(stubSearch))
            whenever(networkRepository.getListOfSortedEvents(stubSearch)).thenReturn(flowOf(stubData))

            systemUnderTest = InteractorGetListOfSortedEventsImpl(useCase, networkRepository)

            val result = systemUnderTest.invoke().first()

            verify(useCase).observeUserSearch()
            verify(networkRepository, never()).getListOfSortedEvents(stubSearch)
            assertEquals(emptyList<EventModelDomain>(), result)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `invoke should return list of Sorted Events from network repository after emitting search`() =
        runTest {

            whenever(useCase.observeUserSearch()).thenReturn(flowOf(stubSearch))
            whenever(networkRepository.getListOfSortedEvents(stubSearch)).thenReturn(flowOf(stubData))

            systemUnderTest = InteractorGetListOfSortedEventsImpl(useCase, networkRepository)

            val result = systemUnderTest.invoke().drop(1).first()

            verify(networkRepository).getListOfSortedEvents(stubSearch)
            assertEquals(stubData, result)
        }
}