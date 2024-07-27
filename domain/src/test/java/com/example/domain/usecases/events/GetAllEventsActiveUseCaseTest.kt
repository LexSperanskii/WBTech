package com.example.domain.usecases.events

import com.example.domain.stabRepositories.TestEventRepository
import com.example.domain.usecases.communities.GetCommunitiesListInteractor
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class GetAllEventsActiveUseCaseTest {
    @Test
    fun `return correct events active list`() = runTest{

        val testEventRepository = TestEventRepository()

        val useCase = GetAllEventsActiveInteractor(eventRepository = testEventRepository)

        val eventsAllActive = useCase.execute().first()

        assertNotNull(eventsAllActive)
        eventsAllActive.forEach { event ->
            assertTrue(!event.isFinished)
            assertNotNull(event.id)
            assertNotNull(event.name)
            assertNotNull(event.date)
            assertNotNull(event.city)
            assertNotNull(event.category)
            assertTrue(event.category.isNotEmpty())
        }
    }
}