package com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.menuScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.user.GetUserUseCase
import com.example.spa_wb_junior_devmeetingapp.models.UserModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.IMapperDomainUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

internal data class MenuScreenUiState(
    val user: UserModelUI = UserModelUI(),
)

internal class MenuViewModel(
    private val mapper: IMapperDomainUI,
    private val getUserUseCase: GetUserUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MenuScreenUiState())
    private val uiState: StateFlow<MenuScreenUiState> = _uiState.asStateFlow()

    init {
        getUser()
    }

    fun getMenuScreenUiStateFlow(): StateFlow<MenuScreenUiState> = uiState

    private fun getUser() {
        getUserUseCase.execute()
            .onEach { user ->
                _uiState.update {
                    it.copy(
                        user = mapper.toUserModelUI(user)
                    )
                }
            }.launchIn(viewModelScope)
    }
}