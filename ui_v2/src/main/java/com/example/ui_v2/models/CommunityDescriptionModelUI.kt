package com.example.ui_v2.models

internal data class CommunityDescriptionModelUI(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val imageURL: String = "",
    val listOfTags: List<String> = listOf(),
    val listOfParticipants: List<UserModelUI> = listOf(),
    val listOfEvents: List<EventModelUI> = listOf(),
    val listOfPastEvents: List<EventModelUI> = listOf(),
)