package com.example.domain.interactors.client

import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
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

class InteractorGetClientPinCodeVerificationTest {

    private lateinit var useCase: EventsUseCase
    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetClientPinCodeVerificationImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubPin = "pin"
    private val stubResponse = true

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        useCase = mock()
        networkRepository = mock()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun reset() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `invoke should return pin verification from repository`() = runTest {

        whenever(useCase.observeClientPinCodeVerification()).thenReturn(flowOf(stubPin))
        whenever(networkRepository.setClientPinCode(stubPin)).thenReturn(flowOf(stubResponse))

        systemUnderTest = InteractorGetClientPinCodeVerificationImpl(useCase, networkRepository)

        val result = systemUnderTest.invoke().first()

        verify(useCase).observeClientPinCodeVerification()
        verify(networkRepository).setClientPinCode(stubPin)
        assertEquals(stubResponse, result)
    }
}