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


class Mapper {

    fun mapCommunityToCommunityModelUI(community: Community): CommunityModelUI =
        CommunityModelUI(
            id = community.id,
            name = community.name,
            size = community.size,
            iconURL = community.iconURL,
        )

    fun mapCommunityDetailToCommunityDetailModelUI(communityDetail: CommunityDetail): CommunityDetailModelUI =
        CommunityDetailModelUI(
            id = communityDetail.id,
            name = communityDetail.name,
            description = communityDetail.description,
            events = communityDetail.events.map { mapEventToEventModelUI(it) },
        )

    fun mapCountryToCountryModelUI(country: Country): CountryModelUI =
        CountryModelUI(
            country = country.country,
            code = country.code,
            flag = country.flag,
        )

    fun mapEventToEventModelUI(event: Event): EventModelUI =
        EventModelUI(
            id = event.id,
            name = event.name,
            date = event.date,
            city = event.city,
            category = event.category,
            iconURL = event.iconURL,
            isFinished = event.isFinished
        )

    fun mapEventDetailToEventDetailModelUI(eventDetail: EventDetail): EventDetailModelUI =
        EventDetailModelUI(
            id = eventDetail.id,
            name = eventDetail.name,
            date = eventDetail.date,
            address = eventDetail.address.toAddressString(),
            category = eventDetail.category,
            locationCoordinates= eventDetail.locationCoordinates,
            description = eventDetail.description,
            listOfParticipants = eventDetail.listOfParticipants.map { mapRegisteredPersonToRegisteredPersonModelUI(it) },
            isFinished = eventDetail.isFinished,
            isUserInParticipants = eventDetail.isUserInParticipants
        )

    fun mapRegisteredPersonToRegisteredPersonModelUI(registeredPerson: RegisteredPerson): RegisteredPersonModelUI =
        RegisteredPersonModelUI(
            id = registeredPerson.id,
            iconURL = registeredPerson.iconURL,
        )

    fun mapPhoneNumberToPhoneNumberModelUI(phoneNumber: PhoneNumber): PhoneNumberModelUI =
        PhoneNumberModelUI(
            countryCode = phoneNumber.countryCode,
            number = phoneNumber.number,
        )

    fun mapUserToUserModelUI(user: User): UserModelUI =
        UserModelUI(
            id = user.id,
            name = user.name,
            surname = user.surname,
            phoneNumberModelUI = mapPhoneNumberToPhoneNumberModelUI(user.phoneNumber),
            iconURL = user.iconURL
        )
}