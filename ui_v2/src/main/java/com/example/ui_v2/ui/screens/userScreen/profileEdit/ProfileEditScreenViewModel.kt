package com.example.ui_v2.ui.screens.userScreen.profileEdit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.availableCountries.IInteractorGetAvailableCountriesList
import com.example.domain.interactors.availableCountries.IInteractorLoadAvailableCountriesList
import com.example.domain.interactors.client.IInteractorGetClient
import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.interactors.listOfTags.IInteractorGetListOfTags
import com.example.domain.interactors.listOfTags.IInteractorLoadListOfTags
import com.example.domain.interactors.oldSuspend.IInteractorSaveClientSettings
import com.example.ui_v2.models.ClientModelUI
import com.example.ui_v2.models.CountryModelUI
import com.example.ui_v2.models.PhoneNumberModelUI
import com.example.ui_v2.models.SocialMediaModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import com.example.ui_v2.ui.utils.UiUtils.PHONE_NUMBER_LENGTH
import com.example.ui_v2.ui.utils.UiUtils.listOfIconsMOCK
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import java.util.UUID

enum class SCREENS {
    MAIN_EDIT,
    EDIT_AVATAR,
    EDIT_INTERESTS
}

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
    val currentScreen: SCREENS = SCREENS.MAIN_EDIT,
    val isButtonSaveForAvatarScreenEnabled: Boolean = true,
    val listOfTags: List<String> = listOf(),
) {
    val isNumberValid: Boolean
        get() = number.length == PHONE_NUMBER_LENGTH
    val isCountryCodeValid: Boolean
        get() = countryCode.code.isNotBlank()
    val isNameSurnameValid: Boolean
        get() = nameSurname.isNotBlank() && nameSurname.length > 1
    val isButtonForInterestsScreenEnabled: Boolean
        get() = listOfUserTags.isNotEmpty()
}

internal class ProfileEditScreenViewModel(
    private val mapper: IMapperDomainUI,
    private val loadClient: IInteractorLoadClient,
    private val getClient: IInteractorGetClient,
    private val loadAvailableCountriesList: IInteractorLoadAvailableCountriesList,
    private val getAvailableCountriesList: IInteractorGetAvailableCountriesList,
    private val loadListOfTags: IInteractorLoadListOfTags,
    private val getListOfTags: IInteractorGetListOfTags,
    private val saveClientSettings: IInteractorSaveClientSettings,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileEditScreenUiState())
    private val uiState: StateFlow<ProfileEditScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getDataUserOutsideScreenUiState()
    }

    fun getProfileEditScreenUiStateFlow(): StateFlow<ProfileEditScreenUiState> = uiState


    fun showAvatarScreen() {
        _uiState.update {
            it.copy(
                currentScreen = SCREENS.EDIT_AVATAR
            )
        }
    }

    fun showInterestsScreen() {
        _uiState.update {
            it.copy(
                currentScreen = SCREENS.EDIT_INTERESTS
            )
        }
    }

    fun showMainEditScreen() {
        _uiState.update {
            it.copy(
                currentScreen = SCREENS.MAIN_EDIT
            )
        }
    }

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

    fun onChangePhotoClick() {
        //TODO: исправить этот мок и удалить из utils
        _uiState.update {
            it.copy(
                avatarURL = listOfIconsMOCK.random()
            )
        }
    }

    fun dumpAvatar() {
        _uiState.update {
            it.copy(
                avatarURL = ""
            )
        }
    }

    fun onTagClick(tag: String) {
        when (uiState.value.listOfUserTags.contains(tag)) {
            true -> {
                _uiState.update {
                    it.copy(
                        listOfUserTags = it.listOfUserTags - tag
                    )
                }
            }

            false -> {
                _uiState.update {
                    it.copy(
                        listOfUserTags = it.listOfUserTags + tag
                    )
                }
            }
        }
    }

    fun saveNewSettings() {
        val uiState = uiState.value
        saveClientSettings.invoke(
            avatar = uiState.avatarURL,
            nameSurname = uiState.nameSurname,
            phoneNumber = mapper.toPhoneNumberModelDomain(
                PhoneNumberModelUI(
                    uiState.countryCode,
                    uiState.number
                )
            ),
            city = uiState.city,
            description = uiState.aboutUser,
            listOfClientTags = uiState.listOfUserTags,
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
    }


    private fun loadData() {
        loadClient.invoke()
        loadAvailableCountriesList.invoke()
        loadListOfTags.invoke()
    }

    private fun getDataUserOutsideScreenUiState() {
        combine(
            getClient.invoke(),
            getAvailableCountriesList.invoke(),
            getListOfTags.invoke()
        ) { client, availableCountriesList, listOfTags ->
            _uiState.update {
                it.copy(
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
                    client = mapper.toClientModelUI(client),
                    listOfTags = listOfTags
                )
            }
        }.launchIn(viewModelScope)
    }

}