package com.example.domain.interactors.listOfEvents

import com.example.domain.usecase.EventsUseCase


interface IInteractorLoadListOfEvents {
    fun invoke()
}

internal class InteractorLoadListOfEventsImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadListOfEvents {

    override fun invoke() {
        useCase.loadListOfEvents()
    }

}