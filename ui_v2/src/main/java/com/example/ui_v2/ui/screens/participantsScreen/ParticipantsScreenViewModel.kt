package com.example.ui_v2.ui.screens.participantsScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.listOfParticipants.IInteractorGetListOfParticipants
import com.example.domain.interactors.listOfParticipants.IInteractorLoadListOfParticipants
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update


internal data class ParticipantsScreenUiState(
    val listOfUsers: List<UserModelUI> = listOf(),
)

internal class ParticipantsScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val mapper: IMapperDomainUI,
    private val loadListOfParticipants: IInteractorLoadListOfParticipants,
    private val getListOfParticipants: IInteractorGetListOfParticipants,
) : ViewModel() {

    private val id: String = try {
        checkNotNull(savedStateHandle[ParticipantsScreenDestination.itemIdArg])
    } catch (e: IllegalStateException) {
        throw IllegalArgumentException("Missing ID", e)
    }

    private val _uiState = MutableStateFlow(ParticipantsScreenUiState())
    private val uiState: StateFlow<ParticipantsScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getDataParticipantsScreenUiState()
    }

    fun getParticipantsScreenUiStateFlow(): StateFlow<ParticipantsScreenUiState> = uiState

    private fun loadData() {
        loadListOfParticipants.invoke(id)
    }

    private fun getDataParticipantsScreenUiState() {
        getListOfParticipants.invoke()
            .onEach { listOfPeople ->
                _uiState.update { it ->
                    it.copy(
                        listOfUsers = listOfPeople.map { mapper.toUserModelUI(it) }
                    )
                }
            }
            .launchIn(viewModelScope)
    }
}