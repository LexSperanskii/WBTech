package com.example.domain.interactors.client.pinCode

import com.example.domain.usecase.ClientUseCase

interface IInteractorLoadClientPinCodeVerification {
    fun invoke(pinCode: String)
}

internal class InteractorLoadClientPinCodeVerificationImpl(
    private val useCase: ClientUseCase,
) : IInteractorLoadClientPinCodeVerification {

    override fun invoke(pinCode: String) {
        useCase.loadClientPinCodeVerification(pinCode)
    }

}