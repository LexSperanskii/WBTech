package com.example.domain.interactors.client.deleteClient

import com.example.domain.models.Response
import com.example.domain.repositories.INetworkClientRepository
import com.example.domain.usecase.ClientUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


interface IInteractorDeleteClientResponse {
    fun invoke(): Flow<Response>
}

internal class InteractorDeleteClientResponseImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorDeleteClientResponse {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val deleteClient = useCase.observeDeleteClient().flatMapLatest {
        networkRepository.deleteClient()
    }

    init {
        deleteClient
            .onEach { response ->
                if (response.status == "success") {
                    useCase.loadClient()
                }
            }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }

    override fun invoke(): Flow<Response> = deleteClient
}