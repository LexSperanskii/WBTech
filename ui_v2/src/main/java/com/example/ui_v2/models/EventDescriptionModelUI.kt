package com.example.ui_v2.models


internal data class EventDescriptionModelUI(
    val id: String = "",
    val name: String = "",
    val day: Int = 0,
    val month: String = "",
    val year: Int = 0,
    val city: String = "",
    val street: String = "",
    val building: String = "",
    val imageURL: String = "",
    val listOfTags: List<String> = listOf(),
    val description: String = "",
    val pitcher: UserModelUI = UserModelUI(),
    val location: EventLocationModelUI = EventLocationModelUI(),
    val metroStation: MetroModelUI = MetroModelUI(),
    val listOfParticipants: List<UserModelUI> = listOf(),
    val organizer: CommunityModelUI = CommunityModelUI(),
    val availableCapacity: Int = 0,
)