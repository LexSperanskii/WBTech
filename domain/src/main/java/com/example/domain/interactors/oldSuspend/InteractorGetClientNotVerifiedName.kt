package com.example.domain.interactors.oldSuspend

import com.example.domain.repositories.INetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn


interface IInteractorGetClientNotVerifiedName {
    fun invoke(): Flow<String>
}

internal class InteractorGetClientNotVerifiedNameImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorGetClientNotVerifiedName {

    override fun invoke(): Flow<String> = networkRepository.getClientNotVerifiedName()
        .catch { exception ->
            // TODO сделать обработку ошибок
        }.flowOn(Dispatchers.IO)
}