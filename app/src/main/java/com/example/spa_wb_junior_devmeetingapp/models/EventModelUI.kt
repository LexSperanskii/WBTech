package com.example.spa_wb_junior_devmeetingapp.models

internal data class EventModelUI(
    val id: Int = 0,
    val name: String = "",
    val date: String = "",
    val city: String = "",
    val category: List<String> = listOf(),
    val iconURL: String = "",
    val isFinished: Boolean = false,
)

internal data class NewEventModelUI(
    val id: Int = 0,
    val name: String = "",
    val day: Int = 0,
    val month: String = "",
    val year: Int = 0,
    val city: String = "",
    val street: String = "",
    val building: String = "",
    val imageURL: String = "",
    val listOfTags: List<String> = listOf(),
)