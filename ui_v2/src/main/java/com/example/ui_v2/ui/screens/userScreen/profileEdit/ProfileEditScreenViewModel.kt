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
import com.example.domain.models.ClientCashModelDomain
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
                    imageURL = uiState.avatarURL,
                    nameSurname = uiState.nameSurname,
                    phoneNumber = PhoneNumberModelUI(
                        uiState.countryCode,
                        uiState.number
                    ),
                    city = uiState.city,
                    description = uiState.aboutUser,
                    listOfClientTags = uiState.listOfUserTags,
                    listOfClientSocialMedia = uiState.listOfSocialMedia,
                    isShowMyCommunities = uiState.showMyCommunitiesChecked,
                    showMyEventsChecked = uiState.showMyEventsChecked,
                    applyNotificationsChecked = uiState.applyNotificationsChecked
                )
            )
        )
    }

    fun clearCash() {
        saveClientCash.invoke(ClientCashModelDomain())
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
                    nameSurname = when (getCash.nameSurname.isNotBlank()) {
                        true -> {
                            getCash.nameSurname
                        }

                        false -> {
                            client.nameSurname
                        }
                    },
                    number = when (getCash.phoneNumber.number.isNotBlank()) {
                        true -> {
                            getCash.phoneNumber.number
                        }

                        false -> {
                            client.phoneNumber.number
                        }
                    },
                    countryCode = when (getCash.phoneNumber.country.code.isNotBlank()) {
                        true -> {
                            mapper.toCountryModelUI(getCash.phoneNumber.country)
                        }

                        false -> {
                            mapper.toCountryModelUI(client.phoneNumber.country)
                        }
                    },
                    listOfCountriesCodes = availableCountriesList.map { mapper.toCountryModelUI(it) },
                    city = when (getCash.city.isNotBlank()) {
                        true -> {
                            getCash.city
                        }

                        false -> {
                            client.city
                        }
                    },
                    aboutUser = when (getCash.description.isNotBlank()) {
                        true -> {
                            getCash.description
                        }

                        false -> {
                            client.description
                        }
                    },
                    listOfUserTags = client.listOfClientTags,
                    listOfSocialMedia = when (getCash.listOfClientSocialMedia.isNotEmpty()) {
                        true -> {
                            getCash.listOfClientSocialMedia.map {
                                mapper.toSocialMediaModelUI(
                                    it
                                )
                            }
                        }

                        false -> {
                            client.listOfClientSocialMedia.map {
                                mapper.toSocialMediaModelUI(
                                    it
                                )
                            }
                        }
                    },
                    showMyCommunitiesChecked = client.isShowMyCommunities,
                    showMyEventsChecked = client.showMyEventsChecked,
                    applyNotificationsChecked = client.applyNotificationsChecked,
                    client = mapper.toClientModelUI(client)
                )
            }
        }.launchIn(viewModelScope)
    }

}

//internal data class ProfileEditScreenUiState(
//    val listOfCountriesCodes: List<CountryModelUI> = listOf(),
//    val client: ClientModelUI = ClientModelUI(),
//    val clientCash: ClientCashModelUI = ClientCashModelUI(),
//    val isCityValid: Boolean = true,
//    val isAboutUserValid: Boolean = true,
//) {
//    val isNumberValid: Boolean
//        get() = clientCash.phoneNumber.number.length == PHONE_NUMBER_LENGTH
//    val isCountryCodeValid: Boolean
//        get() = clientCash.phoneNumber.country.code.isNotBlank()
//    val isNameSurnameValid: Boolean
//        get() = clientCash.nameSurname.isNotBlank() && clientCash.nameSurname.length > 1
//}
//
//internal class ProfileEditScreenViewModel(
//    private val mapper: IMapperDomainUI,
//    private val loadClient: IInteractorLoadClient,
//    private val getClient: IInteractorGetClient,
//    private val loadAvailableCountriesList: IInteractorLoadAvailableCountriesList,
//    private val getAvailableCountriesList: IInteractorGetAvailableCountriesList,
//    private val saveClientSettings: IInteractorSaveClientSettings,
//    private val getClientCash: IInteractorGetClientCash,
//    private val saveClientCash: IInteractorSaveClientCash,
//) : ViewModel() {
//
//    private val _uiState = MutableStateFlow(ProfileEditScreenUiState())
//    private val uiState: StateFlow<ProfileEditScreenUiState> = _uiState.asStateFlow()
//
//    init {
//        loadData()
//        getDataUserOutsideScreenUiState()
//    }
//
//    fun getProfileEditScreenUiStateFlow(): StateFlow<ProfileEditScreenUiState> = uiState
//
//    fun onNameSurnameChange(nameSurname: String) {
//        val clientCash = uiState.value.clientCash
//        saveClientCash.invoke(
//            mapper.toClientCashModelDomain(
//                clientCash.copy(nameSurname = nameSurname)
//            )
//        )
//    }
//
//    fun onNumberChange(number: String) {
//        val clientCash = uiState.value.clientCash
//        saveClientCash.invoke(
//            mapper.toClientCashModelDomain(
//                clientCash.copy(phoneNumber = clientCash.phoneNumber.copy(number = number))
//            )
//        )
//    }
//
//    fun onCountryCodeChange(countryCode: CountryModelUI) {
//        val clientCash = uiState.value.clientCash
//        saveClientCash.invoke(
//            mapper.toClientCashModelDomain(
//                clientCash.copy(phoneNumber = clientCash.phoneNumber.copy(country = countryCode))
//            )
//        )
//    }
//
//    fun onCityChange(city: String) {
//        val clientCash = uiState.value.clientCash
//        saveClientCash.invoke(
//            mapper.toClientCashModelDomain(
//                clientCash.copy(city = city)
//            )
//        )
//    }
//
//    fun onAboutUserChange(aboutUser: String) {
//        val clientCash = uiState.value.clientCash
//        saveClientCash.invoke(
//            mapper.toClientCashModelDomain(
//                clientCash.copy(description = aboutUser)
//            )
//        )
//    }
//
//    fun onSocialNetworkValueChange(socialMediaID: String, value: String) {
//        val clientCash = uiState.value.clientCash
//        saveClientCash.invoke(
//            mapper.toClientCashModelDomain(
//                clientCash.copy(listOfClientSocialMedia = clientCash.listOfClientSocialMedia.map { socialMedia ->
//                    if (socialMedia.socialMediaId == socialMediaID) {
//                        socialMedia.copy(userNickname = value)
//                    } else {
//                        socialMedia
//                    }
//                })
//            )
//        )
//    }
//
//    fun onAddSocialNetworkClick() {
//        val clientCash = uiState.value.clientCash
//        saveClientCash.invoke(
//            mapper.toClientCashModelDomain(
//                clientCash.copy(
//                    listOfClientSocialMedia = clientCash.listOfClientSocialMedia + SocialMediaModelUI(
//                        socialMediaId = UUID.randomUUID().toString()
//                    )
//                )
//            )
//        )
//    }
//
//    fun onShowMyCommunitiesChange(toggle: Boolean) {
//        val clientCash = uiState.value.clientCash
//        saveClientCash.invoke(
//            mapper.toClientCashModelDomain(
//                clientCash.copy(isShowMyCommunities = toggle)
//            )
//        )
//    }
//
//    fun onShowMyEventsChange(toggle: Boolean) {
//        val clientCash = uiState.value.clientCash
//        saveClientCash.invoke(
//            mapper.toClientCashModelDomain(
//                clientCash.copy(showMyEventsChecked = toggle)
//            )
//        )
//    }
//
//    fun onApplyNotificationsChange(toggle: Boolean) {
//        val clientCash = uiState.value.clientCash
//        saveClientCash.invoke(
//            mapper.toClientCashModelDomain(
//                clientCash.copy(applyNotificationsChecked = toggle)
//            )
//        )
//    }
//
//    fun saveNewSettings() {
//        val clientCash = uiState.value.clientCash
//        saveClientSettings.invoke(
//            mapper.toClientModelDomain(
//                ClientModelUI(
//                    nameSurname = clientCash.nameSurname,
//                    phoneNumber = clientCash.phoneNumber,
//                    city = clientCash.city,
//                    description = clientCash.description,
//                    listOfSocialMedia = clientCash.listOfClientSocialMedia,
//                    isShowMyCommunities = clientCash.isShowMyCommunities,
//                    showMyEventsChecked = clientCash.showMyEventsChecked,
//                    applyNotificationsChecked = clientCash.applyNotificationsChecked
//                )
//            )
//        )
//    }
//
//    private fun loadData() {
//        loadClient.invoke()
//        loadAvailableCountriesList.invoke()
//    }
//
//    private fun getDataUserOutsideScreenUiState() {
//        val combineClientCashFlow = combine(
//            getClientCash.invoke(),
//            getClient.invoke()
//        ) { clientCash, client ->
//            clientCash.copy(
//                imageURL = client.imageURL,
//                nameSurname = client.nameSurname,
//                phoneNumber = client.phoneNumber,
//                city = client.city,
//                description = client.description,
//                listOfClientTags = clientCash.listOfClientTags,
//                listOfClientSocialMedia = client.listOfClientSocialMedia,
//                isShowMyCommunities = client.isShowMyCommunities,
//                showMyEventsChecked = client.showMyEventsChecked,
//                applyNotificationsChecked = client.applyNotificationsChecked
//            )
//        }
//        combine(
//            getAvailableCountriesList.invoke(),
//            getClient.invoke(),
//            getClientCash.invoke()
//        ) { availableCountriesList, client, clientCash ->
//            _uiState.update {
//                it.copy(
//                    listOfCountriesCodes = availableCountriesList.map { mapper.toCountryModelUI(it) },
//                    clientCash = mapper.toClientCashModelUI(clientCash),
//                    client = mapper.toClientModelUI(client)
//                )
//            }
//        }.launchIn(viewModelScope)
//    }
//}