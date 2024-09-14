package com.example.domain.di

import com.example.domain.usecases.events.GetAllEventsUseCase
import com.example.domain.usecases.events.InteractorGetRelatedEventsImpl
import com.example.domain.usecases.events.dump.GetAllEventsActiveUseCase
import com.example.domain.usecases.events.dump.GetAllEventsActiveUseCaseImpl
import com.example.domain.usecases.events.dump.GetEventDetailsUseCase
import com.example.domain.usecases.events.dump.GetEventDetailsUseCaseImpl
import com.example.domain.usecases.events.dump.GetMyEventsListUseCase
import com.example.domain.usecases.events.dump.GetMyEventsListUseCaseImpl
import com.example.domain.usecases.events.dump.GetMyEventsPastListUseCase
import com.example.domain.usecases.events.dump.GetMyEventsPastListUseCaseImpl
import org.koin.dsl.module

val eventsModule = module {

    single<GetAllEventsActiveUseCase> {
        GetAllEventsActiveUseCaseImpl(eventRepository = get())
    }
    single<GetAllEventsUseCase> {
        InteractorGetRelatedEventsImpl(eventRepository = get())
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