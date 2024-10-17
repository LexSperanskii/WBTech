package com.example.domain.interactors.oldSuspend

//import com.example.domain.interactors.client.setClientNotVerifiedName.InteractorSetClientNotVerifiedNameImpl
//import com.example.domain.models.Response
//import com.example.domain.repositories.INetworkRepository
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
//class InteractorSetClientNotVerifiedNameTest {
//
//    private lateinit var networkRepository: INetworkRepository
//    private lateinit var systemUnderTest: InteractorSetClientNotVerifiedNameImpl
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    private val testDispatcher = StandardTestDispatcher()
//    private val stubData = "0"
//    private val stubReply = Response("success")
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    @Before
//    fun setup() {
//        Dispatchers.setMain(testDispatcher)
//        networkRepository = mock()
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
//    fun `invoke should call setClientNotVerifiedName from repository`() =
//        runTest {
//
//            whenever(networkRepository.setClientNotVerifiedName(stubData)).thenReturn(
//                flowOf(
//                    stubReply
//                )
//            )
//
//            systemUnderTest = InteractorSetClientNotVerifiedNameImpl(networkRepository)
//
//            val result = systemUnderTest.invoke(stubData).first()
//
//            verify(networkRepository).setClientNotVerifiedName(stubData)
//            assertEquals(stubReply, result)
//        }
//}