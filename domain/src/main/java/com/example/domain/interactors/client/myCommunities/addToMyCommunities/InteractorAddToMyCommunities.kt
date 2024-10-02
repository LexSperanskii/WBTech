package com.example.domain.interactors.client.myCommunities.addToMyCommunities

import com.example.domain.usecase.ClientUseCase

interface IInteractorAddToMyCommunities {
    fun invoke(communityId: String)
}

internal class InteractorAddToMyCommunitiesImpl(
    private val useCase: ClientUseCase,
) : IInteractorAddToMyCommunities {

    override fun invoke(communityId: String) {
        useCase.addToMyCommunities(communityId)
    }

}