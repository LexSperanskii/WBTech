package com.example.domain.interactors.oldSuspend

import com.example.domain.models.Response
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

class InteractorSetClientAvatarTest {

    private lateinit var networkRepository: INetworkRepository
    private lateinit var useCase: EventsUseCase
    private lateinit var systemUnderTest: InteractorSetClientAvatarImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubURL = "0"
    private val stubReply = Response("success")

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        networkRepository = mock()
        useCase = mock()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun reset() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `invoke should call setClientAvatar from repository and load client`() = runTest {

        whenever(networkRepository.setClientAvatar(stubURL)).thenReturn(flowOf(stubReply))

        systemUnderTest = InteractorSetClientAvatarImpl(networkRepository, useCase)

        val result = systemUnderTest.invoke(stubURL).first()

        verify(networkRepository).setClientAvatar(stubURL)
        verify(useCase).loadClient()
        assertEquals(stubReply, result)
    }
}