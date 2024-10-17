package com.example.domain.interactors.client.myChosenTags.addToMyChosenTags

import com.example.domain.usecase.ClientUseCase


interface IInteractorAddToMyChosenTags {
    fun invoke(tag: String)
}

internal class InteractorAddToMyChosenTagsImpl(
    private val useCase: ClientUseCase,
) : IInteractorAddToMyChosenTags {

    override fun invoke(tag: String) {
        useCase.addToClientChosenTags(tag)
    }
}
