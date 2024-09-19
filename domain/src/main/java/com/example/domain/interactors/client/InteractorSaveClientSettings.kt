package com.example.domain.interactors.client

import com.example.domain.models.SocialMediaModelDomain
import com.example.domain.repositories.INetworkRepository


interface IInteractorSaveClientSettings {
    suspend fun invoke(
        nameSurname: String,
        city: String,
        description: String,
        listOfClientSocialMedia: List<SocialMediaModelDomain>,
        isShowMyCommunities: Boolean,
        showMyEventsChecked: Boolean,
        applyNotificationsChecked: Boolean,
    )
}

internal class InteractorSaveClientSettingsImpl(
    private val networkRepository: INetworkRepository,
    private val loadClient: IInteractorLoadClient,
) : IInteractorSaveClientSettings {

    override suspend fun invoke(
        nameSurname: String,
        city: String,
        description: String,
        listOfClientSocialMedia: List<SocialMediaModelDomain>,
        isShowMyCommunities: Boolean,
        showMyEventsChecked: Boolean,
        applyNotificationsChecked: Boolean,
    ) {
        networkRepository.saveClientChanges(
            nameSurname = nameSurname,
            city = city,
            description = description,
            listOfClientSocialMedia = listOfClientSocialMedia,
            isShowMyCommunities = isShowMyCommunities,
            showMyEventsChecked = showMyEventsChecked,
            applyNotificationsChecked = applyNotificationsChecked
        )
        loadClient.invoke()
    }
}