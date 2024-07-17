package com.example.spa_wb_junior_devmeetingapp.ui.screens.menuScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class MenuScreenUiState(
    val mock : String = "",
)

class MenuViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(MenuScreenUiState())
    private val uiState: StateFlow<MenuScreenUiState> = _uiState.asStateFlow()

    fun getMenuScreenUiStateFlow(): StateFlow<MenuScreenUiState> = uiState
}