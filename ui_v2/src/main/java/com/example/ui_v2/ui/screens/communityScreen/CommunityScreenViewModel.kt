package com.example.ui_v2.ui.screens.communityScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.ui_v2.models.CommunityDescriptionModelUI
import com.example.ui_v2.ui.utils.ButtonStatus
import com.example.ui_v2.ui.utils.NewUIMockData
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class CommunityScreenUiState(
    val communityDescription: CommunityDescriptionModelUI = CommunityDescriptionModelUI(),
    val buttonStatus: ButtonStatus = ButtonStatus.Active,
    val isSubscribeButtonEnabled: Boolean = true,
)

internal class CommunityScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val mock: NewUIMockData,
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
        _uiState.update {
            it.copy(
                communityDescription = mock.getCommunityDescription(communityId)
            )
        }
    }

    fun getCommunityScreenUiStateFlow(): StateFlow<CommunityScreenUiState> = uiState

    fun onSubscribeButtonClick() {
        _uiState.update { state ->
            state.copy(
                buttonStatus = when (state.buttonStatus) {
                    ButtonStatus.Active -> {
                        mock.removeFromMyCommunities(state.communityDescription.id)
                        ButtonStatus.Pressed
                    }

                    else -> {
                        ButtonStatus.Active
                    }
                }
            )
        }
    }

}