package com.example.domain.models


data class EventDescriptionModelDomain(
    val id: String = "",
    val name: String = "",
    val time: String = "",
    val day: Int = 0,
    val month: String = "",
    val year: Int = 0,
    val city: String = "",
    val street: String = "",
    val building: String = "",
    val imageURL: String = "",
    val listOfTags: List<String> = listOf(),
    val description: String = "",
    val pitcher: UserModelDomain = UserModelDomain(),
    val location: EventLocationModelDomain = EventLocationModelDomain(),
    val metroStation: MetroModelDomain = MetroModelDomain(),
    val listOfParticipants: List<UserModelDomain> = listOf(),
    val organizer: CommunityModelDomain = CommunityModelDomain(),
    val availableCapacity: Int = 0,
)