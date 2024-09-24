package com.example.domain.interactors.oldSuspend

import com.example.domain.models.Response
import com.example.domain.repositories.INetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn


interface IInteractorSetClientNotVerifiedName {
    suspend fun invoke(nameSurname: String): Flow<Response>
}

internal class InteractorSetClientNotVerifiedNameImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorSetClientNotVerifiedName {

    override suspend fun invoke(nameSurname: String) =
        networkRepository.setClientNotVerifiedName(nameSurname)
            .catch { exception ->
                // TODO сделать обработку ошибок
                emit(Response("error", exception.message ?: ""))
            }.flowOn(Dispatchers.IO)
}