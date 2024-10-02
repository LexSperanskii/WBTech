package com.example.domain.interactors.client.setClientNotVerifiedPhoneNumber

import com.example.domain.models.PhoneNumberModelDomain
import com.example.domain.usecase.ClientUseCase


interface IInteractorSetClientNotVerifiedPhoneNumber {
    fun invoke(phoneNumber: PhoneNumberModelDomain)
}

internal class InteractorSetClientNotVerifiedPhoneNumberImpl(
    private val useCase: ClientUseCase,
) : IInteractorSetClientNotVerifiedPhoneNumber {

    override fun invoke(phoneNumber: PhoneNumberModelDomain) {
        useCase.setClientNotVerifiedPhoneNumber(phoneNumber)
    }
}