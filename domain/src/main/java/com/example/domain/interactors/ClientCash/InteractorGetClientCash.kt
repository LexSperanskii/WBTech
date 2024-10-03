package com.example.domain.interactors.ClientCash

import com.example.domain.models.ClientCashModelDomain
import com.example.domain.repositories.IClientCash
import kotlinx.coroutines.flow.Flow


interface IInteractorGetClientCash {
    fun invoke(): Flow<ClientCashModelDomain>
}

internal class InteractorGetClientCashImpl(
    private val cashRepository: IClientCash,
) : IInteractorGetClientCash {

    override fun invoke(): Flow<ClientCashModelDomain> = cashRepository.getClient()

}