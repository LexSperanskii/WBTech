package com.example.ui_v1.ui.registration.authenticationScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.user.Uiv1GetAvailableCountriesListUseCase
import com.example.domain.usecase.user.Uiv1SetUserPhoneNumberUseCase
import com.example.ui_v1.models.UIv1CountryModelUI
import com.example.ui_v1.models.mapper.UIv1IMapperDomainUI
import com.example.ui_v1.utils.UIv1UiUtils.PHONE_NUMBER_LENGTH
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal data class AuthenticationScreenUiState(
    val country: UIv1CountryModelUI = UIv1CountryModelUI(),
    val listOfCountries: List<UIv1CountryModelUI> = listOf(),
    val number: String = "",
) {
    val isButtonEnabled: Boolean
        get() = number.length == PHONE_NUMBER_LENGTH
}

internal class AuthenticationViewModel(
    private val mapper: UIv1IMapperDomainUI,
    private val uiv1GetAvailableCountriesListUseCase: Uiv1GetAvailableCountriesListUseCase,
    private val uiv1SetUserPhoneNumberUseCase: Uiv1SetUserPhoneNumberUseCase,
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

    fun changeCountryCode(country: UIv1CountryModelUI) {
        _uiState.update {
            it.copy(
                country = country,
            )
        }
    }

    fun onForwardButtonClick() {
        val state = uiState.value
        viewModelScope.launch {
            uiv1SetUserPhoneNumberUseCase.execute(state.country.code, state.number)
        }
    }

    private fun getAvailableCountriesList() {
        uiv1GetAvailableCountriesListUseCase.execute()
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