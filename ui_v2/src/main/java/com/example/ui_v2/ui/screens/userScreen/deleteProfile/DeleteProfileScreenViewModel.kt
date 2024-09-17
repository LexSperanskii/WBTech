package com.example.ui_v2.ui.screens.userScreen.deleteProfile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.client.IInteractorDeleteClient
import kotlinx.coroutines.launch


//internal data class DeleteProfileScreenUiState(
//    val user: UserModelUI = UserModelUI(),
//)

internal class DeleteProfileScreenViewModel(
    private val deleteClient: IInteractorDeleteClient,
) : ViewModel() {

//    private val _uiState = MutableStateFlow(DeleteProfileScreenUiState())
//    private val uiState: StateFlow<DeleteProfileScreenUiState> = _uiState.asStateFlow()
//
//    init {
//        _uiState.update {
//            it.copy(
//                user = UserModelUI()
//            )
//        }
//    }

//    fun getDeleteProfileScreenUiStateFlow(): StateFlow<DeleteProfileScreenUiState> = uiState

    fun onDeleteClick() {
        viewModelScope.launch {
            deleteClient.invoke()
        }
    }
}