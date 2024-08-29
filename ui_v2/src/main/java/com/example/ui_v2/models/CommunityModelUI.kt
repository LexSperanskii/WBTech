package com.example.ui_v2.models

internal data class CommunityModelUI(
    val id: String = "",
    val name: String = "",
    val imageURL: String = "",
)

internal data class PersonalCommunitiesModelUI(
    val id: String = "",
    val nameOfBlock: String = "",
    val listOfCommunities: List<CommunityModelUI> = listOf(),
)