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
    val country: CountryModelUI = CountryModelUI(),
    val listOfCountries: List<CountryModelUI> = listOf(),
    val number: String = "",
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
                country = mapper.mapCountryToCountryModelUI(MockData.getAvailableCountries()[0]),
                listOfCountries = MockData.getAvailableCountries().map { mapper.mapCountryToCountryModelUI(it) },
            )
        }
    }

    fun changeNumber(number : String) {
        _uiState.update {
            it.copy(
                number = number
            )
        }
        isButtonActive()
    }

    fun changeCountryCode(country: CountryModelUI) {
        _uiState.update {
            it.copy(
                country = country,
            )
        }
        isButtonActive()
    }

    fun onForwardButtonClick(){
        val state = uiState.value
        MockData.setUserPhoneNumber(state.country.code, state.number)
    }

    private fun isButtonActive(){
        val number = uiState.value.number
        _uiState.update {
            it.copy(
                isButtonEnabled = number.length == PHONE_NUMBER_LENGTH
            )
        }
    }

}