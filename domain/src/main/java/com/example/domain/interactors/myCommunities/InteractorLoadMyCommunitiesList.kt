package com.example.domain.interactors.myCommunities

import com.example.domain.usecase.EventsUseCase


interface IInteractorLoadMyCommunitiesList {
    fun invoke()
}

internal class InteractorLoadMyCommunitiesListImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadMyCommunitiesList {

    override fun invoke() {
        useCase.loadMyCommunitiesList()
    }

}