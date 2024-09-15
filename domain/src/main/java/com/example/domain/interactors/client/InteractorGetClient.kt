package com.example.domain.interactors.client

import com.example.domain.models.ClientModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetClient {
    fun invoke(): Flow<ClientModelDomain>
}

internal class InteractorGetClientImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetClient {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val client = useCase.observeClient().flatMapLatest {
        networkRepository.getClient()
    }

    override fun invoke(): Flow<ClientModelDomain> = client
}