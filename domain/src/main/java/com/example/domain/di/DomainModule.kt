package com.example.domain.di

import com.example.domain.interactors.availableCountries.IInteractorGetAvailableCountriesList
import com.example.domain.interactors.availableCountries.IInteractorLoadAvailableCountriesList
import com.example.domain.interactors.availableCountries.InteractorGetAvailableCountriesListImpl
import com.example.domain.interactors.availableCountries.InteractorLoadAvailableCountriesListImpl
import com.example.domain.interactors.client.IInteractorGetClient
import com.example.domain.interactors.client.IInteractorGetClientPinCodeVerification
import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.interactors.client.IInteractorLoadClientPinCodeVerification
import com.example.domain.interactors.client.InteractorGetClientImpl
import com.example.domain.interactors.client.InteractorGetClientPinCodeVerificationImpl
import com.example.domain.interactors.client.InteractorLoadClientImpl
import com.example.domain.interactors.client.InteractorLoadClientPinCodeVerificationImpl
import com.example.domain.interactors.communitiesDescription.IInteractorGetCommunitiesDescription
import com.example.domain.interactors.communitiesDescription.IInteractorLoadCommunitiesDescription
import com.example.domain.interactors.communitiesDescription.InteractorGetCommunitiesDescriptionImpl
import com.example.domain.interactors.communitiesDescription.InteractorLoadCommunitiesDescriptionImpl
import com.example.domain.interactors.dataStore.IInteractorClearDataStore
import com.example.domain.interactors.dataStore.IInteractorGetDataStore
import com.example.domain.interactors.dataStore.IInteractorSetDataStore
import com.example.domain.interactors.dataStore.InteractorClearDataStoreImpl
import com.example.domain.interactors.dataStore.InteractorGetDataStoreImpl
import com.example.domain.interactors.dataStore.InteractorSetDataStoreImpl
import com.example.domain.interactors.eventDescription.IInteractorGetEventDescription
import com.example.domain.interactors.eventDescription.IInteractorLoadEventDescription
import com.example.domain.interactors.eventDescription.InteractorGetEventDescriptionImpl
import com.example.domain.interactors.eventDescription.InteractorLoadEventDescriptionImpl
import com.example.domain.interactors.listOfCommunities.IInteractorGetListOfCommunities
import com.example.domain.interactors.listOfCommunities.IInteractorLoadListOfCommunities
import com.example.domain.interactors.listOfCommunities.InteractorGetListOfCommunitiesImpl
import com.example.domain.interactors.listOfCommunities.InteractorLoadListOfCommunitiesImpl
import com.example.domain.interactors.listOfEvents.IInteractorGetListOfEvents
import com.example.domain.interactors.listOfEvents.IInteractorLoadListOfEvents
import com.example.domain.interactors.listOfEvents.InteractorGetListOfEventsImpl
import com.example.domain.interactors.listOfEvents.InteractorLoadListOfEventsImpl
import com.example.domain.interactors.listOfParticipants.IInteractorGetListOfParticipants
import com.example.domain.interactors.listOfParticipants.IInteractorLoadListOfParticipants
import com.example.domain.interactors.listOfParticipants.InteractorGetListOfParticipantsImpl
import com.example.domain.interactors.listOfParticipants.InteractorLoadListOfParticipantsImpl
import com.example.domain.interactors.listOfPeople.IInteractorGetListOfPeople
import com.example.domain.interactors.listOfPeople.IInteractorLoadListOfPeople
import com.example.domain.interactors.listOfPeople.InteractorGetListOfPeopleImpl
import com.example.domain.interactors.listOfPeople.InteractorLoadListOfPeopleImpl
import com.example.domain.interactors.listOfSortedEvents.IInteractorGetListOfSortedEvents
import com.example.domain.interactors.listOfSortedEvents.IInteractorLoadListOfSortedEvents
import com.example.domain.interactors.listOfSortedEvents.InteractorGetListOfSortedEventsImpl
import com.example.domain.interactors.listOfSortedEvents.InteractorLoadListOfSortedEventsImpl
import com.example.domain.interactors.listOfTags.IInteractorGetListOfTags
import com.example.domain.interactors.listOfTags.IInteractorLoadListOfTags
import com.example.domain.interactors.listOfTags.InteractorGetListOfTagsImpl
import com.example.domain.interactors.listOfTags.InteractorLoadListOfTagsImpl
import com.example.domain.interactors.oldSuspend.IInteractorDeleteClient
import com.example.domain.interactors.oldSuspend.IInteractorGetClientNotVerifiedName
import com.example.domain.interactors.oldSuspend.IInteractorGetClientNotVerifiedPhoneNumber
import com.example.domain.interactors.oldSuspend.IInteractorSaveClientSettings
import com.example.domain.interactors.oldSuspend.IInteractorSetClientAvatar
import com.example.domain.interactors.oldSuspend.IInteractorSetClientName
import com.example.domain.interactors.oldSuspend.IInteractorSetClientNotVerifiedName
import com.example.domain.interactors.oldSuspend.IInteractorSetClientNotVerifiedPhoneNumber
import com.example.domain.interactors.oldSuspend.IInteractorSetClientPhoneNumber
import com.example.domain.interactors.oldSuspend.InteractorDeleteClientImpl
import com.example.domain.interactors.oldSuspend.InteractorGetClientNotVerifiedNameImpl
import com.example.domain.interactors.oldSuspend.InteractorGetClientNotVerifiedPhoneNumberImpl
import com.example.domain.interactors.oldSuspend.InteractorSaveClientSettingsImpl
import com.example.domain.interactors.oldSuspend.InteractorSetClientAvatarImpl
import com.example.domain.interactors.oldSuspend.InteractorSetClientNameImpl
import com.example.domain.interactors.oldSuspend.InteractorSetClientNotVerifiedNameImpl
import com.example.domain.interactors.oldSuspend.InteractorSetClientNotVerifiedPhoneNumberImpl
import com.example.domain.interactors.oldSuspend.InteractorSetClientPhoneNumberImpl
import com.example.domain.interactors.oldSuspend.advertBlock.IInteractorGetCommunitiesAdvertBlock
import com.example.domain.interactors.oldSuspend.advertBlock.IInteractorGetEventsAdvertBlock
import com.example.domain.interactors.oldSuspend.advertBlock.InteractorGetCommunitiesAdvertBlockImpl
import com.example.domain.interactors.oldSuspend.advertBlock.InteractorGetEventsAdvertBlockImpl
import com.example.domain.interactors.oldSuspend.myChosenTags.IInteractorAddToMyChosenTags
import com.example.domain.interactors.oldSuspend.myChosenTags.IInteractorRemoveFromMyChosenTags
import com.example.domain.interactors.oldSuspend.myChosenTags.InteractorAddToMyChosenTagsImpl
import com.example.domain.interactors.oldSuspend.myChosenTags.InteractorRemoveFromMyChosenTagsImpl
import com.example.domain.interactors.oldSuspend.myCommunities.IInteractorAddToMyCommunities
import com.example.domain.interactors.oldSuspend.myCommunities.IInteractorRemoveFromMyCommunities
import com.example.domain.interactors.oldSuspend.myCommunities.InteractorAddToMyCommunitiesImpl
import com.example.domain.interactors.oldSuspend.myCommunities.InteractorRemoveFromMyCommunitiesImpl
import com.example.domain.interactors.oldSuspend.myEvents.IInteractorAddToMyEvents
import com.example.domain.interactors.oldSuspend.myEvents.IInteractorRemoveFromMyEvents
import com.example.domain.interactors.oldSuspend.myEvents.InteractorAddToMyEventsImpl
import com.example.domain.interactors.oldSuspend.myEvents.InteractorRemoveFromMyEventsImpl
import com.example.domain.interactors.user.IInteractorGetUser
import com.example.domain.interactors.user.IInteractorLoadUser
import com.example.domain.interactors.user.InteractorGetUserImpl
import com.example.domain.interactors.user.InteractorLoadUserImpl
import com.example.domain.usecase.EventsUseCase
import org.koin.dsl.module

val domainModule = module {

    single<EventsUseCase> { EventsUseCase() }


    single<IInteractorGetCommunitiesAdvertBlock> {
        InteractorGetCommunitiesAdvertBlockImpl(networkRepository = get())
    }
    single<IInteractorGetEventsAdvertBlock> {
        InteractorGetEventsAdvertBlockImpl(networkRepository = get())
    }


    single<IInteractorGetAvailableCountriesList> {
        InteractorGetAvailableCountriesListImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorLoadAvailableCountriesList> {
        InteractorLoadAvailableCountriesListImpl(
            useCase = get()
        )
    }


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


    single<IInteractorSetClientNotVerifiedName> {
        InteractorSetClientNotVerifiedNameImpl(networkRepository = get())
    }
    single<IInteractorGetClientNotVerifiedName> {
        InteractorGetClientNotVerifiedNameImpl(networkRepository = get())
    }
    single<IInteractorSetClientNotVerifiedPhoneNumber> {
        InteractorSetClientNotVerifiedPhoneNumberImpl(networkRepository = get())
    }
    single<IInteractorGetClientNotVerifiedPhoneNumber> {
        InteractorGetClientNotVerifiedPhoneNumberImpl(networkRepository = get())
    }


    single<IInteractorGetCommunitiesDescription> {
        InteractorGetCommunitiesDescriptionImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorLoadCommunitiesDescription> {
        InteractorLoadCommunitiesDescriptionImpl(
            useCase = get()
        )
    }


    single<IInteractorGetEventDescription> {
        InteractorGetEventDescriptionImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorLoadEventDescription> {
        InteractorLoadEventDescriptionImpl(
            useCase = get()
        )
    }


    single<IInteractorGetListOfCommunities> {
        InteractorGetListOfCommunitiesImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorLoadListOfCommunities> {
        InteractorLoadListOfCommunitiesImpl(
            useCase = get()
        )
    }


    single<IInteractorGetListOfEvents> {
        InteractorGetListOfEventsImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorLoadListOfEvents> {
        InteractorLoadListOfEventsImpl(
            useCase = get()
        )
    }


    single<IInteractorGetListOfParticipants> {
        InteractorGetListOfParticipantsImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorLoadListOfParticipants> {
        InteractorLoadListOfParticipantsImpl(
            useCase = get()
        )
    }


    single<IInteractorGetListOfPeople> {
        InteractorGetListOfPeopleImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorLoadListOfPeople> {
        InteractorLoadListOfPeopleImpl(
            useCase = get()
        )
    }


    single<IInteractorGetListOfTags> {
        InteractorGetListOfTagsImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorLoadListOfTags> {
        InteractorLoadListOfTagsImpl(
            useCase = get()
        )
    }


    single<IInteractorGetUser> {
        InteractorGetUserImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorLoadUser> {
        InteractorLoadUserImpl(
            useCase = get()
        )
    }


    single<IInteractorGetListOfSortedEvents> {
        InteractorGetListOfSortedEventsImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorLoadListOfSortedEvents> {
        InteractorLoadListOfSortedEventsImpl(
            useCase = get()
        )
    }




    single<IInteractorSaveClientSettings> {
        InteractorSaveClientSettingsImpl(
            networkRepository = get(),
            useCase = get()
        )
    }
    single<IInteractorDeleteClient> {
        InteractorDeleteClientImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorAddToMyEvents> {
        InteractorAddToMyEventsImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorRemoveFromMyEvents> {
        InteractorRemoveFromMyEventsImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorAddToMyCommunities> {
        InteractorAddToMyCommunitiesImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorRemoveFromMyCommunities> {
        InteractorRemoveFromMyCommunitiesImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorAddToMyChosenTags> {
        InteractorAddToMyChosenTagsImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorRemoveFromMyChosenTags> {
        InteractorRemoveFromMyChosenTagsImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorSetClientName> {
        InteractorSetClientNameImpl(
            networkRepository = get(),
            useCase = get()
        )
    }
    single<IInteractorSetClientPhoneNumber> {
        InteractorSetClientPhoneNumberImpl(
            networkRepository = get(),
            useCase = get()
        )
    }
    single<IInteractorSetClientAvatar> {
        InteractorSetClientAvatarImpl(
            networkRepository = get(),
            useCase = get()
        )
    }


    single<IInteractorGetDataStore> {
        InteractorGetDataStoreImpl(
            datastoreRepository = get()
        )
    }
    single<IInteractorSetDataStore> {
        InteractorSetDataStoreImpl(
            datastoreRepository = get()
        )
    }
    single<IInteractorClearDataStore> {
        InteractorClearDataStoreImpl(
            datastoreRepository = get()
        )
    }
}