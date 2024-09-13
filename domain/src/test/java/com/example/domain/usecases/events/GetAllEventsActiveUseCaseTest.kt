package com.example.domain.usecases.events

import com.example.domain.stabRepositories.EventRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetAllEventsActiveUseCaseTest {

    private lateinit var eventRepositoryStub: EventRepositoryStub
    private lateinit var useCase: GetAllEventsActiveUseCaseImpl
    private lateinit var eventsAllActive: List<Event>

    @Before
    fun setUp() {
        eventRepositoryStub = EventRepositoryStub()
        useCase = GetAllEventsActiveUseCaseImpl(eventRepository = eventRepositoryStub)
    }

    @Test
    fun `events id are unique`() = runTest {
        eventsAllActive = useCase.execute().first()
        val result = eventsAllActive.distinctBy { it.id }.size
        val expectedResult = eventsAllActive.size

        assertTrue(result == expectedResult)
    }

    @Test
    fun `all events have not blank names`() = runTest {
        eventsAllActive = useCase.execute().first()
        eventsAllActive.forEach { event ->
            val result = event.name

            assertTrue(result.isNotBlank())
        }
    }

    @Test
    fun `all events are Active`() = runTest {
        eventsAllActive = useCase.execute().first()
        eventsAllActive.forEach { event ->
            val result = event.isFinished

            assertFalse(result)
        }
    }
}