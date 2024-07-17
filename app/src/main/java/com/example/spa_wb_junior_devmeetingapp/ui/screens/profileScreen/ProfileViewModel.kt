package com.example.spa_wb_junior_devmeetingapp.ui.screens.profileScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class ProfileScreenUiState(
    val mock : String = "",
)

class ProfileViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(ProfileScreenUiState())
    private val uiState: StateFlow<ProfileScreenUiState> = _uiState.asStateFlow()

    fun getProfileScreenUiStateFlow(): StateFlow<ProfileScreenUiState> = uiState
}