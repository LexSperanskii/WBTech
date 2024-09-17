package com.example.domain.interactors.myEvents

import com.example.domain.repositories.INetworkRepository


interface IInteractorRemoveFromMyEvents {
    suspend fun invoke(eventId: String)
}

internal class InteractorRemoveFromMyEventsImpl(
    private val networkRepository: INetworkRepository,
    private val loadMyEventsList: IInteractorLoadMyEventsList,
) : IInteractorRemoveFromMyEvents {

    override suspend fun invoke(eventId: String) {
        networkRepository.removeFromMyEvents(eventId)
    }
}