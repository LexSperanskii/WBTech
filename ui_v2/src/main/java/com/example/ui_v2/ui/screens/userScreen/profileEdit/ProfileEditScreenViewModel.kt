package com.example.ui_v2.ui.screens.userScreen.profileEdit

import androidx.lifecycle.ViewModel
import com.example.domain.models.mock.MockData
import com.example.ui_v2.models.CountryModelUI
import com.example.ui_v2.models.SocialMediaModelUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class ProfileEditScreenUiState(
    val avatarURL: String? = "",
    val nameSurname: String = "",
    val isNameSurnameValid: Boolean = true,
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
)

internal class ProfileEditScreenViewModel(
    private val mock: MockData,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileEditScreenUiState())
    private val uiState: StateFlow<ProfileEditScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                listOfCountriesCodes = mock.getAvailableCountriesList(),
                countryCode = mock.getAvailableCountriesList().first()
            )
        }
    }

    fun getProfileEditScreenUiStateFlow(): StateFlow<ProfileEditScreenUiState> = uiState

    fun onNameSurnameChange(nameSurname: String) {
        _uiState.update {
            it.copy(
                nameSurname = nameSurname,
                isNameSurnameValid = nameSurname.isNotBlank() && nameSurname.length > 1
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
        _uiState.update {
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

    fun safeNewSettings() {
        // сделаьб сохранение в мок
    }

}