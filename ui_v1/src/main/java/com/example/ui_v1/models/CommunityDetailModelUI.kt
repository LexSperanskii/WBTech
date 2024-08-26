package com.example.ui_v1.models

internal class CommunityDetailModelUI(
    val id : Int = 0,
    val name : String = "",
    val description : String = "",
    val events: List<EventModelUI> = listOf()
)