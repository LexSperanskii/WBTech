package com.example.domain.interactors.client.getClientNotVerifiedPhoneNumber

import com.example.domain.models.PhoneNumberModelDomain
import com.example.domain.repositories.INetworkClientRepository
import com.example.domain.usecase.ClientUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetClientNotVerifiedPhoneNumber {
    fun invoke(): Flow<PhoneNumberModelDomain>
}

internal class InteractorGetClientNotVerifiedPhoneNumberImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorGetClientNotVerifiedPhoneNumber {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val getClientNotVerifiedPhoneNumber =
        useCase.observeGetClientNotVerifiedPhoneNumber().flatMapLatest {
        networkRepository.getClientNotVerifiedPhoneNumber()
        }

    override fun invoke(): Flow<PhoneNumberModelDomain> = getClientNotVerifiedPhoneNumber
}