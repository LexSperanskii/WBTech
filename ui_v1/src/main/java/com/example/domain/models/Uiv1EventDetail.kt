package com.example.domain.models

internal data class Uiv1EventDetail(
    val id: Int,
    val name: String,
    val date: String,
    val address: Uiv1EventAddress,
    val category: List<String>,
    val locationCoordinates: String,
    val description: String,
    val listOfParticipants: List<Uiv1RegisteredPerson>,
    val isFinished: Boolean = false,
)

internal data class Uiv1EventAddress(
    val city: String,
    val street: String,
    val building: String,
)

internal fun Uiv1EventAddress.toAddressString(): String {
    return "$city, $street, $building"
}

internal data class Uiv1RegisteredPerson(
    val id: Int,
    val iconURL: String?,
)