package com.example.domain.interactors.client.myCommunities

import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.repositories.INetworkRepository


interface IInteractorAddToMyCommunities {
    suspend fun invoke(communityId: String)
}

internal class InteractorAddToMyCommunitiesImpl(
    private val networkRepository: INetworkRepository,
    private val loadClient: IInteractorLoadClient,
) : IInteractorAddToMyCommunities {

    override suspend fun invoke(communityId: String) {
        networkRepository.addToMyCommunities(communityId)
        loadClient.invoke()
    }
}