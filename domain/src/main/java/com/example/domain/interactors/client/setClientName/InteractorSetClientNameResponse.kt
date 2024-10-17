package com.example.domain.interactors.client.setClientName

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


interface IInteractorSetClientNameResponse {
    fun invoke(): Flow<Response>
}

internal class InteractorSetClientNameResponseImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorSetClientNameResponse {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val setClientName = useCase.observeSetClientName().flatMapLatest { nameSurname ->
        networkRepository.setClientName(nameSurname)
    }

    init {
        setClientName
            .onEach { response ->
                if (response.status == "success") {
                    useCase.loadClient()
                }
            }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }

    override fun invoke(): Flow<Response> = setClientName
}