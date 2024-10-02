package com.example.domain.di

import com.example.domain.usecase.ClientUseCase
import com.example.domain.usecase.EventsUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single<EventsUseCase> { EventsUseCase() }
    single<ClientUseCase> { ClientUseCase() }
}