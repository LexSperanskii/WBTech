package com.example.ui_v2.ui.screens.appointmentScreen.phoneNumber

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.availableCountries.IInteractorGetAvailableCountriesList
import com.example.domain.interactors.availableCountries.IInteractorLoadAvailableCountriesList
import com.example.domain.interactors.eventDescription.IInteractorGetEventDescription
import com.example.domain.interactors.eventDescription.IInteractorLoadEventDescription
import com.example.domain.interactors.oldSuspend.IInteractorSetClientNotVerifiedPhoneNumber
import com.example.ui_v2.models.CountryModelUI
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import com.example.ui_v2.ui.utils.UiUtils.PHONE_NUMBER_LENGTH
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


internal data class AppointmentPhoneNumberScreenUiState(
    val event: EventDescriptionModelUI = EventDescriptionModelUI(),
    val number: String = "",
    val countryCode: CountryModelUI = CountryModelUI(),
    val listOfCountriesCodes: List<CountryModelUI> = listOf(),
) {
    val isButtonEnabled: Boolean
        get() = countryCode.code.isNotBlank() && number.length == PHONE_NUMBER_LENGTH
}

internal class AppointmentPhoneNumberScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val mapper: IMapperDomainUI,
    private val loadEventDescription: IInteractorLoadEventDescription,
    private val getEventDescription: IInteractorGetEventDescription,
    private val loadAvailableCountriesList: IInteractorLoadAvailableCountriesList,
    private val getAvailableCountriesList: IInteractorGetAvailableCountriesList,
    private val setClientNotVerifiedPhoneNumber: IInteractorSetClientNotVerifiedPhoneNumber,
) : ViewModel() {

    private val eventId: String = try {
        checkNotNull(savedStateHandle[AppointmentPhoneNumberScreenDestination.itemIdArg])
    } catch (e: IllegalStateException) {
        throw IllegalArgumentException("Missing appointment ID", e)
    }

    private val _uiState = MutableStateFlow(AppointmentPhoneNumberScreenUiState())
    private val uiState: StateFlow<AppointmentPhoneNumberScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getDataAppointmentPhoneNumberScreenUiState()
        initCountyCode()
    }

    fun getAppointmentPhoneNumberScreenUiStateFlow(): StateFlow<AppointmentPhoneNumberScreenUiState> =
        uiState

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

    fun onButtonClick() {
        val state = uiState.value
        viewModelScope.launch {
            setClientNotVerifiedPhoneNumber.invoke(
                mapper.toCountryModelDomain(state.countryCode),
                state.number
            )
        }
    }

    private fun loadData() {
        loadEventDescription.invoke(eventId)
        loadAvailableCountriesList.invoke()
    }

    private fun getDataAppointmentPhoneNumberScreenUiState() {
        combine(
            getEventDescription.invoke(),
            getAvailableCountriesList.invoke()
        ) { eventDescription, availableCountriesList ->
            _uiState.update { it ->
                it.copy(
                    event = mapper.toEventDescriptionModelUI(eventDescription),
                    listOfCountriesCodes = availableCountriesList.map { mapper.toCountryModelUI(it) },
                )
            }
        }.launchIn(viewModelScope)
    }

    private fun initCountyCode() {
        viewModelScope.launch {
            val availableCountriesList = getAvailableCountriesList.invoke().first()
            val defaultCountryCode =
                availableCountriesList.map { mapper.toCountryModelUI(it) }.first()
            _uiState.update {
                it.copy(
                    countryCode = defaultCountryCode
                )
            }
        }
    }
}