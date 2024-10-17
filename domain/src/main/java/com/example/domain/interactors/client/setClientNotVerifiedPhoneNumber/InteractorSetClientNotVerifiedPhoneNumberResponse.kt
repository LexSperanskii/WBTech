package com.example.domain.interactors.client.setClientNotVerifiedPhoneNumber

import com.example.domain.models.Response
import com.example.domain.repositories.INetworkClientRepository
import com.example.domain.usecase.ClientUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn


interface IInteractorSetClientNotVerifiedPhoneNumberResponse {
    fun invoke(): Flow<Response>
}

internal class InteractorSetClientNotVerifiedPhoneNumberResponseImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorSetClientNotVerifiedPhoneNumberResponse {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val setClientNotVerifiedPhoneNumber =
        useCase.observeSetClientNotVerifiedPhoneNumber().flatMapLatest { phoneNumber ->
            networkRepository.setClientNotVerifiedPhoneNumber(phoneNumber)
        }

    init {
        setClientNotVerifiedPhoneNumber.launchIn(CoroutineScope(Dispatchers.IO))
    }

    override fun invoke(): Flow<Response> = setClientNotVerifiedPhoneNumber
}