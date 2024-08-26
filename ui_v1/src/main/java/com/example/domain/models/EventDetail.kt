package com.example.domain.models

data class EventDetail(
    val id: Int,
    val name: String,
    val date: String,
    val address: EventAddress,
    val category: List<String>,
    val locationCoordinates: String,
    val description: String,
    val listOfParticipants: List<RegisteredPerson>,
    val isFinished: Boolean = false,
)

data class EventAddress(
    val city: String,
    val street: String,
    val building: String,
)

fun EventAddress.toAddressString(): String {
    return "$city, $street, $building"
}

data class RegisteredPerson(
    val id: Int,
    val iconURL: String?,
)