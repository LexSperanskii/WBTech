package com.example.domain.usecases.events

import com.example.domain.stabRepositories.EventRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class GetAllEventsUseCaseTest {

    @Test
    fun `return correct all events list`() = runTest{

        val eventRepositoryStub = EventRepositoryStub()

        val useCase = GetAllEventsInteractor(eventRepository = eventRepositoryStub)

        val eventsAll = useCase.execute().first()

        assertTrue(eventsAll.distinctBy { it.id }.size == eventsAll.size) // проверяем уникальность id
    }

}