package com.example.data.repositoriesImpl

import com.example.domain.models.CommunitiesAdvertBlockModelDomain
import com.example.domain.models.CommunityDescriptionModelDomain
import com.example.domain.models.CommunityModelDomain
import com.example.domain.models.CountryModelDomain
import com.example.domain.models.EventAdvertBlockModelDomain
import com.example.domain.models.EventDescriptionModelDomain
import com.example.domain.models.EventModelDomain
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
    override fun getListOfSortedEvents(search: String): Flow<List<EventModelDomain>> {
        return flow {
            emit(mock.getListOfSortedEvents(search))
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



    override fun getListOfTags(): Flow<List<String>> {
        return flow {
            emit(mock.getListOfTags())
        }.flowOn(Dispatchers.IO)
    }


    override fun getListOfPeople(): Flow<List<UserModelDomain>> {
        return flow {
            emit(mock.getListOfPeople())
        }.flowOn(Dispatchers.IO)
    }

    override fun getUser(id: String): Flow<UserModelDomain> {
        return flow {
            emit(mock.getUser(id))
        }.flowOn(Dispatchers.IO)
    }
    override fun getListOfParticipants(communityOrEventID: String): Flow<List<UserModelDomain>> {
        return flow {
            emit(mock.getListOfParticipants(communityOrEventID))
        }.flowOn(Dispatchers.IO)
    }

    override fun getAvailableCountriesList(): Flow<List<CountryModelDomain>> {
        return flow {
            emit(mock.getAvailableCountriesList())
        }.flowOn(Dispatchers.IO)
    }


    override fun getCommunitiesAdvertBlock(): Flow<List<CommunitiesAdvertBlockModelDomain>> {
        return flow {
            emit(mock.getCommunitiesAdvertBlock())
        }.flowOn(Dispatchers.IO)
    }

    override fun getEventsAdvertBlock(): Flow<List<EventAdvertBlockModelDomain>> {
        return flow {
            emit(mock.getEventsAdvertBlock())
        }.flowOn(Dispatchers.IO)
    }
}