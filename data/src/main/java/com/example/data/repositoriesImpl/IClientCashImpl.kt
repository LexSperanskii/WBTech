package com.example.data.repositoriesImpl

import com.example.domain.models.ClientCashModelDomain
import com.example.domain.repositories.IClientCash
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class IClientCashImpl : IClientCash {

    private val clientCash = MutableSharedFlow<ClientCashModelDomain>(replay = 1)

    override fun saveClient(client: ClientCashModelDomain) {
        clientCash.tryEmit(client)
    }

    override fun getClient(): Flow<ClientCashModelDomain> = clientCash.asSharedFlow()
}