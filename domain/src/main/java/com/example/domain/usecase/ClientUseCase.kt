package com.example.domain.usecase

import com.example.domain.models.ClientModelDomain
import com.example.domain.models.PhoneNumberModelDomain
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow

internal class ClientUseCase {

    private val streamClient = MutableSharedFlow<Unit>(replay = 1)
    private val streamClientPinCode = MutableStateFlow("")
    private val streamDeleteClient = MutableSharedFlow<Unit>(replay = 1)
    private val streamAddToClientChosenTags = MutableSharedFlow<String>(replay = 1)
    private val streamRemoveFromClientChosenTags = MutableSharedFlow<String>(replay = 1)
    private val streamAddToMyCommunities = MutableSharedFlow<String>(replay = 1)
    private val streamRemoveFromMyCommunities = MutableSharedFlow<String>(replay = 1)
    private val streamAddToMyEvents = MutableSharedFlow<String>(replay = 1)
    private val streamRemoveFromMyEvents = MutableSharedFlow<String>(replay = 1)
    private val streamSaveClientSettings = MutableSharedFlow<ClientModelDomain>(replay = 1)
    private val streamSetClientAvatar = MutableSharedFlow<String?>(replay = 1)
    private val streamSetClientName = MutableSharedFlow<String>(replay = 1)
    private val streamSetClientPhoneNumber = MutableSharedFlow<PhoneNumberModelDomain>(replay = 1)
    private val streamSetClientNotVerifiedName = MutableSharedFlow<String>(replay = 1)
    private val streamSetClientNotVerifiedPhoneNumber =
        MutableSharedFlow<PhoneNumberModelDomain>(replay = 1)
    private val streamGetClientNotVerifiedName = MutableSharedFlow<Unit>(replay = 1)
    private val streamGetClientNotVerifiedPhoneNumber = MutableSharedFlow<Unit>(replay = 1)


    //Для Client
    fun loadClient() {
        streamClient.tryEmit(Unit)
    }

    fun observeClient(): Flow<Unit> = streamClient


    //Для ClientPinCodeVerification
    fun loadClientPinCodeVerification(pinCode: String) {
        streamClientPinCode.tryEmit(pinCode)
    }

    fun observeClientPinCodeVerification(): Flow<String> = streamClientPinCode


    //Для DeleteClient
    fun deleteClient() {
        streamDeleteClient.tryEmit(Unit)
    }

    fun observeDeleteClient(): Flow<Unit> = streamDeleteClient

    //Для AddToClientChosenTags
    fun addToClientChosenTags(tag: String) {
        streamAddToClientChosenTags.tryEmit(tag)
    }

    fun observeAddToClientChosenTags(): Flow<String> = streamAddToClientChosenTags

    //Для RemoveFromClientChosenTags
    fun removeFromClientChosenTags(tag: String) {
        streamRemoveFromClientChosenTags.tryEmit(tag)
    }

    fun observeRemoveFromClientChosenTags(): Flow<String> = streamRemoveFromClientChosenTags

    //Для AddToMyCommunities
    fun addToMyCommunities(communityId: String) {
        streamAddToMyCommunities.tryEmit(communityId)
    }

    fun observeAddToMyCommunities(): Flow<String> = streamAddToMyCommunities

    //Для RemoveFromMyCommunities
    fun removeFromToMyCommunities(communityId: String) {
        streamRemoveFromMyCommunities.tryEmit(communityId)
    }

    fun observeRemoveFromMyCommunities(): Flow<String> = streamRemoveFromMyCommunities

    //Для AddToMyEvents
    fun addToMyEvents(eventId: String) {
        streamAddToMyEvents.tryEmit(eventId)
    }

    fun observeAddToMyEvents(): Flow<String> = streamAddToMyEvents

    //Для RemoveFromMyEvents
    fun removeFromToMyEvents(eventId: String) {
        streamRemoveFromMyEvents.tryEmit(eventId)
    }

    fun observeRemoveFromMyEvents(): Flow<String> = streamRemoveFromMyEvents

    //Для SaveClientSettings
    fun saveClientSettings(newClient: ClientModelDomain) {
        streamSaveClientSettings.tryEmit(newClient)
    }

    fun observeSaveClientSettings(): Flow<ClientModelDomain> = streamSaveClientSettings

    //Для SetClientAvatar
    fun setClientAvatar(avatar: String?) {
        streamSetClientAvatar.tryEmit(avatar)
    }

    fun observeSetClientAvatar(): Flow<String?> = streamSetClientAvatar

    //Для SetClientName
    fun setClientName(nameSurname: String) {
        streamSetClientName.tryEmit(nameSurname)
    }

    fun observeSetClientName(): Flow<String> = streamSetClientName

    //Для SetClientPhoneNumber
    fun setClientPhoneNumber(phoneNumber: PhoneNumberModelDomain) {
        streamSetClientPhoneNumber.tryEmit(phoneNumber)
    }

    fun observeSetClientPhoneNumber(): Flow<PhoneNumberModelDomain> = streamSetClientPhoneNumber

    //Для SetClientNotVerifiedName
    fun setClientNotVerifiedName(nameSurname: String) {
        streamSetClientNotVerifiedName.tryEmit(nameSurname)
    }

    fun observeSetClientNotVerifiedName(): Flow<String> = streamSetClientNotVerifiedName

    //Для SetClientNotVerifiedPhoneNumber
    fun setClientNotVerifiedPhoneNumber(phoneNumber: PhoneNumberModelDomain) {
        streamSetClientNotVerifiedPhoneNumber.tryEmit(phoneNumber)
    }

    fun observeSetClientNotVerifiedPhoneNumber(): Flow<PhoneNumberModelDomain> =
        streamSetClientNotVerifiedPhoneNumber

    //Для GetClientNotVerifiedName
    fun loadClientNotVerifiedName() {
        streamGetClientNotVerifiedName.tryEmit(Unit)
    }

    fun observeGetClientNotVerifiedName(): Flow<Unit> = streamGetClientNotVerifiedName

    //Для GetClientNotVerifiedPhoneNumber
    fun loadClientNotVerifiedPhoneNumber() {
        streamGetClientNotVerifiedPhoneNumber.tryEmit(Unit)
    }

    fun observeGetClientNotVerifiedPhoneNumber(): Flow<Unit> = streamGetClientNotVerifiedPhoneNumber
}