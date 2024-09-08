package com.example.ui_v2.ui.screens.userScreen.deleteProfile

import androidx.lifecycle.ViewModel
import com.example.ui_v2.models.UserModelUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class DeleteProfileScreenUiState(
    val user: UserModelUI = UserModelUI(),
)

internal class DeleteProfileScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(DeleteProfileScreenUiState())
    private val uiState: StateFlow<DeleteProfileScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                user = UserModelUI()
            )
        }
    }

    fun getDeleteProfileScreenUiStateFlow(): StateFlow<DeleteProfileScreenUiState> = uiState

}