package com.example.domain.interactors.client

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

class InteractorSetClientNameTest {

    private lateinit var networkRepository: INetworkRepository
    private lateinit var interactorLoadClient: IInteractorLoadClient
    private lateinit var systemUnderTest: InteractorSetClientNameImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubData = "0"

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        networkRepository = mock()
        interactorLoadClient = mock()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun reset() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `invoke should call setClientName from repository and interactorLoadClient`() = runTest {

        systemUnderTest = InteractorSetClientNameImpl(networkRepository, interactorLoadClient)

        systemUnderTest.invoke(stubData)

        verify(networkRepository).setClientName(stubData)
        verify(interactorLoadClient).invoke()
    }
}