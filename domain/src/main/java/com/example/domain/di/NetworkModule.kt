package com.example.domain.di

import com.example.domain.interactors.advertBlock.communitiesAdvertBlock.IInteractorGetCommunitiesAdvertBlock
import com.example.domain.interactors.advertBlock.communitiesAdvertBlock.IInteractorLoadCommunitiesAdvertBlock
import com.example.domain.interactors.advertBlock.communitiesAdvertBlock.InteractorGetCommunitiesAdvertBlockImpl
import com.example.domain.interactors.advertBlock.communitiesAdvertBlock.InteractorLoadCommunitiesAdvertBlockImpl
import com.example.domain.interactors.advertBlock.eventsAdvertBlock.IInteractorGetEventsAdvertBlock
import com.example.domain.interactors.advertBlock.eventsAdvertBlock.IInteractorLoadEventsAdvertBlock
import com.example.domain.interactors.advertBlock.eventsAdvertBlock.InteractorGetEventsAdvertBlockImpl
import com.example.domain.interactors.advertBlock.eventsAdvertBlock.InteractorLoadEventsAdvertBlockImpl
import com.example.domain.interactors.availableCountries.IInteractorGetAvailableCountriesList
import com.example.domain.interactors.availableCountries.IInteractorLoadAvailableCountriesList
import com.example.domain.interactors.availableCountries.InteractorGetAvailableCountriesListImpl
import com.example.domain.interactors.availableCountries.InteractorLoadAvailableCountriesListImpl
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
import org.koin.dsl.module

val networkModule = module {

    single<IInteractorLoadCommunitiesAdvertBlock> {
        InteractorLoadCommunitiesAdvertBlockImpl(
            useCase = get(),
        )
    }
    single<IInteractorGetCommunitiesAdvertBlock> {
        InteractorGetCommunitiesAdvertBlockImpl(
            useCase = get(),
            networkRepository = get()
        )
    }

    single<IInteractorLoadEventsAdvertBlock> {
        InteractorLoadEventsAdvertBlockImpl(
            useCase = get()
        )
    }
    single<IInteractorGetEventsAdvertBlock> {
        InteractorGetEventsAdvertBlockImpl(
            useCase = get(),
            networkRepository = get()
        )
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
}