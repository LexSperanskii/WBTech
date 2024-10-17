package com.example.domain.interactors.listOfSortedEvents

import com.example.domain.models.EventModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetListOfSortedEvents {
    fun invoke(): Flow<List<EventModelDomain>>
}

internal class InteractorGetListOfSortedEventsImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetListOfSortedEvents {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val listOfSortedEventsFlow = useCase.observeUserSearch().flatMapLatest { search ->
        networkRepository.getListOfSortedEvents(search)
    }

    override fun invoke(): Flow<List<EventModelDomain>> = listOfSortedEventsFlow

}