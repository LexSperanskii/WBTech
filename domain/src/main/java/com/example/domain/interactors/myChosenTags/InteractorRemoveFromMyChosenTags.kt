package com.example.domain.interactors.myChosenTags

import com.example.domain.repositories.INetworkRepository


interface IInteractorRemoveFromMyChosenTags {
    suspend fun invoke(tag: String)
}

internal class InteractorRemoveFromMyChosenTagsImpl(
    private val networkRepository: INetworkRepository,
    private val loadMyChosenTagsList: IInteractorLoadMyChosenTagsList,
) : IInteractorRemoveFromMyChosenTags {

    override suspend fun invoke(tag: String) {
        networkRepository.removeFromMyChosenTags(tag)
    }
}