package com.example.domain.interactors.advertBlock.communitiesAdvertBlock

import com.example.domain.models.CommunitiesAdvertBlockModelDomain
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest


interface IInteractorGetCommunitiesAdvertBlock {
    fun invoke(): Flow<List<CommunitiesAdvertBlockModelDomain>>
}

internal class InteractorGetCommunitiesAdvertBlockImpl(
    private val useCase: EventsUseCase,
    private val networkRepository: INetworkRepository,
) : IInteractorGetCommunitiesAdvertBlock {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val communitiesAdvertBlock = useCase.observeCommunitiesAdvertBlock().flatMapLatest {
        networkRepository.getCommunitiesAdvertBlock()
    }


    override fun invoke(): Flow<List<CommunitiesAdvertBlockModelDomain>> = communitiesAdvertBlock

}