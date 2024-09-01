package com.example.ui_v2.ui.screens.profileScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class ProfileScreenUiState(
    val data: String = "",
)

internal class ProfileScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileScreenUiState())
    private val uiState: StateFlow<ProfileScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                data = ""
            )
        }
    }

    fun getProfileScreenUiStateFlow(): StateFlow<ProfileScreenUiState> = uiState

}