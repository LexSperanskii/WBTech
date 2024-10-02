package com.example.domain.interactors.client.getClientNotVerifiedName

import com.example.domain.repositories.INetworkClientRepository
import com.example.domain.usecase.ClientUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetClientNotVerifiedName {
    fun invoke(): Flow<String>
}

internal class InteractorGetClientNotVerifiedNameImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorGetClientNotVerifiedName {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val getClientNotVerifiedName = useCase.observeGetClientNotVerifiedName().flatMapLatest {
        networkRepository.getClientNotVerifiedName()
    }

    override fun invoke(): Flow<String> = getClientNotVerifiedName
}