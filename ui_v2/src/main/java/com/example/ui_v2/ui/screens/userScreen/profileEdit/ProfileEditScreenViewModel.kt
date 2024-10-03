package com.example.ui_v2.ui.screens.userScreen.profileEdit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.availableCountries.IInteractorGetAvailableCountriesList
import com.example.domain.interactors.availableCountries.IInteractorLoadAvailableCountriesList
import com.example.domain.interactors.client.getClient.IInteractorGetClient
import com.example.domain.interactors.client.getClient.IInteractorLoadClient
import com.example.domain.interactors.client.saveClientSettings.IInteractorSaveClientSettings
import com.example.domain.interactors.clientCash.IInteractorGetClientCash
import com.example.domain.interactors.clientCash.IInteractorSaveClientCash
import com.example.ui_v2.models.ClientCashModelUI
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
    private val saveClientCash: IInteractorSaveClientCash,
    private val getClientCash: IInteractorGetClientCash,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileEditScreenUiState())
    private val uiState: StateFlow<ProfileEditScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getDataUserOutsideScreenUiState()
    }

    fun getProfileEditScreenUiStateFlow(): StateFlow<ProfileEditScreenUiState> = uiState

    fun onNameSurnameChange(nameSurname: String) {
        _uiState.update {
            it.copy(
                nameSurname = nameSurname
            )
        }
    }

    fun onNumberChange(number: String) {
        _uiState.update {
            it.copy(
                number = number
            )
        }
    }

    fun onCountryCodeChange(countryCode: CountryModelUI) {
        _uiState.update {
            it.copy(
                countryCode = countryCode
            )
        }
    }

    fun onCityChange(city: String) {
        _uiState.update {
            it.copy(
                city = city
            )
        }
    }

    fun onAboutUserChange(aboutUser: String) {
        _uiState.update {
            it.copy(
                aboutUser = aboutUser
            )
        }
    }

    fun onSocialNetworkValueChange(socialMediaID: String, value: String) {
        _uiState.update { it ->
            it.copy(
                listOfSocialMedia = it.listOfSocialMedia.map { socialMedia ->
                    if (socialMedia.socialMediaId == socialMediaID) {
                        socialMedia.copy(userNickname = value)
                    } else {
                        socialMedia
                    }
                }
            )
        }
    }

    fun onAddSocialNetworkClick() {
        _uiState.update {
            it.copy(
                listOfSocialMedia = it.listOfSocialMedia + SocialMediaModelUI(
                    socialMediaId = UUID.randomUUID().toString()
                )
            )
        }
    }

    fun onShowMyCommunitiesChange(toggle: Boolean) {
        _uiState.update {
            it.copy(
                showMyCommunitiesChecked = toggle
            )
        }
    }

    fun onShowMyEventsChange(toggle: Boolean) {
        _uiState.update {
            it.copy(
                showMyEventsChecked = toggle
            )
        }
    }

    fun onApplyNotificationsChange(toggle: Boolean) {
        _uiState.update {
            it.copy(
                applyNotificationsChecked = toggle
            )
        }
    }

    fun saveNewSettings() {
        val uiState = uiState.value
        saveClientSettings.invoke(
            mapper.toClientModelDomain(
                ClientModelUI(
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

    fun saveCash() {
        val uiState = uiState.value
        saveClientCash.invoke(
            mapper.toClientCashModelDomain(
                ClientCashModelUI(
                    nameSurname = uiState.nameSurname,
                    phoneNumber = PhoneNumberModelUI(
                        uiState.countryCode,
                        uiState.number
                    ),
                    city = uiState.city,
                    description = uiState.aboutUser,
                    listOfClientSocialMedia = uiState.listOfSocialMedia,
                    isShowMyCommunities = uiState.showMyCommunitiesChecked,
                    showMyEventsChecked = uiState.showMyEventsChecked,
                    applyNotificationsChecked = uiState.applyNotificationsChecked
                )
            )
        )
    }

    fun clearCash() {
        saveClientCash.invoke(
            mapper.toClientCashModelDomain(
                ClientCashModelUI()
            )
        )
    }

    private fun getDataUserOutsideScreenUiState() {
        combine(
            getClient.invoke(),
            getAvailableCountriesList.invoke(),
            getClientCash.invoke()
        ) { client, availableCountriesList, getCash ->
            _uiState.update {
                it.copy(
                    avatarURL = client.imageURL,
                    nameSurname = getCash.nameSurname.ifBlank { client.nameSurname },
                    number = getCash.phoneNumber.number.ifBlank { client.phoneNumber.number },
                    countryCode = mapper.toCountryModelUI(
                        if (getCash.phoneNumber.country.code.isNotBlank()) {
                            getCash.phoneNumber.country
                        } else {
                            client.phoneNumber.country
                        }
                    ),
                    listOfCountriesCodes = availableCountriesList.map { mapper.toCountryModelUI(it) },
                    city = getCash.city.ifBlank { client.city },
                    aboutUser = getCash.description.ifBlank { client.description },
                    listOfUserTags = client.listOfClientTags,
                    listOfSocialMedia = getCash.listOfClientSocialMedia
                        .map { mapper.toSocialMediaModelUI(it) }
                        .ifEmpty {
                            client.listOfClientSocialMedia.map {
                                mapper.toSocialMediaModelUI(it)
                            }
                        },
                    showMyCommunitiesChecked = getCash.isShowMyCommunities
                        ?: client.isShowMyCommunities,
                    showMyEventsChecked = getCash.showMyEventsChecked ?: client.showMyEventsChecked,
                    applyNotificationsChecked = getCash.applyNotificationsChecked
                        ?: client.applyNotificationsChecked,
                    client = mapper.toClientModelUI(client)
                )
            }
        }.launchIn(viewModelScope)
    }
}