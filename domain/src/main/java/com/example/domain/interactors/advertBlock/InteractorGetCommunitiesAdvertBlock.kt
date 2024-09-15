package com.example.domain.interactors.advertBlock

import com.example.domain.models.CommunitiesAdvertBlockModelDomain
import com.example.domain.repositories.INetworkRepository


interface IInteractorGetCommunitiesAdvertBlock {
    suspend fun invoke(blockId: String): CommunitiesAdvertBlockModelDomain
}

internal class InteractorGetCommunitiesAdvertBlockImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorGetCommunitiesAdvertBlock {

    override suspend fun invoke(blockId: String): CommunitiesAdvertBlockModelDomain {
        return networkRepository.getCommunitiesAdvertBlock(blockId)
    }
}