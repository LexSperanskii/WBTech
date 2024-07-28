package com.example.domain.usecases.events

import com.example.domain.models.Event
import com.example.domain.stabRepositories.EventRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class GetMyEventsPastListUseCaseTest {

    private lateinit var eventRepositoryStub: EventRepositoryStub
    private lateinit var useCase: GetMyEventsPastListInteractor
    private lateinit var eventsMyPast: List<Event>

    @Before
    fun setUp() = runTest {
        eventRepositoryStub = EventRepositoryStub()
        useCase = GetMyEventsPastListInteractor(eventRepository = eventRepositoryStub)
        eventsMyPast = useCase.execute().first()
    }

    @Test
    fun `my events past id are unique`() {
        assertTrue(eventsMyPast.distinctBy { it.id }.size == eventsMyPast.size)
    }

    @Test
    fun `all my events have not blank names`() {
        eventsMyPast.forEach { event ->
            assertTrue(event.name.isNotBlank())
        }
    }

    @Test
    fun `all my events Past`() {
        eventsMyPast.forEach { event ->
            assertTrue(event.isFinished)
        }
    }
}