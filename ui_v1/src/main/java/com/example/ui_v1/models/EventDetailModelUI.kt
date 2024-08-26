package com.example.ui_v1.models

internal data class EventDetailModelUI(
    val id : Int = 0,
    val name : String = "",
    val date : String = "",
    val address : String = "",
    val category : List<String> = listOf(),
    val locationCoordinates: String = "",
    val description : String = "",
    val listOfParticipants: List<RegisteredPersonModelUI> = listOf(),
    val isFinished: Boolean = false,
)

internal data class RegisteredPersonModelUI(
    val id: Int = 0,
    val iconURL : String? = ""
)