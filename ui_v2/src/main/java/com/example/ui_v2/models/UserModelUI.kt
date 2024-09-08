package com.example.ui_v2.models

internal data class UserModelUI(
    val id: String = "",
    val name: String = "",
    val surname: String = "",
    val city: String = "",
    val listOfTags: List<String> = listOf(),
    val description: String = "",
    val imageURL: String? = "",
    val listOfSocialMediaImageURL: List<String?> = listOf(),
    val userEventsList: List<EventModelUI> = listOf(),
    val userCommunitiesList: List<CommunityModelUI> = listOf(),
)

internal data class ClientModelUI(
    val name: String = "",
    val surname: String = "",
    val countryCode: String = "",
    val number: String = "",
)