package com.example.domain.interactors.client.oldSuspend.myEvents

import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.models.Response
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCaseForOldSuspend
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach


interface IInteractorGetRemoveFromMyEvents {
    fun invoke(): Flow<Response>
}

internal class InteractorGetRemoveFromMyEventsImpl(
    private val useCase: EventsUseCaseForOldSuspend,
    private val networkRepository: INetworkRepository,
    private val loadClient: IInteractorLoadClient,
) : IInteractorGetRemoveFromMyEvents {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val getRemoveFromMyEvents = useCase.observeRemoveFromMyEvents().flatMapLatest { id ->
        networkRepository.removeFromMyEvents(id).onEach { response ->
            if (response.status == "success") {
                loadClient.invoke()
            }
        }
    }

    override fun invoke(): Flow<Response> = getRemoveFromMyEvents
}