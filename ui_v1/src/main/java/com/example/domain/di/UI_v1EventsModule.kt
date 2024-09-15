package com.example.domain.di

import com.example.domain.usecase.events.Uiv1GetAllEventsActiveUseCase
import com.example.domain.usecase.events.Uiv1GetAllEventsActiveUseCaseImpl
import com.example.domain.usecase.events.Uiv1GetAllEventsUseCase
import com.example.domain.usecase.events.Uiv1GetAllEventsUseCaseImpl
import com.example.domain.usecase.events.Uiv1GetEventDetailsUseCase
import com.example.domain.usecase.events.Uiv1GetEventDetailsUseCaseImpl
import com.example.domain.usecase.events.Uiv1GetMyEventsListUseCase
import com.example.domain.usecase.events.Uiv1GetMyEventsListUseCaseImpl
import com.example.domain.usecase.events.Uiv1GetMyEventsPastListUseCase
import com.example.domain.usecase.events.Uiv1GetMyEventsPastListUseCaseImpl
import org.koin.dsl.module

internal val uiv1EventsModule = module {

    single<Uiv1GetAllEventsActiveUseCase> {
        Uiv1GetAllEventsActiveUseCaseImpl(eventRepository = get())
    }
    single<Uiv1GetAllEventsUseCase> {
        Uiv1GetAllEventsUseCaseImpl(eventRepository = get())
    }
    single<Uiv1GetEventDetailsUseCase> {
        Uiv1GetEventDetailsUseCaseImpl(eventRepository = get())
    }
    single<Uiv1GetMyEventsListUseCase> {
        Uiv1GetMyEventsListUseCaseImpl(eventRepository = get())
    }
    single<Uiv1GetMyEventsPastListUseCase> {
        Uiv1GetMyEventsPastListUseCaseImpl(eventRepository = get())
    }

}