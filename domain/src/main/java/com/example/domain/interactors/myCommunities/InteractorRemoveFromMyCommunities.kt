package com.example.domain.interactors.myCommunities

import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.repositories.INetworkRepository


interface IInteractorRemoveFromMyCommunities {
    suspend fun invoke(communityId: String)
}

internal class InteracterRemoveFromMyCommunitiesImpl(
    private val networkRepository: INetworkRepository,
    private val loadClient: IInteractorLoadClient,
) : IInteractorRemoveFromMyCommunities {

    override suspend fun invoke(communityId: String) {
        networkRepository.removeFromMyCommunities(communityId)
        loadClient.invoke()
    }
}