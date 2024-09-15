package com.example.domain.interactors.client

import com.example.domain.repositories.INetworkRepository


interface IInteractorSetClientName {
    suspend fun invoke(nameSurname: String)
}

internal class InteractorSetClientNameImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorSetClientName {

    override suspend fun invoke(nameSurname: String) {
        networkRepository.setClientName(nameSurname)
    }
}