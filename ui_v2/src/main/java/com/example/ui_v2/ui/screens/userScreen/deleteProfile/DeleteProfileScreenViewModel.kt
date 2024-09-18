package com.example.ui_v2.ui.screens.userScreen.deleteProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.client.IInteractorDeleteClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


internal data class DeleteProfileScreenUiState(
    val someData: String = "",
)

internal class DeleteProfileScreenViewModel(
    private val deleteClient: IInteractorDeleteClient,
) : ViewModel() {

    private val _uiState = MutableStateFlow(DeleteProfileScreenUiState())
    private val uiState: StateFlow<DeleteProfileScreenUiState> = _uiState.asStateFlow()

    fun getDeleteProfileScreenUiStateFlow(): StateFlow<DeleteProfileScreenUiState> = uiState

    fun onDeleteClick() {
        viewModelScope.launch {
            deleteClient.invoke()
        }
    }
}