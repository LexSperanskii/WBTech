package com.example.domain.interactors.client

import com.example.domain.models.CountryModelDomain
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

class InteractorSetClientPhoneNumberTest {

    private lateinit var networkRepository: INetworkRepository
    private lateinit var loadClient: IInteractorLoadClient
    private lateinit var systemUnderTest: InteractorSetClientPhoneNumberImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubCountryCode = CountryModelDomain("0", "0", "0")
    private val stubNumber = "0"

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        networkRepository = mock()
        loadClient = mock()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun reset() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `invoke should call setClientPhoneNumber from repository and interactorLoadClient`() =
        runTest {

            systemUnderTest = InteractorSetClientPhoneNumberImpl(networkRepository, loadClient)

            systemUnderTest.invoke(stubCountryCode, stubNumber)

            verify(networkRepository).setClientPhoneNumber(stubCountryCode, stubNumber)
            verify(loadClient).invoke()
        }
}