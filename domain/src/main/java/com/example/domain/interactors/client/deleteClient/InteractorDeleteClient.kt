package com.example.domain.interactors.client.deleteClient

import com.example.domain.usecase.ClientUseCase


interface IInteractorDeleteClient {
    fun invoke()
}

internal class InteractorDeleteClientImpl(
    private val useCase: ClientUseCase,
) : IInteractorDeleteClient {

    override fun invoke() {
        useCase.deleteClient()
    }

}