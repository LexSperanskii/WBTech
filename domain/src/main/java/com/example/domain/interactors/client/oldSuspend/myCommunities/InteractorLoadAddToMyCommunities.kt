package com.example.domain.interactors.client.oldSuspend.myCommunities

import com.example.domain.usecase.EventsUseCaseForOldSuspend


interface IInteractorLoadAddToMyCommunities {
    fun invoke(communityId: String)
}

internal class InteractorLoadAddToMyCommunitiesImpl(
    private val useCase: EventsUseCaseForOldSuspend,
) : IInteractorLoadAddToMyCommunities {

    override fun invoke(communityId: String) {
        useCase.loadAddToMyCommunities(communityId)
    }
}