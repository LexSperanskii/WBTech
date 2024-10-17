package com.example.data.repositoriesImpl

import com.example.domain.models.ClientModelDomain
import com.example.domain.models.PhoneNumberModelDomain
import com.example.domain.models.Response
import com.example.domain.models.mock.MockData
import com.example.domain.repositories.INetworkClientRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NetworkClientRepositoryImpl(private val mock: MockData) : INetworkClientRepository {

    override fun setClientNotVerifiedName(nameSurname: String): Flow<Response> {
        return flow {
            emit(mock.setClientNotVerifiedName(nameSurname))
        }.flowOn(Dispatchers.IO)
    }

    override fun getClientNotVerifiedName(): Flow<String> {
        return flow {
            emit(mock.getClientNotVerifiedName())
        }.flowOn(Dispatchers.IO)
    }

    override fun setClientNotVerifiedPhoneNumber(phoneNumber: PhoneNumberModelDomain): Flow<Response> {
        return flow {
            emit(mock.setClientNotVerifiedPhoneNumber(phoneNumber))
        }.flowOn(Dispatchers.IO)
    }

    override fun getClientNotVerifiedPhoneNumber(): Flow<PhoneNumberModelDomain> {
        return flow {
            emit(mock.getClientNotVerifiedPhoneNumber())
        }.flowOn(Dispatchers.IO)
    }

    override fun setClientPinCode(pinCode: String): Flow<Boolean> {
        return flow {
            emit(mock.setClientPinCode(pinCode))
        }.flowOn(Dispatchers.IO)
    }

    override fun getClient(): Flow<ClientModelDomain> {
        return flow {
            emit(mock.getClient())
        }.flowOn(Dispatchers.IO)
    }

    override fun setClientName(nameSurname: String): Flow<Response> {
        return flow {
            emit(mock.setClientName(nameSurname))
        }.flowOn(Dispatchers.IO)
    }

    override fun setClientPhoneNumber(phoneNumber: PhoneNumberModelDomain): Flow<Response> {
        return flow {
            emit(mock.setClientPhoneNumber(phoneNumber))
        }.flowOn(Dispatchers.IO)
    }

    override fun setClientAvatar(imageURL: String?): Flow<Response> {
        return flow {
            emit(mock.setClientAvatar(imageURL))
        }.flowOn(Dispatchers.IO)
    }

    override fun saveClientChanges(newClient: ClientModelDomain): Flow<Response> {
        return flow {
            emit(
                mock.saveClientChanges(newClient = newClient)
            )
        }.flowOn(Dispatchers.IO)
    }

    override fun deleteClient(): Flow<Response> {
        return flow {
            emit(mock.deleteClient())
        }.flowOn(Dispatchers.IO)
    }


    override fun addToMyEvents(eventId: String): Flow<Response> {
        return flow {
            emit(mock.addToMyEvents(eventId))
        }.flowOn(Dispatchers.IO)
    }

    override fun removeFromMyEvents(eventId: String): Flow<Response> {
        return flow {
            emit(mock.removeFromMyEvents(eventId))
        }.flowOn(Dispatchers.IO)
    }

    override fun addToMyCommunities(communityId: String): Flow<Response> {
        return flow {
            emit(mock.addToMyCommunities(communityId))
        }.flowOn(Dispatchers.IO)
    }

    override fun removeFromMyCommunities(communityId: String): Flow<Response> {
        return flow {
            emit(mock.removeFromMyCommunities(communityId))
        }.flowOn(Dispatchers.IO)
    }

    override fun addToMyChosenTags(tag: String): Flow<Response> {
        return flow {
            emit(mock.addToMyChosenTags(tag))
        }.flowOn(Dispatchers.IO)
    }

    override fun removeFromMyChosenTags(tag: String): Flow<Response> {
        return flow {
            emit(mock.removeFromMyChosenTags(tag))
        }.flowOn(Dispatchers.IO)
    }
}