package com.example.domain.usecases.events

import com.example.domain.models.EventModelDomain
import com.example.domain.repositories.INetworkRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.mapLatest


interface InteractorGetRelatedEvents {
    operator fun invoke(): Flow<List<EventModelDomain>>
}

internal class InteractorGetRelatedEventsImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : InteractorGetRelatedEvents {

    private val eventsPrepared = useCase.observeEventsList().mapLatest { eventDetails ->
        networkRepository.getListOfEvents()
            .map { eventsList ->
                EventModelDomain(eventsList.toString())
            }
    }

    override operator fun invoke(): Flow<List<EventModelDomain>> = eventsPrepared
}