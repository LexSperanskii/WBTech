package com.example.domain.di

import com.example.domain.usecases.user.GetAvailableCountriesListInteractor
import com.example.domain.usecases.user.GetAvailableCountriesListUseCase
import com.example.domain.usecases.user.GetAvailableCountyInteractor
import com.example.domain.usecases.user.GetAvailableCountyUseCase
import com.example.domain.usecases.user.GetUserAvatarInteractor
import com.example.domain.usecases.user.GetUserAvatarUseCase
import com.example.domain.usecases.user.GetUserPhoneNumberInteractor
import com.example.domain.usecases.user.GetUserPhoneNumberUseCase
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
}