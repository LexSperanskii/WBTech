package com.example.domain.interactors.client.oldSuspend.myChosenTags

import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.models.Response
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCaseForOldSuspend
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach


interface IInteractorGetAddToMyChosenTags {
    fun invoke(): Flow<Response>
}

internal class InteractorGetAddToMyChosenTagsImpl(
    private val useCase: EventsUseCaseForOldSuspend,
    private val networkRepository: INetworkRepository,
    private val loadClient: IInteractorLoadClient,
) : IInteractorGetAddToMyChosenTags {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val getAddToMyChosenTags = useCase.observeAddToMyChosenTags().flatMapLatest { tag ->
        networkRepository.addToMyChosenTags(tag).onEach { response ->
            if (response.status == "success") {
                loadClient.invoke()
            }
        }
    }

    override fun invoke(): Flow<Response> = getAddToMyChosenTags
}