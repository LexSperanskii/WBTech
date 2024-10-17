package com.example.domain.OldTestsForUi_v1.usecase.events

//import com.example.domain.stabRepositories.EventRepositoryStub
//import kotlinx.coroutines.flow.first
//import kotlinx.coroutines.test.runTest
//import org.junit.Assert.assertTrue
//import org.junit.Before
//import org.junit.Test

//class GetMyEventsListUseCaseTest {
//
//    private lateinit var eventRepositoryStub: EventRepositoryStub
//    private lateinit var useCase: GetMyEventsListUseCaseImpl
//    private lateinit var eventsMy: List<Event>
//
//    @Before
//    fun setUp() {
//        eventRepositoryStub = EventRepositoryStub()
//        useCase = GetMyEventsListUseCaseImpl(eventRepository = eventRepositoryStub)
//    }
//
//    @Test
//    fun `my events id are unique`() = runTest {
//        eventsMy = useCase.execute().first()
//        val result = eventsMy.distinctBy { it.id }.size
//        val expectedResult = eventsMy.size
//
//        assertTrue(result == expectedResult)
//    }
//
//    @Test
//    fun `all my events have not blank names`() = runTest {
//        eventsMy = useCase.execute().first()
//        eventsMy.forEach { event ->
//            val result = event.name
//
//            assertTrue(result.isNotBlank())
//        }
//    }
//}