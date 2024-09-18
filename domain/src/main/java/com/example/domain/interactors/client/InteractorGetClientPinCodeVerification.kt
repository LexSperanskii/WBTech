package com.example.domain.interactors.client

import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onStart


interface IInteractorGetClientPinCodeVerification {
    fun invoke(): Flow<Boolean>
}

internal class InteractorGetClientPinCodeVerificationImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetClientPinCodeVerification {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val clientPinCodeVerification =
        useCase.observeClientPinCodeVerification().flatMapLatest { pinCode ->
            networkRepository.setClientPinCode(pinCode)
        }

    override fun invoke(): Flow<Boolean> = clientPinCodeVerification.onStart {
        emit(
            false
        )
    }
}