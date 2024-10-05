package com.example.domain.models

data class UserModelDomain(
    val id: String = "",
    val nameSurname: String = "",
    val city: String = "",
    val listOfTags: List<String> = listOf(),
    val description: String = "",
    val imageURL: String? = "",
    val listOfSocialMedia: List<SocialMediaModelDomain> = listOf(),
    val userEventsList: List<EventModelDomain> = listOf(),
    val userCommunitiesList: List<CommunityModelDomain> = listOf(),
)

data class ClientModelDomain(
    val id: String = "",
    val imageURL: String? = "",
    val nameSurname: String = "",
    val phoneNumber: PhoneNumberModelDomain = PhoneNumberModelDomain(),
    val city: String = "",
    val description: String = "",
    val listOfClientTags: List<String> = listOf(),
    val listOfClientSocialMedia: List<SocialMediaModelDomain> = listOf(),
    val clientEventsList: List<EventModelDomain> = listOf(),
    val clientCommunitiesList: List<CommunityModelDomain> = listOf(),
    val isShowMyCommunities: Boolean = true,
    val isShowMyEvents: Boolean = true,
    val isApplyNotifications: Boolean = true,
)

data class SocialMediaModelDomain(
    val socialMediaId: String = "",
    val socialMediaName: String = "",
    val userNickname: String = "",
)