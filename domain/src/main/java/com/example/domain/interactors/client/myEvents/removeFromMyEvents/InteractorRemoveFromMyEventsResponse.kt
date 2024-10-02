package com.example.domain.interactors.client.myEvents.removeFromMyEvents

import com.example.domain.models.Response
import com.example.domain.repositories.INetworkClientRepository
import com.example.domain.usecase.ClientUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


interface IInteractorRemoveFromMyEventsResponse {
    fun invoke(): Flow<Response>
}

internal class InteractorRemoveFromMyEventsResponseImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorRemoveFromMyEventsResponse {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val removeFromMyEvents = useCase.observeRemoveFromMyEvents().flatMapLatest { eventId ->
        networkRepository.removeFromMyEvents(eventId)
    }

    init {
        removeFromMyEvents
            .onEach { response ->
                if (response.status == "success") {
                    useCase.loadClient()
                }
            }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }

    override fun invoke(): Flow<Response> = removeFromMyEvents

}