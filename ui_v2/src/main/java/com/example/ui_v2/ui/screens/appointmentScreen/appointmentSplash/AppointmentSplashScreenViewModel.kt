package com.example.ui_v2.ui.screens.appointmentScreen.appointmentSplash

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.domain.models.mock.NewUIMockData
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.toEventModelUI
import com.example.ui_v2.ui.screens.appointmentScreen.nameSurname.AppointmentDestination
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class AppointmentSplashScreenUiState(
    val event: EventModelUI = EventModelUI(),
)

internal class AppointmentSplashScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val mock: NewUIMockData,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AppointmentSplashScreenUiState())
    private val uiState: StateFlow<AppointmentSplashScreenUiState> = _uiState.asStateFlow()

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

    fun getAppointmentSplashScreenUiStateFlow(): StateFlow<AppointmentSplashScreenUiState> = uiState

}