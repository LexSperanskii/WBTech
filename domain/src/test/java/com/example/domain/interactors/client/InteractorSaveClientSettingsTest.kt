package com.example.domain.interactors.client

import com.example.domain.models.SocialMediaModelDomain
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

class InteractorSaveClientSettingsTest {

    private lateinit var networkRepository: INetworkRepository
    private lateinit var interactorLoadClient: IInteractorLoadClient
    private lateinit var systemUnderTest: InteractorSaveClientSettingsImpl

    @OptIn(ExperimentalCoroutinesApi::class)
    private val testDispatcher = StandardTestDispatcher()

    private val stubNameSurname = "0"
    private val stubCity = "0"
    private val stubDescription = "0"
    private val stubListOfClientSocialMedia: List<SocialMediaModelDomain> = listOf()
    private val stubIsShowMyCommunities = false
    private val stubShowMyEventsChecked = false
    private val stubApplyNotificationsChecked = false

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(testDispatcher)
        networkRepository = mock()
        interactorLoadClient = mock()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun reset() {
        Dispatchers.resetMain()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `invoke should call saveClientChanges from repository and interactorLoadClient`() =
        runTest {

            systemUnderTest =
                InteractorSaveClientSettingsImpl(networkRepository, interactorLoadClient)

            systemUnderTest.invoke(
                stubNameSurname,
                stubCity,
                stubDescription,
                stubListOfClientSocialMedia,
                stubIsShowMyCommunities,
                stubShowMyEventsChecked,
                stubApplyNotificationsChecked
            )

            verify(networkRepository).saveClientChanges(
                stubNameSurname,
                stubCity,
                stubDescription,
                stubListOfClientSocialMedia,
                stubIsShowMyCommunities,
                stubShowMyEventsChecked,
                stubApplyNotificationsChecked
            )
            verify(interactorLoadClient).invoke()
        }
}