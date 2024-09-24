package com.example.domain.interactors.oldSuspend

import com.example.domain.models.Response
import com.example.domain.models.SocialMediaModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach


interface IInteractorSaveClientSettings {
    fun invoke(
        nameSurname: String,
        city: String,
        description: String,
        listOfClientSocialMedia: List<SocialMediaModelDomain>,
        isShowMyCommunities: Boolean,
        showMyEventsChecked: Boolean,
        applyNotificationsChecked: Boolean,
    ): Flow<Response>
}

internal class InteractorSaveClientSettingsImpl(
    private val networkRepository: INetworkRepository,
    private val useCase: EventsUseCase,
) : IInteractorSaveClientSettings {

    override fun invoke(
        nameSurname: String,
        city: String,
        description: String,
        listOfClientSocialMedia: List<SocialMediaModelDomain>,
        isShowMyCommunities: Boolean,
        showMyEventsChecked: Boolean,
        applyNotificationsChecked: Boolean,
    ): Flow<Response> = networkRepository.saveClientChanges(
        nameSurname = nameSurname,
        city = city,
        description = description,
        listOfClientSocialMedia = listOfClientSocialMedia,
        isShowMyCommunities = isShowMyCommunities,
        showMyEventsChecked = showMyEventsChecked,
        applyNotificationsChecked = applyNotificationsChecked
    ).onEach { response ->
        if (response.status == "success") {
            useCase.loadClient()
        }
    }.catch { exception ->
        // TODO сделать обработку ошибок
        emit(Response("error", exception.message ?: ""))
    }.flowOn(Dispatchers.IO)

}
