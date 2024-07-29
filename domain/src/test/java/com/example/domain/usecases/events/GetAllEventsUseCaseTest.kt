package com.example.domain.usecases.events

import com.example.domain.models.Event
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
    fun setUp() = runTest {
        eventRepositoryStub = EventRepositoryStub()
        useCase = GetAllEventsUseCaseImpl(eventRepository = eventRepositoryStub)
        eventsAll = useCase.execute().first()
    }

    @Test
    fun `events id are unique`() {
        assertTrue(eventsAll.distinctBy { it.id }.size == eventsAll.size)
    }

    @Test
    fun `all events have not blank names`() {
        eventsAll.forEach { event ->
            assertTrue(event.name.isNotBlank())
        }
    }
}