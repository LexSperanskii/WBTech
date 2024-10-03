package com.example.data.repositoriesImpl

import com.example.domain.models.ClientCashModelDomain
import com.example.domain.repositories.IClientCash
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow

class IClientCashImpl : IClientCash {

    private val clientCash = MutableStateFlow(ClientCashModelDomain())
    private val cash = clientCash.flatMapLatest { clientCash -> flow { emit(clientCash) } }

    override fun saveClient(client: ClientCashModelDomain) {
        clientCash.tryEmit(client)
    }

    override fun getClient(): Flow<ClientCashModelDomain> = cash
}