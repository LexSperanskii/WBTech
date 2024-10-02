package com.example.domain.interactors.client.setClientName

import com.example.domain.usecase.ClientUseCase


interface IInteractorSetClientName {
    fun invoke(nameSurname: String)
}

internal class InteractorSetClientNameImpl(
    private val useCase: ClientUseCase,
) : IInteractorSetClientName {

    override fun invoke(nameSurname: String) {
        useCase.setClientName(nameSurname)
    }
}