package com.example.domain.di

import com.example.domain.usecases.user.GetAvailableCountriesListUseCase
import com.example.domain.usecases.user.GetAvailableCountriesListUseCaseImpl
import com.example.domain.usecases.user.GetPinCodeVerificationUseCase
import com.example.domain.usecases.user.GetPinCodeVerificationUseCaseImpl
import com.example.domain.usecases.user.GetUserAvatarUseCase
import com.example.domain.usecases.user.GetUserAvatarUseCaseImpl
import com.example.domain.usecases.user.GetUserPhoneNumberUseCase
import com.example.domain.usecases.user.GetUserPhoneNumberUseCaseImpl
import com.example.domain.usecases.user.GetUserUseCase
import com.example.domain.usecases.user.GetUserUseCaseImpl
import com.example.domain.usecases.user.SetUserPhoneNumberUseCase
import com.example.domain.usecases.user.SetUserPhoneNumberUseCaseImpl
import com.example.domain.usecases.user.SetUserPinCodeUseCase
import com.example.domain.usecases.user.SetUserPinCodeUseCaseImpl
import com.example.domain.usecases.user.SetUserUseCase
import com.example.domain.usecases.user.SetUserUseCaseImpl
import org.koin.dsl.module

val userModule = module {

    single<GetAvailableCountriesListUseCase> {
        GetAvailableCountriesListUseCaseImpl(countriesRepository = get())
    }
    single<SetUserPhoneNumberUseCase> {
        SetUserPhoneNumberUseCaseImpl(userRepository = get())
    }
    single<GetPinCodeVerificationUseCase> {
        GetPinCodeVerificationUseCaseImpl(userRepository = get())
    }
    single<SetUserPinCodeUseCase> {
        SetUserPinCodeUseCaseImpl(userRepository = get())
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

}