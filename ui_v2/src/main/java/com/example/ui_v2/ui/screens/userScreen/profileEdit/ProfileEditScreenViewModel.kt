package com.example.ui_v2.ui.screens.userScreen.profileEdit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.availableCountries.IInteractorGetAvailableCountriesList
import com.example.domain.interactors.availableCountries.IInteractorLoadAvailableCountriesList
import com.example.domain.interactors.client.IInteractorGetClient
import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.interactors.dataStore.IInteractorClearDataStore
import com.example.domain.interactors.dataStore.IInteractorGetDataStore
import com.example.domain.interactors.dataStore.IInteractorSetDataStore
import com.example.domain.interactors.oldSuspend.IInteractorSaveClientSettings
import com.example.domain.interactors.oldSuspend.IInteractorSetClientPhoneNumber
import com.example.ui_v2.models.ClientModelUI
import com.example.ui_v2.models.CountryModelUI
import com.example.ui_v2.models.SocialMediaModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import com.example.ui_v2.ui.utils.DataStoreKey
import com.example.ui_v2.ui.utils.UiUtils.PHONE_NUMBER_LENGTH
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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
    private val setClientPhoneNumber: IInteractorSetClientPhoneNumber,
    private val saveClientSettings: IInteractorSaveClientSettings,
    private val setDataStore: IInteractorSetDataStore,
    private val getDataStore: IInteractorGetDataStore,
    private val clearDataStore: IInteractorClearDataStore,
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
            nameSurname = uiState.nameSurname,
            city = uiState.city,
            description = uiState.aboutUser,
            listOfClientSocialMedia = uiState.listOfSocialMedia.filter { it.userNickname.isNotBlank() }
                .map {
                    mapper.toSocialMediaModelDomain(
                        it
                    )
                },
            isShowMyCommunities = uiState.showMyCommunitiesChecked,
            showMyEventsChecked = uiState.showMyEventsChecked,
            applyNotificationsChecked = uiState.applyNotificationsChecked
        ).launchIn(viewModelScope)
        setClientPhoneNumber.invoke(
            mapper.toCountryModelDomain(uiState.countryCode),
            uiState.number
        ).launchIn(viewModelScope)
    }

    fun saveInDataStore() {
        val uiState = uiState.value
        viewModelScope.launch {
            setDataStore.invoke(DataStoreKey.Name.name, uiState.nameSurname)
            setDataStore.invoke(DataStoreKey.Number.name, uiState.number)
            setDataStore.invoke(DataStoreKey.City.name, uiState.city)
            setDataStore.invoke(DataStoreKey.About.name, uiState.aboutUser)
        }
    }

    fun deleteDataStore() {
        viewModelScope.launch {
            clearDataStore.invoke()
        }
    }

    private fun loadData() {
        loadClient.invoke()
        loadAvailableCountriesList.invoke()
    }

    private fun getDataUserOutsideScreenUiState() {
        val clientCountriesFlow = combine(
            getClient.invoke(),
            getAvailableCountriesList.invoke()
        ) { client, availableCountriesList ->
            ProfileEditScreenUiState().copy(
                avatarURL = client.imageURL,
                nameSurname = client.nameSurname,
                number = client.phoneNumber.number,
                countryCode = mapper.toCountryModelUI(client.phoneNumber.country),
                listOfCountriesCodes = availableCountriesList.map { mapper.toCountryModelUI(it) },
                city = client.city,
                aboutUser = client.description,
                listOfUserTags = client.listOfClientTags,
                listOfSocialMedia = client.listOfClientSocialMedia.map {
                    mapper.toSocialMediaModelUI(
                        it
                    )
                },
                showMyCommunitiesChecked = client.isShowMyCommunities,
                showMyEventsChecked = client.showMyEventsChecked,
                applyNotificationsChecked = client.applyNotificationsChecked,
                client = mapper.toClientModelUI(client)
            )
        }

        val dataStoreFlow = combine(
            getDataStore.invoke(DataStoreKey.Name.name),
            getDataStore.invoke(DataStoreKey.Number.name),
            getDataStore.invoke(DataStoreKey.City.name),
            getDataStore.invoke(DataStoreKey.About.name),
        ) { dsName, dsNumber, dsCity, dsAbout ->
            ProfileEditScreenUiState().copy(
                nameSurname = dsName,
                number = dsNumber,
                city = dsCity,
                aboutUser = dsAbout
            )
        }

        clientCountriesFlow.combine(dataStoreFlow) { clientCountries, dataStore ->
            _uiState.update {
                it.copy(
                    avatarURL = clientCountries.avatarURL,
                    nameSurname = when (dataStore.nameSurname.isBlank()) {
                        true -> {
                            clientCountries.nameSurname
                        }

                        else -> {
                            dataStore.nameSurname
                        }
                    },
                    number = when (dataStore.number.isBlank()) {
                        true -> {
                            clientCountries.number
                        }

                        else -> {
                            dataStore.number
                        }
                    },
                    countryCode = clientCountries.countryCode,
                    listOfCountriesCodes = clientCountries.listOfCountriesCodes,
                    city = when (dataStore.city.isBlank()) {
                        true -> {
                            clientCountries.city
                        }

                        else -> {
                            dataStore.city
                        }
                    },
                    aboutUser = when (dataStore.aboutUser.isBlank()) {
                        true -> {
                            clientCountries.aboutUser
                        }

                        else -> {
                            dataStore.aboutUser
                        }
                    },
                    listOfUserTags = clientCountries.listOfUserTags,
                    listOfSocialMedia = clientCountries.listOfSocialMedia,
                    showMyCommunitiesChecked = clientCountries.showMyCommunitiesChecked,
                    showMyEventsChecked = clientCountries.showMyEventsChecked,
                    applyNotificationsChecked = clientCountries.applyNotificationsChecked,
                    client = clientCountries.client
                )
            }
        }.launchIn(viewModelScope)
    }

}