package com.example.domain.interactors.client.oldSuspend.myEvents

import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCaseForOldSuspend
import kotlinx.coroutines.flow.onEach


interface IInteractorLoadAddToMyEvents {
    fun invoke(eventId: String)
}

internal class InteractorLoadAddToMyEventsImpl(
    private val useCase: EventsUseCaseForOldSuspend,
    private val networkRepository: INetworkRepository,
    private val loadClient: IInteractorLoadClient,
) : IInteractorLoadAddToMyEvents {

//    override fun invoke(eventId: String) {
//        useCase.loadAddToMyEvents(eventId)
//    }


    override fun invoke(eventId: String) {
        networkRepository.addToMyEvents(eventId).onEach { response ->
            if (response.status == "success") {
                loadClient.invoke()
            }
        }
    }
}