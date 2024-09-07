package com.example.ui_v2.ui.screens.appointmentScreen.nameSurname

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.toEventModelUI
import com.example.ui_v2.ui.utils.NewUIMockData
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal data class AppointmentNameSurnameScreenUiState(
    val event: EventModelUI = EventModelUI(),
    val nameSurnameValue: String = "",
    val isNameSurnameValid: Boolean = true,
) {
    val isButtonEnabled: Boolean
        get() = nameSurnameValue.isNotBlank()
}

internal class AppointmentNameSurnameScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val mock: NewUIMockData,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AppointmentNameSurnameScreenUiState())
    private val uiState: StateFlow<AppointmentNameSurnameScreenUiState> = _uiState.asStateFlow()

    private val eventId: String = try {
        checkNotNull(savedStateHandle[AppointmentDestination.itemIdArg])
    } catch (e: IllegalStateException) {
        // TODO: do state with error
        DEFAULT_ID
    }

    init {
        _uiState.update {
            it.copy(
                event = mock.getEventDescription(eventId).toEventModelUI()
            )
        }
    }

    fun getAppointmentNameSurnameScreenUiStateFlow(): StateFlow<AppointmentNameSurnameScreenUiState> =
        uiState

    fun onNameSurnameChange(inputValue: String) {
        _uiState.update {
            it.copy(
                nameSurnameValue = inputValue
            )
        }
    }

    fun onButtonClick(navigateToAppointmentPhoneNumberScreen: () -> Unit) {
        val parts = uiState.value.nameSurnameValue.split(Regex("\\s+"), limit = 2)
        val name = parts[0]
        val surname = parts.getOrNull(1) ?: ""
        when (surname.isNotBlank()) {
            true -> {
                _uiState.update {
                    it.copy(
                        isNameSurnameValid = true
                    )
                }
                mock.setClientName(name, surname)
                navigateToAppointmentPhoneNumberScreen()
            }

            false -> {
                _uiState.update {
                    it.copy(
                        isNameSurnameValid = false
                    )
                }
            }
        }

    }

}