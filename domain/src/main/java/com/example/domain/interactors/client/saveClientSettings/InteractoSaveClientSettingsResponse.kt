package com.example.domain.interactors.client.saveClientSettings

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


interface IInteractoSaveClientSettingsResponse {
    fun invoke(): Flow<Response>
}

internal class InteractoSaveClientSettingsResponseImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractoSaveClientSettingsResponse {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val saveClientChanges = useCase.observeSaveClientSettings().flatMapLatest { newClient ->
        networkRepository.saveClientChanges(newClient)
    }

    init {
        saveClientChanges
            .onEach { response ->
                if (response.status == "success") {
                    useCase.loadClient()
                }
            }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }

    override fun invoke(): Flow<Response> = saveClientChanges
}