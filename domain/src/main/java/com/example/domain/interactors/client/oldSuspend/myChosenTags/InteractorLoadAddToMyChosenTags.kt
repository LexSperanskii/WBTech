package com.example.domain.interactors.client.oldSuspend.myChosenTags


import com.example.domain.usecase.EventsUseCaseForOldSuspend


interface IInteractorLoadAddToMyChosenTags {
    fun invoke(tag: String)
}

internal class InteractorLoadAddToMyChosenTagsImpl(
    private val useCase: EventsUseCaseForOldSuspend,
) : IInteractorLoadAddToMyChosenTags {

    override fun invoke(tag: String) {
        useCase.loadAddToMyChosenTags(tag)
    }
}