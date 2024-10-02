package com.example.domain.interactors.client.setClientNotVerifiedName

import com.example.domain.usecase.ClientUseCase


interface IInteractorSetClientNotVerifiedName {
    fun invoke(nameSurname: String)
}

internal class InteractorSetClientNotVerifiedNameImpl(
    private val useCase: ClientUseCase,
) : IInteractorSetClientNotVerifiedName {

    override fun invoke(nameSurname: String) {
        useCase.setClientNotVerifiedName(nameSurname)
    }
}