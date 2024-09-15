package com.example.domain.interactors.listOfTags

import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetListOfTags {
    fun invoke(): Flow<List<String>>
}

internal class InteractorGetListOfTagsImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetListOfTags {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val listOfTags = useCase.observeListOfTags().flatMapLatest {
        networkRepository.getListOfTags()
    }

    override fun invoke(): Flow<List<String>> = listOfTags
}