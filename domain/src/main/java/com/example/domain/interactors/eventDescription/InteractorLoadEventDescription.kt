package com.example.domain.interactors.eventDescription

import com.example.domain.usecase.EventsUseCase

interface IInteractorLoadEventDescription {
    fun invoke(eventId: String)
}

internal class InteractorLoadEventDescriptionImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadEventDescription {

    override fun invoke(eventId: String) {
        useCase.loadNewEventById(eventId)
    }

}