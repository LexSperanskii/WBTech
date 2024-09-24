package com.example.domain.interactors.oldSuspend

import com.example.domain.models.CountryModelDomain
import com.example.domain.models.Response
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach


interface IInteractorSetClientPhoneNumber {
    suspend fun invoke(countryCode: CountryModelDomain, number: String): Flow<Response>
}

internal class InteractorSetClientPhoneNumberImpl(
    private val networkRepository: INetworkRepository,
    private val useCase: EventsUseCase,
) : IInteractorSetClientPhoneNumber {

    override suspend fun invoke(countryCode: CountryModelDomain, number: String) =
        networkRepository.setClientPhoneNumber(countryCode, number)
            .onEach { response ->
                if (response.status == "success") {
                    useCase.loadClient()
                }
            }.catch { exception ->
                // TODO сделать обработку ошибок
                emit(Response("error", exception.message ?: ""))
            }.flowOn(Dispatchers.IO)
}