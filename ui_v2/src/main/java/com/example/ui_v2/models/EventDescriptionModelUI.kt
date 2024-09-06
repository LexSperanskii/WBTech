package com.example.ui_v2.models


internal data class EventDescriptionModelUI(
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
    val pitcher: UserModelUI = UserModelUI(),
    val location: EventLocationModelUI = EventLocationModelUI(),
    val metroStation: MetroModelUI = MetroModelUI(),
    val listOfParticipants: List<UserModelUI> = listOf(),
    val organizer: CommunityModelUI = CommunityModelUI(),
    val availableCapacity: Int = 0,
)

internal fun EventDescriptionModelUI.toEventModelUI(): EventModelUI =
    EventModelUI(
        id = this.id,
        name = this.name,
        time = this.time,
        day = this.day,
        month = this.month,
        year = this.year,
        city = this.city,
        street = this.street,
        building = this.building,
        imageURL = this.imageURL,
        listOfTags = this.listOfTags
    )