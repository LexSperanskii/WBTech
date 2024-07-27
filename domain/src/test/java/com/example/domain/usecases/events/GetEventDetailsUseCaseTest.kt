package com.example.domain.usecases.events

import com.example.domain.stabRepositories.TestEventRepository
import com.example.domain.utils.EVENT_ID
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertNotNull

class GetEventDetailsUseCaseTest {

    @Test
    fun `return correct event detail`() = runTest{

        val testEventRepository = TestEventRepository()

        val useCase = GetEventDetailsInteractor(eventRepository = testEventRepository)

        val eventDetail = useCase.execute(EVENT_ID).first()

        assertNotNull(eventDetail)
        assertNotNull(eventDetail.id)
        assertNotNull(eventDetail.name)
        assertNotNull(eventDetail.date)
        assertNotNull(eventDetail.address)
        assertNotNull(eventDetail.category)
        assertTrue(eventDetail.category.isNotEmpty())
        assertNotNull(eventDetail.locationCoordinates)
        assertNotNull(eventDetail.description)
        assertNotNull(eventDetail.isFinished)
    }

}