package com.example.ui_v2.ui.screens.appointmentScreen.verificationCode

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.client.IInteractorGetClientPhoneNumber
import com.example.domain.interactors.client.IInteractorGetClientPinCodeVerification
import com.example.domain.interactors.client.IInteractorLoadClientPinCodeVerification
import com.example.domain.interactors.eventDescription.IInteractorGetEventDescription
import com.example.domain.interactors.eventDescription.IInteractorLoadEventDescription
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.models.PhoneNumberModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import com.example.ui_v2.ui.screens.appointmentScreen.nameSurname.AppointmentDestination
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_ID
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
    val isPinCodeValid: Boolean = true,
    val phoneNumber: PhoneNumberModelUI = PhoneNumberModelUI(),
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
    private val getClientPhoneNumber: IInteractorGetClientPhoneNumber,
    private val loadClientPinCodeVerification: IInteractorLoadClientPinCodeVerification,
    private val getClientPinCodeVerification: IInteractorGetClientPinCodeVerification,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AppointmentVerificationScreenUiState())
    private val uiState: StateFlow<AppointmentVerificationScreenUiState> = _uiState.asStateFlow()

    private val eventId: String = try {
        checkNotNull(savedStateHandle[AppointmentDestination.itemIdArg])
    } catch (e: IllegalStateException) {
        // TODO: do state with error
        DEFAULT_ID
    }

    init {
        loadData()
        getDataAppointmentVerificationScreenUiState()
        initClientPhoneNumber()
        startCountdown()
    }

    fun getAppointmentVerificationScreenUiStateFlow(): StateFlow<AppointmentVerificationScreenUiState> =
        uiState

    fun onCountdownClick() {
        _uiState.update {
            it.copy(
                isCountdownEnabled = false
            )
        }
        startCountdown()
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
                }
            )
        }
    }

    fun onButtonClick() {
        val pinCode = uiState.value.pinCode
        loadClientPinCodeVerification.invoke(pinCode)
    }

    private fun loadData() {
//        loadEventDescription.invoke(eventId)
    }

    private fun getDataAppointmentVerificationScreenUiState() {
        combine(
            getEventDescription.invoke(),
            getClientPinCodeVerification.invoke()
        ) { eventDescription, pinCodeVerification ->
            _uiState.update {
                it.copy(
                    event = mapper.toEventDescriptionModelUI(eventDescription),
                    isPinCodeValid = pinCodeVerification
                )
            }
        }.launchIn(viewModelScope)
    }

    private fun initClientPhoneNumber() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    phoneNumber = mapper.toPhoneNumberModelUI(getClientPhoneNumber.invoke())
                )
            }
        }
    }

    //    private fun startCountdown() {
//        viewModelScope.launch {
//            var countdown = 10
//            while (countdown > 0) {
//                delay(1000L)
//                _uiState.update {
//                    it.copy(
//                        countdown = countdown
//                    )
//                }
//                countdown--
//            }
//            _uiState.update {
//                it.copy(
//                    countdown = countdown,
//                    isCountdownEnabled = true
//                )
//            }
//        }
//    }
    private fun startCountdown() {
        viewModelScope.launch {
            while (uiState.value.countdown > 0) {
                delay(1000L)
                _uiState.update {
                    it.copy(
                        countdown = it.countdown - 1
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
}