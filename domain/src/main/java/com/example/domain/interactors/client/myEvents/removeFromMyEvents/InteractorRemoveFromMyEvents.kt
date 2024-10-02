package com.example.domain.interactors.client.myEvents.removeFromMyEvents

import com.example.domain.usecase.ClientUseCase


interface IInteractorRemoveFromMyEvents {
    fun invoke(eventId: String)
}

internal class InteractorRemoveFromMyEventsImpl(
    private val useCase: ClientUseCase,
) : IInteractorRemoveFromMyEvents {

    override fun invoke(eventId: String) {
        useCase.removeFromToMyEvents(eventId)
    }
}