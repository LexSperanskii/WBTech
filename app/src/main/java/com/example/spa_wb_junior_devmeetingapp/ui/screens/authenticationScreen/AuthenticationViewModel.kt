package com.example.spa_wb_junior_devmeetingapp.ui.screens.authenticationScreen

import androidx.lifecycle.ViewModel
import com.example.domain.models.MockData
import com.example.spa_wb_junior_devmeetingapp.models.CountryModelUI
import com.example.spa_wb_junior_devmeetingapp.models.Mapper
import com.example.spa_wb_junior_devmeetingapp.models.PhoneNumberModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.PHONE_NUMBER_LENGTH
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class AuthenticationScreenUiState(
    val phoneNumber: PhoneNumberModelUI = PhoneNumberModelUI(),
    val country: CountryModelUI = CountryModelUI(),
    val listOfCountries: List<CountryModelUI> = listOf(),
    val isButtonEnabled: Boolean = false
)

class AuthenticationViewModel(
    private val mapper: Mapper,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthenticationScreenUiState())
    private val uiState: StateFlow<AuthenticationScreenUiState> = _uiState.asStateFlow()

    fun getAuthenticationScreenUiStateFlow(): StateFlow<AuthenticationScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                phoneNumber = it.phoneNumber.copy(countryCode = MockData.getAvailableCountries()[0].code),
                country = mapper.mapCountryToCountryModelUI(MockData.getAvailableCountries()[0]),
                listOfCountries = MockData.getAvailableCountries().map { mapper.mapCountryToCountryModelUI(it) }
            )
        }
    }

    fun changeNumber( number : String) {
        _uiState.update {
            it.copy(
                phoneNumber = it.phoneNumber.copy(number = number)
            )
        }
        isButtonActive()
    }

    fun changeCountryCode(country: CountryModelUI) {
        _uiState.update {
            it.copy(
                phoneNumber = it.phoneNumber.copy(countryCode = country.code),
                country = country
            )
        }
        isButtonActive()
    }

    private fun isButtonActive(){
        val phoneNumber = uiState.value.phoneNumber
        _uiState.update {
            it.copy(
                isButtonEnabled = phoneNumber.number.length == PHONE_NUMBER_LENGTH
            )
        }
    }

}