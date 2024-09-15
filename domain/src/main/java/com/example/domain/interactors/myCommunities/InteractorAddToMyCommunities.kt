package com.example.domain.interactors.myCommunities

import com.example.domain.models.CommunityModelDomain
import com.example.domain.repositories.INetworkRepository


interface IInteractorAddToMyCommunities {
    suspend fun invoke(community: CommunityModelDomain)
}

internal class InteractorAddToMyCommunitiesImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorAddToMyCommunities {

    override suspend fun invoke(community: CommunityModelDomain) {
        networkRepository.addToMyCommunities(community)
    }
}