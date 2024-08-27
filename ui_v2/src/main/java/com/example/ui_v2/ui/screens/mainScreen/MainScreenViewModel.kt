package com.example.ui_v2.ui.screens.mainScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal data class MainScreenUiState(
    val data: String = "",
)

internal class MainScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenUiState())
    private val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                data = ""
            )
        }
    }

    fun getMainScreenUiStateFlow(): StateFlow<MainScreenUiState> = uiState

}