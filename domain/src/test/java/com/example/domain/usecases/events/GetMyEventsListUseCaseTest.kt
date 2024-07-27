package com.example.domain.usecases.events

import com.example.domain.stabRepositories.TestEventRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class GetMyEventsListUseCaseTest {

    @Test
    fun `return correct my events list`() = runTest{

        val testEventRepository = TestEventRepository()

        val useCase = GetMyEventsListInteractor(eventRepository = testEventRepository)

        val eventsMy = useCase.execute().first()

        assertNotNull(eventsMy)
        eventsMy.forEach { event ->
            assertNotNull(event.id)
            assertNotNull(event.name)
            assertNotNull(event.date)
            assertNotNull(event.city)
            assertNotNull(event.category)
            assertTrue(event.category.isNotEmpty())
            assertNotNull(event.isFinished)
        }
    }
}