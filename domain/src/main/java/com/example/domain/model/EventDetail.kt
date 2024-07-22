package com.example.domain.model

import javax.management.Descriptor

data class EventDetail(
    val id : Int,
    val name : String,
    val date : String,
    val address : EventAddress,
    val category : List<String>,
    val mapCoordinates: String,
    val description : String,
    val listOfParticipants: List<RegisteredPerson>,
    val isFinished: Boolean = false,
    val isUserInParticipants: Boolean = false,
)

data class EventAddress(
    val city: String,
    val street: String,
    val building: String
)

data class RegisteredPerson(
    val id: Int,
    val iconURL : String
)