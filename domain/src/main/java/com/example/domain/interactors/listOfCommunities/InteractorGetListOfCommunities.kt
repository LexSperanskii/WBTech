package com.example.domain.interactors.listOfCommunities

import com.example.domain.models.CommunityModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetListOfCommunities {
    fun invoke(): Flow<List<CommunityModelDomain>>
}

internal class InteractorGetListOfCommunitiesImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetListOfCommunities {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val listOfCommunitiesFlow = useCase.observeListOfCommunities().flatMapLatest {
        networkRepository.getListOfCommunities()
    }

    override fun invoke(): Flow<List<CommunityModelDomain>> = listOfCommunitiesFlow
}