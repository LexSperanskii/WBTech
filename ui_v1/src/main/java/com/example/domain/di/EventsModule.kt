package com.example.domain.di

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
import org.koin.dsl.module

val eventsModule = module {

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

}