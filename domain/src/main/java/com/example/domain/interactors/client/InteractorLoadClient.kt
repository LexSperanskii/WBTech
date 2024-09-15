package com.example.domain.interactors.client

import com.example.domain.usecase.EventsUseCase


interface IInteractorLoadClient {
    fun invoke()
}

internal class InteractorLoadClientImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadClient {

    override fun invoke() {
        useCase.loadClient()
    }

}