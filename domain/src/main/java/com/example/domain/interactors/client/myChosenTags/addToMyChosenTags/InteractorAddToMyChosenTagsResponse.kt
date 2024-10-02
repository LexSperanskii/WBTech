package com.example.domain.interactors.client.myChosenTags.addToMyChosenTags

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


interface IInteractorAddToMyChosenTagsResponse {
    fun invoke(): Flow<Response>
}


internal class InteractorAddToMyChosenTagsResponseImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorAddToMyChosenTagsResponse {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val addToMyChosenTag = useCase.observeAddToClientChosenTags().flatMapLatest { tag ->
        networkRepository.addToMyChosenTags(tag)
    }

    init {
        addToMyChosenTag
            .onEach { response ->
                if (response.status == "success") {
                    useCase.loadClient()
                }
            }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }

    override fun invoke(): Flow<Response> = addToMyChosenTag

}