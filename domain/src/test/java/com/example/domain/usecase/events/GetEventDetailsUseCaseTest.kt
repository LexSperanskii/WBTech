package com.example.domain.usecase.events

//import com.example.domain.models.EventDetail
//import com.example.domain.stabRepositories.EventRepositoryStub
//import com.example.domain.usecase.events.dump.GetEventDetailsUseCaseImpl
//import com.example.domain.utils.EVENT_ID
//import kotlinx.coroutines.flow.first
//import kotlinx.coroutines.test.runTest
//import org.junit.Assert.assertTrue
//import org.junit.Before
//import org.junit.Test
//import org.junit.jupiter.api.Assertions.assertEquals
//
//class GetEventDetailsUseCaseTest {
//
//    private lateinit var eventRepositoryStub: EventRepositoryStub
//    private lateinit var useCase: GetEventDetailsUseCaseImpl
//    private lateinit var eventDetail: EventDetail
//
//    @Before
//    fun setUp() {
//        eventRepositoryStub = EventRepositoryStub()
//        useCase = GetEventDetailsUseCaseImpl(eventRepository = eventRepositoryStub)
//    }
//
//    @Test
//    fun `received correct event by id`() = runTest {
//        eventDetail = useCase.execute(EVENT_ID).first()
//        val result = eventDetail.id
//        val expectedResult = EVENT_ID
//
//        assertEquals(result, expectedResult)
//    }
//
//    @Test
//    fun `event name is not blank`() = runTest {
//        eventDetail = useCase.execute(EVENT_ID).first()
//        val result = eventDetail.name
//
//        assertTrue(result.isNotBlank())
//    }
//}