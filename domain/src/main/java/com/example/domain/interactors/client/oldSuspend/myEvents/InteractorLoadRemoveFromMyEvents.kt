package com.example.domain.interactors.client.oldSuspend.myEvents

import com.example.domain.usecase.EventsUseCaseForOldSuspend


interface IInteractorLoadRemoveFromMyEvents {
    fun invoke(eventId: String)
}

internal class InteractorLoadRemoveFromMyEventsImpl(
    private val useCase: EventsUseCaseForOldSuspend,
) : IInteractorLoadRemoveFromMyEvents {

    override fun invoke(eventId: String) {
        useCase.loadRemoveFromMyEvents(eventId)
    }
}