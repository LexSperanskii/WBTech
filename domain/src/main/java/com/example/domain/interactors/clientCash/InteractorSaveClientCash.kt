package com.example.domain.interactors.clientCash

import com.example.domain.models.ClientCashModelDomain
import com.example.domain.repositories.IClientCash


interface IInteractorSaveClientCash {
    fun invoke(client: ClientCashModelDomain)
}

internal class InteractorSaveClientCashImpl(
    private val clientCashRepository: IClientCash,
) : IInteractorSaveClientCash {

    override fun invoke(client: ClientCashModelDomain) {
        clientCashRepository.saveClient(client)
    }

}