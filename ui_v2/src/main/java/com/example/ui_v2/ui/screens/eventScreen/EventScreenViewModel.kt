package com.example.ui_v2.ui.screens.eventScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class EventScreenUiState(
    val data: String = "",
)

internal class EventScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(EventScreenUiState())
    private val uiState: StateFlow<EventScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                data = ""
            )
        }
    }

    fun getEventScreenUiStateFlow(): StateFlow<EventScreenUiState> = uiState

}