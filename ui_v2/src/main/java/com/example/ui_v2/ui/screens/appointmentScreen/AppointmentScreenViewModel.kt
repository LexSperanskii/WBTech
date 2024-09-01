package com.example.ui_v2.ui.screens.appointmentScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class AppointmentScreenUiState(
    val data: String = "",
)

internal class AppointmentScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(AppointmentScreenUiState())
    private val uiState: StateFlow<AppointmentScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                data = ""
            )
        }
    }

    fun getAppointmentScreenUiStateFlow(): StateFlow<AppointmentScreenUiState> = uiState

}