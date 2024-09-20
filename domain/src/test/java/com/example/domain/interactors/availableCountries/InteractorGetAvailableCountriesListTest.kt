package com.example.domain.interactors.availableCountries

import com.example.domain.models.CountryModelDomain
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

class InteractorGetAvailableCountriesListTest {

    private lateinit var useCase: EventsUseCase
    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetAvailableCountriesListImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubData = listOf(
        CountryModelDomain("0", "Россия", "+7"),
        CountryModelDomain("1", "Казахстан", "+7")
    )

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
    fun `invoke should return list of Available Countries from network repository`() = runTest {

        whenever(useCase.observeAvailableCountriesList()).thenReturn(flowOf(Unit))
        whenever(networkRepository.getAvailableCountriesList()).thenReturn(flowOf(stubData))

        systemUnderTest = InteractorGetAvailableCountriesListImpl(useCase, networkRepository)

        val result = systemUnderTest.invoke().first()

        verify(useCase).observeAvailableCountriesList()
        verify(networkRepository).getAvailableCountriesList()
        assertEquals(stubData, result)
    }
}