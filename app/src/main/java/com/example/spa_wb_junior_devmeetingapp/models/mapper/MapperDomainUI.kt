package com.example.spa_wb_junior_devmeetingapp.models.mapper

import com.example.domain.models.Community
import com.example.domain.models.CommunityDetail
import com.example.domain.models.Country
import com.example.domain.models.Event
import com.example.domain.models.EventDetail
import com.example.domain.models.PhoneNumber
import com.example.domain.models.RegisteredPerson
import com.example.domain.models.User
import com.example.domain.models.toAddressString
import com.example.spa_wb_junior_devmeetingapp.models.CommunityDetailModelUI
import com.example.spa_wb_junior_devmeetingapp.models.CommunityModelUI
import com.example.spa_wb_junior_devmeetingapp.models.CountryModelUI
import com.example.spa_wb_junior_devmeetingapp.models.EventDetailModelUI
import com.example.spa_wb_junior_devmeetingapp.models.EventModelUI
import com.example.spa_wb_junior_devmeetingapp.models.PhoneNumberModelUI
import com.example.spa_wb_junior_devmeetingapp.models.RegisteredPersonModelUI
import com.example.spa_wb_junior_devmeetingapp.models.UserModelUI


internal fun Community.toCommunityModelUI(): CommunityModelUI =
    CommunityModelUI(
        id = this.id,
        name = this.name,
        size = this.size,
        iconURL = this.iconURL,
    )

internal fun CommunityDetail.toCommunityDetailModelUI(): CommunityDetailModelUI =
    CommunityDetailModelUI(
        id = this.id,
        name = this.name,
        description = this.description,
        events = this.events.map { it.toEventModelUI() },
    )

internal fun Country.toCountryModelUI(): CountryModelUI =
    CountryModelUI(
        country = this.country,
        code = this.code,
        flag = this.flag,
    )

internal fun Event.toEventModelUI(): EventModelUI =
    EventModelUI(
        id = this.id,
        name = this.name,
        date = this.date,
        city = this.city,
        category = this.category,
        iconURL = this.iconURL,
        isFinished = this.isFinished
    )

internal fun EventDetail.toEventDetailModelUI(): EventDetailModelUI =
    EventDetailModelUI(
        id = this.id,
        name = this.name,
        date = this.date,
        address = this.address.toAddressString(),
        category = this.category,
        locationCoordinates= this.locationCoordinates,
        description = this.description,
        listOfParticipants = this.listOfParticipants.map { it.toRegisteredPersonModelUI() },
        isFinished = this.isFinished,
    )

internal fun RegisteredPerson.toRegisteredPersonModelUI(): RegisteredPersonModelUI =
    RegisteredPersonModelUI(
        id = this.id,
        iconURL = this.iconURL,
    )
internal fun RegisteredPersonModelUI.toRegisteredPerson(): RegisteredPerson =
    RegisteredPerson(
        id = this.id,
        iconURL = this.iconURL,
    )

internal fun PhoneNumber.toPhoneNumberModelUI(): PhoneNumberModelUI =
    PhoneNumberModelUI(
        countryCode = this.countryCode,
        number = this.number,
    )

internal fun User.toUserModelUI(): UserModelUI =
    UserModelUI(
        id = this.id,
        name = this.name,
        surname = this.surname,
        phoneNumberModelUI = this.phoneNumber.toPhoneNumberModelUI(),
        iconURL = this.iconURL
    )