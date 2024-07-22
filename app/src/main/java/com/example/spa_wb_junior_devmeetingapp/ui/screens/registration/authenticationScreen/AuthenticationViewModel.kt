package com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.authenticationScreen

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.user.GetAvailableCountriesListUseCase
import com.example.domain.usecases.user.GetAvailableCountyUseCase
import com.example.domain.usecases.user.SetUserPhoneNumberUseCase
import com.example.spa_wb_junior_devmeetingapp.models.CountryModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.Mapper
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
    private val getAvailableCountriesListUseCase: GetAvailableCountriesListUseCase,
    private val getAvailableCountyUseCase: GetAvailableCountyUseCase,
    private val setUserPhoneNumberUseCase: SetUserPhoneNumberUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthenticationScreenUiState())
    private val uiState: StateFlow<AuthenticationScreenUiState> = _uiState.asStateFlow()

    fun getAuthenticationScreenUiStateFlow(): StateFlow<AuthenticationScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                country = mapper.mapCountryToCountryModelUI(getAvailableCountyUseCase.execute()) ,
                listOfCountries = getAvailableCountriesListUseCase.execute().map { mapper.mapCountryToCountryModelUI(it) },
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
        setUserPhoneNumberUseCase.execute(state.country.code, state.number)
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