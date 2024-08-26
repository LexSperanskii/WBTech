package com.example.ui_v1.models.mapper

import com.example.domain.models.Community
import com.example.domain.models.CommunityDetail
import com.example.domain.models.Country
import com.example.domain.models.Event
import com.example.domain.models.EventDetail
import com.example.domain.models.PhoneNumber
import com.example.domain.models.RegisteredPerson
import com.example.domain.models.User
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
    fun toCommunityModelUI(community: Community): CommunityModelUI
    fun toCommunityDetailModelUI(communityDetail: CommunityDetail): CommunityDetailModelUI
    fun toCountryModelUI(country: Country): CountryModelUI
    fun toEventModelUI(event: Event): EventModelUI
    fun toEventDetailModelUI(eventDetail: EventDetail): EventDetailModelUI
    fun toRegisteredPersonModelUI(registeredPerson: RegisteredPerson): RegisteredPersonModelUI
    fun toRegisteredPerson(registeredPersonModelUI: RegisteredPersonModelUI): RegisteredPerson
    fun toPhoneNumberModelUI(phoneNumber: PhoneNumber): PhoneNumberModelUI
    fun toUserModelUI(user: User): UserModelUI
}

internal class MapperDomainUI() : IMapperDomainUI{

    override fun toCommunityModelUI(community: Community): CommunityModelUI =
        CommunityModelUI(
            id = community.id,
            name = community.name,
            size = community.size,
            iconURL = community.iconURL,
        )

    override fun toCommunityDetailModelUI(communityDetail: CommunityDetail): CommunityDetailModelUI =
        CommunityDetailModelUI(
            id = communityDetail.id,
            name = communityDetail.name,
            description = communityDetail.description,
            events = communityDetail.events.map { toEventModelUI(it) },
        )

    override fun toCountryModelUI(country: Country): CountryModelUI =
        CountryModelUI(
            country = country.country,
            code = country.code,
            flag = country.flag,
        )

    override fun toEventModelUI(event: Event): EventModelUI =
        EventModelUI(
            id = event.id,
            name = event.name,
            date = event.date,
            city = event.city,
            category = event.category,
            iconURL = event.iconURL,
            isFinished = event.isFinished
        )

    override fun toEventDetailModelUI(eventDetail: EventDetail): EventDetailModelUI =
        EventDetailModelUI(
            id = eventDetail.id,
            name = eventDetail.name,
            date = eventDetail.date,
            address = eventDetail.address.toAddressString(),
            category = eventDetail.category,
            locationCoordinates = eventDetail.locationCoordinates,
            description = eventDetail.description,
            listOfParticipants = eventDetail.listOfParticipants.map { toRegisteredPersonModelUI(it) },
            isFinished = eventDetail.isFinished,
        )

    override fun toRegisteredPersonModelUI(registeredPerson: RegisteredPerson): RegisteredPersonModelUI =
        RegisteredPersonModelUI(
            id = registeredPerson.id,
            iconURL = registeredPerson.iconURL,
        )

    override fun toRegisteredPerson(registeredPersonModelUI: RegisteredPersonModelUI): RegisteredPerson =
        RegisteredPerson(
            id = registeredPersonModelUI.id,
            iconURL = registeredPersonModelUI.iconURL,
        )

    override fun toPhoneNumberModelUI(phoneNumber: PhoneNumber): PhoneNumberModelUI =
        PhoneNumberModelUI(
            countryCode = phoneNumber.countryCode,
            number = phoneNumber.number,
        )

    override fun toUserModelUI(user: User): UserModelUI =
        UserModelUI(
            id = user.id,
            name = user.name,
            surname = user.surname,
            phoneNumberModelUI = toPhoneNumberModelUI(user.phoneNumber),
            iconURL = user.iconURL
        )
}