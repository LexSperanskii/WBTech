package com.example.spa_wb_junior_devmeetingapp.model

import com.example.spa_wb_junior_devmeetingapp.data.mockData.EventStatus

data class EventItem(
    val eventName : String = "",
    val eventStatus : EventStatus = EventStatus.NONE,
    val eventDate : String = "",
    val eventPlace : String = "",
    val eventCategory : List<String> = listOf(),
    val eventIconURL : String = "",
    val eventIsPlaned : Boolean = false,
)