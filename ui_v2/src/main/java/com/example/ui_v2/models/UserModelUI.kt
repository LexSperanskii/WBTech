package com.example.ui_v2.models

internal data class UserModelUI(
    val id: String = "",
    val nameSurname: String = "",
    val city: String = "",
    val listOfTags: List<String> = listOf(),
    val description: String = "",
    val imageURL: String? = "",
    val listOfSocialMediaImageURL: List<SocialMediaModelUI> = listOf(),
    val userEventsList: List<EventModelUI> = listOf(),
    val userCommunitiesList: List<CommunityModelUI> = listOf(),
)

internal data class ClientModelUI(
    val id: String = "",
    val imageURL: String? = "",
    val nameSurname: String = "",
    val phoneNumber: PhoneNumberModelUI = PhoneNumberModelUI(),
    val city: String = "",
    val description: String = "",
    val listOfTags: List<String> = listOf(),
    val listOfSocialMedia: List<SocialMediaModelUI> = listOf(),
    val userEventsList: List<EventModelUI> = listOf(),
    val userCommunitiesList: List<CommunityModelUI> = listOf(),
    val isShowMyCommunities: Boolean = true,
    val showMyEventsChecked: Boolean = true,
)

internal data class SocialMediaModelUI(
    val socialMediaId: String = "",
    val socialMediaIconURL: String? = "",
    val socialMediaName: String = "",
    val userNickname: String = "",
)