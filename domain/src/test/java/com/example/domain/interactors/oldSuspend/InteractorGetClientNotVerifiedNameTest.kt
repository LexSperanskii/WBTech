package com.example.domain.interactors.oldSuspend

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

class InteractorGetClientNotVerifiedNameTest {

    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetClientNotVerifiedNameImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubData = "0"

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
    fun `invoke should call getClientNotVerifiedName from repository`() = runTest {

        whenever(networkRepository.getClientNotVerifiedName()).thenReturn(flowOf(stubData))

        systemUnderTest = InteractorGetClientNotVerifiedNameImpl(networkRepository)

        val result = systemUnderTest.invoke().first()

        verify(networkRepository).getClientNotVerifiedName()
        assertEquals(stubData, result)
    }
}