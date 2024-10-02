package com.example.domain.interactors.client.getClient

import com.example.domain.models.ClientModelDomain
import com.example.domain.repositories.INetworkClientRepository
import com.example.domain.usecase.ClientUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetClient {
    fun invoke(): Flow<ClientModelDomain>
}

internal class InteractorGetClientImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorGetClient {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val client = useCase.observeClient().flatMapLatest {
        networkRepository.getClient()
    }

    override fun invoke(): Flow<ClientModelDomain> = client
}