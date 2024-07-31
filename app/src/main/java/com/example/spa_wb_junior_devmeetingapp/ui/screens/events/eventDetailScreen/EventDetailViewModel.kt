package com.example.spa_wb_junior_devmeetingapp.ui.screens.events.eventDetailScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.events.AddUserAsParticipantUseCase
import com.example.domain.usecases.events.GetEventDetailsUseCase
import com.example.domain.usecases.events.RemoveUserAsParticipantUseCase
import com.example.domain.usecases.user.GetUserUseCase
import com.example.spa_wb_junior_devmeetingapp.models.EventDetailModelUI
import com.example.spa_wb_junior_devmeetingapp.models.RegisteredPersonModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.IMapperDomainUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal data class EventDetailScreenUiState(
    val event: EventDetailModelUI = EventDetailModelUI(),
    val userAsRegisteredPerson: RegisteredPersonModelUI = RegisteredPersonModelUI()
) {
    val isUserInParticipants: Boolean
        get() = event.listOfParticipants.contains(userAsRegisteredPerson)
}

internal class EventDetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val mapper: IMapperDomainUI,
    private val getEventDetailsUseCase: GetEventDetailsUseCase,
    private val addUserAsParticipantUseCase: AddUserAsParticipantUseCase,
    private val removeUserAsParticipantUseCase: RemoveUserAsParticipantUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val eventId: Int = checkNotNull(savedStateHandle[EventDetailsDestination.itemIdArg])

    private val _uiState = MutableStateFlow(EventDetailScreenUiState())
    private val uiState: StateFlow<EventDetailScreenUiState> = _uiState.asStateFlow()

    init {
        getEventDetails()
    }

    fun getEventDetailScreenUiStateFlow(): StateFlow<EventDetailScreenUiState> = uiState

    fun onGoToMeetingClick() {
        val state = uiState.value
        viewModelScope.launch {
            when (state.isUserInParticipants) {
                true -> {
                    removeUserAsParticipantUseCase.execute(
                        eventId = state.event.id,
                        participant = mapper.toRegisteredPerson(state.userAsRegisteredPerson)
                    )
                }

                else -> {
                    addUserAsParticipantUseCase.execute(
                        eventId = state.event.id,
                        participant = mapper.toRegisteredPerson(state.userAsRegisteredPerson)
                    )
                }
            }
            refreshEventDetails()
        }
    }

    private fun refreshEventDetails(){
        val state = uiState.value
        getEventDetailsUseCase.execute(state.event.id)
            .onEach { event ->
                _uiState.update {
                    it.copy(
                        event = mapper.toEventDetailModelUI(event)
                    )
                }
            }.launchIn(viewModelScope)
    }

    private fun getEventDetails() {
        combine(
            getEventDetailsUseCase.execute(eventId),
            getUserUseCase.execute()
        ) { event, user ->
            _uiState.update {
                it.copy(
                    event = mapper.toEventDetailModelUI(event),
                    userAsRegisteredPerson = RegisteredPersonModelUI(user.id, user.iconURL)
                )
            }
        }.launchIn(viewModelScope)
    }
}