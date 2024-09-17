package com.example.domain.interactors.client

import com.example.domain.models.PhoneNumberModelDomain
import com.example.domain.repositories.INetworkRepository


interface IInteractorGetClientNotVerifiedPhoneNumber {
    suspend fun invoke(): PhoneNumberModelDomain
}

internal class InteractorGetClientNotVerifiedPhoneNumberImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorGetClientNotVerifiedPhoneNumber {

    override suspend fun invoke(): PhoneNumberModelDomain {
        return networkRepository.getClientNotVerifiedPhoneNumber()
    }
}