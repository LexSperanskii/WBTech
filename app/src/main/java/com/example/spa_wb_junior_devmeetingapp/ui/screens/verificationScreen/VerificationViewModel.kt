package com.example.spa_wb_junior_devmeetingapp.ui.screens.verificationScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow


data class VerificationScreenUiState(
    val mock: String = "",
)

class VerificationViewModel() : ViewModel() {

    private val _uiState = MutableStateFlow(VerificationScreenUiState())
    private val uiState: StateFlow<VerificationScreenUiState> = _uiState.asStateFlow()

    fun getVerificationScreenUiStateFlow(): StateFlow<VerificationScreenUiState> = uiState
}