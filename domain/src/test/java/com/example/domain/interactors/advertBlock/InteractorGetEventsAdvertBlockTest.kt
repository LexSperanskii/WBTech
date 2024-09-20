package com.example.domain.interactors.advertBlock

import com.example.domain.repositories.INetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class InteractorGetEventsAdvertBlockTest {

    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetEventsAdvertBlockImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubId = "0"

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

        systemUnderTest = InteractorGetEventsAdvertBlockImpl(networkRepository)

        systemUnderTest.invoke(stubId)

        verify(networkRepository).getEventsAdvertBlock(stubId)
    }

}