package com.example.domain.usecases.events

import com.example.domain.stabRepositories.EventRepositoryStub
import com.example.domain.utils.COMMUNITY_ID
import com.example.domain.utils.EVENT_ID
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull

class GetEventDetailsUseCaseTest {

    @Test
    fun `return correct event detail`() = runTest{

        val eventRepositoryStub = EventRepositoryStub()

        val useCase = GetEventDetailsInteractor(eventRepository = eventRepositoryStub)

        val eventDetail = useCase.execute(EVENT_ID).first()

        assertEquals(eventDetail.id, EVENT_ID)
    }

}