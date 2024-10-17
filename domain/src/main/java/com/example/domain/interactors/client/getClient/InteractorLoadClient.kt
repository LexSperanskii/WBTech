package com.example.domain.interactors.client.getClient

import com.example.domain.usecase.ClientUseCase

interface IInteractorLoadClient {
    fun invoke()
}

internal class InteractorLoadClientImpl(
    private val useCase: ClientUseCase,
) : IInteractorLoadClient {

    override fun invoke() {
        useCase.loadClient()
    }

}