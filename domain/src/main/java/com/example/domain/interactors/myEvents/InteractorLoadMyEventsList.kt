package com.example.domain.interactors.myEvents

import com.example.domain.usecase.EventsUseCase


interface IInteractorLoadMyEventsList {
    fun invoke()
}

internal class InteractorLoadMyEventsListImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadMyEventsList {

    override fun invoke() {
        useCase.loadMyEventsList()
    }

}