package com.example.domain.interactors.listOfParticipants

import com.example.domain.usecase.EventsUseCase


interface IInteractorLoadListOfParticipants {
    fun invoke(communityOrEventID: String)
}

internal class InteractorLoadListOfParticipantsImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadListOfParticipants {

    override fun invoke(communityOrEventID: String) {
        useCase.loadListOfParticipants(communityOrEventID)
    }

}