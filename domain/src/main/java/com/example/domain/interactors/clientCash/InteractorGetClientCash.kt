package com.example.domain.interactors.clientCash

import com.example.domain.models.ClientCashModelDomain
import com.example.domain.repositories.IClientCash
import com.example.domain.repositories.INetworkClientRepository
import com.example.domain.usecase.ClientUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.onStart


interface IInteractorGetClientCash {
    fun invoke(): Flow<ClientCashModelDomain>
}

internal class InteractorGetClientCashImpl(
    private val clientCashRepository: IClientCash,
    private val useCase: ClientUseCase,
    private val networkRepository: INetworkClientRepository,
) : IInteractorGetClientCash {

    @OptIn(ExperimentalCoroutinesApi::class)
    private val client = useCase.observeClient().flatMapLatest {
        networkRepository.getClient()
    }

    override fun invoke(): Flow<ClientCashModelDomain> =
        combine(
            clientCashRepository.getClient(),
            client
        ) { clientCash, client ->
            ClientCashModelDomain(
                imageURL = client.imageURL,
                listOfClientTags = client.listOfClientTags,
                nameSurname = clientCash.nameSurname,
                phoneNumber = clientCash.phoneNumber,
                city = clientCash.city,
                description = clientCash.description,
                listOfClientSocialMedia = clientCash.listOfClientSocialMedia,
                isShowMyCommunities = clientCash.isShowMyCommunities,
                isShowMyEvents = clientCash.isShowMyEvents,
                isApplyNotifications = clientCash.isApplyNotifications,
            )
        }.onStart {
            val clientStarter = client.first()
            emit(
                ClientCashModelDomain(
                    imageURL = clientStarter.imageURL,
                    listOfClientTags = clientStarter.listOfClientTags,
                    nameSurname = clientStarter.nameSurname,
                    phoneNumber = clientStarter.phoneNumber,
                    city = clientStarter.city,
                    description = clientStarter.description,
                    listOfClientSocialMedia = clientStarter.listOfClientSocialMedia,
                    isShowMyCommunities = clientStarter.isShowMyCommunities,
                    isShowMyEvents = clientStarter.isShowMyEvents,
                    isApplyNotifications = clientStarter.isApplyNotifications,
                )
            )
        }
}