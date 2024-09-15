package com.example.domain.interactors.myChosenTags

import com.example.domain.usecase.EventsUseCase


interface IInteractorLoadMyChosenTagsList {
    fun invoke()
}

internal class InteractorLoadMyChosenTagsListImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadMyChosenTagsList {

    override fun invoke() {
        useCase.loadMyChosenTagsList()
    }

}