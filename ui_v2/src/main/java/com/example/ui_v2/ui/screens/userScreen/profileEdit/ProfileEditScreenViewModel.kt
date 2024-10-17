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
    val clientCash: ClientCashModelUI = ClientCashModelUI(),
    val listOfCountriesCodes: List<CountryModelUI> = listOf(),
    val isClientExist: Boolean = false,

    val isCityValid: Boolean = true,
    val isDescriptionValid: Boolean = true,
) {
    val isNumberValid: Boolean
        get() = clientCash.phoneNumber.number.length == PHONE_NUMBER_LENGTH
    val isCountryCodeValid: Boolean
        get() = clientCash.phoneNumber.country.code.isNotBlank()
    val isNameSurnameValid: Boolean
        get() = clientCash.nameSurname.isNotBlank() && clientCash.nameSurname.length > 1
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
        saveClientCash.invoke(
            mapper.toClientCashModelDomain(
                uiState.value.clientCash.copy(
                    nameSurname = nameSurname
                )
            )
        )
    }

    fun onNumberChange(number: String) {
        saveClientCash.invoke(
            mapper.toClientCashModelDomain(
                uiState.value.clientCash.let {
                    it.copy(
                        phoneNumber = it.phoneNumber.copy(
                            number = number
                        )
                    )
                }

            )
        )
    }

    fun onCountryCodeChange(countryCode: CountryModelUI) {
        saveClientCash.invoke(
            mapper.toClientCashModelDomain(
                uiState.value.clientCash.let {
                    it.copy(
                        phoneNumber = it.phoneNumber.copy(
                            country = countryCode
                        )
                    )
                }
            )
        )
    }

    fun onCityChange(city: String) {
        saveClientCash.invoke(
            mapper.toClientCashModelDomain(
                uiState.value.clientCash.copy(
                    city = city
                )
            )
        )
    }

    fun onDescriptionChange(description: String) {
        saveClientCash.invoke(
            mapper.toClientCashModelDomain(
                uiState.value.clientCash.copy(
                    description = description
                )
            )
        )
    }

    fun onSocialNetworkValueChange(socialMediaID: String, value: String) {
        saveClientCash.invoke(
            mapper.toClientCashModelDomain(
                uiState.value.clientCash.let {
                    it.copy(
                        listOfClientSocialMedia = it.listOfClientSocialMedia.map { socialMedia ->
                            if (socialMedia.socialMediaId == socialMediaID) {
                                socialMedia.copy(userNickname = value)
                            } else {
                                socialMedia
                            }
                        }
                    )
                }
            )
        )
    }

    fun onAddSocialNetworkClick() {
        saveClientCash.invoke(
            mapper.toClientCashModelDomain(
                uiState.value.clientCash.let {
                    it.copy(
                        listOfClientSocialMedia = it.listOfClientSocialMedia + SocialMediaModelUI(
                            socialMediaId = UUID.randomUUID().toString()
                        )
                    )
                }
            )
        )
    }

    fun onShowMyCommunitiesChange(toggle: Boolean) {
        saveClientCash.invoke(
            mapper.toClientCashModelDomain(
                uiState.value.clientCash.copy(
                    isShowMyCommunities = toggle
                )
            )
        )
    }

    fun onShowMyEventsChange(toggle: Boolean) {
        saveClientCash.invoke(
            mapper.toClientCashModelDomain(
                uiState.value.clientCash.copy(
                    isShowMyEvents = toggle
                )
            )
        )
    }

    fun onApplyNotificationsChange(toggle: Boolean) {
        saveClientCash.invoke(
            mapper.toClientCashModelDomain(
                uiState.value.clientCash.copy(
                    isApplyNotifications = toggle
                )
            )
        )
    }

    fun saveNewSettings() {
        saveClientSettings.invoke(
            mapper.toClientModelDomain(
                uiState.value.clientCash.let {
                    ClientModelUI(
                        nameSurname = it.nameSurname,
                        phoneNumber = it.phoneNumber,
                        city = it.city,
                        description = it.description,
                        listOfSocialMedia = it.listOfClientSocialMedia.filter { it.userNickname.isNotBlank() },
                        isShowMyCommunities = it.isShowMyCommunities,
                        isShowMyEvents = it.isShowMyEvents,
                        isApplyNotifications = it.isApplyNotifications
                    )
                }

            )
        )
    }

    private fun loadData() {
        loadAvailableCountriesList.invoke()
        loadClient.invoke()
    }

    private fun getDataUserOutsideScreenUiState() {
        combine(
            getAvailableCountriesList.invoke(),
            getClientCash.invoke(),
            getClient.invoke()
        ) { availableCountriesList, clientCash, client ->
            _uiState.update {
                it.copy(
                    clientCash = mapper.toClientCashModelUI(clientCash),
                    listOfCountriesCodes = availableCountriesList.map { mapper.toCountryModelUI(it) },
                    isClientExist = mapper.toClientModelUI(client).phoneNumber.number.isNotBlank()
                )
            }
        }.launchIn(viewModelScope)
    }
}