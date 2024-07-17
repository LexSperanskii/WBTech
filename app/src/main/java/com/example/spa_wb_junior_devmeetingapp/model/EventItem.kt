package com.example.spa_wb_junior_devmeetingapp.model

import org.threeten.bp.LocalDate

enum class EventStatus(val status: String) {
    NONE(""),
    FINISHED("Завершилась")
}

data class EventItem(
    val eventName : String = "",
    val eventStatus : EventStatus = EventStatus.NONE,
    val eventDate : LocalDate = LocalDate.of(1703,1,1),
    val eventPlace : String = "",
    val eventCategory : List<String> = listOf(),
    val eventIconURL : String = "",
    val eventIsScheduled : Boolean = false,
    val communityId : Int = 0
)