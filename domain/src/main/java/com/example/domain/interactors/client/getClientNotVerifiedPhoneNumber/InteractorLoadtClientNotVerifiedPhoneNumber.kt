package com.example.domain.interactors.client.getClientNotVerifiedPhoneNumber

import com.example.domain.usecase.ClientUseCase

interface IInteractorLoadtClientNotVerifiedPhoneNumber {
    fun invoke()
}

internal class InteractorLoadtClientNotVerifiedPhoneNumberImpl(
    private val useCase: ClientUseCase,
) : IInteractorLoadtClientNotVerifiedPhoneNumber {

    override fun invoke() {
        useCase.loadClientNotVerifiedPhoneNumber()
    }
}