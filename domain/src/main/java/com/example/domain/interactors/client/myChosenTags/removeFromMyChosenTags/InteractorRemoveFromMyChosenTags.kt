package com.example.domain.interactors.client.myChosenTags.removeFromMyChosenTags

import com.example.domain.usecase.ClientUseCase


interface IInteractorRemoveFromMyChosenTags {
    fun invoke(tag: String)
}

internal class InteractorRemoveFromMyChosenTagsImpl(
    private val useCase: ClientUseCase,
) : IInteractorRemoveFromMyChosenTags {

    override fun invoke(tag: String) {
        useCase.removeFromClientChosenTags(tag)
    }

}