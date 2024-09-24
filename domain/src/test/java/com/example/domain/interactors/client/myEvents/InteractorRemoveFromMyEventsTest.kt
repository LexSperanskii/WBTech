package com.example.domain.interactors.client.myEvents

import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.interactors.oldSuspend.myEvents.InteractorRemoveFromMyEventsImpl
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

class InteractorRemoveFromMyEventsTest {

    private lateinit var networkRepository: INetworkRepository
    private lateinit var interactorLoadClient: IInteractorLoadClient
    private lateinit var systemUnderTest: InteractorRemoveFromMyEventsImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubId = "0"

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
    fun `invoke should call removeFromMyEvents from repository and interactorLoadClient`() =
        runTest {

            systemUnderTest =
                InteractorRemoveFromMyEventsImpl(networkRepository, interactorLoadClient)

            systemUnderTest.invoke(stubId)

            verify(networkRepository).removeFromMyEvents(stubId)
            verify(interactorLoadClient).invoke()
        }
}