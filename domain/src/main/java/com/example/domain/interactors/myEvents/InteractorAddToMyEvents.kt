package com.example.domain.interactors.myEvents

import com.example.domain.repositories.INetworkRepository


interface IInteractorAddToMyEvents {
    suspend fun invoke(eventId: String)
}

internal class InteractorAddToMyEventsImpl(
    private val networkRepository: INetworkRepository,
    private val loadMyEventsList: IInteractorLoadMyEventsList,
) : IInteractorAddToMyEvents {

    override suspend fun invoke(eventId: String) {
        networkRepository.addToMyEvents(eventId)
    }
}