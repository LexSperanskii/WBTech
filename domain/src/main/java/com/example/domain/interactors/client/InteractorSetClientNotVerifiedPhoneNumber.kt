package com.example.domain.interactors.client

import com.example.domain.models.CountryModelDomain
import com.example.domain.repositories.INetworkRepository


interface IInteractorSetClientNotVerifiedPhoneNumber {
    suspend fun invoke(countryCode: CountryModelDomain, number: String)
}

internal class InteractorSetClientNotVerifiedPhoneNumberImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorSetClientNotVerifiedPhoneNumber {

    override suspend fun invoke(countryCode: CountryModelDomain, number: String) {
        networkRepository.setClientNotVerifiedPhoneNumber(countryCode, number)
    }
}