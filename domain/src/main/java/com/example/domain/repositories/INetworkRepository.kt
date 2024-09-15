package com.example.domain.repositories

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
import kotlinx.coroutines.flow.Flow

interface INetworkRepository {

    fun getListOfEvents(): Flow<List<EventModelDomain>>
    fun getEventDescription(eventId: String): Flow<EventDescriptionModelDomain>

    fun getListOfCommunities(): Flow<List<CommunityModelDomain>>
    fun getCommunityDescription(communityId: String): Flow<CommunityDescriptionModelDomain>
    fun getMyCommunitiesList(): Flow<List<CommunityModelDomain>>
    suspend fun addToMyCommunities(communityId: String)
    suspend fun removeFromMyCommunities(communityId: String)

    fun getListOfTags(): Flow<List<String>>
    fun getMyChosenTagsList(): Flow<List<String>>
    suspend fun addToMyChosenTags(tag: String)
    suspend fun removeFromMyChosenTags(tag: String)

    fun getListOfPeople(): Flow<List<UserModelDomain>>
    fun getUser(id: String): Flow<UserModelDomain>
    fun getListOfParticipants(communityOrEventID: String): Flow<List<UserModelDomain>>

    fun getAvailableCountriesList(): Flow<List<CountryModelDomain>>

    suspend fun setClientName(nameSurname: String)
    suspend fun setClientPhoneNumber(countryCode: String, number: String)
    suspend fun setClientPinCode(pinCode: String): Boolean
    suspend fun getClientPhoneNumber(): PhoneNumberModelDomain
    fun getClient(): Flow<ClientModelDomain>

    suspend fun getCommunitiesAdvertBlock(blockId: String): CommunitiesAdvertBlockModelDomain
    suspend fun getEventsAdvertBlock(blockId: String): EventAdvertBlockModelDomain
}