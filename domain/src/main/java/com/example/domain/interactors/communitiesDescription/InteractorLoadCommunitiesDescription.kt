package com.example.domain.interactors.communitiesDescription

import com.example.domain.usecase.EventsUseCase

interface IInteractorLoadCommunitiesDescription {
    fun invoke(communityId: String)
}

internal class InteractorLoadCommunitiesDescriptionImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadCommunitiesDescription {

    override fun invoke(communityId: String) {
        useCase.loadNewCommunityById(communityId)
    }

}