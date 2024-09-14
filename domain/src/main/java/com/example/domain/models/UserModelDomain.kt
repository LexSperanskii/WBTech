package com.example.domain.models

data class UserModelDomain(
    val id: String = "",
    val nameSurname: String = "",
    val city: String = "",
    val listOfTags: List<String> = listOf(),
    val description: String = "",
    val imageURL: String? = "",
    val listOfSocialMediaImageURL: List<SocialMediaModelDomain> = listOf(),
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
    val listOfTags: List<String> = listOf(),
    val listOfSocialMedia: List<SocialMediaModelDomain> = listOf(),
    val userEventsList: List<EventModelDomain> = listOf(),
    val userCommunitiesList: List<CommunityModelDomain> = listOf(),
    val isShowMyCommunities: Boolean = true,
    val showMyEventsChecked: Boolean = true,
)

data class SocialMediaModelDomain(
    val socialMediaId: String = "",
    val socialMediaName: String = "",
    val userNickname: String = "",
)