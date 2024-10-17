package com.example.domain.interactors.client.myChosenTags.removeFromMyChosenTags

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


interface IInteractorRemoveFromMyChosenTagsResponse {
    fun invoke(): Flow<Response>
}


internal class InteractorRemoveFromMyChosenTagsResponseImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorRemoveFromMyChosenTagsResponse {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val removeFromMyChosenTag =
        useCase.observeRemoveFromClientChosenTags().flatMapLatest { tag ->
            networkRepository.removeFromMyChosenTags(tag)
        }

    init {
        removeFromMyChosenTag
            .onEach { response ->
                if (response.status == "success") {
                    useCase.loadClient()
                }
            }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }

    override fun invoke(): Flow<Response> = removeFromMyChosenTag

}