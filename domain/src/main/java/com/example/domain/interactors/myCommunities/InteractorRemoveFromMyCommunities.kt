package com.example.domain.interactors.myCommunities

import com.example.domain.models.CommunityModelDomain
import com.example.domain.repositories.INetworkRepository


interface IInteractorRemoveFromMyCommunities {
    suspend fun invoke(community: CommunityModelDomain)
}

internal class InteracterRemoveFromMyCommunitiesImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorRemoveFromMyCommunities {

    override suspend fun invoke(community: CommunityModelDomain) {
        networkRepository.removeFromMyCommunities(community)
    }
}