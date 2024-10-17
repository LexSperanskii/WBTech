package com.example.ui_v2.ui.screens.userScreen.userOutside

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.user.IInteractorGetUser
import com.example.domain.interactors.user.IInteractorLoadUser
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update


internal data class UserOutsideScreenUiState(
    val user: UserModelUI = UserModelUI(),
)

internal class UserOutsideScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val mapper: IMapperDomainUI,
    private val loadUser: IInteractorLoadUser,
    private val getUser: IInteractorGetUser,
) : ViewModel() {

    private val _uiState = MutableStateFlow(UserOutsideScreenUiState())
    private val uiState: StateFlow<UserOutsideScreenUiState> = _uiState.asStateFlow()

    private val id: String = try {
        checkNotNull(savedStateHandle[UserOutsideScreenDestination.itemIdArg])
    } catch (e: IllegalStateException) {
        // TODO: do state with error
        DEFAULT_ID
    }

    init {
        loadData()
        getDataUserOutsideScreenUiState()
    }

    fun getUserOutsideScreenUiStateFlow(): StateFlow<UserOutsideScreenUiState> = uiState

    private fun loadData() {
        loadUser.invoke(id)
    }

    private fun getDataUserOutsideScreenUiState() {
        getUser.invoke()
            .onEach { user ->
                _uiState.update {
                    it.copy(
                        user = mapper.toUserModelUI(user)
                    )
                }
            }
            .launchIn(viewModelScope)
    }
}