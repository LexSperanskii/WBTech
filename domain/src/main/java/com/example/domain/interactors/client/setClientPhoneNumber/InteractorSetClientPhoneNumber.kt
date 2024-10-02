package com.example.domain.interactors.client.setClientPhoneNumber

import com.example.domain.models.PhoneNumberModelDomain
import com.example.domain.usecase.ClientUseCase


interface IInteractorSetClientPhoneNumber {
    fun invoke(phoneNumber: PhoneNumberModelDomain)
}

internal class InteractorSetClientPhoneNumberImpl(
    private val useCase: ClientUseCase,
) : IInteractorSetClientPhoneNumber {

    override fun invoke(phoneNumber: PhoneNumberModelDomain) {
        useCase.setClientPhoneNumber(phoneNumber)
    }
}