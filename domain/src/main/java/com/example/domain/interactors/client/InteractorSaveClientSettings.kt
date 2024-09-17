package com.example.domain.interactors.client

import com.example.domain.models.SocialMediaModelDomain
import com.example.domain.repositories.INetworkRepository


interface IInteractorSaveClientSettings {
    suspend fun invoke(
        imageURL: String?,
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
) : IInteractorSaveClientSettings {

    override suspend fun invoke(
        imageURL: String?,
        nameSurname: String,
        city: String,
        description: String,
        listOfClientSocialMedia: List<SocialMediaModelDomain>,
        isShowMyCommunities: Boolean,
        showMyEventsChecked: Boolean,
        applyNotificationsChecked: Boolean,
    ) {
        networkRepository.saveClientChanges(
            imageURL = imageURL,
            nameSurname = nameSurname,
            city = city,
            description = description,
            listOfClientSocialMedia = listOfClientSocialMedia,
            isShowMyCommunities = isShowMyCommunities,
            showMyEventsChecked = showMyEventsChecked,
            applyNotificationsChecked = applyNotificationsChecked
        )
    }
}