package com.example.ui_v1.ui.events.eventDetailScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.events.Uiv1AddUserAsParticipantUseCase
import com.example.domain.usecase.events.Uiv1GetEventDetailsUseCase
import com.example.domain.usecase.events.Uiv1RemoveUserAsParticipantUseCase
import com.example.domain.usecase.user.Uiv1GetUserUseCase
import com.example.ui_v1.models.UIv1EventDetailModelUI
import com.example.ui_v1.models.UIv1RegisteredPersonModelUI
import com.example.ui_v1.models.mapper.UIv1IMapperDomainUI
import com.example.ui_v1.utils.UIv1UiUtils.DEFAULT_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal data class EventDetailScreenUiState(
    val event: UIv1EventDetailModelUI = UIv1EventDetailModelUI(),
    val userAsRegisteredPerson: UIv1RegisteredPersonModelUI = UIv1RegisteredPersonModelUI(),
) {
    val isUserInParticipants: Boolean
        get() = event.listOfParticipants.contains(userAsRegisteredPerson)
}

internal class EventDetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val mapper: UIv1IMapperDomainUI,
    private val uiv1GetEventDetailsUseCase: Uiv1GetEventDetailsUseCase,
    private val uiv1AddUserAsParticipantUseCase: Uiv1AddUserAsParticipantUseCase,
    private val uiv1RemoveUserAsParticipantUseCase: Uiv1RemoveUserAsParticipantUseCase,
    private val uiv1GetUserUseCase: Uiv1GetUserUseCase,
) : ViewModel() {

    private val eventId: Int = try {
        checkNotNull(savedStateHandle[EventDetailsDestinationUIv1.itemIdArg])
    } catch (e: IllegalStateException) {
        // TODO: do state with error
        DEFAULT_ID
    }

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
                    uiv1RemoveUserAsParticipantUseCase.execute(
                        eventId = state.event.id,
                        participant = mapper.toRegisteredPerson(state.userAsRegisteredPerson)
                    )
                }

                else -> {
                    uiv1AddUserAsParticipantUseCase.execute(
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
        uiv1GetEventDetailsUseCase.execute(state.event.id)
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
            uiv1GetEventDetailsUseCase.execute(eventId),
            uiv1GetUserUseCase.execute()
        ) { event, user ->
            _uiState.update {
                it.copy(
                    event = mapper.toEventDetailModelUI(event),
                    userAsRegisteredPerson = UIv1RegisteredPersonModelUI(user.id, user.iconURL)
                )
            }
        }.launchIn(viewModelScope)
    }
}