package com.example.domain.usecases.events

import com.example.domain.models.Event
import com.example.domain.stabRepositories.EventRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetAllEventsActiveUseCaseTest {

    private lateinit var eventRepositoryStub: EventRepositoryStub
    private lateinit var useCase: GetAllEventsActiveInteractor
    private lateinit var eventsAllActive: List<Event>

    @Before
    fun setUp() = runTest {
        eventRepositoryStub = EventRepositoryStub()
        useCase = GetAllEventsActiveInteractor(eventRepository = eventRepositoryStub)
        eventsAllActive = useCase.execute().first()
    }

    @Test
    fun `events id are unique`() {
        assertTrue(eventsAllActive.distinctBy { it.id }.size == eventsAllActive.size)
    }

    @Test
    fun `all events have not blank names`() {
        eventsAllActive.forEach { event ->
            assertTrue(event.name.isNotBlank())
        }
    }

    @Test
    fun `all events are Active`() {
        eventsAllActive.forEach { event ->
            assertTrue(!event.isFinished)
        }
    }
}