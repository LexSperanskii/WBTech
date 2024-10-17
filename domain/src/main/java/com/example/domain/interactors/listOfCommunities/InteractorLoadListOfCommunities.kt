package com.example.domain.interactors.listOfCommunities

import com.example.domain.usecase.EventsUseCase


interface IInteractorLoadListOfCommunities {
    fun invoke()
}

internal class InteractorLoadListOfCommunitiesImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadListOfCommunities {

    override fun invoke() {
        useCase.loadListOCommunities()
    }

}