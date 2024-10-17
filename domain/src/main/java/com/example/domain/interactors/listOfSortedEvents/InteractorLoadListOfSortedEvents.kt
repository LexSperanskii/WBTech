package com.example.domain.interactors.listOfSortedEvents

import com.example.domain.usecase.EventsUseCase


interface IInteractorLoadListOfSortedEvents {
    fun invoke(search: String)
}

internal class InteractorLoadListOfSortedEventsImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadListOfSortedEvents {

    override fun invoke(search: String) {
        useCase.loadListOfSortedEvents(search)
    }

}