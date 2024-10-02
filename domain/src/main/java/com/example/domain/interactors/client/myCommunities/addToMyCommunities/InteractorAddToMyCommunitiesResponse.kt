package com.example.domain.interactors.client.myCommunities.addToMyCommunities

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


interface IInteractorAddToMyCommunitiesResponse {
    fun invoke(): Flow<Response>
}


internal class InteractorAddToMyCommunitiesResponseImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorAddToMyCommunitiesResponse {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val addToMyCommunities =
        useCase.observeAddToMyCommunities().flatMapLatest { communityId ->
            networkRepository.addToMyCommunities(communityId)
        }

    init {
        addToMyCommunities
            .onEach { response ->
                if (response.status == "success") {
                    useCase.loadClient()
                }
            }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }

    override fun invoke(): Flow<Response> = addToMyCommunities

}