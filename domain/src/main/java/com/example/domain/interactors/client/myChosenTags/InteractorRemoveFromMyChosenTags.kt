package com.example.domain.interactors.client.myChosenTags

import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.repositories.INetworkRepository


interface IInteractorRemoveFromMyChosenTags {
    suspend fun invoke(tag: String)
}

internal class InteractorRemoveFromMyChosenTagsImpl(
    private val networkRepository: INetworkRepository,
    private val loadClient: IInteractorLoadClient,
) : IInteractorRemoveFromMyChosenTags {

    override suspend fun invoke(tag: String) {
        networkRepository.removeFromMyChosenTags(tag)
        loadClient.invoke()
    }
}