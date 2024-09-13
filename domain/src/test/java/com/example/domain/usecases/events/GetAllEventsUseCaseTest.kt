package com.example.domain.usecases.events

import com.example.domain.stabRepositories.EventRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetAllEventsUseCaseTest {

    private lateinit var eventRepositoryStub: EventRepositoryStub
    private lateinit var useCase: GetAllEventsUseCaseImpl
    private lateinit var eventsAll: List<Event>

    @Before
    fun setUp() {
        eventRepositoryStub = EventRepositoryStub()
        useCase = GetAllEventsUseCaseImpl(eventRepository = eventRepositoryStub)
    }

    @Test
    fun `events id are unique`() = runTest {
        eventsAll = useCase.execute().first()
        val result = eventsAll.distinctBy { it.id }.size
        val expectedResult = eventsAll.size

        assertTrue(result == expectedResult)
    }

    @Test
    fun `all events have not blank names`() = runTest {
        eventsAll = useCase.execute().first()
        eventsAll.forEach { event ->
            val result = event.name

            assertTrue(result.isNotBlank())
        }
    }
}