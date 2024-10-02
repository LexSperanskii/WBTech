package com.example.domain.interactors.client.saveClientSettings

import com.example.domain.models.ClientModelDomain
import com.example.domain.usecase.ClientUseCase


interface IInteractorSaveClientSettings {
    fun invoke(newClient: ClientModelDomain)
}

internal class InteractorSaveClientSettingsImpl(
    private val useCase: ClientUseCase,
) : IInteractorSaveClientSettings {

    override fun invoke(newClient: ClientModelDomain) {
        useCase.saveClientSettings(newClient)
    }

}
