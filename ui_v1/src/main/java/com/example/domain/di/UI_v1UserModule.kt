package com.example.domain.di

import com.example.domain.usecase.user.Uiv1GetAvailableCountriesListUseCase
import com.example.domain.usecase.user.Uiv1GetAvailableCountriesListUseCaseImpl
import com.example.domain.usecase.user.Uiv1GetPinCodeVerificationUseCase
import com.example.domain.usecase.user.Uiv1GetPinCodeVerificationUseCaseImpl
import com.example.domain.usecase.user.Uiv1GetUserAvatarUseCase
import com.example.domain.usecase.user.Uiv1GetUserAvatarUseCaseImpl
import com.example.domain.usecase.user.Uiv1GetUserPhoneNumberUseCase
import com.example.domain.usecase.user.Uiv1GetUserPhoneNumberUseCaseImpl
import com.example.domain.usecase.user.Uiv1GetUserUseCase
import com.example.domain.usecase.user.Uiv1GetUserUseCaseImpl
import com.example.domain.usecase.user.Uiv1SetUserPhoneNumberUseCase
import com.example.domain.usecase.user.Uiv1SetUserPhoneNumberUseCaseImpl
import com.example.domain.usecase.user.Uiv1SetUserPinCodeUseCase
import com.example.domain.usecase.user.Uiv1SetUserPinCodeUseCaseImpl
import com.example.domain.usecase.user.Uiv1SetUserUseCase
import com.example.domain.usecase.user.Uiv1SetUserUseCaseImpl
import org.koin.dsl.module

internal val uiv1UserModule = module {

    single<Uiv1GetAvailableCountriesListUseCase> {
        Uiv1GetAvailableCountriesListUseCaseImpl(countriesRepository = get())
    }
    single<Uiv1SetUserPhoneNumberUseCase> {
        Uiv1SetUserPhoneNumberUseCaseImpl(userRepository = get())
    }
    single<Uiv1GetPinCodeVerificationUseCase> {
        Uiv1GetPinCodeVerificationUseCaseImpl(userRepository = get())
    }
    single<Uiv1SetUserPinCodeUseCase> {
        Uiv1SetUserPinCodeUseCaseImpl(userRepository = get())
    }
    single<Uiv1GetUserAvatarUseCase> {
        Uiv1GetUserAvatarUseCaseImpl(userRepository = get())
    }
    single<Uiv1SetUserUseCase> {
        Uiv1SetUserUseCaseImpl(userRepository = get())
    }
    single<Uiv1GetUserPhoneNumberUseCase> {
        Uiv1GetUserPhoneNumberUseCaseImpl(userRepository = get())
    }
    single<Uiv1GetUserUseCase> {
        Uiv1GetUserUseCaseImpl(userRepository = get())
    }

}