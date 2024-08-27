package com.example.ui_v2.ui.screens.onboarding.locationScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class LocationScreenUiState(
    val location: String = "",
)

internal class LocationScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(LocationScreenUiState())
    private val uiState: StateFlow<LocationScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                location = "111111.266,121651.5165"
            )
        }
    }

    fun getLocationScreenUiStateFlow(): StateFlow<LocationScreenUiState> = uiState

}