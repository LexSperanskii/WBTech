package com.example.domain.interactors.oldSuspend

import com.example.domain.models.CountryModelDomain
import com.example.domain.models.Response
import com.example.domain.repositories.INetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn


interface IInteractorSetClientNotVerifiedPhoneNumber {
    suspend fun invoke(countryCode: CountryModelDomain, number: String): Flow<Response>
}

internal class InteractorSetClientNotVerifiedPhoneNumberImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorSetClientNotVerifiedPhoneNumber {

    override suspend fun invoke(countryCode: CountryModelDomain, number: String) =
        networkRepository.setClientNotVerifiedPhoneNumber(countryCode, number)
            .catch { exception ->
                // TODO сделать обработку ошибок
                emit(Response("error", exception.message ?: ""))
            }.flowOn(Dispatchers.IO)
}