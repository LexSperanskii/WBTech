package com.example.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow

internal class EventsUseCase {

    private val streamEventId = MutableSharedFlow<String>(replay = 1)
    private var eventIdLastValue: String = ""

    private val streamListOfEvents = MutableSharedFlow<Unit>(replay = 1)

    private val streamListOfCommunities = MutableSharedFlow<Unit>(replay = 1)

    private val streamCommunityId = MutableSharedFlow<String>(replay = 1)
    private var communityIdLastValue: String = ""

    private val streamMyCommunitiesList = MutableSharedFlow<Unit>(replay = 1)

    private val streamListOfTags = MutableSharedFlow<Unit>(replay = 1)

    private val streamMyChosenTagsList = MutableSharedFlow<Unit>(replay = 1)

    private val streamListOfPeople = MutableSharedFlow<Unit>(replay = 1)

    private val streamUserId = MutableSharedFlow<String>(replay = 1)
    private var userIdLastValue: String = ""

    private val streamListOfParticipantsId = MutableSharedFlow<String>(replay = 1)
    private var participantsIdLastValue: String = ""

    private val streamAvailableCountriesList = MutableSharedFlow<Unit>(replay = 1)

    private val streamClient = MutableSharedFlow<Unit>(replay = 1)

    private val streamClientPinCode = MutableSharedFlow<String>(replay = 1)

    private val streamUserSearch = MutableSharedFlow<String>(replay = 1)
    private var userSearchLastValue: String = ""

    private val streamMyEventsList = MutableSharedFlow<Unit>(replay = 1)


    // Для EventDescription
    fun loadNewEventById(eventId: String) {
        eventIdLastValue = eventId
        streamEventId.tryEmit(eventId)
    }

    fun refreshEvent() {
        eventIdLastValue.run { streamEventId.tryEmit(this) }
    }

    fun observeEventId(): Flow<String> = streamEventId


    // Для ListOfEvents
    fun loadListOfEvents() {
        streamListOfEvents.tryEmit(Unit)
    }

    fun observeListOfEvents(): Flow<Unit> = streamListOfEvents


    // Для ListOfCommunities
    fun loadListOCommunities() {
        streamListOfCommunities.tryEmit(Unit)
    }

    fun observeListOfCommunities(): Flow<Unit> = streamListOfCommunities


    // Для CommunityDescription
    fun loadNewCommunityById(communityId: String) {
        communityIdLastValue = communityId
        streamCommunityId.tryEmit(communityId)
    }

    fun refreshCommunity() {
        communityIdLastValue.run { streamCommunityId.tryEmit(this) }
    }

    fun observeCommunityId(): Flow<String> = streamCommunityId


    // Для MyCommunitiesList
    fun loadMyCommunitiesList() {
        streamMyCommunitiesList.tryEmit(Unit)
    }

    fun observeMyCommunitiesList(): Flow<Unit> = streamMyCommunitiesList


    // Для ListOfTags
    fun loadListOfTags() {
        streamListOfTags.tryEmit(Unit)
    }

    fun observeListOfTags(): Flow<Unit> = streamListOfTags


    // Для myChosenTagsList
    fun loadMyChosenTagsList() {
        streamMyChosenTagsList.tryEmit(Unit)
    }

    fun observeMyChosenTagsList(): Flow<Unit> = streamMyChosenTagsList


    // Для ListOfPeople
    fun loadListOfPeople() {
        streamListOfPeople.tryEmit(Unit)
    }

    fun observeListOfPeople(): Flow<Unit> = streamListOfPeople


    // Для User
    fun loadNewUserById(userId: String) {
        userIdLastValue = userId
        streamUserId.tryEmit(userId)
    }

    fun refreshUser() {
        userIdLastValue.run { streamUserId.tryEmit(this) }
    }

    fun observeUser(): Flow<String> = streamUserId


    // Для ListOfParticipants
    fun loadListOfParticipants(communityOrEventID: String) {
        participantsIdLastValue = communityOrEventID
        streamListOfParticipantsId.tryEmit(communityOrEventID)
    }

    fun refreshListOfParticipants() {
        participantsIdLastValue.run { streamListOfParticipantsId.tryEmit(this) }
    }

    fun observeListOfParticipants(): Flow<String> = streamListOfParticipantsId


    // Для AvailableCountries
    fun loadAvailableCountriesList() {
        streamAvailableCountriesList.tryEmit(Unit)
    }

    fun observeAvailableCountriesList(): Flow<Unit> = streamAvailableCountriesList


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


    // Для ListOfSortedEvents
    fun loadListOfSortedEvents(search: String) {
        userSearchLastValue = search
        streamUserSearch.tryEmit(search)
    }

    fun refreshUserSearch() {
        userSearchLastValue.run { streamUserSearch.tryEmit(this) }
    }

    fun observeUserSearch(): Flow<String> = streamUserSearch


    // Для MyEventsList
    fun loadMyEventsList() {
        streamMyEventsList.tryEmit(Unit)
    }

    fun observeMyEventsList(): Flow<Unit> = streamMyEventsList
}