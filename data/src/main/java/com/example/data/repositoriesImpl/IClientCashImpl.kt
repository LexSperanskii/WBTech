package com.example.data.repositoriesImpl

import com.example.domain.repositories.ClientCash
import com.example.domain.repositories.IClientCash
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flow

class IClientCashImpl : IClientCash {

    private val clientCash = MutableStateFlow(ClientCash())
    private val cash = clientCash.flatMapLatest { clientCash -> flow { emit(clientCash) } }

    override fun saveClient(client: ClientCash) {
        clientCash.tryEmit(client)
    }

    override fun getClient(): Flow<ClientCash> = cash
}