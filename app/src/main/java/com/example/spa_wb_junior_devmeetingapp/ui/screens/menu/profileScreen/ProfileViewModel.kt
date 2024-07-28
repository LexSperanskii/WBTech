package com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.profileScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.user.GetUserUseCase
import com.example.spa_wb_junior_devmeetingapp.models.UserModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toCountryModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toUserModelUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal data class ProfileScreenUiState(
    val user: UserModelUI = UserModelUI()
)

internal class ProfileViewModel(
    private val getUserUseCase: GetUserUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileScreenUiState())
    private val uiState: StateFlow<ProfileScreenUiState> = _uiState.asStateFlow()

    init {
        getUser()
    }

    fun getProfileScreenUiStateFlow(): StateFlow<ProfileScreenUiState> = uiState

    private fun getUser() {
        getUserUseCase.execute()
            .onEach { user ->
                _uiState.update {
                    it.copy(
                        user = user.toUserModelUI()
                    )
                }
            }.launchIn(viewModelScope)
    }
}