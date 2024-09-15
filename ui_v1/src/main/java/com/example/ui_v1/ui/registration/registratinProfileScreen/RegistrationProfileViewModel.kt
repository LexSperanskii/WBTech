package com.example.ui_v1.ui.registration.registratinProfileScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.user.Uiv1GetUserAvatarUseCase
import com.example.domain.usecase.user.Uiv1SetUserUseCase
import com.example.ui_v1.utils.UIv1UiUtils.EMPTY_STRING
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


internal data class RegistrationProfileScreenUiState(
    val name : String = EMPTY_STRING,
    val surname : String = EMPTY_STRING,
    val avatarURL : String? = null,
){
    val isButtonEnabled: Boolean
        get() = name.isNotBlank()
}

internal class RegistrationProfileViewModel(
    private val uiv1GetUserAvatarUseCase: Uiv1GetUserAvatarUseCase,
    private val uiv1SetUserUseCase: Uiv1SetUserUseCase,
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
    }
    fun onSurnameChange(surname : String) {
        _uiState.update {
            it.copy(
                surname = surname
            )
        }
    }

    fun onAvatarEditButtonClick() {
        val avatarURL = _uiState.value.avatarURL
        when {
            avatarURL.isNullOrBlank() -> {
                uiv1GetUserAvatarUseCase.execute()
                    .onEach { avatarURL ->
                        _uiState.update {
                            it.copy(
                                avatarURL = avatarURL
                            )
                        }
                    }.launchIn(viewModelScope)
            }

            else -> {
                _uiState.update {
                    it.copy(
                        avatarURL = null
                    )
                }
            }
        }
    }

    fun inButtonSaveClick(){
        val state = _uiState.value
        viewModelScope.launch {
            uiv1SetUserUseCase.execute(state.name, state.surname, state.avatarURL)
        }
    }
}