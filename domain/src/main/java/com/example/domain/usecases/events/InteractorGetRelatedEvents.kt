package com.example.domain.usecases.events

import com.example.domain.models.EventModelDomain
import com.example.domain.repositories.networkRepository.IEventRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.mapLatest


interface InteractorGetRelatedEvents {
    operator fun invoke(): Flow<List<EventModelDomain>>
}

internal class InteractorGetRelatedEventsImpl(
    private val useCase: EventsUseCase,
    private val eventRepository: IEventRepository,
) : InteractorGetRelatedEvents {

    private val eventsPrepared = useCase.observeEventsList().mapLatest {
        eventRepository.eventsList()
    }

    override operator fun invoke(): Flow<List<EventModelDomain>> = eventsPrepared
}