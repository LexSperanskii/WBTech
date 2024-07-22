package com.example.spa_wb_junior_devmeetingapp.ui.screens.registratinProfileScreen

import androidx.lifecycle.ViewModel
import com.example.domain.models.MockData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class RegistrationProfileScreenUiState(
    val name : String = "",
    val surname : String = "",
    val avatarURL : String? = null,
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
    fun onAvatarEditButtonClick() {
        _uiState.update {
            it.copy(
                avatarURL = when(it.avatarURL.isNullOrBlank()){
                    true -> { MockData.getUserAvatar() }
                    else -> { null }
                }
            )
        }
    }

    fun inButtonSaveClick(){
        val state = _uiState.value
        MockData.setUserName(state.name)
        MockData.setUserSurname(state.surname)
        MockData.setUserAvatar(state.avatarURL)
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