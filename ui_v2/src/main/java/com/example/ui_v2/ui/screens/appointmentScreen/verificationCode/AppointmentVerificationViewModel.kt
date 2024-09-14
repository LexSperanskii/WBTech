package com.example.ui_v2.ui.screens.appointmentScreen.verificationCode

import androidx.core.text.isDigitsOnly
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.mock.MockData
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.PhoneNumberModelUI
import com.example.ui_v2.models.toEventModelUI
import com.example.ui_v2.ui.screens.appointmentScreen.nameSurname.AppointmentDestination
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_ID
import com.example.ui_v2.ui.utils.UiUtils.PIN_CODE_LENGTH
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


internal data class AppointmentVerificationScreenUiState(
    val event: EventModelUI = EventModelUI(),
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
    private val mock: MockData,
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
        _uiState.update {
            it.copy(
                event = mock.getEventDescription(eventId).toEventModelUI(),
                phoneNumber = mock.getClientPhoneNumber()
            )
        }
        startCountdown()
    }

    private fun startCountdown() {
        viewModelScope.launch {
            var countdown = 10
            while (countdown > 0) {
                delay(1000L)
                _uiState.update {
                    it.copy(
                        countdown = countdown
                    )
                }
                countdown--
            }
            _uiState.update {
                it.copy(
                    countdown = countdown,
                    isCountdownEnabled = true
                )
            }
        }
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

    fun onButtonClick(navigate: () -> Unit) {
        when (mock.setClientPinCode(uiState.value.pinCode)) {
            true -> {
                _uiState.update {
                    it.copy(
                        isPinCodeValid = true
                    )
                }
                navigate()
            }

            false -> {
                _uiState.update {
                    it.copy(
                        isPinCodeValid = false
                    )
                }
            }
        }

    }
}