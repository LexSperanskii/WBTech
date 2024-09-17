package com.example.ui_v2.models.mapper

import androidx.compose.ui.graphics.Color
import com.example.domain.models.ClientModelDomain
import com.example.domain.models.CommunitiesAdvertBlockModelDomain
import com.example.domain.models.CommunityDescriptionModelDomain
import com.example.domain.models.CommunityModelDomain
import com.example.domain.models.CountryModelDomain
import com.example.domain.models.EventAdvertBlockModelDomain
import com.example.domain.models.EventDescriptionModelDomain
import com.example.domain.models.EventLocationModelDomain
import com.example.domain.models.EventModelDomain
import com.example.domain.models.MetroModelDomain
import com.example.domain.models.PhoneNumberModelDomain
import com.example.domain.models.SocialMediaModelDomain
import com.example.domain.models.UserModelDomain
import com.example.ui_v2.R
import com.example.ui_v2.models.ClientModelUI
import com.example.ui_v2.models.CommunitiesAdvertBlockModelUI
import com.example.ui_v2.models.CommunityDescriptionModelUI
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.models.CountryModelUI
import com.example.ui_v2.models.EventAdvertBlockModelUI
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.models.EventLocationModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.MetroModelUI
import com.example.ui_v2.models.PhoneNumberModelUI
import com.example.ui_v2.models.SocialMediaModelUI
import com.example.ui_v2.models.UserModelUI

internal interface IMapperDomainUI {
    fun toCommunityDescriptionModelUI(communityDescriptionModelDomain: CommunityDescriptionModelDomain): CommunityDescriptionModelUI
    fun toCommunityModelUI(communityModelDomain: CommunityModelDomain): CommunityModelUI
    fun toCommunitiesAdvertBlockModelUI(communitiesAdvertBlockModelDomain: CommunitiesAdvertBlockModelDomain): CommunitiesAdvertBlockModelUI
    fun toCountryModelUI(countryModelDomain: CountryModelDomain): CountryModelUI
    fun toCountryModelDomain(countryModelUI: CountryModelUI): CountryModelDomain
    fun toEventDescriptionModelUI(eventDescriptionModelDomain: EventDescriptionModelDomain): EventDescriptionModelUI
    fun toEventLocationModelUI(eventLocationModelDomain: EventLocationModelDomain): EventLocationModelUI
    fun toEventModelUI(eventModelDomain: EventModelDomain): EventModelUI
    fun toEventAdvertBlockModelUI(eventAdvertBlockModelDomain: EventAdvertBlockModelDomain): EventAdvertBlockModelUI
    fun toMetroModelUI(metroModelDomain: MetroModelDomain): MetroModelUI
    fun toPhoneNumberModelUI(phoneNumberModelDomain: PhoneNumberModelDomain): PhoneNumberModelUI
    fun toUserModelUI(userModelDomain: UserModelDomain): UserModelUI
    fun toClientModelUI(clientModelDomain: ClientModelDomain): ClientModelUI
    fun toSocialMediaModelUI(socialMediaModelDomain: SocialMediaModelDomain): SocialMediaModelUI
    fun toSocialMediaModelDomain(socialMediaModelUI: SocialMediaModelUI): SocialMediaModelDomain
}

internal class MapperDomainUIImpl : IMapperDomainUI {

    override fun toCommunityDescriptionModelUI(communityDescriptionModelDomain: CommunityDescriptionModelDomain): CommunityDescriptionModelUI =
        CommunityDescriptionModelUI(
            id = communityDescriptionModelDomain.id,
            name = communityDescriptionModelDomain.name,
            description = communityDescriptionModelDomain.description,
            imageURL = communityDescriptionModelDomain.imageURL,
            listOfTags = communityDescriptionModelDomain.listOfTags,
            listOfParticipants = communityDescriptionModelDomain.listOfParticipants.map {
                toUserModelUI(
                    it
                )
            },
            listOfEvents = communityDescriptionModelDomain.listOfEvents.map { toEventModelUI(it) },
            listOfPastEvents = communityDescriptionModelDomain.listOfPastEvents.map {
                toEventModelUI(
                    it
                )
            }
        )

    override fun toCommunityModelUI(communityModelDomain: CommunityModelDomain): CommunityModelUI =
        CommunityModelUI(
            id = communityModelDomain.id,
            name = communityModelDomain.name,
            description = communityModelDomain.description,
            imageURL = communityModelDomain.imageURL,
        )

    override fun toCommunitiesAdvertBlockModelUI(communitiesAdvertBlockModelDomain: CommunitiesAdvertBlockModelDomain): CommunitiesAdvertBlockModelUI =
        CommunitiesAdvertBlockModelUI(
            id = communitiesAdvertBlockModelDomain.id,
            nameOfBlock = communitiesAdvertBlockModelDomain.nameOfBlock,
            listOfCommunities = communitiesAdvertBlockModelDomain.listOfCommunities.map {
                toCommunityModelUI(
                    it
                )
            }
        )

    override fun toCountryModelUI(countryModelDomain: CountryModelDomain): CountryModelUI =
        CountryModelUI(
            id = countryModelDomain.id,
            country = countryModelDomain.country,
            code = countryModelDomain.code,
            flag = correctFlagById(countryModelDomain)
        )

    override fun toCountryModelDomain(countryModelUI: CountryModelUI): CountryModelDomain =
        CountryModelDomain(
            id = countryModelUI.id,
            country = countryModelUI.country,
            code = countryModelUI.code
        )

    override fun toEventDescriptionModelUI(eventDescriptionModelDomain: EventDescriptionModelDomain): EventDescriptionModelUI =
        EventDescriptionModelUI(
            id = eventDescriptionModelDomain.id,
            name = eventDescriptionModelDomain.name,
            time = eventDescriptionModelDomain.time,
            day = eventDescriptionModelDomain.day,
            month = eventDescriptionModelDomain.month,
            year = eventDescriptionModelDomain.year,
            city = eventDescriptionModelDomain.city,
            street = eventDescriptionModelDomain.street,
            building = eventDescriptionModelDomain.building,
            imageURL = eventDescriptionModelDomain.imageURL,
            listOfTags = eventDescriptionModelDomain.listOfTags,
            description = eventDescriptionModelDomain.description,
            pitcher = toUserModelUI(eventDescriptionModelDomain.pitcher),
            location = toEventLocationModelUI(eventDescriptionModelDomain.location),
            metroStation = toMetroModelUI(eventDescriptionModelDomain.metroStation),
            listOfParticipants = eventDescriptionModelDomain.listOfParticipants.map {
                toUserModelUI(
                    it
                )
            },
            organizer = toCommunityModelUI(eventDescriptionModelDomain.organizer),
            availableCapacity = eventDescriptionModelDomain.availableCapacity,
        )

    override fun toEventLocationModelUI(eventLocationModelDomain: EventLocationModelDomain): EventLocationModelUI =
        EventLocationModelUI(
            latitude = eventLocationModelDomain.latitude,
            longitude = eventLocationModelDomain.longitude
        )

    override fun toEventModelUI(eventModelDomain: EventModelDomain): EventModelUI =
        EventModelUI(
            id = eventModelDomain.id,
            name = eventModelDomain.name,
            time = eventModelDomain.time,
            day = eventModelDomain.day,
            month = eventModelDomain.month,
            year = eventModelDomain.year,
            city = eventModelDomain.city,
            street = eventModelDomain.street,
            building = eventModelDomain.building,
            imageURL = eventModelDomain.imageURL,
            listOfTags = eventModelDomain.listOfTags
        )

    override fun toEventAdvertBlockModelUI(eventAdvertBlockModelDomain: EventAdvertBlockModelDomain): EventAdvertBlockModelUI =
        EventAdvertBlockModelUI(
            id = eventAdvertBlockModelDomain.id,
            nameOfBlock = eventAdvertBlockModelDomain.nameOfBlock,
            listOfEvents = eventAdvertBlockModelDomain.listOfEvents.map { toEventModelUI(it) }
        )

    override fun toMetroModelUI(metroModelDomain: MetroModelDomain): MetroModelUI =
        MetroModelUI(
            name = metroModelDomain.name,
            tint = Color(metroModelDomain.tint.toLong(16))
        )

    override fun toPhoneNumberModelUI(phoneNumberModelDomain: PhoneNumberModelDomain): PhoneNumberModelUI =
        PhoneNumberModelUI(
            country = toCountryModelUI(phoneNumberModelDomain.country),
            number = phoneNumberModelDomain.number
        )

    override fun toUserModelUI(userModelDomain: UserModelDomain): UserModelUI =
        UserModelUI(
            id = userModelDomain.id,
            nameSurname = userModelDomain.nameSurname,
            city = userModelDomain.city,
            listOfTags = userModelDomain.listOfTags,
            description = userModelDomain.description,
            imageURL = userModelDomain.imageURL,
            listOfSocialMedia = userModelDomain.listOfSocialMedia.map {
                toSocialMediaModelUI(
                    it
                )
            },
            userEventsList = userModelDomain.userEventsList.map { toEventModelUI(it) },
            userCommunitiesList = userModelDomain.userCommunitiesList.map { toCommunityModelUI(it) }
        )

    override fun toClientModelUI(clientModelDomain: ClientModelDomain): ClientModelUI =
        ClientModelUI(
            id = clientModelDomain.id,
            imageURL = clientModelDomain.imageURL,
            nameSurname = clientModelDomain.nameSurname,
            phoneNumber = toPhoneNumberModelUI(clientModelDomain.phoneNumber),
            city = clientModelDomain.city,
            description = clientModelDomain.description,
            listOfTags = clientModelDomain.listOfClientTags,
            listOfSocialMedia = clientModelDomain.listOfClientSocialMedia.map {
                toSocialMediaModelUI(
                    it
                )
            },
            clientEventsList = clientModelDomain.clientEventsList.map { toEventModelUI(it) },
            clientCommunitiesList = clientModelDomain.clientCommunitiesList.map {
                toCommunityModelUI(
                    it
                )
            },
            isShowMyCommunities = clientModelDomain.isShowMyCommunities,
            showMyEventsChecked = clientModelDomain.showMyEventsChecked,
            applyNotificationsChecked = clientModelDomain.applyNotificationsChecked
        )

    override fun toSocialMediaModelUI(socialMediaModelDomain: SocialMediaModelDomain): SocialMediaModelUI =
        SocialMediaModelUI(
            socialMediaId = socialMediaModelDomain.socialMediaId,
            socialMediaIcon = correctSocialMediaIconById(socialMediaModelDomain),
            socialMediaName = socialMediaModelDomain.socialMediaName,
            userNickname = socialMediaModelDomain.userNickname
        )

    override fun toSocialMediaModelDomain(socialMediaModelUI: SocialMediaModelUI): SocialMediaModelDomain =
        SocialMediaModelDomain(
            socialMediaId = socialMediaModelUI.socialMediaId,
            socialMediaName = socialMediaModelUI.socialMediaName,
            userNickname = socialMediaModelUI.userNickname
        )

    private fun correctFlagById(countryModelDomain: CountryModelDomain): Int {
        return when (countryModelDomain.id) {
            "0" -> {
                R.drawable.flag_ru
            }

            "1" -> {
                R.drawable.flag_kz
            }

            "2" -> {
                R.drawable.flag_by
            }

            "3" -> {
                R.drawable.flag_kg
            }

            "4" -> {
                R.drawable.flag_az
            }

            else -> {
                R.drawable.flag_default
            }
        }
    }

    private fun correctSocialMediaIconById(socialMediaModelDomain: SocialMediaModelDomain): Int {
        return when (socialMediaModelDomain.socialMediaId) {
            "0" -> {
                R.drawable.label_xabr
            }

            "1" -> {
                R.drawable.label_telegramm
            }

            else -> {
                R.drawable.icon_avatar_person
            }
        }
    }
}

