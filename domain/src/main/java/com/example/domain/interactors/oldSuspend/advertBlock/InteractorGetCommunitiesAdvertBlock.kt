package com.example.domain.interactors.oldSuspend.advertBlock

import com.example.domain.models.CommunitiesAdvertBlockModelDomain
import com.example.domain.repositories.INetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn


interface IInteractorGetCommunitiesAdvertBlock {
    fun invoke(blockId: String): Flow<CommunitiesAdvertBlockModelDomain>
}

internal class InteractorGetCommunitiesAdvertBlockImpl(
    private val networkRepository: INetworkRepository,
) : IInteractorGetCommunitiesAdvertBlock {

    override fun invoke(blockId: String): Flow<CommunitiesAdvertBlockModelDomain> =
        networkRepository.getCommunitiesAdvertBlock(blockId)
            .catch { exception ->
                // TODO сделать обработку ошибок
            }.flowOn(Dispatchers.IO)
}