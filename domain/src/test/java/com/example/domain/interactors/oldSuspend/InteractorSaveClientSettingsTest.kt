package com.example.domain.interactors.oldSuspend

//import com.example.domain.interactors.client.saveClientSettings.InteractorSaveClientSettingsImpl
//import com.example.domain.models.Response
//import com.example.domain.models.SocialMediaModelDomain
//import com.example.domain.repositories.INetworkRepository
//import com.example.domain.usecase.EventsUseCase
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.flow.first
//import kotlinx.coroutines.flow.flowOf
//import kotlinx.coroutines.test.StandardTestDispatcher
//import kotlinx.coroutines.test.resetMain
//import kotlinx.coroutines.test.runTest
//import kotlinx.coroutines.test.setMain
//import org.junit.After
//import org.junit.Assert.assertEquals
//import org.junit.Before
//import org.junit.Test
//import org.mockito.Mockito.mock
//import org.mockito.Mockito.verify
//import org.mockito.kotlin.whenever
//
//class InteractorSaveClientSettingsTest {
//
//    private lateinit var networkRepository: INetworkRepository
//    private lateinit var useCase: EventsUseCase
//    private lateinit var systemUnderTest: InteractorSaveClientSettingsImpl
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    private val testDispatcher = StandardTestDispatcher()
//
//    private val stubNameSurname = "0"
//    private val stubCity = "0"
//    private val stubDescription = "0"
//    private val stubListOfClientSocialMedia: List<SocialMediaModelDomain> = listOf()
//    private val stubIsShowMyCommunities = false
//    private val stubShowMyEventsChecked = false
//    private val stubApplyNotificationsChecked = false
//    private val stubReply = Response("success")
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    @Before
//    fun setup() {
//        Dispatchers.setMain(testDispatcher)
//        networkRepository = mock()
//        useCase = mock()
//    }
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    @After
//    fun reset() {
//        Dispatchers.resetMain()
//    }
//
//    @OptIn(ExperimentalCoroutinesApi::class)
//    @Test
//    fun `invoke should call saveClientChanges from repository and load client`() =
//        runTest {
//
//            whenever(
//                networkRepository.saveClientChanges(
//                    stubNameSurname,
//                    stubCity,
//                    stubDescription,
//                    stubListOfClientSocialMedia,
//                    stubIsShowMyCommunities,
//                    stubShowMyEventsChecked,
//                    stubApplyNotificationsChecked
//                )
//            ).thenReturn(flowOf(stubReply))
//
//            systemUnderTest = InteractorSaveClientSettingsImpl(networkRepository, useCase)
//
//            val result = systemUnderTest.invoke(
//                stubNameSurname,
//                stubCity,
//                stubDescription,
//                stubListOfClientSocialMedia,
//                stubIsShowMyCommunities,
//                stubShowMyEventsChecked,
//                stubApplyNotificationsChecked
//            ).first()
//
//            verify(networkRepository).saveClientChanges(
//                stubNameSurname,
//                stubCity,
//                stubDescription,
//                stubListOfClientSocialMedia,
//                stubIsShowMyCommunities,
//                stubShowMyEventsChecked,
//                stubApplyNotificationsChecked
//            )
//            verify(useCase).loadClient()
//            assertEquals(stubReply, result)
//        }
//}