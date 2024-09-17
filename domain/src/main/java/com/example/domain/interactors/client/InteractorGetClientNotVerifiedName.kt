package com.example.domain.interactors.client

import com.example.domain.repositories.INetworkRepository


interface IInteractorGetClientNotVerifiedName {
    suspend fun invoke(): String
}

internal class InteractorGetClientNotVerifiedNameImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorGetClientNotVerifiedName {

    override suspend fun invoke(): String {
        return networkRepository.getClientNotVerifiedName()
    }
}