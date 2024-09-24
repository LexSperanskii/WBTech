package com.example.ui_v2.ui.screens.appointmentScreen.verificationCode

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.client.IInteractorGetClientPinCodeVerification
import com.example.domain.interactors.client.IInteractorLoadClientPinCodeVerification
import com.example.domain.interactors.eventDescription.IInteractorGetEventDescription
import com.example.domain.interactors.eventDescription.IInteractorLoadEventDescription
import com.example.domain.interactors.oldSuspend.IInteractorGetClientNotVerifiedName
import com.example.domain.interactors.oldSuspend.IInteractorGetClientNotVerifiedPhoneNumber
import com.example.domain.interactors.oldSuspend.IInteractorSetClientName
import com.example.domain.interactors.oldSuspend.IInteractorSetClientPhoneNumber
import com.example.domain.interactors.oldSuspend.myEvents.IInteractorAddToMyEvents
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.models.PhoneNumberModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import com.example.ui_v2.ui.screens.appointmentScreen.nameSurname.AppointmentDestination
import com.example.ui_v2.ui.utils.UiUtils.PIN_CODE_LENGTH
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


internal data class AppointmentVerificationScreenUiState(
    val event: EventDescriptionModelUI = EventDescriptionModelUI(),
    val pinCode: String = "",
    val isPinCodeValid: Boolean = false,
    val isPinCodeFieldStateValid: Boolean = true,
    val clientPhoneNumber: PhoneNumberModelUI = PhoneNumberModelUI(),
    val clientNameSurname: String = "",
    val countdown: Int = 10,
    val isCountdownEnabled: Boolean = false,
) {
    val isButtonEnabled: Boolean
        get() = pinCode.isNotBlank() && pinCode.length == PIN_CODE_LENGTH
}

internal class AppointmentVerificationScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val mapper: IMapperDomainUI,
    private val loadEventDescription: IInteractorLoadEventDescription,
    private val getEventDescription: IInteractorGetEventDescription,
    private val loadClientPinCodeVerification: IInteractorLoadClientPinCodeVerification,
    private val getClientPinCodeVerification: IInteractorGetClientPinCodeVerification,
    private val getClientNotVerifiedPhoneNumber: IInteractorGetClientNotVerifiedPhoneNumber,
    private val getClientNotVerifiedName: IInteractorGetClientNotVerifiedName,
    private val setClientName: IInteractorSetClientName,
    private val setClientPhoneNumber: IInteractorSetClientPhoneNumber,
    private val addToMyEvents: IInteractorAddToMyEvents,
) : ViewModel() {

    private val eventId: String = try {
        checkNotNull(savedStateHandle[AppointmentDestination.itemIdArg])
    } catch (e: IllegalStateException) {
        throw IllegalArgumentException("Missing appointment ID", e)
    }

    private val _uiState = MutableStateFlow(AppointmentVerificationScreenUiState())
    private val uiState: StateFlow<AppointmentVerificationScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getDataAppointmentVerificationScreenUiState()
        startCountdown()
    }

    fun getAppointmentVerificationScreenUiStateFlow(): StateFlow<AppointmentVerificationScreenUiState> =
        uiState

    fun startCountdown() {
        viewModelScope.launch {
            while (uiState.value.countdown > 0) {
                delay(1000L)
                _uiState.update {
                    it.copy(
                        countdown = it.countdown - 1,
                        isCountdownEnabled = false
                    )
                }
            }
            _uiState.update {
                it.copy(
                    countdown = 10,
                    isCountdownEnabled = true
                )
            }
        }
    }

    fun onPinCodeChange(pinCode: String) {
        _uiState.update {
            it.copy(
                pinCode = when (pinCode.isDigitsOnly() && pinCode.length <= PIN_CODE_LENGTH) {
                    true -> {
                        pinCode
                    }

                    else -> {
                        it.pinCode
                    }
                },
                isPinCodeFieldStateValid = true
            )
        }
    }

    fun onButtonClick() {
        loadClientPinCodeVerification.invoke(uiState.value.pinCode)
        _uiState.update {
            it.copy(
                isPinCodeFieldStateValid = it.isPinCodeValid
            )
        }
    }

    fun setVerifiedClientNameAndPhoneNumber() {
        val state = uiState.value
        setClientName.invoke(state.clientNameSurname).launchIn(viewModelScope)
        setClientPhoneNumber.invoke(
            mapper.toCountryModelDomain(state.clientPhoneNumber.country),
            state.clientPhoneNumber.number
        ).launchIn(viewModelScope)
        addToMyEvents.invoke(state.event.id).launchIn(viewModelScope)
    }

    private fun loadData() {
        loadEventDescription.invoke(eventId)
    }

    private fun getDataAppointmentVerificationScreenUiState() {
        combine(
            getEventDescription.invoke(),
            getClientPinCodeVerification.invoke(),
            getClientNotVerifiedPhoneNumber.invoke(),
            getClientNotVerifiedName.invoke()
        ) { eventDescription, pinCodeVerification, clientNotVerifiedPhoneNumber, clientNotVerifiedName ->
            _uiState.update {
                it.copy(
                    event = mapper.toEventDescriptionModelUI(eventDescription),
                    isPinCodeValid = pinCodeVerification,
                    clientPhoneNumber = mapper.toPhoneNumberModelUI(clientNotVerifiedPhoneNumber),
                    clientNameSurname = clientNotVerifiedName
                )
            }
        }.launchIn(viewModelScope)
    }

}