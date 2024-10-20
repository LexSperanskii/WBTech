package com.example.ui_v1.ui.menu.profileScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.user.Uiv1GetUserUseCase
import com.example.ui_v1.models.UIv1UserModelUI
import com.example.ui_v1.models.mapper.UIv1IMapperDomainUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

internal data class ProfileScreenUiState(
    val user: UIv1UserModelUI = UIv1UserModelUI(),
)

internal class ProfileViewModel(
    private val mapper: UIv1IMapperDomainUI,
    private val uiv1GetUserUseCase: Uiv1GetUserUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileScreenUiState())
    private val uiState: StateFlow<ProfileScreenUiState> = _uiState.asStateFlow()

    init {
        getUser()
    }

    fun getProfileScreenUiStateFlow(): StateFlow<ProfileScreenUiState> = uiState

    private fun getUser() {
        uiv1GetUserUseCase.execute()
            .onEach { user ->
                _uiState.update {
                    it.copy(
                        user = mapper.toUserModelUI(user)
                    )
                }
            }.launchIn(viewModelScope)
    }
}