package com.example.ui_v2.models

internal data class ClientCashModelUI(
    val imageURL: String? = "",
    val nameSurname: String = "",
    val phoneNumber: PhoneNumberModelUI = PhoneNumberModelUI(),
    val city: String = "",
    val description: String = "",
    val listOfClientTags: List<String> = listOf(),
    val listOfClientSocialMedia: List<SocialMediaModelUI> = listOf(),
    val isShowMyCommunities: Boolean = true,
    val isShowMyEvents: Boolean = true,
    val isApplyNotifications: Boolean = true,
)