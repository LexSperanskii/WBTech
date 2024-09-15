package com.example.domain.interactors.listOfParticipants

import com.example.domain.models.UserModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetListOfParticipants {
    fun invoke(): Flow<List<UserModelDomain>>
}

internal class InteractorGetListOfParticipantsImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetListOfParticipants {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val listOfParticipants = useCase.observeListOfParticipants().flatMapLatest { id ->
        networkRepository.getListOfParticipants(id)
    }

    override fun invoke(): Flow<List<UserModelDomain>> = listOfParticipants
}