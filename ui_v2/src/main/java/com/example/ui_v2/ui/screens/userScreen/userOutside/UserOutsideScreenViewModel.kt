package com.example.ui_v2.ui.screens.userScreen.userOutside

import androidx.lifecycle.ViewModel
import com.example.ui_v2.models.UserModelUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class UserOutsideScreenUiState(
    val user: UserModelUI = UserModelUI(),
)

internal class UserOutsideScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UserOutsideScreenUiState())
    private val uiState: StateFlow<UserOutsideScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                user = UserModelUI()
            )
        }
    }

    fun getUserOutsideScreenUiStateFlow(): StateFlow<UserOutsideScreenUiState> = uiState

}