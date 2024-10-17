package com.example.domain.interactors.eventDescription

import com.example.domain.models.EventDescriptionModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetEventDescription {
    fun invoke(): Flow<EventDescriptionModelDomain>
}

internal class InteractorGetEventDescriptionImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetEventDescription {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val eventDescription = useCase.observeEventId().flatMapLatest { eventId ->
        networkRepository.getEventDescription(eventId)
    }

    override fun invoke(): Flow<EventDescriptionModelDomain> = eventDescription
}