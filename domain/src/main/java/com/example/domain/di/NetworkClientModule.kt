package com.example.domain.di

import com.example.domain.interactors.client.deleteClient.IInteractorDeleteClient
import com.example.domain.interactors.client.deleteClient.IInteractorDeleteClientResponse
import com.example.domain.interactors.client.deleteClient.InteractorDeleteClientImpl
import com.example.domain.interactors.client.deleteClient.InteractorDeleteClientResponseImpl
import com.example.domain.interactors.client.getClient.IInteractorGetClient
import com.example.domain.interactors.client.getClient.IInteractorLoadClient
import com.example.domain.interactors.client.getClient.InteractorGetClientImpl
import com.example.domain.interactors.client.getClient.InteractorLoadClientImpl
import com.example.domain.interactors.client.getClientNotVerifiedName.IInteractorGetClientNotVerifiedName
import com.example.domain.interactors.client.getClientNotVerifiedName.IInteractorLoadClientNotVerifiedName
import com.example.domain.interactors.client.getClientNotVerifiedName.InteractorGetClientNotVerifiedNameImpl
import com.example.domain.interactors.client.getClientNotVerifiedName.InteractorLoadClientNotVerifiedNameImpl
import com.example.domain.interactors.client.getClientNotVerifiedPhoneNumber.IInteractorGetClientNotVerifiedPhoneNumber
import com.example.domain.interactors.client.getClientNotVerifiedPhoneNumber.IInteractorLoadtClientNotVerifiedPhoneNumber
import com.example.domain.interactors.client.getClientNotVerifiedPhoneNumber.InteractorGetClientNotVerifiedPhoneNumberImpl
import com.example.domain.interactors.client.getClientNotVerifiedPhoneNumber.InteractorLoadtClientNotVerifiedPhoneNumberImpl
import com.example.domain.interactors.client.myChosenTags.addToMyChosenTags.IInteractorAddToMyChosenTags
import com.example.domain.interactors.client.myChosenTags.addToMyChosenTags.IInteractorAddToMyChosenTagsResponse
import com.example.domain.interactors.client.myChosenTags.addToMyChosenTags.InteractorAddToMyChosenTagsImpl
import com.example.domain.interactors.client.myChosenTags.addToMyChosenTags.InteractorAddToMyChosenTagsResponseImpl
import com.example.domain.interactors.client.myChosenTags.removeFromMyChosenTags.IInteractorRemoveFromMyChosenTags
import com.example.domain.interactors.client.myChosenTags.removeFromMyChosenTags.IInteractorRemoveFromMyChosenTagsResponse
import com.example.domain.interactors.client.myChosenTags.removeFromMyChosenTags.InteractorRemoveFromMyChosenTagsImpl
import com.example.domain.interactors.client.myChosenTags.removeFromMyChosenTags.InteractorRemoveFromMyChosenTagsResponseImpl
import com.example.domain.interactors.client.myCommunities.addToMyCommunities.IInteractorAddToMyCommunities
import com.example.domain.interactors.client.myCommunities.addToMyCommunities.IInteractorAddToMyCommunitiesResponse
import com.example.domain.interactors.client.myCommunities.addToMyCommunities.InteractorAddToMyCommunitiesImpl
import com.example.domain.interactors.client.myCommunities.addToMyCommunities.InteractorAddToMyCommunitiesResponseImpl
import com.example.domain.interactors.client.myCommunities.removeFromMyCommunities.IInteractorRemoveFromMyCommunities
import com.example.domain.interactors.client.myCommunities.removeFromMyCommunities.IInteractorRemoveFromMyCommunitiesResponse
import com.example.domain.interactors.client.myCommunities.removeFromMyCommunities.InteractorRemoveFromMyCommunitiesImpl
import com.example.domain.interactors.client.myCommunities.removeFromMyCommunities.InteractorRemoveFromMyCommunitiesResponseImpl
import com.example.domain.interactors.client.myEvents.addToMyEvents.IInteractorAddToMyEvents
import com.example.domain.interactors.client.myEvents.addToMyEvents.IInteractorAddToMyEventsResponse
import com.example.domain.interactors.client.myEvents.addToMyEvents.InteractorAddToMyEventsImpl
import com.example.domain.interactors.client.myEvents.addToMyEvents.InteractorAddToMyEventsResponseImpl
import com.example.domain.interactors.client.myEvents.removeFromMyEvents.IInteractorRemoveFromMyEvents
import com.example.domain.interactors.client.myEvents.removeFromMyEvents.IInteractorRemoveFromMyEventsResponse
import com.example.domain.interactors.client.myEvents.removeFromMyEvents.InteractorRemoveFromMyEventsImpl
import com.example.domain.interactors.client.myEvents.removeFromMyEvents.InteractorRemoveFromMyEventsResponseImpl
import com.example.domain.interactors.client.pinCode.IInteractorGetClientPinCodeVerification
import com.example.domain.interactors.client.pinCode.IInteractorLoadClientPinCodeVerification
import com.example.domain.interactors.client.pinCode.InteractorGetClientPinCodeVerificationImpl
import com.example.domain.interactors.client.pinCode.InteractorLoadClientPinCodeVerificationImpl
import com.example.domain.interactors.client.saveClientSettings.IInteractoSaveClientSettingsResponse
import com.example.domain.interactors.client.saveClientSettings.IInteractorSaveClientSettings
import com.example.domain.interactors.client.saveClientSettings.InteractoSaveClientSettingsResponseImpl
import com.example.domain.interactors.client.saveClientSettings.InteractorSaveClientSettingsImpl
import com.example.domain.interactors.client.setClientAvatar.IInteractorSetClientAvatar
import com.example.domain.interactors.client.setClientAvatar.IInteractorSetClientAvatarResponse
import com.example.domain.interactors.client.setClientAvatar.InteractorSetClientAvatarImpl
import com.example.domain.interactors.client.setClientAvatar.InteractorSetClientAvatarResponseImpl
import com.example.domain.interactors.client.setClientName.IInteractorSetClientName
import com.example.domain.interactors.client.setClientName.IInteractorSetClientNameResponse
import com.example.domain.interactors.client.setClientName.InteractorSetClientNameImpl
import com.example.domain.interactors.client.setClientName.InteractorSetClientNameResponseImpl
import com.example.domain.interactors.client.setClientNotVerifiedName.IInteractorSetClientNotVerifiedName
import com.example.domain.interactors.client.setClientNotVerifiedName.IInteractorSetClientNotVerifiedNameResponse
import com.example.domain.interactors.client.setClientNotVerifiedName.InteractorSetClientNotVerifiedNameImpl
import com.example.domain.interactors.client.setClientNotVerifiedName.InteractorSetClientNotVerifiedNameResponseImpl
import com.example.domain.interactors.client.setClientNotVerifiedPhoneNumber.IInteractorSetClientNotVerifiedPhoneNumber
import com.example.domain.interactors.client.setClientNotVerifiedPhoneNumber.IInteractorSetClientNotVerifiedPhoneNumberResponse
import com.example.domain.interactors.client.setClientNotVerifiedPhoneNumber.InteractorSetClientNotVerifiedPhoneNumberImpl
import com.example.domain.interactors.client.setClientNotVerifiedPhoneNumber.InteractorSetClientNotVerifiedPhoneNumberResponseImpl
import com.example.domain.interactors.client.setClientPhoneNumber.IInteractorSetClientPhoneNumber
import com.example.domain.interactors.client.setClientPhoneNumber.IInteractorSetClientPhoneNumberResponse
import com.example.domain.interactors.client.setClientPhoneNumber.InteractorSetClientPhoneNumberImpl
import com.example.domain.interactors.client.setClientPhoneNumber.InteractorSetClientPhoneNumberResponseImpl
import org.koin.dsl.module

val networkClientModule = module {

    single<IInteractorGetClient> {
        InteractorGetClientImpl(
            useCase = get(),
            networkRepository = get()
        )
    }

    single<IInteractorLoadClient> {
        InteractorLoadClientImpl(
            useCase = get()
        )
    }

    single<IInteractorGetClientPinCodeVerification> {
        InteractorGetClientPinCodeVerificationImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorLoadClientPinCodeVerification> {
        InteractorLoadClientPinCodeVerificationImpl(
            useCase = get()
        )
    }

    single<IInteractorDeleteClient> {
        InteractorDeleteClientImpl(
            useCase = get()
        )
    }
    single<IInteractorDeleteClientResponse>(createdAtStart = true) {
        InteractorDeleteClientResponseImpl(
            useCase = get(),
            networkRepository = get()
        )
    }

    single<IInteractorAddToMyChosenTags> {
        InteractorAddToMyChosenTagsImpl(
            useCase = get()
        )
    }
    single<IInteractorAddToMyChosenTagsResponse>(createdAtStart = true) {
        InteractorAddToMyChosenTagsResponseImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorRemoveFromMyChosenTags> {
        InteractorRemoveFromMyChosenTagsImpl(
            useCase = get()
        )
    }
    single<IInteractorRemoveFromMyChosenTagsResponse>(createdAtStart = true) {
        InteractorRemoveFromMyChosenTagsResponseImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorAddToMyCommunities> {
        InteractorAddToMyCommunitiesImpl(
            useCase = get()
        )
    }
    single<IInteractorAddToMyCommunitiesResponse>(createdAtStart = true) {
        InteractorAddToMyCommunitiesResponseImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorRemoveFromMyCommunities> {
        InteractorRemoveFromMyCommunitiesImpl(
            useCase = get()
        )
    }
    single<IInteractorRemoveFromMyCommunitiesResponse>(createdAtStart = true) {
        InteractorRemoveFromMyCommunitiesResponseImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorAddToMyEvents> {
        InteractorAddToMyEventsImpl(
            useCase = get()
        )
    }
    single<IInteractorAddToMyEventsResponse>(createdAtStart = true) {
        InteractorAddToMyEventsResponseImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorRemoveFromMyEvents> {
        InteractorRemoveFromMyEventsImpl(
            useCase = get()
        )
    }
    single<IInteractorRemoveFromMyEventsResponse>(createdAtStart = true) {
        InteractorRemoveFromMyEventsResponseImpl(
            useCase = get(),
            networkRepository = get()
        )
    }

    single<IInteractorSaveClientSettings> {
        InteractorSaveClientSettingsImpl(
            useCase = get()
        )
    }
    single<IInteractoSaveClientSettingsResponse>(createdAtStart = true) {
        InteractoSaveClientSettingsResponseImpl(
            useCase = get(),
            networkRepository = get()
        )
    }

    single<IInteractorSetClientAvatar> {
        InteractorSetClientAvatarImpl(
            useCase = get()
        )
    }
    single<IInteractorSetClientAvatarResponse>(createdAtStart = true) {
        InteractorSetClientAvatarResponseImpl(
            useCase = get(),
            networkRepository = get()
        )
    }

    single<IInteractorSetClientName> {
        InteractorSetClientNameImpl(
            useCase = get()
        )
    }
    single<IInteractorSetClientNameResponse>(createdAtStart = true) {
        InteractorSetClientNameResponseImpl(
            useCase = get(),
            networkRepository = get()
        )
    }

    single<IInteractorSetClientPhoneNumber> {
        InteractorSetClientPhoneNumberImpl(
            useCase = get()
        )
    }
    single<IInteractorSetClientPhoneNumberResponse>(createdAtStart = true) {
        InteractorSetClientPhoneNumberResponseImpl(
            useCase = get(),
            networkRepository = get()
        )
    }

    single<IInteractorSetClientNotVerifiedName> {
        InteractorSetClientNotVerifiedNameImpl(
            useCase = get()
        )
    }
    single<IInteractorSetClientNotVerifiedNameResponse>(createdAtStart = true) {
        InteractorSetClientNotVerifiedNameResponseImpl(
            useCase = get(),
            networkRepository = get()
        )
    }

    single<IInteractorSetClientNotVerifiedPhoneNumber> {
        InteractorSetClientNotVerifiedPhoneNumberImpl(
            useCase = get()
        )
    }
    single<IInteractorSetClientNotVerifiedPhoneNumberResponse>(createdAtStart = true) {
        InteractorSetClientNotVerifiedPhoneNumberResponseImpl(
            useCase = get(),
            networkRepository = get()
        )
    }

    single<IInteractorLoadClientNotVerifiedName> {
        InteractorLoadClientNotVerifiedNameImpl(
            useCase = get()
        )
    }
    single<IInteractorGetClientNotVerifiedName> {
        InteractorGetClientNotVerifiedNameImpl(
            useCase = get(),
            networkRepository = get()
        )
    }

    single<IInteractorLoadtClientNotVerifiedPhoneNumber> {
        InteractorLoadtClientNotVerifiedPhoneNumberImpl(
            useCase = get()
        )
    }
    single<IInteractorGetClientNotVerifiedPhoneNumber> {
        InteractorGetClientNotVerifiedPhoneNumberImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
}