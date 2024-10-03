package com.example.domain.models


data class ClientCashModelDomain(
    val imageURL: String? = "",
    val nameSurname: String = "",
    val phoneNumber: PhoneNumberModelDomain = PhoneNumberModelDomain(),
    val city: String = "",
    val description: String = "",
    val listOfClientTags: List<String> = listOf(),
    val listOfClientSocialMedia: List<SocialMediaModelDomain> = listOf(),
    val isShowMyCommunities: Boolean = true,
    val showMyEventsChecked: Boolean = true,
    val applyNotificationsChecked: Boolean = true,
)