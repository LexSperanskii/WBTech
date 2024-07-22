package com.example.spa_wb_junior_devmeetingapp.models

import com.example.domain.models.Community
import com.example.domain.models.CommunityDetail
import com.example.domain.models.Country
import com.example.domain.models.Event
import com.example.domain.models.EventAddress
import com.example.domain.models.EventDetail
import com.example.domain.models.PhoneNumber
import com.example.domain.models.RegisteredPerson
import com.example.domain.models.User


class Mapper {

    fun mapCommunityToCommunityModelUI(community: Community): CommunityModelUI {
        return CommunityModelUI(
            id = community.id,
            name = community.name,
            size = community.size,
            iconURL = community.iconURL,
        )
    }

    fun mapCommunityDetailToCommunityDetailModelUI(communityDetail: CommunityDetail): CommunityDetailModelUI {
        return CommunityDetailModelUI(
            id = communityDetail.id,
            name = communityDetail.name,
            description = communityDetail.description,
            events = communityDetail.events.map { mapEventToEventModelUI(it) },
        )
    }
    fun mapCountryToCountryModelUI(country: Country): CountryModelUI {
        return CountryModelUI(
            country = country.country,
            code = country.code,
            flag = country.flag,
        )
    }

    fun mapEventToEventModelUI(event: Event): EventModelUI {
        return EventModelUI(
            id = event.id,
            name = event.name,
            date = event.date,
            city = event.city,
            category = event.category,
            iconURL = event.iconURL,
            isFinished = event.isFinished
        )
    }

    fun mapEventDetailToEventDetailModelUI(eventDetail: EventDetail): EventDetailModelUI {
        return EventDetailModelUI(
            id = eventDetail.id,
            name = eventDetail.name,
            date = eventDetail.date,
            address = mapEventAddressToEventAddressModelUI(eventDetail.address),
            category = eventDetail.category,
            locationCoordinates= eventDetail.locationCoordinates,
            description = eventDetail.description,
            listOfParticipants = eventDetail.listOfParticipants.map { mapRegisteredPersonToRegisteredPersonModelUI(it) },
            isFinished = eventDetail.isFinished,
            isUserInParticipants = eventDetail.isUserInParticipants
        )
    }

    fun mapEventAddressToEventAddressModelUI(eventAddress: EventAddress): EventAddressModelUI {
        return EventAddressModelUI(
            city = eventAddress.city,
            street = eventAddress.street,
            building = eventAddress.building,
        )
    }
    fun mapRegisteredPersonToRegisteredPersonModelUI(registeredPerson: RegisteredPerson): RegisteredPersonModelUI {
        return RegisteredPersonModelUI(
            id = registeredPerson.id,
            iconURL = registeredPerson.iconURL,
        )
    }
    fun mapPhoneNumberToPhoneNumberModelUI(phoneNumber: PhoneNumber): PhoneNumberModelUI {
        return PhoneNumberModelUI(
            countryCode = phoneNumber.countryCode,
            number = phoneNumber.number,
        )
    }
    fun mapUserToUserModelUI(user: User): UserModelUI {
        return UserModelUI(
            id = user.id,
            name = user.name,
            surname = user.surname,
            phoneNumberModelUI = mapPhoneNumberToPhoneNumberModelUI(user.phoneNumber),
            iconURL = user.iconURL
        )
    }
}