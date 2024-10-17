package com.example.domain.repositories

import com.example.domain.models.ClientModelDomain
import com.example.domain.models.PhoneNumberModelDomain
import com.example.domain.models.Response
import kotlinx.coroutines.flow.Flow

interface INetworkClientRepository {

    fun setClientNotVerifiedName(nameSurname: String): Flow<Response>
    fun getClientNotVerifiedName(): Flow<String>
    fun setClientNotVerifiedPhoneNumber(phoneNumber: PhoneNumberModelDomain): Flow<Response>
    fun getClientNotVerifiedPhoneNumber(): Flow<PhoneNumberModelDomain>
    fun setClientPinCode(pinCode: String): Flow<Boolean>
    fun getClient(): Flow<ClientModelDomain>
    fun setClientName(nameSurname: String): Flow<Response>
    fun setClientPhoneNumber(phoneNumber: PhoneNumberModelDomain): Flow<Response>
    fun setClientAvatar(imageURL: String?): Flow<Response>
    fun saveClientChanges(newClient: ClientModelDomain): Flow<Response>
    fun deleteClient(): Flow<Response>
    fun addToMyEvents(eventId: String): Flow<Response>
    fun removeFromMyEvents(eventId: String): Flow<Response>
    fun addToMyCommunities(communityId: String): Flow<Response>
    fun removeFromMyCommunities(communityId: String): Flow<Response>
    fun addToMyChosenTags(tag: String): Flow<Response>
    fun removeFromMyChosenTags(tag: String): Flow<Response>
}