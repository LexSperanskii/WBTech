package com.example.domain.interactors.client.pinCode

import com.example.domain.repositories.INetworkClientRepository
import com.example.domain.usecase.ClientUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetClientPinCodeVerification {
    fun invoke(): Flow<Boolean>
}

internal class InteractorGetClientPinCodeVerificationImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorGetClientPinCodeVerification {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val clientPinCodeVerification =
        useCase.observeClientPinCodeVerification().flatMapLatest { pinCode ->
            networkRepository.setClientPinCode(pinCode)
        }

    override fun invoke(): Flow<Boolean> = clientPinCodeVerification
}