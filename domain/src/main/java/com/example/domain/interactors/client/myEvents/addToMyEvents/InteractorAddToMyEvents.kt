package com.example.domain.interactors.client.myEvents.addToMyEvents

import com.example.domain.usecase.ClientUseCase

interface IInteractorAddToMyEvents {
    fun invoke(eventId: String)
}

internal class InteractorAddToMyEventsImpl(
    private val useCase: ClientUseCase,
) : IInteractorAddToMyEvents {

    override fun invoke(eventId: String) {
        useCase.addToMyEvents(eventId)
    }

}