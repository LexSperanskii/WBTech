package com.example.domain.interactors.client

import com.example.domain.interactors.oldSuspend.InteractorGetClientNotVerifiedPhoneNumberImpl
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

class InteractorGetClientNotVerifiedPhoneNumberTest {

    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetClientNotVerifiedPhoneNumberImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()

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
    fun `invoke should call getClientNotVerifiedPhoneNumber from repository`() = runTest {

        systemUnderTest = InteractorGetClientNotVerifiedPhoneNumberImpl(networkRepository)

        systemUnderTest.invoke()

        verify(networkRepository).getClientNotVerifiedPhoneNumber()
    }
}