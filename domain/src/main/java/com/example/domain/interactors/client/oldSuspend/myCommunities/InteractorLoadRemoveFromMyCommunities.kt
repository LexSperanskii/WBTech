package com.example.domain.interactors.client.oldSuspend.myCommunities


import com.example.domain.usecase.EventsUseCaseForOldSuspend

interface IInteractorLoadRemoveFromMyCommunities {
    fun invoke(communityId: String)
}

internal class InteractorLoadRemoveFromMyCommunitiesImpl(
    private val useCase: EventsUseCaseForOldSuspend,
) : IInteractorLoadRemoveFromMyCommunities {

    override fun invoke(communityId: String) {
        useCase.loadRemoveFromMyCommunities(communityId)
    }
}