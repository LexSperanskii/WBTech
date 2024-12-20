package com.example.domain.interactors.oldSuspend.myEvents

//import com.example.domain.interactors.client.myEvents.removeFromMyEvents.InteractorRemoveFromMyEventsImpl
//import com.example.domain.models.Response
//import com.example.domain.repositories.INetworkRepository
//import com.example.domain.usecase.EventsUseCase
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.flow.first
//import kotlinx.coroutines.flow.flowOf
//import kotlinx.coroutines.test.StandardTestDispatcher
//import kotlinx.coroutines.test.resetMain
//import kotlinx.coroutines.test.runTest
//import kotlinx.coroutines.test.setMain
//import org.junit.After
//import org.junit.Assert.assertEquals
//import org.junit.Before
//import org.junit.Test
//import org.mockito.Mockito.mock
//import org.mockito.Mockito.verify
//import org.mockito.kotlin.whenever
//
//class InteractorRemoveFromMyEventsTest {
//
//    private lateinit var networkRepository: INetworkRepository
//    private lateinit var useCase: EventsUseCase
//    private lateinit var systemUnderTest: InteractorRemoveFromMyEventsImpl
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    private val testDispatcher = StandardTestDispatcher()
//    private val stubId = "0"
//    private val stubReply = Response("success")
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    @Before
//    fun setup() {
//        Dispatchers.setMain(testDispatcher)
//        networkRepository = mock()
//        useCase = mock()
//    }
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    @After
//    fun reset() {
//        Dispatchers.resetMain()
//    }
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    @Test
//    fun `invoke should call removeFromMyEvents from repository and load client`() =
//        runTest {
//
//            whenever(networkRepository.removeFromMyEvents(stubId)).thenReturn(flowOf(stubReply))
//
//            systemUnderTest = InteractorRemoveFromMyEventsImpl(networkRepository, useCase)
//
//            val result = systemUnderTest.invoke(stubId).first()
//
//            verify(networkRepository).removeFromMyEvents(stubId)
//            verify(useCase).loadClient()
//            assertEquals(stubReply, result)
//        }
//}