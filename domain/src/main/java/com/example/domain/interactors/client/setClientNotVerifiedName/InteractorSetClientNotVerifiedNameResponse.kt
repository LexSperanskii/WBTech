package com.example.domain.interactors.client.setClientNotVerifiedName

import com.example.domain.models.Response
import com.example.domain.repositories.INetworkClientRepository
import com.example.domain.usecase.ClientUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn


interface IInteractorSetClientNotVerifiedNameResponse {
    fun invoke(): Flow<Response>
}

internal class InteractorSetClientNotVerifiedNameResponseImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorSetClientNotVerifiedNameResponse {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val setClientNotVerifiedName =
        useCase.observeSetClientNotVerifiedName().flatMapLatest { nameSurname ->
            networkRepository.setClientNotVerifiedName(nameSurname)
        }

    init {
        setClientNotVerifiedName.launchIn(CoroutineScope(Dispatchers.IO))
    }

    override fun invoke(): Flow<Response> = setClientNotVerifiedName
}