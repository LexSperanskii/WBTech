package com.example.domain.di

import com.example.domain.interactors.advertBlock.IInteractorGetCommunitiesAdvertBlock
import com.example.domain.interactors.advertBlock.IInteractorGetEventsAdvertBlock
import com.example.domain.interactors.advertBlock.InteractorGetCommunitiesAdvertBlockImpl
import com.example.domain.interactors.advertBlock.InteractorGetEventsAdvertBlockImpl
import com.example.domain.interactors.availableCountries.IInteractorGetAvailableCountriesList
import com.example.domain.interactors.availableCountries.IInteractorLoadAvailableCountriesList
import com.example.domain.interactors.availableCountries.InteractorGetAvailableCountriesListImpl
import com.example.domain.interactors.availableCountries.InteractorLoadAvailableCountriesListImpl
import com.example.domain.interactors.client.IInteractorGetClient
import com.example.domain.interactors.client.IInteractorGetClientNotVerifiedName
import com.example.domain.interactors.client.IInteractorGetClientNotVerifiedPhoneNumber
import com.example.domain.interactors.client.IInteractorGetClientPinCodeVerification
import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.interactors.client.IInteractorLoadClientPinCodeVerification
import com.example.domain.interactors.client.IInteractorSaveClientSettings
import com.example.domain.interactors.client.IInteractorSetClientAvatar
import com.example.domain.interactors.client.IInteractorSetClientName
import com.example.domain.interactors.client.IInteractorSetClientNotVerifiedName
import com.example.domain.interactors.client.IInteractorSetClientNotVerifiedPhoneNumber
import com.example.domain.interactors.client.IInteractorSetClientPhoneNumber
import com.example.domain.interactors.client.InteractorGetClientImpl
import com.example.domain.interactors.client.InteractorGetClientNotVerifiedNameImpl
import com.example.domain.interactors.client.InteractorGetClientNotVerifiedPhoneNumberImpl
import com.example.domain.interactors.client.InteractorGetClientPinCodeVerificationImpl
import com.example.domain.interactors.client.InteractorLoadClientImpl
import com.example.domain.interactors.client.InteractorLoadClientPinCodeVerificationImpl
import com.example.domain.interactors.client.InteractorSaveClientSettingsImpl
import com.example.domain.interactors.client.InteractorSetClientAvatarImpl
import com.example.domain.interactors.client.InteractorSetClientNameImpl
import com.example.domain.interactors.client.InteractorSetClientNotVerifiedNameImpl
import com.example.domain.interactors.client.InteractorSetClientNotVerifiedPhoneNumberImpl
import com.example.domain.interactors.client.InteractorSetClientPhoneNumberImpl
import com.example.domain.interactors.client.myChosenTags.IInteractorAddToMyChosenTags
import com.example.domain.interactors.client.myChosenTags.IInteractorRemoveFromMyChosenTags
import com.example.domain.interactors.client.myChosenTags.InteractorAddToMyChosenTagsImpl
import com.example.domain.interactors.client.myChosenTags.InteractorRemoveFromMyChosenTagsImpl
import com.example.domain.interactors.client.myCommunities.IInteractorAddToMyCommunities
import com.example.domain.interactors.client.myCommunities.IInteractorRemoveFromMyCommunities
import com.example.domain.interactors.client.myCommunities.InteracterRemoveFromMyCommunitiesImpl
import com.example.domain.interactors.client.myCommunities.InteractorAddToMyCommunitiesImpl
import com.example.domain.interactors.client.myEvents.IInteractorAddToMyEvents
import com.example.domain.interactors.client.myEvents.IInteractorRemoveFromMyEvents
import com.example.domain.interactors.client.myEvents.InteractorAddToMyEventsImpl
import com.example.domain.interactors.client.myEvents.InteractorRemoveFromMyEventsImpl
import com.example.domain.interactors.client.oldSuspend.deleteClient.IInteractorLoadDeleteClient
import com.example.domain.interactors.client.oldSuspend.deleteClient.InteractorLoadDeleteClientImpl
import com.example.domain.interactors.communitiesDescription.IInteractorGetCommunitiesDescription
import com.example.domain.interactors.communitiesDescription.IInteractorLoadCommunitiesDescription
import com.example.domain.interactors.communitiesDescription.InteractorGetCommunitiesDescriptionImpl
import com.example.domain.interactors.communitiesDescription.InteractorLoadCommunitiesDescriptionImpl
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
    single<IInteractorSetClientName> {
        InteractorSetClientNameImpl(
            networkRepository = get(),
            loadClient = get()
        )
    }
    single<IInteractorSetClientPhoneNumber> {
        InteractorSetClientPhoneNumberImpl(
            networkRepository = get(),
            loadClient = get()
        )
    }
    single<IInteractorSetClientAvatar> {
        InteractorSetClientAvatarImpl(
            networkRepository = get(),
            loadClient = get()
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
    single<IInteractorLoadDeleteClient> {
        InteractorLoadDeleteClientImpl(
            networkRepository = get(),
            loadClient = get()
        )
    }
    single<IInteractorSaveClientSettings> {
        InteractorSaveClientSettingsImpl(
            networkRepository = get(),
            loadClient = get()
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



    single<IInteractorAddToMyChosenTags> {
        InteractorAddToMyChosenTagsImpl(
            networkRepository = get(),
            loadClient = get()
        )
    }
    single<IInteractorRemoveFromMyChosenTags> {
        InteractorRemoveFromMyChosenTagsImpl(
            networkRepository = get(),
            loadClient = get()
        )
    }



    single<IInteractorAddToMyCommunities> {
        InteractorAddToMyCommunitiesImpl(
            networkRepository = get(),
            loadClient = get()
        )
    }
    single<IInteractorRemoveFromMyCommunities> {
        InteracterRemoveFromMyCommunitiesImpl(
            networkRepository = get(),
            loadClient = get()
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



    single<IInteractorAddToMyEvents> {
        InteractorAddToMyEventsImpl(
            networkRepository = get(),
            loadClient = get()
        )
    }
    single<IInteractorRemoveFromMyEvents> {
        InteractorRemoveFromMyEventsImpl(
            networkRepository = get(),
            loadClient = get()
        )
    }
}