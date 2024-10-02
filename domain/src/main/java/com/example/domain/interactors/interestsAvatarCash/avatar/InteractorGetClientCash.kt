package com.example.domain.interactors.interestsAvatarCash.avatar

import com.example.domain.repositories.ClientCash
import com.example.domain.repositories.IClientCash
import kotlinx.coroutines.flow.Flow


interface IInteractorGetClientCash {
    fun invoke(): Flow<ClientCash>
}

internal class InteractorGetClientCashImpl(
    private val cashRepository: IClientCash,
) : IInteractorGetClientCash {

    override fun invoke(): Flow<ClientCash> = cashRepository.getClient()

}