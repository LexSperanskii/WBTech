package com.example.ui_v2.ui.screens.communityScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.client.IInteractorGetClient
import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.interactors.client.myCommunities.IInteractorAddToMyCommunities
import com.example.domain.interactors.client.myCommunities.IInteractorRemoveFromMyCommunities
import com.example.domain.interactors.communitiesDescription.IInteractorGetCommunitiesDescription
import com.example.domain.interactors.communitiesDescription.IInteractorLoadCommunitiesDescription
import com.example.ui_v2.models.CommunityDescriptionModelUI
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import com.example.ui_v2.ui.utils.ButtonStatus
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


internal data class CommunityScreenUiState(
    val communityDescription: CommunityDescriptionModelUI = CommunityDescriptionModelUI(),
    val clientCommunitiesList: List<CommunityModelUI> = listOf(),
    val isSubscribeButtonEnabled: Boolean = true,
) {
    val isInClientCommunities: Boolean
        get() = clientCommunitiesList.any { it.id == communityDescription.id }
    val buttonStatus: ButtonStatus
        get() = when (isInClientCommunities) {
            true -> {
                ButtonStatus.Pressed
            }

            false -> {
                ButtonStatus.Active
            }
        }
}

internal class CommunityScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val mapper: IMapperDomainUI,
    private val loadCommunitiesDescription: IInteractorLoadCommunitiesDescription,
    private val getCommunitiesDescription: IInteractorGetCommunitiesDescription,
    private val loadClient: IInteractorLoadClient,
    private val getClient: IInteractorGetClient,
    private val addToMyCommunities: IInteractorAddToMyCommunities,
    private val removeFromMyCommunities: IInteractorRemoveFromMyCommunities,
) : ViewModel() {

    private val communityId: String = try {
        checkNotNull(savedStateHandle[CommunityScreenDestination.itemIdArg])
    } catch (e: IllegalStateException) {
        // TODO: do state with error
        DEFAULT_ID
    }

    private val _uiState = MutableStateFlow(CommunityScreenUiState())
    private val uiState: StateFlow<CommunityScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getDataForCommunityScreenUiState()
    }

    fun getCommunityScreenUiStateFlow(): StateFlow<CommunityScreenUiState> = uiState

    fun onSubscribeButtonClick() {
        val state = uiState.value
        viewModelScope.launch {
            when (state.isInClientCommunities) {
                true -> {
                    removeFromMyCommunities.invoke(state.communityDescription.id)
                }

                false -> {
                    addToMyCommunities.invoke(state.communityDescription.id)
                }
            }
        }
    }

    private fun loadData() {
        loadCommunitiesDescription.invoke(communityId)
        loadClient.invoke()
    }

    private fun getDataForCommunityScreenUiState() {
        combine(
            getCommunitiesDescription.invoke(),
            getClient.invoke()
        ) { communitiesDescription, client ->
            _uiState.update { it ->
                it.copy(
                    communityDescription = mapper.toCommunityDescriptionModelUI(
                        communitiesDescription
                    ),
                    clientCommunitiesList = client.clientCommunitiesList.map {
                        mapper.toCommunityModelUI(
                            it
                        )
                    }
                )
            }
        }.launchIn(viewModelScope)
    }

}