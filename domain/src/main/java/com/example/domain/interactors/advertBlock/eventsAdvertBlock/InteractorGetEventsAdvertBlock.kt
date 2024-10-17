package com.example.domain.interactors.advertBlock.eventsAdvertBlock

import com.example.domain.models.EventAdvertBlockModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetEventsAdvertBlock {
    fun invoke(): Flow<List<EventAdvertBlockModelDomain>>
}

internal class InteractorGetEventsAdvertBlockImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetEventsAdvertBlock {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val eventsAdvertBlock = useCase.observeEventsAdvertBlock().flatMapLatest {
        networkRepository.getEventsAdvertBlock()
    }

    override fun invoke(): Flow<List<EventAdvertBlockModelDomain>> = eventsAdvertBlock
}