package com.example.ui_v2.ui.screens.onboarding.locationScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class LocationScreenUiState(
    val latitude: Double = 0.0,
    val longitude: Double = 0.0,
)

internal class LocationScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LocationScreenUiState())
    private val uiState: StateFlow<LocationScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                latitude = 59.934997,
                longitude = 30.330624
            )
        }
    }

    fun getLocationScreenUiStateFlow(): StateFlow<LocationScreenUiState> = uiState

}