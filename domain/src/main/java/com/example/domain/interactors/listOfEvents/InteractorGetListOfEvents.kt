package com.example.domain.interactors.listOfEvents

import com.example.domain.models.EventModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetListOfEvents {
    fun invoke(): Flow<List<EventModelDomain>>
}

internal class InteractorGetListOfEventsImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetListOfEvents {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val listOfEventsFlow = useCase.observeListOfEvents().flatMapLatest {
        networkRepository.getListOfEvents()
    }

    override fun invoke(): Flow<List<EventModelDomain>> = listOfEventsFlow
}