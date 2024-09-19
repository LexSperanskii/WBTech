package com.example.domain.interactors.client

import com.example.domain.repositories.INetworkRepository


interface IInteractorSetClientAvatar {
    suspend fun invoke(imageURL: String?)
}

internal class InteractorSetClientAvatarImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorSetClientAvatar {

    override suspend fun invoke(imageURL: String?) {
        networkRepository.setClientAvatar(imageURL)
    }
}