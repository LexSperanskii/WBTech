package com.example.domain.models

data class EventModelDomain(
    val id: String = "",
    val name: String = "",
    val time: String = "",
    val day: Int = 0,
    val month: String = "",
    val year: Int = 0,
    val city: String = "",
    val street: String = "",
    val building: String = "",
    val imageURL: String = "",
    val listOfTags: List<String> = listOf(),
)

data class EventAdvertBlockModelDomain(
    val id: String = "",
    val nameOfBlock: String = "",
    val listOfEvents: List<EventModelDomain> = listOf(),
)