package com.example.spa_wb_junior_devmeetingapp.models

internal class CommunityDetailModelUI(
    val id : Int = 0,
    val name : String = "",
    val description : String = "",
    val events: List<EventModelUI> = listOf()
)