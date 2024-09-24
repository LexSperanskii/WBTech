package com.example.domain.interactors.oldSuspend

import com.example.domain.models.CountryModelDomain
import com.example.domain.models.PhoneNumberModelDomain
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

class InteractorGetClientNotVerifiedPhoneNumberTest {

    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetClientNotVerifiedPhoneNumberImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubData = PhoneNumberModelDomain(
        country = CountryModelDomain("0", "0", "0"),
        number = "0"
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
    fun `invoke should call getClientNotVerifiedPhoneNumber from repository`() = runTest {

        whenever(networkRepository.getClientNotVerifiedPhoneNumber()).thenReturn(flowOf(stubData))

        systemUnderTest = InteractorGetClientNotVerifiedPhoneNumberImpl(networkRepository)

        val result = systemUnderTest.invoke().first()

        verify(networkRepository).getClientNotVerifiedPhoneNumber()
        assertEquals(stubData, result)
    }
}