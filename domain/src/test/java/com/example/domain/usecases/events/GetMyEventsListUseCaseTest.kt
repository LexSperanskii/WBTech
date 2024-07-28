package com.example.domain.usecases.events

import com.example.domain.stabRepositories.EventRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class GetMyEventsListUseCaseTest {

    @Test
    fun `return correct my events list`() = runTest{

        val eventRepositoryStub = EventRepositoryStub()

        val useCase = GetMyEventsListInteractor(eventRepository = eventRepositoryStub)

        val eventsMy = useCase.execute().first()

        assertTrue(eventsMy.distinctBy { it.id }.size == eventsMy.size) // проверяем уникальность id
    }
}