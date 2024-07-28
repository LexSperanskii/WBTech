package com.example.domain.stabRepositories

import com.example.domain.models.Community
import com.example.domain.models.CommunityDetail
import com.example.domain.models.Country
import com.example.domain.models.Event
import com.example.domain.models.EventAddress
import com.example.domain.models.EventDetail
import com.example.domain.models.PhoneNumber
import com.example.domain.models.RegisteredPerson
import com.example.domain.models.User

object StubData {
    val communitiesList = listOf(
        Community(0, "AAA", 1, ""),
        Community(1, "BBB", 200, ""),
        Community(2, "CCC", 3000, "")
    )
    val communityDetail = CommunityDetail(
        id = 0,
        name = "test",
        description = "hello",
        events = listOf(
            Event(0, "event1", "01.01.2007", "Mockow", listOf("ggg", "hhh"), "", true),
            Event(0, "event2", "02.01.2007", "Spb", listOf("fff", "jjj"), "", false)
        )
    )
    val countiesList = listOf(
        Country("Russia", "+7", "ggsfgsfg"),
        Country("Kz", "+7", "sgsgsdfg"),
        Country("Gb", "+44", "sdgsdfgsdg")
    )
    val eventsList = listOf(
        Event(
            id = 0,
            name = "Встреча разработчиков",
            date = "05.12.2024",
            city = "Санкт-Петербург",
            category = listOf("Python", "Junior", "Moscow"),
            iconURL = "fsdfsdf",
            isFinished = true
        ),
        Event(
            id = 1,
            name = "Встреча разработчиков",
            date = "05.12.2024",
            city = "Санкт-Петербург",
            category = listOf("Python", "Junior", "Moscow"),
            iconURL = "fsdfsdfsfd",
            isFinished = false
        ),
    )
    val eventDetail = EventDetail(
        id = 0,
        name = "Встреча разработчиков Kotlon",
        date = "13.09.2024",
        address = EventAddress("Москва", "ул. Громова", "4"),
        category = listOf("Python", "Junior", "Moscow"),
        locationCoordinates = "115.22455 , 5554.15651",
        description = "sdfsdfsdfsdfsddddddd",
        listOfParticipants = listOf(
            RegisteredPerson(0, null),
            RegisteredPerson(1, "dfsdfsdf")
        ),
        isFinished = false,
    )
    val phoneNumber = PhoneNumber("+7", "0000000000")
    val userAvatarURL = "sdfsdfsdfsdfsdfsdf"
    val user = User(
        id = 0,
        name = "GGG",
        surname = "HHH",
        phoneNumber = PhoneNumber("+7", "0000000000"),
        iconURL = null
    )
}