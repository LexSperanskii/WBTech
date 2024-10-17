package com.example.domain.interactors.advertBlock.communitiesAdvertBlock

import com.example.domain.usecase.EventsUseCase


interface IInteractorLoadCommunitiesAdvertBlock {
    fun invoke()
}

internal class InteractorLoadCommunitiesAdvertBlockImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadCommunitiesAdvertBlock {

    override fun invoke() {
        useCase.loadCommunitiesAdvertBlock()
    }

}