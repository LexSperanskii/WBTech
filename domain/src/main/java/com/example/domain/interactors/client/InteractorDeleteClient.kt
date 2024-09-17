package com.example.domain.interactors.client

import com.example.domain.repositories.INetworkRepository

interface IInteractorDeleteClient {
    suspend fun invoke()
}

internal class InteractorDeleteClientImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorDeleteClient {

    override suspend fun invoke() {
        networkRepository.deleteClient()
    }
}