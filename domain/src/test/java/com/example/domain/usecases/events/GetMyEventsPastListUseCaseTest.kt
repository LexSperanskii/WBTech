package com.example.domain.usecases.events

import com.example.domain.stabRepositories.TestEventRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class GetMyEventsPastListUseCaseTest {

    @Test
    fun `return correct my events past list`() = runTest{

        val testEventRepository = TestEventRepository()

        val useCase = GetMyEventsPastListInteractor(eventRepository = testEventRepository)

        val eventsMyPast = useCase.execute().first()

        assertNotNull(eventsMyPast)
        eventsMyPast.forEach { event ->
            assertTrue(event.isFinished)
            assertNotNull(event.id)
            assertNotNull(event.name)
            assertNotNull(event.date)
            assertNotNull(event.city)
            assertNotNull(event.category)
            assertTrue(event.category.isNotEmpty())
        }
    }

}