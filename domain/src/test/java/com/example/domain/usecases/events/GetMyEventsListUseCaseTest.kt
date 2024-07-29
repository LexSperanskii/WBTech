package com.example.domain.usecases.events

import com.example.domain.models.Event
import com.example.domain.stabRepositories.EventRepositoryStub
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetMyEventsListUseCaseTest {

    private lateinit var eventRepositoryStub: EventRepositoryStub
    private lateinit var useCase: GetMyEventsListUseCaseImpl
    private lateinit var eventsMy: List<Event>

    @Before
    fun setUp() = runTest {
        eventRepositoryStub = EventRepositoryStub()
        useCase = GetMyEventsListUseCaseImpl(eventRepository = eventRepositoryStub)
        eventsMy = useCase.execute().first()
    }

    @Test
    fun `my events id are unique`() {
        assertTrue(eventsMy.distinctBy { it.id }.size == eventsMy.size)
    }

    @Test
    fun `all my events have not blank names`() {
        eventsMy.forEach { event ->
            assertTrue(event.name.isNotBlank())
        }
    }
}