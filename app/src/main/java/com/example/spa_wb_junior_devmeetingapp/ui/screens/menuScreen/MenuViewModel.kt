package com.example.spa_wb_junior_devmeetingapp.ui.screens.menuScreen

import androidx.lifecycle.ViewModel
import com.example.spa_wb_junior_devmeetingapp.data.mockData.avatarIconURL
import com.example.spa_wb_junior_devmeetingapp.model.PhoneNumber
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class MenuScreenUiState(
    val name : String = "",
    val phoneNumber: PhoneNumber = PhoneNumber(),
    val avatarURL: String = "",
)

class MenuViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(MenuScreenUiState())
    private val uiState: StateFlow<MenuScreenUiState> = _uiState.asStateFlow()

    fun getMenuScreenUiStateFlow(): StateFlow<MenuScreenUiState> = uiState

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