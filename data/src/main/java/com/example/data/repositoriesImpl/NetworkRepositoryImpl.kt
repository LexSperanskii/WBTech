package com.example.data.repositoriesImpl

import com.example.domain.models.ClientModelDomain
import com.example.domain.models.CommunitiesAdvertBlockModelDomain
import com.example.domain.models.CommunityDescriptionModelDomain
import com.example.domain.models.CommunityModelDomain
import com.example.domain.models.CountryModelDomain
import com.example.domain.models.EventAdvertBlockModelDomain
import com.example.domain.models.EventDescriptionModelDomain
import com.example.domain.models.EventModelDomain
import com.example.domain.models.PhoneNumberModelDomain
import com.example.domain.models.UserModelDomain
import com.example.domain.models.mock.MockData
import com.example.domain.repositories.INetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


internal class NetworkRepositoryImpl(private val mock: MockData) : INetworkRepository {

    override fun getListOfEvents(): Flow<List<EventModelDomain>> {
        return flow {
            emit(mock.getListOfEvents())
        }.flowOn(Dispatchers.IO)
    }

    override fun getEventDescription(eventId: String): Flow<EventDescriptionModelDomain> {
        return flow {
            emit(mock.getEventDescription(eventId))
        }.flowOn(Dispatchers.IO)
    }


    override fun getListOfCommunities(): Flow<List<CommunityModelDomain>> {
        return flow {
            emit(mock.getListOfCommunities())
        }.flowOn(Dispatchers.IO)
    }

    override fun getCommunityDescription(communityId: String): Flow<CommunityDescriptionModelDomain> {
        return flow {
            emit(mock.getCommunityDescription(communityId))
        }.flowOn(Dispatchers.IO)
    }

    override fun getMyCommunitiesList(): Flow<List<CommunityModelDomain>> {
        return flow {
            emit(mock.getMyCommunitiesList())
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun addToMyCommunities(communityId: String) {
        mock.addToMyCommunities(communityId)
    }

    override suspend fun removeFromMyCommunities(communityId: String) {
        mock.removeFromMyCommunities(communityId)
    }


    override fun getListOfTags(): Flow<List<String>> {
        return flow {
            emit(mock.getListOfTags())
        }.flowOn(Dispatchers.IO)
    }

    override fun getMyChosenTagsList(): Flow<List<String>> {
        return flow {
            emit(mock.getMyChosenTagsList())
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun addToMyChosenTags(tag: String) {
        mock.addToMyChosenTags(tag)
    }

    override suspend fun removeFromMyChosenTags(tag: String) {
        mock.removeFromMyChosenTags(tag)
    }


    override fun getListOfPeople(): Flow<List<UserModelDomain>> {
        return flow {
            emit(mock.getListOfPeople())
        }.flowOn(Dispatchers.IO)
    }

    override fun getListOfParticipants(communityOrEventID: String): Flow<List<UserModelDomain>> {
        return flow {
            emit(mock.getListOfParticipants(communityOrEventID))
        }.flowOn(Dispatchers.IO)
    }

    override fun getUser(id: String): Flow<UserModelDomain> {
        return flow {
            emit(mock.getUser(id))
        }.flowOn(Dispatchers.IO)
    }


    override fun getAvailableCountriesList(): Flow<List<CountryModelDomain>> {
        return flow {
            emit(mock.getAvailableCountriesList())
        }.flowOn(Dispatchers.IO)
    }


    override suspend fun setClientName(nameSurname: String) {
        mock.setClientName(nameSurname)
    }

    override suspend fun setClientPhoneNumber(countryCode: String, number: String) {
        mock.setClientPhoneNumber(countryCode, number)
    }

    override suspend fun setClientPinCode(pinCode: String): Boolean {
        return mock.setClientPinCode(pinCode)
    }

    override suspend fun getClientPhoneNumber(): PhoneNumberModelDomain {
        return mock.getClientPhoneNumber()
    }

    override fun getClient(): Flow<ClientModelDomain> {
        return flow {
            emit(mock.getClient())
        }.flowOn(Dispatchers.IO)
    }


    override suspend fun getCommunitiesAdvertBlock(blockId: String): CommunitiesAdvertBlockModelDomain {
        return mock.getCommunitiesAdvertBlock(blockId)
    }

    override suspend fun getEventsAdvertBlock(blockId: String): EventAdvertBlockModelDomain {
        return mock.getEventsAdvertBlock(blockId)
    }

}