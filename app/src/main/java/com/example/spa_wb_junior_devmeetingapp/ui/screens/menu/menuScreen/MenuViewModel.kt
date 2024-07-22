package com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.menuScreen

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.user.GetUserUseCase
import com.example.spa_wb_junior_devmeetingapp.models.mapper.Mapper
import com.example.spa_wb_junior_devmeetingapp.models.UserModelUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class MenuScreenUiState(
    val user : UserModelUI = UserModelUI(),
)

class MenuViewModel(
    private val mapper: Mapper,
    private val getUserUseCase: GetUserUseCase,
): ViewModel() {

    private val _uiState = MutableStateFlow(MenuScreenUiState())
    private val uiState: StateFlow<MenuScreenUiState> = _uiState.asStateFlow()

    fun getMenuScreenUiStateFlow(): StateFlow<MenuScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                user = mapper.mapUserToUserModelUI(getUserUseCase.execute())
            )
        }
    }
}