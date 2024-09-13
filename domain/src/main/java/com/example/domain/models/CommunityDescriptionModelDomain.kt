package com.example.domain.models

data class CommunityDescriptionModelDomain(
    val id: String = "",
    val name: String = "",
    val description: String = "",
    val imageURL: String = "",
    val listOfTags: List<String> = listOf(),
    val listOfParticipants: List<UserModelDomain> = listOf(),
    val listOfEvents: List<EventModelDomain> = listOf(),
    val listOfPastEvents: List<EventModelDomain> = listOf(),
)