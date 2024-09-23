package com.example.domain.interactors.client.oldSuspend.deleteClient

import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.models.Response
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCaseForOldSuspend
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach


interface IInteractorGetDeleteClient {
    fun invoke(): Flow<Response>
}

internal class InteractorGetDeleteClientImpl(
    private val useCase: EventsUseCaseForOldSuspend,
    private val networkRepository: INetworkRepository,
    private val loadClient: IInteractorLoadClient,
) : IInteractorGetDeleteClient {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val getDeleteClient = useCase.observeDeleteClient().flatMapLatest {
        networkRepository.deleteClient().onEach { response ->
            if (response.status == "success") {
                loadClient.invoke()
            }
        }
    }

    override fun invoke(): Flow<Response> = getDeleteClient
}