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
import com.example.domain.models.SocialMediaModelDomain
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


    override suspend fun setClientNotVerifiedName(nameSurname: String) {
        mock.setClientNotVerifiedName(nameSurname)
    }

    override suspend fun getClientNotVerifiedName(): String {
        return mock.getClientNotVerifiedName()
    }

    override suspend fun setClientNotVerifiedPhoneNumber(
        countryCode: CountryModelDomain,
        number: String,
    ) {
        mock.setClientNotVerifiedPhoneNumber(countryCode, number)
    }

    override suspend fun getClientNotVerifiedPhoneNumber(): PhoneNumberModelDomain {
        return mock.getClientNotVerifiedPhoneNumber()
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
    override suspend fun setClientName(nameSurname: String) {
        mock.setClientName(nameSurname)
    }

    override suspend fun setClientPhoneNumber(countryCode: CountryModelDomain, number: String) {
        mock.setClientPhoneNumber(countryCode, number)
    }
    override suspend fun saveClientChanges(
        imageURL: String?,
        nameSurname: String,
        city: String,
        description: String,
        listOfClientSocialMedia: List<SocialMediaModelDomain>,
        isShowMyCommunities: Boolean,
        showMyEventsChecked: Boolean,
        applyNotificationsChecked: Boolean,
    ) {
        mock.saveClientChanges(
            imageURL = imageURL,
            nameSurname = nameSurname,
            city = city,
            description = description,
            listOfClientSocialMedia = listOfClientSocialMedia,
            isShowMyCommunities = isShowMyCommunities,
            showMyEventsChecked = showMyEventsChecked,
            applyNotificationsChecked = applyNotificationsChecked
        )
    }
    override suspend fun deleteClient() {
        return mock.deleteClient()
    }

    override suspend fun addToMyEvents(eventId: String) {
        mock.addToMyEvents(eventId)
    }

    override suspend fun removeFromMyEvents(eventId: String) {
        mock.removeFromMyEvents(eventId)
    }

    override suspend fun addToMyCommunities(communityId: String) {
        mock.addToMyCommunities(communityId)
    }

    override suspend fun removeFromMyCommunities(communityId: String) {
        mock.removeFromMyCommunities(communityId)
    }

    override suspend fun addToMyChosenTags(tag: String) {
        mock.addToMyChosenTags(tag)
    }

    override suspend fun removeFromMyChosenTags(tag: String) {
        mock.removeFromMyChosenTags(tag)
    }


    override suspend fun getCommunitiesAdvertBlock(blockId: String): CommunitiesAdvertBlockModelDomain {
        return mock.getCommunitiesAdvertBlock(blockId)
    }
    override suspend fun getEventsAdvertBlock(blockId: String): EventAdvertBlockModelDomain {
        return mock.getEventsAdvertBlock(blockId)
    }
}