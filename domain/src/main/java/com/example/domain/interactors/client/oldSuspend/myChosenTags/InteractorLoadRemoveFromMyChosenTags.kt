package com.example.domain.interactors.client.oldSuspend.myChosenTags


import com.example.domain.usecase.EventsUseCaseForOldSuspend


interface IInteractorLoadRemoveFromMyChosenTags {
    fun invoke(tag: String)
}

internal class InteractorLoadRemoveFromMyChosenTagsImpl(
    private val useCase: EventsUseCaseForOldSuspend,
) : IInteractorLoadRemoveFromMyChosenTags {

    override fun invoke(tag: String) {
        useCase.loadRemoveFromMyChosenTags(tag)
    }
}