package com.example.domain.usecases.events

import com.example.domain.stabRepositories.EventRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class GetAllEventsActiveUseCaseTest {
    @Test
    fun `return correct events active list`() = runTest{

        val eventRepositoryStub = EventRepositoryStub()

        val useCase = GetAllEventsActiveInteractor(eventRepository = eventRepositoryStub)

        val eventsAllActive = useCase.execute().first()

        eventsAllActive.forEach { event ->
            assertTrue(!event.isFinished)
        }
    }
}