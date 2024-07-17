package com.example.spa_wb_junior_devmeetingapp.ui.screens.authenticationScreen

import androidx.lifecycle.ViewModel
import com.example.spa_wb_junior_devmeetingapp.data.mockData.mockCountryList
import com.example.spa_wb_junior_devmeetingapp.model.Country
import com.example.spa_wb_junior_devmeetingapp.model.PhoneNumber
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.PHONE_NUMBER_LENGTH
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class AuthenticationScreenUiState(
    val phoneNumber: PhoneNumber = PhoneNumber(),
    val country: Country = Country(),
    val listOfCountries: List<Country> = listOf(),
    val isButtonActive: Boolean = false
)

class AuthenticationViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(AuthenticationScreenUiState())
    private val uiState: StateFlow<AuthenticationScreenUiState> = _uiState.asStateFlow()

    fun getAuthenticationScreenUiStateFlow(): StateFlow<AuthenticationScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                phoneNumber = it.phoneNumber.copy(countryCode = mockCountryList[0].countryCode),
                country = mockCountryList[0],
                listOfCountries = mockCountryList
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

    fun changeCountryCode(country: Country) {
        _uiState.update {
            it.copy(
                phoneNumber = it.phoneNumber.copy(countryCode = country.countryCode),
                country = country
            )
        }
        isButtonActive()
    }

    private fun isButtonActive(){
        val phoneNumber = uiState.value.phoneNumber
        val isButtonActive = phoneNumber.countryCode.isNotBlank() && phoneNumber.number.isNotBlank() && phoneNumber.number.length == PHONE_NUMBER_LENGTH
        _uiState.update {
            it.copy(
                isButtonActive = isButtonActive
            )
        }
    }

}