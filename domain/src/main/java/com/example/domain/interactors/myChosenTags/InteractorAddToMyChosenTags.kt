package com.example.domain.interactors.myChosenTags

import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.repositories.INetworkRepository


interface IInteractorAddToMyChosenTags {
    suspend fun invoke(tag: String)
}

internal class InteractorAddToMyChosenTagsImpl(
    private val networkRepository: INetworkRepository,
    private val loadClient: IInteractorLoadClient,
) : IInteractorAddToMyChosenTags {

    override suspend fun invoke(tag: String) {
        networkRepository.addToMyChosenTags(tag)
        loadClient.invoke()
    }
}