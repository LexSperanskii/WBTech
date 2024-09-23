package com.example.domain.interactors.client.oldSuspend.myEvents

import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.models.Response
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCaseForOldSuspend
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach


interface IInteractorGetAddToMyEvents {
    fun invoke(): Flow<Response>
}

internal class InteractorGetAddToMyEventsImpl(
    private val useCase: EventsUseCaseForOldSuspend,
    private val networkRepository: INetworkRepository,
    private val loadClient: IInteractorLoadClient,
) : IInteractorGetAddToMyEvents {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val getAddToMyEvents = useCase.observeAddToMyEvents().flatMapLatest { id ->
        networkRepository.addToMyEvents(id).onEach { response ->
            if (response.status == "success") {
                loadClient.invoke()
            }
        }
    }

    override fun invoke(): Flow<Response> = getAddToMyEvents
}
