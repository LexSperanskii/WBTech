package com.example.domain.interactors.client.oldSuspend.deleteClient

import com.example.domain.usecase.EventsUseCaseForOldSuspend

interface IInteractorLoadDeleteClient {
    fun invoke()
}

internal class InteractorLoadDeleteClientImpl(
    private val useCase: EventsUseCaseForOldSuspend,
) : IInteractorLoadDeleteClient {

    override fun invoke() {
        useCase.loadDeleteClient()
    }
}