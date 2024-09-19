package com.example.domain.interactors.client

import com.example.domain.models.CountryModelDomain
import com.example.domain.repositories.INetworkRepository


interface IInteractorSetClientPhoneNumber {
    suspend fun invoke(countryCode: CountryModelDomain, number: String)
}

internal class InteractorSetClientPhoneNumberImpl(
    private val networkRepository: INetworkRepository,
    private val loadClient: IInteractorLoadClient,
) : IInteractorSetClientPhoneNumber {

    override suspend fun invoke(countryCode: CountryModelDomain, number: String) {
        networkRepository.setClientPhoneNumber(countryCode, number)
        loadClient.invoke()
    }
}