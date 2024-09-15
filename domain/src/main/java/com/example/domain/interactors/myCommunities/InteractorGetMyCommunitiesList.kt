package com.example.domain.interactors.myCommunities

import com.example.domain.models.CommunityModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetMyCommunitiesList {
    fun invoke(): Flow<List<CommunityModelDomain>>
}

internal class InteractorGetMyCommunitiesListImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetMyCommunitiesList {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val myCommunities = useCase.observeMyCommunitiesList().flatMapLatest {
        networkRepository.getMyCommunitiesList()
    }

    override fun invoke(): Flow<List<CommunityModelDomain>> = myCommunities
}