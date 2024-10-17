package com.example.domain.interactors.client.myCommunities.removeFromMyCommunities

import com.example.domain.usecase.ClientUseCase

interface IInteractorRemoveFromMyCommunities {
    fun invoke(communityId: String)
}

internal class InteractorRemoveFromMyCommunitiesImpl(
    private val useCase: ClientUseCase,
) : IInteractorRemoveFromMyCommunities {

    override fun invoke(communityId: String) {
        useCase.removeFromToMyCommunities(communityId)
    }

}