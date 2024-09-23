package com.example.domain.usecase

//internal class EventsUseCaseForOldSuspend{
//
//    private val streamDeleteClient = MutableSharedFlow<Unit>(replay = 1)
//
//    private val streamAddToMyEvents = MutableSharedFlow<String>(replay = 1)
//    private val streamRemoveFromMyEvents = MutableSharedFlow<String>(replay = 1)
//
//    private val streamAddToMyCommunities = MutableSharedFlow<String>(replay = 1)
//    private val streamRemoveFromCommunities = MutableSharedFlow<String>(replay = 1)
//
//    private val streamAddToMyChosenTags = MutableSharedFlow<String>(replay = 1)
//    private val streamRemoveFromMyChosenTags = MutableSharedFlow<String>(replay = 1)
//
//    private val streamSaveClientSettings = MutableSharedFlow<String>(replay = 1)
//
//
//    // Для DeleteClient
//    fun loadDeleteClient() {
//        streamDeleteClient.tryEmit(Unit)
//    }
//    fun observeDeleteClient(): Flow<Unit> = streamDeleteClient
//
//    // Для AddToMyEvents
//    fun loadAddToMyEvents(eventId: String) {
//        streamAddToMyEvents.tryEmit(eventId)
//    }
//    fun observeAddToMyEvents(): Flow<String> = streamAddToMyEvents
//
//    // Для RemoveFromMyEvents
//    fun loadRemoveFromMyEvents(eventId: String) {
//        streamRemoveFromMyEvents.tryEmit(eventId)
//    }
//    fun observeRemoveFromMyEvents(): Flow<String> = streamRemoveFromMyEvents
//
//    // Для AddToMyCommunities
//    fun loadAddToMyCommunities(eventId: String) {
//        streamAddToMyCommunities.tryEmit(eventId)
//    }
//    fun observeAddToMyCommunities(): Flow<String> = streamAddToMyCommunities
//
//    // Для RemoveFromMyCommunities
//    fun loadRemoveFromMyCommunities(eventId: String) {
//        streamRemoveFromCommunities.tryEmit(eventId)
//    }
//    fun observeRemoveFromMyCommunities(): Flow<String> = streamRemoveFromCommunities
//
//    // Для AddToMyChosenTags
//    fun loadAddToMyChosenTags(eventId: String) {
//        streamAddToMyChosenTags.tryEmit(eventId)
//    }
//    fun observeAddToMyChosenTags(): Flow<String> = streamAddToMyChosenTags
//
//    // Для RemoveFromMyChosenTags
//    fun loadRemoveFromMyChosenTags(eventId: String) {
//        streamRemoveFromMyChosenTags.tryEmit(eventId)
//    }
//    fun observeRemoveFromMyChosenTags(): Flow<String> = streamRemoveFromMyChosenTags
//
//    // Для SaveClientChanges
//    fun loadSaveClientSettings(
//        nameSurname: String,
//        city: String,
//        description: String,
//        listOfClientSocialMedia: List<SocialMediaModelDomain>,
//        isShowMyCommunities: Boolean,
//        showMyEventsChecked: Boolean,
//        applyNotificationsChecked: Boolean,
//    ) {
//        streamSaveClientSettings.tryEmit(eventId)
//    }
//    fun observeSaveClientSettings(): Flow<String> = streamSaveClientSettings
//}
