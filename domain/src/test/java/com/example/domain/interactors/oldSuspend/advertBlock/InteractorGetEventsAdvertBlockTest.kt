package com.example.domain.interactors.oldSuspend.advertBlock

import com.example.domain.models.EventAdvertBlockModelDomain
import com.example.domain.repositories.INetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import org.mockito.kotlin.whenever

class InteractorGetEventsAdvertBlockTest {

    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetEventsAdvertBlockImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubId = "0"
    private val stubData = EventAdvertBlockModelDomain(
        id = "0",
        nameOfBlock = "0",
        listOfEvents = listOf()
    )

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        networkRepository = mock()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun reset() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `invoke should call getEventsAdvertBlock from repository`() = runTest {

        whenever(networkRepository.getEventsAdvertBlock(stubId)).thenReturn(flowOf(stubData))

        systemUnderTest = InteractorGetEventsAdvertBlockImpl(networkRepository)

        val result = systemUnderTest.invoke(stubId).first()

        verify(networkRepository).getEventsAdvertBlock(stubId)
        assertEquals(stubData, result)
    }

}