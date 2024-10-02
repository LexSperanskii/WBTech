package com.example.domain.interactors.client.setClientAvatar

import com.example.domain.models.Response
import com.example.domain.repositories.INetworkClientRepository
import com.example.domain.usecase.ClientUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


interface IInteractorSetClientAvatarResponse {
    fun invoke(): Flow<Response>
}

internal class InteractorSetClientAvatarResponseImpl(
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorSetClientAvatarResponse {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val setClientAvatar = useCase.observeSetClientAvatar().flatMapLatest { avatar ->
        networkRepository.setClientAvatar(avatar)
    }

    init {
        setClientAvatar
            .onEach { response ->
                if (response.status == "success") {
                    useCase.loadClient()
                }
            }
            .launchIn(CoroutineScope(Dispatchers.IO))
    }

    override fun invoke(): Flow<Response> = setClientAvatar
}