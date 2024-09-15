package com.example.domain.interactors.listOfPeople

import com.example.domain.usecase.EventsUseCase


interface IInteractorLoadListOfPeople {
    fun invoke()
}

internal class InteractorLoadListOfPeopleImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadListOfPeople {

    override fun invoke() {
        useCase.loadListOfPeople()
    }

}