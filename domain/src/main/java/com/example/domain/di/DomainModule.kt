package com.example.domain.di

import com.example.domain.usecases.communities.GetCommunitiesListInteractor
import com.example.domain.usecases.communities.GetCommunitiesListUseCase
import com.example.domain.usecases.communities.GetCommunityDetailInteractor
import com.example.domain.usecases.communities.GetCommunityDetailUseCase
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
import com.example.domain.usecases.user.GetAvailableCountriesListInteractor
import com.example.domain.usecases.user.GetAvailableCountriesListUseCase
import com.example.domain.usecases.user.GetAvailableCountyInteractor
import com.example.domain.usecases.user.GetAvailableCountyUseCase
import com.example.domain.usecases.user.GetUserAvatarInteractor
import com.example.domain.usecases.user.GetUserAvatarUseCase
import com.example.domain.usecases.user.GetUserInteractor
import com.example.domain.usecases.user.GetUserPhoneNumberInteractor
import com.example.domain.usecases.user.GetUserPhoneNumberUseCase
import com.example.domain.usecases.user.GetUserUseCase
import com.example.domain.usecases.user.SetUserAvatarInteractor
import com.example.domain.usecases.user.SetUserAvatarUseCase
import com.example.domain.usecases.user.SetUserNameInteractor
import com.example.domain.usecases.user.SetUserNameUseCase
import com.example.domain.usecases.user.SetUserPhoneNumberInteractor
import com.example.domain.usecases.user.SetUserPhoneNumberUseCase
import com.example.domain.usecases.user.SetUserSurnameInteractor
import com.example.domain.usecases.user.SetUserSurnameUseCase
import org.koin.dsl.module

val domainModule = module {

    single<GetAvailableCountriesListUseCase> {
        GetAvailableCountriesListInteractor(countriesRepository = get())
    }
    single<GetAvailableCountyUseCase> {
        GetAvailableCountyInteractor(countriesRepository = get())
    }
    single<SetUserPhoneNumberUseCase> {
        SetUserPhoneNumberInteractor(userRepository = get())
    }
    single<GetUserAvatarUseCase> {
        GetUserAvatarInteractor(userRepository = get())
    }
    single<SetUserNameUseCase> {
        SetUserNameInteractor(userRepository = get())
    }
    single<SetUserSurnameUseCase> {
        SetUserSurnameInteractor(userRepository = get())
    }
    single<SetUserAvatarUseCase> {
        SetUserAvatarInteractor(userRepository = get())
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
}