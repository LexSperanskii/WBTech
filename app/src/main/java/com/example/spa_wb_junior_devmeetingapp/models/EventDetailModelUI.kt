package com.example.spa_wb_junior_devmeetingapp.models

data class EventDetailModelUI(
    val id : Int = 0,
    val name : String = "",
    val date : String = "",
    val address : String = "",
    val category : List<String> = listOf(),
    val locationCoordinates: String = "",
    val description : String = "",
    val listOfParticipants: List<RegisteredPersonModelUI> = listOf(),
    val isFinished: Boolean = false,
    val isUserInParticipants: Boolean = false,
)

data class RegisteredPersonModelUI(
    val id: Int = 0,
    val iconURL : String = ""
)