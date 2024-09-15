package com.example.domain.interactors.client

import com.example.domain.repositories.INetworkRepository


interface IInteractorSetClientPhoneNumber {
    suspend fun invoke(countryCode: String, number: String)
}

internal class InteractorSetClientPhoneNumberImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorSetClientPhoneNumber {

    override suspend fun invoke(countryCode: String, number: String) {
        networkRepository.setClientPhoneNumber(countryCode, number)
    }
}