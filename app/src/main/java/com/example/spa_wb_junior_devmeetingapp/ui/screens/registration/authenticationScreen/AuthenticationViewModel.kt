package com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.authenticationScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.user.GetAvailableCountriesListUseCase
import com.example.domain.usecases.user.SetUserPhoneNumberUseCase
import com.example.spa_wb_junior_devmeetingapp.models.CountryModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.IMapperDomainUI
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.PHONE_NUMBER_LENGTH
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal data class AuthenticationScreenUiState(
    val country: CountryModelUI = CountryModelUI(),
    val listOfCountries: List<CountryModelUI> = listOf(),
    val number: String = "",
) {
    val isButtonEnabled: Boolean
        get() = number.length == PHONE_NUMBER_LENGTH
}

internal class AuthenticationViewModel(
    private val mapper: IMapperDomainUI,
    private val getAvailableCountriesListUseCase: GetAvailableCountriesListUseCase,
    private val setUserPhoneNumberUseCase: SetUserPhoneNumberUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AuthenticationScreenUiState())
    private val uiState: StateFlow<AuthenticationScreenUiState> = _uiState.asStateFlow()

    init {
        getAvailableCountriesList()
    }

    fun getAuthenticationScreenUiStateFlow(): StateFlow<AuthenticationScreenUiState> = uiState

    fun changeNumber(number: String) {
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

    fun onForwardButtonClick() {
        val state = uiState.value
        viewModelScope.launch {
            setUserPhoneNumberUseCase.execute(state.country.code, state.number)
        }
    }

    private fun getAvailableCountriesList() {
        getAvailableCountriesListUseCase.execute()
            .onEach { availableCountriesList ->
                _uiState.update {
                    it.copy(
                        country = mapper.toCountryModelUI(availableCountriesList.first()),
                        listOfCountries = availableCountriesList.map { mapper.toCountryModelUI(it) }
                    )
                }
            }.launchIn(viewModelScope)
    }
}