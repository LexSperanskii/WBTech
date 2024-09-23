package com.example.domain.interactors.client.oldSuspend.myChosenTags

import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.models.Response
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCaseForOldSuspend
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach


interface IInteractorGetRemoveFromMyChosenTags {
    fun invoke(): Flow<Response>
}

internal class InteractorGetRemoveFromMyChosenTagsImpl(
    private val useCase: EventsUseCaseForOldSuspend,
    private val networkRepository: INetworkRepository,
    private val loadClient: IInteractorLoadClient,
) : IInteractorGetRemoveFromMyChosenTags {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val getRemoveFromMyChosenTags =
        useCase.observeRemoveFromMyChosenTags().flatMapLatest { tag ->
            networkRepository.removeFromMyChosenTags(tag).onEach { response ->
                if (response.status == "success") {
                    loadClient.invoke()
                }
            }
        }

    override fun invoke(): Flow<Response> = getRemoveFromMyChosenTags
}