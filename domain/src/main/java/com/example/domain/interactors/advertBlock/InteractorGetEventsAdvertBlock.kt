package com.example.domain.interactors.advertBlock

import com.example.domain.models.EventAdvertBlockModelDomain
import com.example.domain.repositories.INetworkRepository


interface IInteractorGetEventsAdvertBlock {
    suspend fun invoke(blockId: String): EventAdvertBlockModelDomain
}

internal class InteractorGetEventsAdvertBlockImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorGetEventsAdvertBlock {

    override suspend fun invoke(blockId: String): EventAdvertBlockModelDomain {
        return networkRepository.getEventsAdvertBlock(blockId)
    }
}