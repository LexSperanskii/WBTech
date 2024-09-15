package com.example.ui_v2.ui.screens.appointmentScreen.phoneNumber

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.ui_v2.models.CountryModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import com.example.ui_v2.models.toEventModelUI
import com.example.ui_v2.ui.screens.appointmentScreen.nameSurname.AppointmentDestination
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_ID
import com.example.ui_v2.ui.utils.UiUtils.PHONE_NUMBER_LENGTH
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class AppointmentPhoneNumberScreenUiState(
    val event: EventModelUI = EventModelUI(),
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
) : ViewModel() {

    private val _uiState = MutableStateFlow(AppointmentPhoneNumberScreenUiState())
    private val uiState: StateFlow<AppointmentPhoneNumberScreenUiState> = _uiState.asStateFlow()

    private val eventId: String = try {
        checkNotNull(savedStateHandle[AppointmentDestination.itemIdArg])
    } catch (e: IllegalStateException) {
        // TODO: do state with error
        DEFAULT_ID
    }

    init {
        _uiState.update {
            it.copy(
                event = mock.getEventDescription(eventId).toEventModelUI(),
                listOfCountriesCodes = mock.getAvailableCountriesList(),
                countryCode = mock.getAvailableCountriesList().first()
            )
        }
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
        val uiState = uiState.value
        mock.setClientPhoneNumber(uiState.countryCode.code, uiState.number)
    }
}