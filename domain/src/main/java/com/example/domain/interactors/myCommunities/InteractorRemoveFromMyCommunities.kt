package com.example.domain.interactors.myCommunities

import com.example.domain.repositories.INetworkRepository


interface IInteractorRemoveFromMyCommunities {
    suspend fun invoke(communityId: String)
}

internal class InteracterRemoveFromMyCommunitiesImpl(
    private val networkRepository: INetworkRepository,
    private val loadMyCommunitiesList: IInteractorLoadMyCommunitiesList,
) : IInteractorRemoveFromMyCommunities {

    override suspend fun invoke(communityId: String) {
        networkRepository.removeFromMyCommunities(communityId)
        loadMyCommunitiesList.invoke()
    }
}