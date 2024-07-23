package com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.registratinProfileScreen

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.user.GetUserAvatarUseCase
import com.example.domain.usecases.user.SetUserAvatarUseCase
import com.example.domain.usecases.user.SetUserNameUseCase
import com.example.domain.usecases.user.SetUserSurnameUseCase
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

class RegistrationProfileViewModel(
    private val getUserAvatarUseCase : GetUserAvatarUseCase,
    private val setUserNameUseCase : SetUserNameUseCase,
    private val setUserSurnameUseCase : SetUserSurnameUseCase,
    private val setUserAvatarUseCase : SetUserAvatarUseCase,
): ViewModel() {

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
                    true -> { getUserAvatarUseCase.execute() }
                    else -> { null }
                }
            )
        }
    }

    fun inButtonSaveClick(){
        val state = _uiState.value
        setUserNameUseCase.execute(state.name)
        setUserSurnameUseCase.execute(state.surname)
        setUserAvatarUseCase.execute(state.avatarURL)
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