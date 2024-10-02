package com.example.domain.interactors.ClientCash

import com.example.domain.repositories.ClientCash
import com.example.domain.repositories.IClientCash


interface IInteractorSaveClientCash {
    fun invoke(client: ClientCash)
}

internal class InteractorSaveClientCashImpl(
    private val cashRepository: IClientCash,
) : IInteractorSaveClientCash {

    override fun invoke(client: ClientCash) {
        cashRepository.saveClient(client)
    }

}