package com.example.ui_v2.ui.screens.eventScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.domain.models.mock.MockData
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.ui.utils.ButtonStatus
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class EventScreenUiState(
    val eventDescription: EventDescriptionModelUI = EventDescriptionModelUI(),
    val myCommunitiesList: List<CommunityModelUI> = listOf(),
    val otherCommunityEventsList: List<EventModelUI> = listOf(),
    val buttonStatus: ButtonStatus = ButtonStatus.Active,
) {
    val isInMyCommunities: Boolean
        get() = myCommunitiesList.any { it.id == eventDescription.organizer.id }
    val isJoinEventButtonEnabled: Boolean
        get() = eventDescription.availableCapacity > 0
}

internal class EventScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val mock: MockData,
) : ViewModel() {

    private val eventId: String = try {
        checkNotNull(savedStateHandle[EventScreenDestination.itemIdArg])
    } catch (e: IllegalStateException) {
        // TODO: do state with error
        DEFAULT_ID
    }

    private val _uiState = MutableStateFlow(EventScreenUiState())
    private val uiState: StateFlow<EventScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                eventDescription = mock.getEventDescription(eventId),
                myCommunitiesList = mock.getMyCommunitiesList(),
                otherCommunityEventsList = mock.getListOfEvents().take(10),
            )
        }
    }

    fun getEventScreenUiStateFlow(): StateFlow<EventScreenUiState> = uiState

    fun onCommunityButtonClick() {
        _uiState.update { state ->
            state.copy(
                myCommunitiesList = when (state.myCommunitiesList.any { it.id == state.eventDescription.organizer.id }) {
                    true -> {
                        mock.removeFromMyCommunities(state.eventDescription.organizer)
                        state.myCommunitiesList.toMutableList()
                            .apply { remove(state.eventDescription.organizer) }
                    }

                    else -> {
                        mock.addToMyCommunities(state.eventDescription.organizer)
                        state.myCommunitiesList.toMutableList()
                            .apply { add(state.eventDescription.organizer) }
                    }
                }
            )
        }
    }

    fun onJoinEventButtonClick() {
        _uiState.update { state ->
            state.copy(
                buttonStatus = when (state.buttonStatus) {
                    ButtonStatus.Active -> {
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