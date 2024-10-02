package com.example.domain.repositories


import com.example.domain.models.PhoneNumberModelDomain
import com.example.domain.models.SocialMediaModelDomain
import kotlinx.coroutines.flow.Flow

data class ClientCash(
    val imageURL: String? = "",
    val nameSurname: String = "",
    val phoneNumber: PhoneNumberModelDomain = PhoneNumberModelDomain(),
    val city: String = "",
    val description: String = "",
    val listOfClientTags: List<String> = listOf(),
    val listOfClientSocialMedia: List<SocialMediaModelDomain> = listOf(),
    val isShowMyCommunities: Boolean = true,
    val showMyEventsChecked: Boolean = true,
    val applyNotificationsChecked: Boolean = true,
)

interface IClientCash {
    fun saveClient(client: ClientCash)
    fun getClient(): Flow<ClientCash>
}