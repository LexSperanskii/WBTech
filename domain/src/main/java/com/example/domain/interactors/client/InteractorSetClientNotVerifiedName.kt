package com.example.domain.interactors.client

import com.example.domain.repositories.INetworkRepository


interface IInteractorSetClientNotVerifiedName {
    suspend fun invoke(nameSurname: String)
}

internal class InteractorSetClientNotVerifiedNameImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorSetClientNotVerifiedName {

    override suspend fun invoke(nameSurname: String) {
        networkRepository.setClientNotVerifiedName(nameSurname)
    }
}