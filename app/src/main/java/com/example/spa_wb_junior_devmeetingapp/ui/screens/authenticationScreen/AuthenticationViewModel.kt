package com.example.spa_wb_junior_devmeetingapp.ui.screens.authenticationScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class AuthenticationScreenUiState(
    val accountName : String = "",
)

class AuthenticationViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(AuthenticationScreenUiState())
    private val uiState: StateFlow<AuthenticationScreenUiState> = _uiState.asStateFlow()

    fun getUiStateFlow(): StateFlow<AuthenticationScreenUiState> = uiState

}