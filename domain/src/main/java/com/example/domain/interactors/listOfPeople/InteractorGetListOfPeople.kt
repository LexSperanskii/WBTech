package com.example.domain.interactors.listOfPeople

import com.example.domain.models.UserModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetListOfPeople {
    fun invoke(): Flow<List<UserModelDomain>>
}

internal class InteractorGetListOfPeopleImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetListOfPeople {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val listOfPeople = useCase.observeListOfPeople().flatMapLatest {
        networkRepository.getListOfPeople()
    }

    override fun invoke(): Flow<List<UserModelDomain>> = listOfPeople
}