package com.example.domain.interactors.oldSuspend

import com.example.domain.models.Response
import com.example.domain.repositories.INetworkRepository
import com.example.domain.usecase.EventsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach


interface IInteractorSetClientName {
    fun invoke(nameSurname: String): Flow<Response>
}

internal class InteractorSetClientNameImpl(
    private val networkRepository: INetworkRepository,
    private val useCase: EventsUseCase,
) : IInteractorSetClientName {

    override fun invoke(nameSurname: String) = networkRepository.setClientName(nameSurname)
        .onEach { response ->
            if (response.status == "success") {
                useCase.loadClient()
            }
        }.catch { exception ->
            // TODO сделать обработку ошибок
            emit(Response("error", exception.message ?: ""))
        }.flowOn(Dispatchers.IO)
}