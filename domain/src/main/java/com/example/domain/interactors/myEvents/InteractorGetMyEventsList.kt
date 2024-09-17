package com.example.domain.interactors.myEvents

import com.example.domain.models.EventModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetMyEventsList {
    fun invoke(): Flow<List<EventModelDomain>>
}

internal class InteractorGetMyEventsListImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetMyEventsList {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val myEvents = useCase.observeMyEventsList().flatMapLatest {
        networkRepository.getMyEventsList()
    }

    override fun invoke(): Flow<List<EventModelDomain>> = myEvents
}