package com.example.ui_v2.ui.screens.userScreen.userInside

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.client.IInteractorGetClient
import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.ui_v2.models.ClientModelUI
import com.example.ui_v2.models.SocialMediaModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update


internal data class UserInsideScreenUiState(
    val client: ClientModelUI = ClientModelUI(),
    val isClientRegistered: Boolean = true,
) {
    val filteredSocialMediaList: List<SocialMediaModelUI>
        get() = client.listOfSocialMedia.filter { it.userNickname.isNotBlank() }
}

internal class UserInsideScreenViewModel(
    private val mapper: IMapperDomainUI,
    private val loadClient: IInteractorLoadClient,
    private val getClient: IInteractorGetClient,
) : ViewModel() {

    private val _uiState = MutableStateFlow(UserInsideScreenUiState())
    private val uiState: StateFlow<UserInsideScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getDataUserOutsideScreenUiState()
    }

    fun getUserInsideScreenUiStateFlow(): StateFlow<UserInsideScreenUiState> = uiState

    private fun loadData() {
        loadClient.invoke()
    }

    private fun getDataUserOutsideScreenUiState() {
        getClient.invoke()
            .onEach { client ->
                _uiState.update {
                    it.copy(
                        client = mapper.toClientModelUI(client),
                        isClientRegistered = client.phoneNumber.number.isNotBlank()
                    )
                }
            }
            .launchIn(viewModelScope)
    }
}