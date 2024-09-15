package com.example.domain.interactors.myChosenTags

import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetMyChosenTagsList {
    fun invoke(): Flow<List<String>>
}

internal class InteractorGetMyChosenTagsListImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetMyChosenTagsList {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val myChosenTagsList = useCase.observeMyChosenTagsList().flatMapLatest {
        networkRepository.getMyChosenTagsList()
    }

    override fun invoke(): Flow<List<String>> = myChosenTagsList
}