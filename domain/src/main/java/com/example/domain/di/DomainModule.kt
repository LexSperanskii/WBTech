package com.example.domain.di

import com.example.domain.usecases.communities.GetCommunitiesListUseCase
import com.example.domain.usecases.communities.GetCommunitiesListUseCaseImpl
import com.example.domain.usecases.communities.GetCommunityDetailUseCase
import com.example.domain.usecases.communities.GetCommunityDetailUseCaseImpl
import com.example.domain.usecases.events.AddUserAsParticipantUseCase
import com.example.domain.usecases.events.AddUserAsParticipantUseCaseImpl
import com.example.domain.usecases.events.GetAllEventsActiveUseCase
import com.example.domain.usecases.events.GetAllEventsActiveUseCaseImpl
import com.example.domain.usecases.events.GetAllEventsUseCase
import com.example.domain.usecases.events.GetAllEventsUseCaseImpl
import com.example.domain.usecases.events.GetEventDetailsUseCase
import com.example.domain.usecases.events.GetEventDetailsUseCaseImpl
import com.example.domain.usecases.events.GetMyEventsListUseCase
import com.example.domain.usecases.events.GetMyEventsListUseCaseImpl
import com.example.domain.usecases.events.GetMyEventsPastListUseCase
import com.example.domain.usecases.events.GetMyEventsPastListUseCaseImpl
import com.example.domain.usecases.events.RemoveUserAsParticipantUseCase
import com.example.domain.usecases.events.RemoveUserAsParticipantUseCaseImpl
import com.example.domain.usecases.user.GetAvailableCountriesListUseCase
import com.example.domain.usecases.user.GetAvailableCountriesListUseCaseImpl
import com.example.domain.usecases.user.GetUserAvatarUseCase
import com.example.domain.usecases.user.GetUserAvatarUseCaseImpl
import com.example.domain.usecases.user.GetUserPhoneNumberUseCase
import com.example.domain.usecases.user.GetUserPhoneNumberUseCaseImpl
import com.example.domain.usecases.user.GetUserUseCase
import com.example.domain.usecases.user.GetUserUseCaseImpl
import com.example.domain.usecases.user.PinCodeVerificationUseCase
import com.example.domain.usecases.user.PinCodeVerificationUseCaseImpl
import com.example.domain.usecases.user.SetUserPhoneNumberUseCase
import com.example.domain.usecases.user.SetUserPhoneNumberUseCaseImpl
import com.example.domain.usecases.user.SetUserUseCase
import com.example.domain.usecases.user.SetUserUseCaseImpl
import org.koin.dsl.module

val domainModule = module {

    single<GetAvailableCountriesListUseCase> {
        GetAvailableCountriesListUseCaseImpl(countriesRepository = get())
    }
    single<SetUserPhoneNumberUseCase> {
        SetUserPhoneNumberUseCaseImpl(userRepository = get())
    }
    single<PinCodeVerificationUseCase> {
        PinCodeVerificationUseCaseImpl(userRepository = get())
    }
    single<GetUserAvatarUseCase> {
        GetUserAvatarUseCaseImpl(userRepository = get())
    }
    single<SetUserUseCase> {
        SetUserUseCaseImpl(userRepository = get())
    }
    single<GetUserPhoneNumberUseCase> {
        GetUserPhoneNumberUseCaseImpl(userRepository = get())
    }
    single<GetUserUseCase> {
        GetUserUseCaseImpl(userRepository = get())
    }

    single<GetAllEventsActiveUseCase> {
        GetAllEventsActiveUseCaseImpl(eventRepository = get())
    }
    single<GetAllEventsUseCase> {
        GetAllEventsUseCaseImpl(eventRepository = get())
    }
    single<GetEventDetailsUseCase> {
        GetEventDetailsUseCaseImpl(eventRepository = get())
    }
    single<GetMyEventsListUseCase> {
        GetMyEventsListUseCaseImpl(eventRepository = get())
    }
    single<GetMyEventsPastListUseCase> {
        GetMyEventsPastListUseCaseImpl(eventRepository = get())
    }

    single<GetCommunitiesListUseCase> {
        GetCommunitiesListUseCaseImpl(communityRepository = get())
    }
    single<GetCommunityDetailUseCase> {
        GetCommunityDetailUseCaseImpl(communityRepository = get())
    }
    single<AddUserAsParticipantUseCase> {
        AddUserAsParticipantUseCaseImpl(eventRepository = get())
    }
    single<RemoveUserAsParticipantUseCase> {
        RemoveUserAsParticipantUseCaseImpl(eventRepository = get())
    }

}