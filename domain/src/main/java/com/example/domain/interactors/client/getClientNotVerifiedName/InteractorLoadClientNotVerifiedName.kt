package com.example.domain.interactors.client.getClientNotVerifiedName

import com.example.domain.usecase.ClientUseCase

interface IInteractorLoadClientNotVerifiedName {
    fun invoke()
}

internal class InteractorLoadClientNotVerifiedNameImpl(
    private val useCase: ClientUseCase,
) : IInteractorLoadClientNotVerifiedName {

    override fun invoke() {
        useCase.loadClientNotVerifiedName()
    }
}