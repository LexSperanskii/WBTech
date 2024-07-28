package com.example.domain.usecases.events

import com.example.domain.stabRepositories.EventRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class GetMyEventsPastListUseCaseTest {

    @Test
    fun `return correct my events past list`() = runTest{

        val eventRepositoryStub = EventRepositoryStub()

        val useCase = GetMyEventsPastListInteractor(eventRepository = eventRepositoryStub)

        val eventsMyPast = useCase.execute().first()

        eventsMyPast.forEach { event ->
            assertTrue(event.isFinished)
        }
    }

}