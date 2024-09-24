package com.example.domain.interactors.oldSuspend.myCommunities

import com.example.domain.models.Response
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach

interface IInteractorAddToMyCommunities {
    fun invoke(communityId: String): Flow<Response>
}

internal class InteractorAddToMyCommunitiesImpl(
    private val networkRepository: INetworkRepository,
    private val useCase: EventsUseCase,
) : IInteractorAddToMyCommunities {

    override fun invoke(communityId: String): Flow<Response> =
        networkRepository.addToMyCommunities(communityId)
            .onEach { response ->
                if (response.status == "success") {
                    useCase.loadClient()
                }
            }.catch { exception ->
                // TODO сделать обработку ошибок
                emit(Response("error", exception.message ?: ""))
            }.flowOn(Dispatchers.IO)

}