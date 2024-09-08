package com.example.ui_v2.ui.screens.userScreen.userInside

import androidx.lifecycle.ViewModel
import com.example.ui_v2.models.UserModelUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class UserInsideScreenUiState(
    val user: UserModelUI = UserModelUI(),
)

internal class UserInsideScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UserInsideScreenUiState())
    private val uiState: StateFlow<UserInsideScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                user = UserModelUI()
            )
        }
    }

    fun getUserInsideScreenUiStateFlow(): StateFlow<UserInsideScreenUiState> = uiState

}