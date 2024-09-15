package com.example.domain.interactors.listOfTags

import com.example.domain.usecase.EventsUseCase


interface IInteractorLoadListOfTags {
    fun invoke()
}

internal class InteractorLoadListOfTagsImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadListOfTags {

    override fun invoke() {
        useCase.loadListOfTags()
    }

}