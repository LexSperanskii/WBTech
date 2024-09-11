package com.example.ui_v2.ui.screens.userScreen.userOutside

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.ui.utils.NewUIMockData
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class UserOutsideScreenUiState(
    val user: UserModelUI = UserModelUI(),
)

internal class UserOutsideScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val mock: NewUIMockData,
) : ViewModel() {

    private val _uiState = MutableStateFlow(UserOutsideScreenUiState())
    private val uiState: StateFlow<UserOutsideScreenUiState> = _uiState.asStateFlow()

    private val id: String = try {
        checkNotNull(savedStateHandle[UserOutsideScreenDestination.itemIdArg])
    } catch (e: IllegalStateException) {
        // TODO: do state with error
        DEFAULT_ID
    }

    init {
        _uiState.update {
            it.copy(
                user = mock.getUser(id)
            )
        }
    }

    fun getUserOutsideScreenUiStateFlow(): StateFlow<UserOutsideScreenUiState> = uiState

}