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
    private const val DEFAULT_ID_0 = 0
    private const val DEFAULT_ID_1 = 1
    private const val DEFAULT_ID_2 = 2
    private const val DEFAULT_NAME_ONE = "Name ONE"
    private const val DEFAULT_NAME_TWO = "Name TWO"
    private const val DEFAULT_NAME_THREE = "Name THREE"
    private const val DEFAULT_SIZE_1 = 1
    private const val DEFAULT_SIZE_2000 = 2000
    private const val DEFAULT_SIZE_10000 = 10000
    private const val DEFAULT_URL = "https://i.pinimg.com/564x/dc/c4/ef/dcc4ef15c657260d1d13331daf3a13c8.jpg"
    private const val DEFAULT_DESCRIPTION = "Jdfskdf SDGF'ASDG SDF KLSDMF'df ,, asdfa. ADSF,af, AEFaef"
    private const val DEFAULT_CITY = "Moscow"
    private const val DEFAULT_ADDRESS = "ул. Громова"
    private const val DEFAULT_BUILDING = "4"
    private const val DEFAULT_LOCATION_COORDINATE = "59.845381, 50.238776"
    private const val DEFAULT_DATE = "01.01.2007"
    private const val DEFAULT_TAG = "Kotlin"
    private const val DEFAULT_COUNTRY_CODE = "+7"
    private const val DEFAULT_PHONE_NUMBER = "1234567890"

    const val userAvatarURL = DEFAULT_URL

    val communitiesList = listOf(
        Community(DEFAULT_ID_0, DEFAULT_NAME_ONE, DEFAULT_SIZE_1, DEFAULT_URL),
        Community(DEFAULT_ID_1, DEFAULT_NAME_TWO, DEFAULT_SIZE_2000, DEFAULT_URL),
        Community(DEFAULT_ID_2, DEFAULT_NAME_THREE, DEFAULT_SIZE_10000, DEFAULT_URL)
    )
    val communityDetail = CommunityDetail(
        id = 0,
        name = DEFAULT_NAME_ONE,
        description = DEFAULT_DESCRIPTION,
        events = listOf(
            Event(0, DEFAULT_NAME_ONE, DEFAULT_DATE, DEFAULT_CITY, listOf(DEFAULT_TAG, DEFAULT_TAG), DEFAULT_URL, true),
            Event(0, DEFAULT_NAME_TWO, DEFAULT_DATE, DEFAULT_CITY, listOf(DEFAULT_TAG), DEFAULT_URL, false)
        )
    )
    val countiesList = listOf(
        Country("Rus", "+7", DEFAULT_URL),
        Country("Kz", "+7", DEFAULT_URL),
        Country("Gb", "+44", DEFAULT_URL),
    )
    val eventsList = listOf(
        Event(
            id = DEFAULT_ID_0,
            name = DEFAULT_NAME_ONE,
            date = DEFAULT_DATE,
            city = DEFAULT_CITY,
            category = listOf(DEFAULT_TAG,DEFAULT_TAG),
            iconURL = DEFAULT_URL,
            isFinished = true
        ),
        Event(
            id = DEFAULT_ID_1,
            name = DEFAULT_NAME_TWO,
            date = DEFAULT_DATE,
            city = DEFAULT_CITY,
            category = listOf(DEFAULT_TAG),
            iconURL = DEFAULT_URL,
            isFinished = false
        ),
    )
    val eventDetail = EventDetail(
        id = DEFAULT_ID_0,
        name = DEFAULT_NAME_ONE,
        date = DEFAULT_DATE,
        address = EventAddress(DEFAULT_CITY, DEFAULT_ADDRESS, DEFAULT_BUILDING),
        category = listOf(DEFAULT_TAG,DEFAULT_TAG,DEFAULT_TAG),
        locationCoordinates = DEFAULT_LOCATION_COORDINATE,
        description = DEFAULT_DESCRIPTION,
        listOfParticipants = listOf(
            RegisteredPerson(DEFAULT_ID_0, null),
            RegisteredPerson(DEFAULT_ID_1, DEFAULT_URL)
        ),
        isFinished = false,
    )
    val phoneNumber = PhoneNumber(DEFAULT_COUNTRY_CODE, DEFAULT_PHONE_NUMBER)

    val user = User(
        id = DEFAULT_ID_0,
        name = DEFAULT_NAME_ONE,
        surname = DEFAULT_NAME_TWO,
        phoneNumber = PhoneNumber(DEFAULT_COUNTRY_CODE, DEFAULT_PHONE_NUMBER),
        iconURL = null
    )
}