package com.example.domain.interactors.client.setClientPhoneNumber

import com.example.domain.models.Response
import com.example.domain.repositories.INetworkClientRepository
import com.example.domain.usecase.ClientUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


interface IInteractorSetClientPhoneNumberResponse {
    fun invoke(): Flow<Response>
}

internal class InteractorSetClientPhoneNumberResponseImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorSetClientPhoneNumberResponse {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val setClientPhoneNumber =
        useCase.observeSetClientPhoneNumber().flatMapLatest { phoneNumber ->
            networkRepository.setClientPhoneNumber(phoneNumber)
        }

    init {
        setClientPhoneNumber
            .onEach { response ->
                if (response.status == "success") {
                    useCase.loadClient()
                }
            }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }

    override fun invoke(): Flow<Response> = setClientPhoneNumber
}