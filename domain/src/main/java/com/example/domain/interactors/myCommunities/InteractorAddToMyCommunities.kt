package com.example.domain.interactors.myCommunities

import com.example.domain.repositories.INetworkRepository


interface IInteractorAddToMyCommunities {
    suspend fun invoke(communityId: String)
}

internal class InteractorAddToMyCommunitiesImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorAddToMyCommunities {

    override suspend fun invoke(communityId: String) {
        networkRepository.addToMyCommunities(communityId)
    }
}