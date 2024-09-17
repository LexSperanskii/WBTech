package com.example.domain.usecase.events

//import com.example.domain.stabRepositories.EventRepositoryStub
//import com.example.domain.usecase.events.dump.GetMyEventsPastListUseCaseImpl
//import kotlinx.coroutines.flow.first
//import kotlinx.coroutines.test.runTest
//import org.junit.Assert.assertTrue
//import org.junit.Before
//import org.junit.Test
//
//class GetMyEventsPastListUseCaseTest {
//
//    private lateinit var eventRepositoryStub: EventRepositoryStub
//    private lateinit var useCase: GetMyEventsPastListUseCaseImpl
//    private lateinit var eventsMyPast: List<Event>
//
//    @Before
//    fun setUp() {
//        eventRepositoryStub = EventRepositoryStub()
//        useCase = GetMyEventsPastListUseCaseImpl(eventRepository = eventRepositoryStub)
//    }
//
//    @Test
//    fun `my events past id are unique`() = runTest {
//        eventsMyPast = useCase.execute().first()
//        val result = eventsMyPast.distinctBy { it.id }.size
//        val expectedResult = eventsMyPast.size
//
//        assertTrue(result == expectedResult)
//    }
//
//    @Test
//    fun `all my events have not blank names`() = runTest {
//        eventsMyPast = useCase.execute().first()
//        eventsMyPast.forEach { event ->
//            val result = event.name
//
//            assertTrue(result.isNotBlank())
//        }
//    }
//
//    @Test
//    fun `all my events Past`() = runTest {
//        eventsMyPast = useCase.execute().first()
//        eventsMyPast.forEach { event ->
//            val result = event.isFinished
//
//            assertTrue(result)
//        }
//    }
//}