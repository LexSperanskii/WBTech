package com.example.domain.interactors.client

import com.example.domain.usecase.EventsUseCase

interface IInteractorLoadClientPinCodeVerification {
    fun invoke(pinCode: String)
}

internal class InteractorLoadClientPinCodeVerificationImpl(
    private val useCase: EventsUseCase,
) : IInteractorLoadClientPinCodeVerification {

    override fun invoke(pinCode: String) {
        useCase.loadClientPinCodeVerification(pinCode)
    }

}