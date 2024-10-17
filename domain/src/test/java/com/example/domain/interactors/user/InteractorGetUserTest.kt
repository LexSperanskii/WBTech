package com.example.domain.interactors.user

import com.example.domain.models.UserModelDomain
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

class InteractorGetUserTest {

    private lateinit var useCase: EventsUseCase
    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetUserImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubUserId = "0"
    private val stubData = UserModelDomain(
        id = "0",
        nameSurname = "0",
        city = "0",
        listOfTags = listOf(),
        description = "0",
        imageURL = "0",
        listOfSocialMedia = listOf(),
        userEventsList = listOf(),
        userCommunitiesList = listOf(),
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
    fun `invoke should return user by id from network repository`() = runTest {

        whenever(useCase.observeUser()).thenReturn(flowOf(stubUserId))
        whenever(networkRepository.getUser(stubUserId)).thenReturn(flowOf(stubData))

        systemUnderTest = InteractorGetUserImpl(useCase, networkRepository)

        val result = systemUnderTest.invoke().first()

        verify(useCase).observeUser()
        verify(networkRepository).getUser(stubUserId)
        assertEquals(stubData, result)
    }

}