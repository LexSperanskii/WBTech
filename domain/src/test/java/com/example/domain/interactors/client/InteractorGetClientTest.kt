package com.example.domain.interactors.client

import com.example.domain.models.ClientModelDomain
import com.example.domain.models.PhoneNumberModelDomain
import com.example.domain.models.SocialMediaModelDomain
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

class InteractorGetClientTest {

    private lateinit var useCase: EventsUseCase
    private lateinit var networkRepository: INetworkRepository
    private lateinit var systemUnderTest: InteractorGetClientImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()
    private val stubData = ClientModelDomain(
        id = "0",
        imageURL = "0",
        nameSurname = "0",
        phoneNumber = PhoneNumberModelDomain(),
        city = "0",
        description = "0",
        listOfClientTags = listOf(),
        listOfClientSocialMedia = listOf(
            SocialMediaModelDomain(
                socialMediaId = "0",
                socialMediaName = "Хабр",
                userNickname = ""
            ),
            SocialMediaModelDomain(
                socialMediaId = "1",
                socialMediaName = "Телеграм",
                userNickname = ""
            )
        ),
        clientEventsList = listOf(),
        clientCommunitiesList = listOf(),
        isShowMyCommunities = false,
        showMyEventsChecked = false,
        applyNotificationsChecked = false,
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
    fun `invoke should return client from network repository`() = runTest {

        whenever(useCase.observeClient()).thenReturn(flowOf(Unit))
        whenever(networkRepository.getClient()).thenReturn(flowOf(stubData))

        systemUnderTest = InteractorGetClientImpl(useCase, networkRepository)

        val result = systemUnderTest.invoke().first()

        verify(useCase).observeClient()
        verify(networkRepository).getClient()
        assertEquals(stubData, result)
    }
}