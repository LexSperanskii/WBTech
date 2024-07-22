package com.example.spa_wb_junior_devmeetingapp.ui.screens.profileScreen

import androidx.lifecycle.ViewModel
import com.example.domain.models.MockData
import com.example.spa_wb_junior_devmeetingapp.models.mapper.Mapper
import com.example.spa_wb_junior_devmeetingapp.models.UserModelUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class ProfileScreenUiState(
    val user : UserModelUI = UserModelUI()
)

class ProfileViewModel(
    private val mapper: Mapper
): ViewModel() {

    private val _uiState = MutableStateFlow(ProfileScreenUiState())
    private val uiState: StateFlow<ProfileScreenUiState> = _uiState.asStateFlow()

    fun getProfileScreenUiStateFlow(): StateFlow<ProfileScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                user = mapper.mapUserToUserModelUI(MockData.getUser())
            )
        }
    }
}