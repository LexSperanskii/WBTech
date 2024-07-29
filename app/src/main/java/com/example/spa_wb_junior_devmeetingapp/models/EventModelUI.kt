package com.example.spa_wb_junior_devmeetingapp.models

internal data class EventModelUI(
    val id: Int = 0,
    val name: String = "",
    val date: String = "",
    val city: String = "",
    val category: List<String> = listOf(),
    val iconURL: String = "",
    val isFinished: Boolean = false
)