package com.example.domain.interactors.advertBlock.eventsAdvertBlock

import com.example.domain.usecase.EventsUseCase

interface IInteractorLoadEventsAdvertBlock {
    fun invoke()
}

internal class InteractorLoadEventsAdvertBlockImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadEventsAdvertBlock {

    override fun invoke() {
        useCase.loadEventsAdvertBlock()
    }

}