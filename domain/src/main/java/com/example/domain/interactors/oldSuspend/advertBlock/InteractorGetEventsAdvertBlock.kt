package com.example.domain.interactors.oldSuspend.advertBlock

import com.example.domain.models.EventAdvertBlockModelDomain
import com.example.domain.repositories.INetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn


interface IInteractorGetEventsAdvertBlock {
    suspend fun invoke(blockId: String): Flow<EventAdvertBlockModelDomain>
}

internal class InteractorGetEventsAdvertBlockImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorGetEventsAdvertBlock {

    override suspend fun invoke(blockId: String): Flow<EventAdvertBlockModelDomain> =
        networkRepository.getEventsAdvertBlock(blockId)
            .catch { exception ->
                // TODO сделать обработку ошибок
            }.flowOn(Dispatchers.IO)
}