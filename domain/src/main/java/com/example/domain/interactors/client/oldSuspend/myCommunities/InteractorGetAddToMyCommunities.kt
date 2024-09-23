package com.example.domain.interactors.client.oldSuspend.myCommunities

import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.models.Response
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCaseForOldSuspend
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onEach


interface IInteractorGetAddToMyCommunities {
    fun invoke(): Flow<Response>
}

internal class InteractorGetAddToMyCommunitiesImpl(
    private val useCase: EventsUseCaseForOldSuspend,
    private val networkRepository: INetworkRepository,
    private val loadClient: IInteractorLoadClient,
) : IInteractorGetAddToMyCommunities {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val getAddToMyCommunities = useCase.observeAddToMyCommunities().flatMapLatest { id ->
        networkRepository.addToMyCommunities(id).onEach { response ->
            if (response.status == "success") {
                loadClient.invoke()
            }
        }
    }

    override fun invoke(): Flow<Response> = getAddToMyCommunities
}