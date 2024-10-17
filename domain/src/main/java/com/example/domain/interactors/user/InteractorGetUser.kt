package com.example.domain.interactors.user

import com.example.domain.models.UserModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetUser {
    fun invoke(): Flow<UserModelDomain>
}

internal class InteractorGetUserImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetUser {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val user = useCase.observeUser().flatMapLatest { userId ->
        networkRepository.getUser(userId)
    }

    override fun invoke(): Flow<UserModelDomain> = user
}