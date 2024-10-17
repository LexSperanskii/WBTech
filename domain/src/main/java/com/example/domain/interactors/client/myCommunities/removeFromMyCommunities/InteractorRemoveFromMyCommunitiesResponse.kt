package com.example.domain.interactors.client.myCommunities.removeFromMyCommunities

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


interface IInteractorRemoveFromMyCommunitiesResponse {
    fun invoke(): Flow<Response>
}

internal class InteractorRemoveFromMyCommunitiesResponseImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorRemoveFromMyCommunitiesResponse {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val removeFromMyCommunities =
        useCase.observeRemoveFromMyCommunities().flatMapLatest { communityId ->
            networkRepository.removeFromMyChosenTags(communityId)
        }

    init {
        removeFromMyCommunities
            .onEach { response ->
                if (response.status == "success") {
                    useCase.loadClient()
                }
            }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }

    override fun invoke(): Flow<Response> = removeFromMyCommunities

}