package com.example.spa_wb_junior_devmeetingapp.ui.screens.registratinProfileScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class RegistrationProfileScreenUiState(
    val name : String = "",
    val surname : String = "",
    val isButtonEnabled: Boolean = false
)

class RegistrationProfileViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(RegistrationProfileScreenUiState())
    private val uiState: StateFlow<RegistrationProfileScreenUiState> = _uiState.asStateFlow()

    fun getRegistrationProfileScreenUiStateFlow(): StateFlow<RegistrationProfileScreenUiState> = uiState

    fun onNameChange(name : String) {
        _uiState.update {
            it.copy(
                name = name
            )
        }
        isButtonEnabled()
    }
    fun onSurnameChange(surname : String) {
        _uiState.update {
            it.copy(
                surname = surname
            )
        }
    }
    private fun isButtonEnabled(){
        val name = uiState.value.name
        _uiState.update {
            it.copy(
                isButtonEnabled = name.isNotBlank()
            )
        }
    }
}