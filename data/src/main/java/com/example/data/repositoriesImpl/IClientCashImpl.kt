package com.example.data.repositoriesImpl

import com.example.domain.repositories.ClientCash
import com.example.domain.repositories.IClientCash
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class IClientCashImpl : IClientCash {

    private val clientCash = MutableStateFlow(ClientCash())

    override fun saveClient(client: ClientCash) {
        clientCash.tryEmit(client)
    }

    override fun getClient(): Flow<ClientCash> = clientCash.asStateFlow()
}