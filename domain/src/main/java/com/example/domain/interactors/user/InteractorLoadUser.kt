package com.example.domain.interactors.user

import com.example.domain.usecase.EventsUseCase


interface IInteractorLoadUser {
    fun invoke(userId: String)
}

internal class InteractorLoadUserImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadUser {

    override fun invoke(userId: String) {
        useCase.loadNewUserById(userId)
    }

}