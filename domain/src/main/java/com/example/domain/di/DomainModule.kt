package com.example.domain.di

import com.example.domain.usecases.communities.GetCommunitiesListInteractor
import com.example.domain.usecases.communities.GetCommunitiesListUseCase
import com.example.domain.usecases.communities.GetCommunityDetailInteractor
import com.example.domain.usecases.communities.GetCommunityDetailUseCase
import com.example.domain.usecases.events.AddUserAsParticipantInteractor
import com.example.domain.usecases.events.AddUserAsParticipantUseCase
import com.example.domain.usecases.events.GetAllEventsActiveInteractor
import com.example.domain.usecases.events.GetAllEventsActiveUseCase
import com.example.domain.usecases.events.GetAllEventsInteractor
import com.example.domain.usecases.events.GetAllEventsUseCase
import com.example.domain.usecases.events.GetEventDetailsInteractor
import com.example.domain.usecases.events.GetEventDetailsUseCase
import com.example.domain.usecases.events.GetMyEventsListInteractor
import com.example.domain.usecases.events.GetMyEventsListUseCase
import com.example.domain.usecases.events.GetMyEventsPastListInteractor
import com.example.domain.usecases.events.GetMyEventsPastListUseCase
import com.example.domain.usecases.events.RemoveUserAsParticipantInteractor
import com.example.domain.usecases.events.RemoveUserAsParticipantUseCase
import com.example.domain.usecases.user.GetAvailableCountriesListInteractor
import com.example.domain.usecases.user.GetAvailableCountriesListUseCase
import com.example.domain.usecases.user.GetUserAvatarInteractor
import com.example.domain.usecases.user.GetUserAvatarUseCase
import com.example.domain.usecases.user.GetUserInteractor
import com.example.domain.usecases.user.GetUserPhoneNumberInteractor
import com.example.domain.usecases.user.GetUserPhoneNumberUseCase
import com.example.domain.usecases.user.GetUserUseCase
import com.example.domain.usecases.user.PinCodeVerificationInteractor
import com.example.domain.usecases.user.PinCodeVerificationUseCase
import com.example.domain.usecases.user.SetUserInteractor
import com.example.domain.usecases.user.SetUserPhoneNumberInteractor
import com.example.domain.usecases.user.SetUserPhoneNumberUseCase
import com.example.domain.usecases.user.SetUserUseCase
import org.koin.dsl.module

val domainModule = module {

    single<GetAvailableCountriesListUseCase> {
        GetAvailableCountriesListInteractor(countriesRepository = get())
    }
    single<SetUserPhoneNumberUseCase> {
        SetUserPhoneNumberInteractor(userRepository = get())
    }
    single<PinCodeVerificationUseCase> {
        PinCodeVerificationInteractor(userRepository = get())
    }
    single<GetUserAvatarUseCase> {
        GetUserAvatarInteractor(userRepository = get())
    }
    single<SetUserUseCase> {
        SetUserInteractor(userRepository = get())
    }
    single<GetUserPhoneNumberUseCase> {
        GetUserPhoneNumberInteractor(userRepository = get())
    }
    single<GetUserUseCase> {
        GetUserInteractor(userRepository = get())
    }

    single<GetAllEventsActiveUseCase> {
        GetAllEventsActiveInteractor(eventRepository = get())
    }
    single<GetAllEventsUseCase> {
        GetAllEventsInteractor(eventRepository = get())
    }
    single<GetEventDetailsUseCase> {
        GetEventDetailsInteractor(eventRepository = get())
    }
    single<GetMyEventsListUseCase> {
        GetMyEventsListInteractor(eventRepository = get())
    }
    single<GetMyEventsPastListUseCase> {
        GetMyEventsPastListInteractor(eventRepository = get())
    }

    single<GetCommunitiesListUseCase> {
        GetCommunitiesListInteractor(communityRepository = get())
    }
    single<GetCommunityDetailUseCase> {
        GetCommunityDetailInteractor(communityRepository = get())
    }
    single<AddUserAsParticipantUseCase> {
        AddUserAsParticipantInteractor(eventRepository = get())
    }
    single<RemoveUserAsParticipantUseCase> {
        RemoveUserAsParticipantInteractor(eventRepository = get())
    }

}