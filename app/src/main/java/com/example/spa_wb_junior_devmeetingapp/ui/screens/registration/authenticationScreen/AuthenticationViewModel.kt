package com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.authenticationScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.user.GetAvailableCountriesListUseCase
import com.example.domain.usecases.user.SetUserPhoneNumberUseCase
import com.example.spa_wb_junior_devmeetingapp.models.CountryModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toCountryModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.PHONE_NUMBER_LENGTH
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class AuthenticationScreenUiState(
    val country: CountryModelUI = CountryModelUI(),
    val listOfCountries: List<CountryModelUI> = listOf(),
    val number: String = "",
){
    val isButtonEnabled: Boolean
        get() = number.length == PHONE_NUMBER_LENGTH
}

class AuthenticationViewModel(
    private val getAvailableCountriesListUseCase: GetAvailableCountriesListUseCase,
    private val setUserPhoneNumberUseCase: SetUserPhoneNumberUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthenticationScreenUiState())
    private val uiState: StateFlow<AuthenticationScreenUiState> = _uiState.asStateFlow()

    fun getAuthenticationScreenUiStateFlow(): StateFlow<AuthenticationScreenUiState> = uiState

    init {
        getAvailableCountriesList()
    }

    private fun getAvailableCountriesList() {
        viewModelScope.launch {
            getAvailableCountriesListUseCase.execute()
                .collect { availableCountriesList ->
                    _uiState.update {
                        it.copy(
                            country = availableCountriesList.first().toCountryModelUI(),
                            listOfCountries = availableCountriesList.map { it.toCountryModelUI() }
                        )
                    }
                }
        }
    }

    fun changeNumber(number : String) {
        _uiState.update {
            it.copy(
                number = number
            )
        }
    }

    fun changeCountryCode(country: CountryModelUI) {
        _uiState.update {
            it.copy(
                country = country,
            )
        }
    }

    fun onForwardButtonClick(){
        val state = uiState.value
        viewModelScope.launch {
            setUserPhoneNumberUseCase.execute(state.country.code, state.number)
        }
    }
}