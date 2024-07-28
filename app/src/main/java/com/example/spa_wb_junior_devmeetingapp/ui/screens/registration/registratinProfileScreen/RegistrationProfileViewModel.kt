package com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.registratinProfileScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.user.GetUserAvatarUseCase
import com.example.domain.usecases.user.SetUserUseCase
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.EMPTY_STRING
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
    private val getUserAvatarUseCase : GetUserAvatarUseCase,
    private val setUserUseCase : SetUserUseCase
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
        getUserAvatarUseCase.execute()
            .onEach { avatarURL ->
                _uiState.update {
                    it.copy(
                        avatarURL = when (it.avatarURL.isNullOrBlank()) {
                            true -> {
                                avatarURL
                            }

                            else -> {
                                null
                            }
                        }
                    )
                }
            }.launchIn(viewModelScope)
    }

    fun inButtonSaveClick(){
        val state = _uiState.value
        viewModelScope.launch {
            setUserUseCase.execute(state.name, state.surname, state.avatarURL)
        }
    }
}