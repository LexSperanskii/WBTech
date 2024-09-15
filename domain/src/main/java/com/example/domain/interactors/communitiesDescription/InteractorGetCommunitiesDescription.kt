package com.example.domain.interactors.communitiesDescription

import com.example.domain.models.CommunityDescriptionModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetCommunitiesDescription {
    fun invoke(): Flow<CommunityDescriptionModelDomain>
}

internal class InteractorGetCommunitiesDescriptionImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetCommunitiesDescription {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val communityDescription = useCase.observeCommunityId().flatMapLatest { communityId ->
        networkRepository.getCommunityDescription(communityId)
    }

    override fun invoke(): Flow<CommunityDescriptionModelDomain> = communityDescription
}