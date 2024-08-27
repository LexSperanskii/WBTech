package com.example.ui_v1.models.mapper

import com.example.domain.models.Uiv1Community
import com.example.domain.models.Uiv1CommunityDetail
import com.example.domain.models.Uiv1Country
import com.example.domain.models.Uiv1Event
import com.example.domain.models.Uiv1EventDetail
import com.example.domain.models.Uiv1PhoneNumber
import com.example.domain.models.Uiv1RegisteredPerson
import com.example.domain.models.Uiv1User
import com.example.domain.models.toAddressString
import com.example.ui_v1.models.CommunityDetailModelUI
import com.example.ui_v1.models.CommunityModelUI
import com.example.ui_v1.models.CountryModelUI
import com.example.ui_v1.models.EventDetailModelUI
import com.example.ui_v1.models.EventModelUI
import com.example.ui_v1.models.PhoneNumberModelUI
import com.example.ui_v1.models.RegisteredPersonModelUI
import com.example.ui_v1.models.UserModelUI

internal interface IMapperDomainUI{
    fun toCommunityModelUI(uiv1Community: Uiv1Community): CommunityModelUI
    fun toCommunityDetailModelUI(uiv1CommunityDetail: Uiv1CommunityDetail): CommunityDetailModelUI
    fun toCountryModelUI(uiv1Country: Uiv1Country): CountryModelUI
    fun toEventModelUI(uiv1Event: Uiv1Event): EventModelUI
    fun toEventDetailModelUI(uiv1EventDetail: Uiv1EventDetail): EventDetailModelUI
    fun toRegisteredPersonModelUI(uiv1RegisteredPerson: Uiv1RegisteredPerson): RegisteredPersonModelUI
    fun toRegisteredPerson(registeredPersonModelUI: RegisteredPersonModelUI): Uiv1RegisteredPerson
    fun toPhoneNumberModelUI(uiv1PhoneNumber: Uiv1PhoneNumber): PhoneNumberModelUI
    fun toUserModelUI(uiv1User: Uiv1User): UserModelUI
}

internal class MapperDomainUI : IMapperDomainUI{

    override fun toCommunityModelUI(uiv1Community: Uiv1Community): CommunityModelUI =
        CommunityModelUI(
            id = uiv1Community.id,
            name = uiv1Community.name,
            size = uiv1Community.size,
            iconURL = uiv1Community.iconURL,
        )

    override fun toCommunityDetailModelUI(uiv1CommunityDetail: Uiv1CommunityDetail): CommunityDetailModelUI =
        CommunityDetailModelUI(
            id = uiv1CommunityDetail.id,
            name = uiv1CommunityDetail.name,
            description = uiv1CommunityDetail.description,
            events = uiv1CommunityDetail.uiv1Events.map { toEventModelUI(it) },
        )

    override fun toCountryModelUI(uiv1Country: Uiv1Country): CountryModelUI =
        CountryModelUI(
            country = uiv1Country.country,
            code = uiv1Country.code,
            flag = uiv1Country.flag,
        )

    override fun toEventModelUI(uiv1Event: Uiv1Event): EventModelUI =
        EventModelUI(
            id = uiv1Event.id,
            name = uiv1Event.name,
            date = uiv1Event.date,
            city = uiv1Event.city,
            category = uiv1Event.category,
            iconURL = uiv1Event.iconURL,
            isFinished = uiv1Event.isFinished
        )

    override fun toEventDetailModelUI(uiv1EventDetail: Uiv1EventDetail): EventDetailModelUI =
        EventDetailModelUI(
            id = uiv1EventDetail.id,
            name = uiv1EventDetail.name,
            date = uiv1EventDetail.date,
            address = uiv1EventDetail.address.toAddressString(),
            category = uiv1EventDetail.category,
            locationCoordinates = uiv1EventDetail.locationCoordinates,
            description = uiv1EventDetail.description,
            listOfParticipants = uiv1EventDetail.listOfParticipants.map {
                toRegisteredPersonModelUI(
                    it
                )
            },
            isFinished = uiv1EventDetail.isFinished,
        )

    override fun toRegisteredPersonModelUI(uiv1RegisteredPerson: Uiv1RegisteredPerson): RegisteredPersonModelUI =
        RegisteredPersonModelUI(
            id = uiv1RegisteredPerson.id,
            iconURL = uiv1RegisteredPerson.iconURL,
        )

    override fun toRegisteredPerson(registeredPersonModelUI: RegisteredPersonModelUI): Uiv1RegisteredPerson =
        Uiv1RegisteredPerson(
            id = registeredPersonModelUI.id,
            iconURL = registeredPersonModelUI.iconURL,
        )

    override fun toPhoneNumberModelUI(uiv1PhoneNumber: Uiv1PhoneNumber): PhoneNumberModelUI =
        PhoneNumberModelUI(
            countryCode = uiv1PhoneNumber.countryCode,
            number = uiv1PhoneNumber.number,
        )

    override fun toUserModelUI(uiv1User: Uiv1User): UserModelUI =
        UserModelUI(
            id = uiv1User.id,
            name = uiv1User.name,
            surname = uiv1User.surname,
            phoneNumberModelUI = toPhoneNumberModelUI(uiv1User.uiv1PhoneNumber),
            iconURL = uiv1User.iconURL
        )
}