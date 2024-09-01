package com.example.ui_v2.ui.screens.communityScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class CommunityScreenUiState(
    val data: String = "",
)

internal class CommunityScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(CommunityScreenUiState())
    private val uiState: StateFlow<CommunityScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                data = ""
            )
        }
    }

    fun getCommunityScreenUiStateFlow(): StateFlow<CommunityScreenUiState> = uiState

}