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
import com.example.domain.models.SocialMediaModelDomain
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

    suspend fun setClientNotVerifiedName(nameSurname: String)
    suspend fun getClientNotVerifiedName(): String
    suspend fun setClientNotVerifiedPhoneNumber(countryCode: CountryModelDomain, number: String)
    suspend fun getClientNotVerifiedPhoneNumber(): PhoneNumberModelDomain
    fun setClientPinCode(pinCode: String): Flow<Boolean>
    fun getClient(): Flow<ClientModelDomain>
    suspend fun setClientName(nameSurname: String)
    suspend fun setClientPhoneNumber(countryCode: CountryModelDomain, number: String)
    suspend fun saveClientChanges(
        imageURL: String?,
        nameSurname: String,
        city: String,
        description: String,
        listOfClientSocialMedia: List<SocialMediaModelDomain>,
        isShowMyCommunities: Boolean,
        showMyEventsChecked: Boolean,
        applyNotificationsChecked: Boolean,
    )
    suspend fun deleteClient()
    suspend fun addToMyEvents(eventId: String)
    suspend fun removeFromMyEvents(eventId: String)
    suspend fun addToMyCommunities(communityId: String)
    suspend fun removeFromMyCommunities(communityId: String)
    suspend fun addToMyChosenTags(tag: String)
    suspend fun removeFromMyChosenTags(tag: String)

    suspend fun getCommunitiesAdvertBlock(blockId: String): CommunitiesAdvertBlockModelDomain
    suspend fun getEventsAdvertBlock(blockId: String): EventAdvertBlockModelDomain
}