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
import com.example.domain.models.Response
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

    fun setClientNotVerifiedName(nameSurname: String): Flow<Response>
    fun getClientNotVerifiedName(): Flow<String>
    fun setClientNotVerifiedPhoneNumber(
        countryCode: CountryModelDomain,
        number: String,
    ): Flow<Response>

    fun getClientNotVerifiedPhoneNumber(): Flow<PhoneNumberModelDomain>
    fun setClientPinCode(pinCode: String): Flow<Boolean>
    fun getClient(): Flow<ClientModelDomain>
    fun setClientName(nameSurname: String): Flow<Response>
    fun setClientPhoneNumber(countryCode: CountryModelDomain, number: String): Flow<Response>
    fun setClientAvatar(imageURL: String?): Flow<Response>
    fun saveClientChanges(
        nameSurname: String,
        city: String,
        description: String,
        listOfClientSocialMedia: List<SocialMediaModelDomain>,
        isShowMyCommunities: Boolean,
        showMyEventsChecked: Boolean,
        applyNotificationsChecked: Boolean,
    ): Flow<Response>

    fun deleteClient(): Flow<Response>
    fun addToMyEvents(eventId: String): Flow<Response>
    fun removeFromMyEvents(eventId: String): Flow<Response>
    fun addToMyCommunities(communityId: String): Flow<Response>
    fun removeFromMyCommunities(communityId: String): Flow<Response>
    fun addToMyChosenTags(tag: String): Flow<Response>
    fun removeFromMyChosenTags(tag: String): Flow<Response>

    suspend fun getCommunitiesAdvertBlock(blockId: String): CommunitiesAdvertBlockModelDomain
    suspend fun getEventsAdvertBlock(blockId: String): EventAdvertBlockModelDomain
}