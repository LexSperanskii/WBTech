package com.example.domain.interactors.client

import com.example.domain.repositories.INetworkRepository


interface IInteractorSetClientPinCode {
    suspend fun invoke(pinCode: String): Boolean
}

internal class InteractorSetClientPinCodeImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorSetClientPinCode {

    override suspend fun invoke(pinCode: String): Boolean {
        return networkRepository.setClientPinCode(pinCode)
    }
}