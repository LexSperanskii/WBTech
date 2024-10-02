package com.example.domain.interactors.client

//import com.example.domain.interactors.client.getClient.InteractorLoadClientImpl
//import com.example.domain.usecase.EventsUseCase
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.test.StandardTestDispatcher
//import kotlinx.coroutines.test.resetMain
//import kotlinx.coroutines.test.runTest
//import kotlinx.coroutines.test.setMain
//import org.junit.After
//import org.junit.Before
//import org.junit.Test
//import org.mockito.Mockito.mock
//import org.mockito.Mockito.verify
//
//class InteractorLoadClientTest {
//
//    private lateinit var useCase: EventsUseCase
//    private lateinit var systemUnderTest: InteractorLoadClientImpl
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    private val testDispatcher = StandardTestDispatcher()
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    @Before
//    fun setup() {
//        Dispatchers.setMain(testDispatcher)
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
//    fun `invoke should call loadClient from use case`() = runTest {
//
//        systemUnderTest = InteractorLoadClientImpl(useCase)
//
//        systemUnderTest.invoke()
//
//        verify(useCase).loadClient()
//    }
//}