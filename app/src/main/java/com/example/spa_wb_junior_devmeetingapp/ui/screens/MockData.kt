package com.example.spa_wb_junior_devmeetingapp.ui.screens

enum class EventStatus(val status: String) {
    NONE(""),
    FINISHED("Завершилась")
}

data class MockEvent(
    val eventName : String = "",
    val eventStatus : EventStatus = EventStatus.NONE,
    val eventDate : String = "",
    val eventPlace : String = "",
    val eventCategory : List<String> = listOf(),
    val eventIconURL : String = "",
)
data class MockCommunity(
    val communityName : String = "",
    val communitySize : Int = 0,
    val communityIconURL : String = ""
)

const val eventIconURL = "https://i.pinimg.com/564x/9c/b1/64/9cb164c7777bcc08bda333504b6210bf.jpg"
val mockListOfEvents = listOf(
    MockEvent(
        eventName = "Имя события",
        eventStatus = EventStatus.NONE,
        eventDate = "13.09.2024",
        eventPlace = "Петрозаводск",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    MockEvent(
        eventName = "Имя события",
        eventStatus = EventStatus.FINISHED,
        eventDate = "14.09.2024",
        eventPlace = "Майкоп",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    MockEvent(
        eventName = "Имя события",
        eventStatus = EventStatus.NONE,
        eventDate = "15.09.2024",
        eventPlace = "Владивосток",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    MockEvent(
        eventName = "Имя события",
        eventStatus = EventStatus.FINISHED,
        eventDate = "16.09.2024",
        eventPlace = "Краснодар",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    MockEvent(
        eventName = "Имя события",
        eventStatus = EventStatus.FINISHED,
        eventDate = "17.09.2024",
        eventPlace = "Рязань",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    MockEvent(
        eventName = "Имя события",
        eventStatus = EventStatus.NONE,
        eventDate = "18.09.2024",
        eventPlace = "Сочи",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    MockEvent(
        eventName = "Имя события",
        eventStatus = EventStatus.FINISHED,
        eventDate = "19.09.2024",
        eventPlace = "Санкт-Петербург",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    MockEvent(
        eventName = "Имя события",
        eventStatus = EventStatus.NONE,
        eventDate = "20.09.2024",
        eventPlace = "Москва",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    ),
    MockEvent(
        eventName = "Имя события",
        eventStatus = EventStatus.FINISHED,
        eventDate = "21.09.2024",
        eventPlace = "Казань",
        eventCategory = listOf("Python", "Junior", "Moscow"),
        eventIconURL = eventIconURL
    )
)

const val communityIconURL = "https://i.pinimg.com/564x/dc/c4/ef/dcc4ef15c657260d1d13331daf3a13c8.jpg"
val mockListOfCommunities = listOf(
    MockCommunity(
        communityName = "Имя сообщества",
        communitySize = 1,
        communityIconURL = communityIconURL
    ),
    MockCommunity(
        communityName = "Имя сообщества",
        communitySize = 5,
        communityIconURL = communityIconURL
    ),
    MockCommunity(
        communityName = "Имя сообщества",
        communitySize = 50,
        communityIconURL = communityIconURL
    ),
    MockCommunity(
        communityName = "Имя сообщества",
        communitySize = 150,
        communityIconURL = communityIconURL
    ),
    MockCommunity(
        communityName = "Имя сообщества",
        communitySize = 1500,
        communityIconURL = communityIconURL
    ),
    MockCommunity(
        communityName = "Имя сообщества",
        communitySize = 7000,
        communityIconURL = communityIconURL
    ),
    MockCommunity(
        communityName = "Имя сообщества",
        communitySize = 15000,
        communityIconURL = communityIconURL
    ),
    MockCommunity(
        communityName = "Имя сообщества",
        communitySize = 150000,
        communityIconURL = communityIconURL
    ),
    MockCommunity(
        communityName = "Имя сообщества",
        communitySize = 1000000,
        communityIconURL = communityIconURL
    ),
    MockCommunity(
        communityName = "Имя сообщества",
        communitySize = 10000000,
        communityIconURL = communityIconURL
    )
)