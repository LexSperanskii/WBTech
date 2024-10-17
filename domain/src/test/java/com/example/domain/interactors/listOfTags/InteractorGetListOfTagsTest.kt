package com.example.domain.interactors.listOfTags

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

class InteractorGetListOfTagsTest {

    private lateinit var useCase: EventsUseCase
    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetListOfTagsImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubData = listOf(
        "S", "Sa", "asa"
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
    fun `invoke should return list of Tags from network repository`() = runTest {

        whenever(useCase.observeListOfTags()).thenReturn(flowOf(Unit))
        whenever(networkRepository.getListOfTags()).thenReturn(flowOf(stubData))

        systemUnderTest = InteractorGetListOfTagsImpl(useCase, networkRepository)

        val result = systemUnderTest.invoke().first()

        verify(useCase).observeListOfTags()
        verify(networkRepository).getListOfTags()
        assertEquals(stubData, result)
    }
}