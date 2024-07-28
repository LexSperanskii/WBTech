package com.example.domain.usecases.events

import com.example.domain.models.Event
import com.example.domain.models.EventDetail
import com.example.domain.stabRepositories.EventRepositoryStub
import com.example.domain.utils.COMMUNITY_ID
import com.example.domain.utils.EVENT_ID
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull

class GetEventDetailsUseCaseTest {

    private lateinit var eventRepositoryStub: EventRepositoryStub
    private lateinit var useCase: GetEventDetailsInteractor
    private lateinit var eventDetail: EventDetail

    @Before
    fun setUp() = runTest {
        eventRepositoryStub = EventRepositoryStub()
        useCase = GetEventDetailsInteractor(eventRepository = eventRepositoryStub)
        eventDetail = useCase.execute(EVENT_ID).first()
    }

    @Test
    fun `received correct event by id`() {
        assertEquals(eventDetail.id, EVENT_ID)
    }

    @Test
    fun `event name is not blank`() {
        assertTrue(eventDetail.name.isNotBlank())
    }
}