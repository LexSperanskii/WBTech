package com.example.ui_v1.ui.menu.profileScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.user.GetUserUseCase
import com.example.ui_v1.models.UserModelUI
import com.example.ui_v1.models.mapper.IMapperDomainUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

internal data class ProfileScreenUiState(
    val user: UserModelUI = UserModelUI()
)

internal class ProfileViewModel(
    private val mapper: IMapperDomainUI,
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
                        user = mapper.toUserModelUI(user)
                    )
                }
            }.launchIn(viewModelScope)
    }
}