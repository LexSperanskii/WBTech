package com.example.spa_wb_junior_devmeetingapp.ui.screens.profileScreen

import androidx.lifecycle.ViewModel
import com.example.spa_wb_junior_devmeetingapp.data.mockData.avatarIconURL
import com.example.spa_wb_junior_devmeetingapp.model.PhoneNumber
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ProfileScreenUiState(
    val name : String = "",
    val phoneNumber: PhoneNumber = PhoneNumber(),
    val avatarURL: String = ""
)

class ProfileViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(ProfileScreenUiState())
    private val uiState: StateFlow<ProfileScreenUiState> = _uiState.asStateFlow()

    fun getProfileScreenUiStateFlow(): StateFlow<ProfileScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                name = "Иван Иванов",
                phoneNumber = PhoneNumber("+7", "1234567788"),
                avatarURL = avatarIconURL
            )
        }
    }
}