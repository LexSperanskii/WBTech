package com.example.ui_v2.ui.screens.peopleScreen

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class PeopleScreenUiState(
    val data: String = "",
)

internal class PeopleScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(PeopleScreenUiState())
    private val uiState: StateFlow<PeopleScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                data = ""
            )
        }
    }

    fun getPeopleScreenUiStateFlow(): StateFlow<PeopleScreenUiState> = uiState

}