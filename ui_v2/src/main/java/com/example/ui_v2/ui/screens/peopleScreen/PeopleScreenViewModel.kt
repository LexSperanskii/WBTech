package com.example.ui_v2.ui.screens.peopleScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.ui.utils.NewUIMockData
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


internal data class PeopleScreenUiState(
    val listOfUsers: List<UserModelUI> = listOf(),
)

internal class PeopleScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val mock: NewUIMockData,
) : ViewModel() {

    private val eventId: String = try {
        checkNotNull(savedStateHandle[PeopleScreenDestination.itemIdArg])
    } catch (e: IllegalStateException) {
        // TODO: do state with error
        DEFAULT_ID
    }

    private val _uiState = MutableStateFlow(PeopleScreenUiState())
    private val uiState: StateFlow<PeopleScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                listOfUsers = mock.getListOfParticipants(eventId)
            )
        }
    }

    fun getPeopleScreenUiStateFlow(): StateFlow<PeopleScreenUiState> = uiState

}