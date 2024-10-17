package com.example.domain.interactors.oldSuspend.advertBlock

//import com.example.domain.interactors.advertBlock.communitiesAdvertBlock.InteractorGetCommunitiesAdvertBlockImpl
//import com.example.domain.models.CommunitiesAdvertBlockModelDomain
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
//class InteractorGetCommunitiesAdvertBlockTest {
//
//    private lateinit var networkRepository: INetworkRepository
//    private lateinit var systemUnderTest: InteractorGetCommunitiesAdvertBlockImpl
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    private val testDispatcher = StandardTestDispatcher()
//    private val stubId = "0"
//    private val stubData = CommunitiesAdvertBlockModelDomain(
//        id = "0",
//        nameOfBlock = "0",
//        listOfCommunities = listOf()
//    )
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
//    fun `invoke should call getCommunitiesAdvertBlock from repository`() = runTest {
//
//        whenever(networkRepository.getCommunitiesAdvertBlock(stubId)).thenReturn(flowOf(stubData))
//
//        systemUnderTest = InteractorGetCommunitiesAdvertBlockImpl(networkRepository)
//
//        val result = systemUnderTest.invoke(stubId).first()
//
//        verify(networkRepository).getCommunitiesAdvertBlock(stubId)
//        assertEquals(stubData, result)
//    }
//}