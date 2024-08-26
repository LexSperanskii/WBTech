package com.example.ui_v2.models

internal data class EventModelUI(
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