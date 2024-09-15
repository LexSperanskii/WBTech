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
import com.example.domain.interactors.client.IInteractorGetClientPhoneNumber
import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.interactors.client.IInteractorSetClientName
import com.example.domain.interactors.client.IInteractorSetClientPhoneNumber
import com.example.domain.interactors.client.IInteractorSetClientPinCode
import com.example.domain.interactors.client.InteractorGetClientImpl
import com.example.domain.interactors.client.InteractorGetClientPhoneNumberImpl
import com.example.domain.interactors.client.InteractorLoadClientImpl
import com.example.domain.interactors.client.InteractorSetClientNameImpl
import com.example.domain.interactors.client.InteractorSetClientPhoneNumberImpl
import com.example.domain.interactors.client.InteractorSetClientPinCodeImpl
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
import com.example.domain.interactors.myChosenTags.IInteractorAddToMyChosenTags
import com.example.domain.interactors.myChosenTags.IInteractorGetMyChosenTagsList
import com.example.domain.interactors.myChosenTags.IInteractorLoadMyChosenTagsList
import com.example.domain.interactors.myChosenTags.IInteractorRemoveFromMyChosenTags
import com.example.domain.interactors.myChosenTags.InteractorAddToMyChosenTagsImpl
import com.example.domain.interactors.myChosenTags.InteractorGetMyChosenTagsListImpl
import com.example.domain.interactors.myChosenTags.InteractorLoadMyChosenTagsListImpl
import com.example.domain.interactors.myChosenTags.InteractorRemoveFromMyChosenTagsImpl
import com.example.domain.interactors.myCommunities.IInteractorAddToMyCommunities
import com.example.domain.interactors.myCommunities.IInteractorGetMyCommunitiesList
import com.example.domain.interactors.myCommunities.IInteractorLoadMyCommunitiesList
import com.example.domain.interactors.myCommunities.IInteractorRemoveFromMyCommunities
import com.example.domain.interactors.myCommunities.InteracterRemoveFromMyCommunitiesImpl
import com.example.domain.interactors.myCommunities.InteractorAddToMyCommunitiesImpl
import com.example.domain.interactors.myCommunities.InteractorGetMyCommunitiesListImpl
import com.example.domain.interactors.myCommunities.InteractorLoadMyCommunitiesListImpl
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
    single<IInteractorGetClientPhoneNumber> {
        InteractorGetClientPhoneNumberImpl(networkRepository = get())
    }
    single<IInteractorSetClientName> {
        InteractorSetClientNameImpl(networkRepository = get())
    }
    single<IInteractorSetClientPhoneNumber> {
        InteractorSetClientPhoneNumberImpl(networkRepository = get())
    }
    single<IInteractorSetClientPinCode> {
        InteractorSetClientPinCodeImpl(networkRepository = get())
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


    single<IInteractorGetMyChosenTagsList> {
        InteractorGetMyChosenTagsListImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorLoadMyChosenTagsList> {
        InteractorLoadMyChosenTagsListImpl(
            useCase = get()
        )
    }
    single<IInteractorAddToMyChosenTags> {
        InteractorAddToMyChosenTagsImpl(networkRepository = get())
    }
    single<IInteractorRemoveFromMyChosenTags> {
        InteractorRemoveFromMyChosenTagsImpl(networkRepository = get())
    }


    single<IInteractorGetMyCommunitiesList> {
        InteractorGetMyCommunitiesListImpl(
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorLoadMyCommunitiesList> {
        InteractorLoadMyCommunitiesListImpl(
            useCase = get()
        )
    }
    single<IInteractorAddToMyCommunities> {
        InteractorAddToMyCommunitiesImpl(networkRepository = get())
    }
    single<IInteractorRemoveFromMyCommunities> {
        InteracterRemoveFromMyCommunitiesImpl(networkRepository = get())
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
}