package com.example.domain.repositories

import com.example.domain.models.ClientCashModelDomain
import kotlinx.coroutines.flow.Flow

interface IClientCash {
    fun saveClient(client: ClientCashModelDomain)
    fun getClient(): Flow<ClientCashModelDomain>
}