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
import com.example.ui_v1.models.UIv1CommunityDetailModelUI
import com.example.ui_v1.models.UIv1CommunityModelUI
import com.example.ui_v1.models.UIv1CountryModelUI
import com.example.ui_v1.models.UIv1EventDetailModelUI
import com.example.ui_v1.models.UIv1EventModelUI
import com.example.ui_v1.models.UIv1PhoneNumberModelUI
import com.example.ui_v1.models.UIv1RegisteredPersonModelUI
import com.example.ui_v1.models.UIv1UserModelUI

internal interface UIv1IMapperDomainUI {
    fun toCommunityModelUI(uiv1Community: Uiv1Community): UIv1CommunityModelUI
    fun toCommunityDetailModelUI(uiv1CommunityDetail: Uiv1CommunityDetail): UIv1CommunityDetailModelUI
    fun toCountryModelUI(uiv1Country: Uiv1Country): UIv1CountryModelUI
    fun toEventModelUI(uiv1Event: Uiv1Event): UIv1EventModelUI
    fun toEventDetailModelUI(uiv1EventDetail: Uiv1EventDetail): UIv1EventDetailModelUI
    fun toRegisteredPersonModelUI(uiv1RegisteredPerson: Uiv1RegisteredPerson): UIv1RegisteredPersonModelUI
    fun toRegisteredPerson(uiv1RegisteredPersonModelUI: UIv1RegisteredPersonModelUI): Uiv1RegisteredPerson
    fun toPhoneNumberModelUI(uiv1PhoneNumber: Uiv1PhoneNumber): UIv1PhoneNumberModelUI
    fun toUserModelUI(uiv1User: Uiv1User): UIv1UserModelUI
}

internal class UIv1MapperDomainUI : UIv1IMapperDomainUI {

    override fun toCommunityModelUI(uiv1Community: Uiv1Community): UIv1CommunityModelUI =
        UIv1CommunityModelUI(
            id = uiv1Community.id,
            name = uiv1Community.name,
            size = uiv1Community.size,
            iconURL = uiv1Community.iconURL,
        )

    override fun toCommunityDetailModelUI(uiv1CommunityDetail: Uiv1CommunityDetail): UIv1CommunityDetailModelUI =
        UIv1CommunityDetailModelUI(
            id = uiv1CommunityDetail.id,
            name = uiv1CommunityDetail.name,
            description = uiv1CommunityDetail.description,
            events = uiv1CommunityDetail.uiv1Events.map { toEventModelUI(it) },
        )

    override fun toCountryModelUI(uiv1Country: Uiv1Country): UIv1CountryModelUI =
        UIv1CountryModelUI(
            country = uiv1Country.country,
            code = uiv1Country.code,
            flag = uiv1Country.flag,
        )

    override fun toEventModelUI(uiv1Event: Uiv1Event): UIv1EventModelUI =
        UIv1EventModelUI(
            id = uiv1Event.id,
            name = uiv1Event.name,
            date = uiv1Event.date,
            city = uiv1Event.city,
            category = uiv1Event.category,
            iconURL = uiv1Event.iconURL,
            isFinished = uiv1Event.isFinished
        )

    override fun toEventDetailModelUI(uiv1EventDetail: Uiv1EventDetail): UIv1EventDetailModelUI =
        UIv1EventDetailModelUI(
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

    override fun toRegisteredPersonModelUI(uiv1RegisteredPerson: Uiv1RegisteredPerson): UIv1RegisteredPersonModelUI =
        UIv1RegisteredPersonModelUI(
            id = uiv1RegisteredPerson.id,
            iconURL = uiv1RegisteredPerson.iconURL,
        )

    override fun toRegisteredPerson(uiv1RegisteredPersonModelUI: UIv1RegisteredPersonModelUI): Uiv1RegisteredPerson =
        Uiv1RegisteredPerson(
            id = uiv1RegisteredPersonModelUI.id,
            iconURL = uiv1RegisteredPersonModelUI.iconURL,
        )

    override fun toPhoneNumberModelUI(uiv1PhoneNumber: Uiv1PhoneNumber): UIv1PhoneNumberModelUI =
        UIv1PhoneNumberModelUI(
            countryCode = uiv1PhoneNumber.countryCode,
            number = uiv1PhoneNumber.number,
        )

    override fun toUserModelUI(uiv1User: Uiv1User): UIv1UserModelUI =
        UIv1UserModelUI(
            id = uiv1User.id,
            name = uiv1User.name,
            surname = uiv1User.surname,
            uiv1PhoneNumberModelUI = toPhoneNumberModelUI(uiv1User.uiv1PhoneNumber),
            iconURL = uiv1User.iconURL
        )
}