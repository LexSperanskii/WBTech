package com.example.domain.interactors.client

import com.example.domain.models.PhoneNumberModelDomain
import com.example.domain.repositories.INetworkRepository


interface IInteractorGetClientPhoneNumber {
    suspend fun invoke(): PhoneNumberModelDomain
}

internal class InteractorGetClientPhoneNumberImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorGetClientPhoneNumber {

    override suspend fun invoke(): PhoneNumberModelDomain {
        return networkRepository.getClientPhoneNumber()
    }
}