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
import com.example.domain.models.Response
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

    override fun setClientNotVerifiedPhoneNumber(
        countryCode: CountryModelDomain,
        number: String,
    ): Flow<Response> {
        return flow {
            emit(mock.setClientNotVerifiedPhoneNumber(countryCode, number))
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

    override fun setClientPhoneNumber(
        countryCode: CountryModelDomain,
        number: String,
    ): Flow<Response> {
        return flow {
            emit(mock.setClientPhoneNumber(countryCode, number))
        }.flowOn(Dispatchers.IO)
    }

    override fun setClientAvatar(imageURL: String?): Flow<Response> {
        return flow {
            emit(mock.setClientAvatar(imageURL))
        }.flowOn(Dispatchers.IO)
    }

    override fun saveClientChanges(
        nameSurname: String,
        city: String,
        description: String,
        listOfClientSocialMedia: List<SocialMediaModelDomain>,
        isShowMyCommunities: Boolean,
        showMyEventsChecked: Boolean,
        applyNotificationsChecked: Boolean,
    ): Flow<Response> {
        return flow {
            emit(
                mock.saveClientChanges(
                    nameSurname = nameSurname,
                    city = city,
                    description = description,
                    listOfClientSocialMedia = listOfClientSocialMedia,
                    isShowMyCommunities = isShowMyCommunities,
                    showMyEventsChecked = showMyEventsChecked,
                    applyNotificationsChecked = applyNotificationsChecked
                )
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


    override suspend fun getCommunitiesAdvertBlock(blockId: String): CommunitiesAdvertBlockModelDomain {
        return mock.getCommunitiesAdvertBlock(blockId)
    }
    override suspend fun getEventsAdvertBlock(blockId: String): EventAdvertBlockModelDomain {
        return mock.getEventsAdvertBlock(blockId)
    }
}