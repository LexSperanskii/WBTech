package com.example.ui_v2.ui.screens.userScreen.profileEdit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.ClientCash.IInteractorGetClientCash
import com.example.domain.interactors.ClientCash.IInteractorSaveClientCash
import com.example.domain.interactors.availableCountries.IInteractorGetAvailableCountriesList
import com.example.domain.interactors.availableCountries.IInteractorLoadAvailableCountriesList
import com.example.domain.interactors.client.getClient.IInteractorGetClient
import com.example.domain.interactors.client.getClient.IInteractorLoadClient
import com.example.domain.interactors.client.saveClientSettings.IInteractorSaveClientSettings
import com.example.domain.repositories.ClientCash
import com.example.ui_v2.models.ClientModelUI
import com.example.ui_v2.models.CountryModelUI
import com.example.ui_v2.models.PhoneNumberModelUI
import com.example.ui_v2.models.SocialMediaModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import com.example.ui_v2.ui.utils.UiUtils.PHONE_NUMBER_LENGTH
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import java.util.UUID


internal data class ProfileEditScreenUiState(
    val avatarURL: String? = "",
    val nameSurname: String = "",
    val number: String = "",
    val countryCode: CountryModelUI = CountryModelUI(),
    val listOfCountriesCodes: List<CountryModelUI> = listOf(),
    val city: String = "",
    val isCityValid: Boolean = true,
    val aboutUser: String = "",
    val isAboutUserValid: Boolean = true,
    val listOfUserTags: List<String> = listOf(),
    val listOfSocialMedia: List<SocialMediaModelUI> = listOf(),
    val showMyCommunitiesChecked: Boolean = true,
    val showMyEventsChecked: Boolean = true,
    val applyNotificationsChecked: Boolean = true,
    val client: ClientModelUI = ClientModelUI(),
    val clientCash: ClientCash = ClientCash(),
) {
    val isNumberValid: Boolean
        get() = number.length == PHONE_NUMBER_LENGTH
    val isCountryCodeValid: Boolean
        get() = countryCode.code.isNotBlank()
    val isNameSurnameValid: Boolean
        get() = nameSurname.isNotBlank() && nameSurname.length > 1
}

internal class ProfileEditScreenViewModel(
    private val mapper: IMapperDomainUI,
    private val loadClient: IInteractorLoadClient,
    private val getClient: IInteractorGetClient,
    private val loadAvailableCountriesList: IInteractorLoadAvailableCountriesList,
    private val getAvailableCountriesList: IInteractorGetAvailableCountriesList,
    private val saveClientSettings: IInteractorSaveClientSettings,
    private val getClientCash: IInteractorGetClientCash,
    private val saveClientCash: IInteractorSaveClientCash,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileEditScreenUiState())
    private val uiState: StateFlow<ProfileEditScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getDataUserOutsideScreenUiState()
    }

    fun getProfileEditScreenUiStateFlow(): StateFlow<ProfileEditScreenUiState> = uiState

    fun onNameSurnameChange(nameSurname: String) {
        val cash = uiState.value.clientCash
        saveClientCash.invoke(cash.copy(nameSurname = nameSurname))
//        _uiState.update {
//            it.copy(
//                nameSurname = nameSurname
//            )
//        }
    }

    fun onNumberChange(number: String) {
        val cash = uiState.value.clientCash
        saveClientCash.invoke(cash.copy(phoneNumber = cash.phoneNumber.copy(number = number)))
//        _uiState.update {
//            it.copy(
//                number = number
//            )
//        }
    }

    fun onCountryCodeChange(countryCode: CountryModelUI) {
        val cash = uiState.value.clientCash
        saveClientCash.invoke(
            cash.copy(
                phoneNumber = cash.phoneNumber.copy(
                    country = mapper.toCountryModelDomain(
                        countryCode
                    )
                )
            )
        )
//        _uiState.update {
//            it.copy(
//                countryCode = countryCode
//            )
//        }
    }

    fun onCityChange(city: String) {
        val cash = uiState.value.clientCash
        saveClientCash.invoke(cash.copy(city = city))
//        _uiState.update {
//            it.copy(
//                city = city
//            )
//        }
    }

    fun onAboutUserChange(aboutUser: String) {
        val cash = uiState.value.clientCash
        saveClientCash.invoke(cash.copy(description = aboutUser))
//        _uiState.update {
//            it.copy(
//                aboutUser = aboutUser
//            )
//        }
    }

    fun onSocialNetworkValueChange(socialMediaID: String, value: String) {
        val cash = uiState.value.clientCash
        saveClientCash.invoke(cash.copy(listOfClientSocialMedia = cash.listOfClientSocialMedia.map { socialMedia ->
            if (socialMedia.socialMediaId == socialMediaID) {
                socialMedia.copy(userNickname = value)
            } else {
                socialMedia
            }
        }))
//        _uiState.update { it ->
//            it.copy(
//                listOfSocialMedia = it.listOfSocialMedia.map { socialMedia ->
//                    if (socialMedia.socialMediaId == socialMediaID) {
//                        socialMedia.copy(userNickname = value)
//                    } else {
//                        socialMedia
//                    }
//                }
//            )
//        }
    }

    fun onAddSocialNetworkClick() {
        val cash = uiState.value.clientCash
        saveClientCash.invoke(
            cash.copy(
                listOfClientSocialMedia = cash.listOfClientSocialMedia + mapper.toSocialMediaModelDomain(
                    SocialMediaModelUI(
                        socialMediaId = UUID.randomUUID().toString()
                    )
                )
            )
        )

//        _uiState.update {
//            it.copy(
//                listOfSocialMedia = it.listOfSocialMedia + SocialMediaModelUI(
//                    socialMediaId = UUID.randomUUID().toString()
//                )
//            )
//        }
    }

    fun onShowMyCommunitiesChange(toggle: Boolean) {
        val cash = uiState.value.clientCash
        saveClientCash.invoke(cash.copy(isShowMyCommunities = toggle))

//        _uiState.update {
//            it.copy(
//                showMyCommunitiesChecked = toggle
//            )
//        }
    }

    fun onShowMyEventsChange(toggle: Boolean) {
        val cash = uiState.value.clientCash
        saveClientCash.invoke(cash.copy(showMyEventsChecked = toggle))
//        _uiState.update {
//            it.copy(
//                showMyEventsChecked = toggle
//            )
//        }
    }

    fun onApplyNotificationsChange(toggle: Boolean) {
        val cash = uiState.value.clientCash
        saveClientCash.invoke(cash.copy(applyNotificationsChecked = toggle))
//        _uiState.update {
//            it.copy(
//                applyNotificationsChecked = toggle
//            )
//        }
    }

    fun saveNewSettings() {
        val uiState = uiState.value
        saveClientSettings.invoke(
            mapper.toClientModelDomain(
                ClientModelUI(
                    imageURL = uiState.avatarURL,
                    nameSurname = uiState.nameSurname,
                    phoneNumber = PhoneNumberModelUI(
                        uiState.countryCode,
                        uiState.number
                    ),
                    city = uiState.city,
                    description = uiState.aboutUser,
                    listOfSocialMedia = uiState.listOfSocialMedia.filter { it.userNickname.isNotBlank() },
                    isShowMyCommunities = uiState.showMyCommunitiesChecked,
                    showMyEventsChecked = uiState.showMyEventsChecked,
                    applyNotificationsChecked = uiState.applyNotificationsChecked
                )
            )
        )
    }

    private fun loadData() {
        loadClient.invoke()
        loadAvailableCountriesList.invoke()
    }

    private fun getDataUserOutsideScreenUiState() {
        val combineClientCashFlow = combine(
            getClientCash.invoke(),
            getClient.invoke()
        ) { clientCash, client ->
            clientCash.copy(
                imageURL = client.imageURL,
                nameSurname = client.nameSurname,
                phoneNumber = client.phoneNumber,
                city = client.city,
                description = client.description,
                listOfClientTags = client.listOfClientTags,
                listOfClientSocialMedia = client.listOfClientSocialMedia,
                isShowMyCommunities = client.isShowMyCommunities,
                showMyEventsChecked = client.showMyEventsChecked,
                applyNotificationsChecked = client.applyNotificationsChecked
            )
        }
        combine(
            combineClientCashFlow,
            getAvailableCountriesList.invoke(),
            getClientCash.invoke(),
            getClient.invoke()
        ) { combineClientCash, availableCountriesList, clientCash, client ->
            _uiState.update {
                it.copy(
                    avatarURL = combineClientCash.imageURL,
                    nameSurname = combineClientCash.nameSurname,
                    number = combineClientCash.phoneNumber.number,
                    countryCode = mapper.toCountryModelUI(combineClientCash.phoneNumber.country),
                    listOfCountriesCodes = availableCountriesList.map { mapper.toCountryModelUI(it) },
                    city = combineClientCash.city,
                    aboutUser = combineClientCash.description,
                    listOfUserTags = combineClientCash.listOfClientTags,
                    listOfSocialMedia = combineClientCash.listOfClientSocialMedia.map {
                        mapper.toSocialMediaModelUI(
                            it
                        )
                    },
                    showMyCommunitiesChecked = combineClientCash.isShowMyCommunities,
                    showMyEventsChecked = combineClientCash.showMyEventsChecked,
                    applyNotificationsChecked = combineClientCash.applyNotificationsChecked,
                    clientCash = clientCash,
                    client = mapper.toClientModelUI(client)
                )
            }
        }.launchIn(viewModelScope)


//        combine(
//            getClient.invoke(),
//            getAvailableCountriesList.invoke()
//        ) { client, availableCountriesList ->
//            _uiState.update {
//                it.copy(
//                    avatarURL = client.imageURL,
//                    nameSurname = client.nameSurname,
//                    number = client.phoneNumber.number,
//                    countryCode = mapper.toCountryModelUI(client.phoneNumber.country),
//                    listOfCountriesCodes = availableCountriesList.map { mapper.toCountryModelUI(it) },
//                    city = client.city,
//                    aboutUser = client.description,
//                    listOfUserTags = client.listOfClientTags,
//                    listOfSocialMedia = client.listOfClientSocialMedia.map {
//                        mapper.toSocialMediaModelUI(
//                            it
//                        )
//                    },
//                    showMyCommunitiesChecked = client.isShowMyCommunities,
//                    showMyEventsChecked = client.showMyEventsChecked,
//                    applyNotificationsChecked = client.applyNotificationsChecked,
//                    client = mapper.toClientModelUI(client)
//                )
//            }
//        }.launchIn(viewModelScope)
    }

}