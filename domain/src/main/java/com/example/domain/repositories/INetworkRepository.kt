package com.example.domain.repositories

import com.example.domain.models.CommunitiesAdvertBlockModelDomain
import com.example.domain.models.CommunityDescriptionModelDomain
import com.example.domain.models.CommunityModelDomain
import com.example.domain.models.CountryModelDomain
import com.example.domain.models.EventAdvertBlockModelDomain
import com.example.domain.models.EventDescriptionModelDomain
import com.example.domain.models.EventModelDomain
import com.example.domain.models.UserModelDomain
import kotlinx.coroutines.flow.Flow

interface INetworkRepository {

    fun getListOfEvents(): Flow<List<EventModelDomain>>
    fun getEventDescription(eventId: String): Flow<EventDescriptionModelDomain>
    fun getListOfSortedEvents(search: String): Flow<List<EventModelDomain>>

    fun getListOfCommunities(): Flow<List<CommunityModelDomain>>
    fun getCommunityDescription(communityId: String): Flow<CommunityDescriptionModelDomain>

    fun getListOfTags(): Flow<List<String>>

    fun getListOfPeople(): Flow<List<UserModelDomain>>
    fun getUser(id: String): Flow<UserModelDomain>
    fun getListOfParticipants(communityOrEventID: String): Flow<List<UserModelDomain>>

    fun getAvailableCountriesList(): Flow<List<CountryModelDomain>>


    fun getCommunitiesAdvertBlock(): Flow<List<CommunitiesAdvertBlockModelDomain>>
    fun getEventsAdvertBlock(): Flow<List<EventAdvertBlockModelDomain>>
}