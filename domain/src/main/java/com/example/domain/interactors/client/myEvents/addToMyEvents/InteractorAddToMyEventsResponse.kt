package com.example.domain.interactors.client.myEvents.addToMyEvents

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


interface IInteractorAddToMyEventsResponse {
    fun invoke(): Flow<Response>
}

internal class InteractorAddToMyEventsResponseImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorAddToMyEventsResponse {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val addToMyEvents = useCase.observeAddToMyEvents().flatMapLatest { eventId ->
        networkRepository.addToMyEvents(eventId)
    }

    init {
        addToMyEvents
            .onEach { response ->
                if (response.status == "success") {
                    useCase.loadClient()
                }
            }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }

    override fun invoke(): Flow<Response> = addToMyEvents

}