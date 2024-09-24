package com.example.domain.interactors.oldSuspend

import com.example.domain.models.PhoneNumberModelDomain
import com.example.domain.repositories.INetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn


interface IInteractorGetClientNotVerifiedPhoneNumber {
    suspend fun invoke(): Flow<PhoneNumberModelDomain>
}

internal class InteractorGetClientNotVerifiedPhoneNumberImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorGetClientNotVerifiedPhoneNumber {

    override suspend fun invoke(): Flow<PhoneNumberModelDomain> =
        networkRepository.getClientNotVerifiedPhoneNumber()
            .catch { exception ->
                // TODO сделать обработку ошибок
            }.flowOn(Dispatchers.IO)
}