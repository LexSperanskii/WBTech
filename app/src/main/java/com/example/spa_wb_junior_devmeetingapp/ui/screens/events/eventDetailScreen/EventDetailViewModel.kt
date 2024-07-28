package com.example.spa_wb_junior_devmeetingapp.ui.screens.events.eventDetailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.events.AddUserAsParticipantUseCase
import com.example.domain.usecases.events.GetEventDetailsUseCase
import com.example.domain.usecases.events.RemoveUserAsParticipantUseCase
import com.example.domain.usecases.user.GetUserUseCase
import com.example.spa_wb_junior_devmeetingapp.models.EventDetailModelUI
import com.example.spa_wb_junior_devmeetingapp.models.RegisteredPersonModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toEventDetailModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toRegisteredPerson
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toUserModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.DEFAULT_EVENT_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class EventDetailScreenUiState(
    val event: EventDetailModelUI = EventDetailModelUI(),
    val userAsRegisteredPerson: RegisteredPersonModelUI = RegisteredPersonModelUI()
) {
    val isUserInParticipants: Boolean
        get() = event.listOfParticipants.contains(userAsRegisteredPerson)
}

class EventDetailViewModel(
    private val getEventDetailsUseCase: GetEventDetailsUseCase,
    private val addUserAsParticipantUseCase: AddUserAsParticipantUseCase,
    private val removeUserAsParticipantUseCase: RemoveUserAsParticipantUseCase,
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(EventDetailScreenUiState())
    private val uiState: StateFlow<EventDetailScreenUiState> = _uiState.asStateFlow()

    fun getEventDetailScreenUiStateFlow(): StateFlow<EventDetailScreenUiState> = uiState

    init {
        getEventDetails()
    }

    fun onGoToMeetingClick() {
        val state = uiState.value
        viewModelScope.launch {
            when (state.isUserInParticipants) {
                true -> {
                    removeUserAsParticipantUseCase.execute(
                        DEFAULT_EVENT_ID,
                        state.userAsRegisteredPerson.toRegisteredPerson()
                    )
                }

                else -> {
                    addUserAsParticipantUseCase.execute(
                        DEFAULT_EVENT_ID,
                        state.userAsRegisteredPerson.toRegisteredPerson()
                    )
                }
            }
            getEventDetails()
        }
    }

    private fun getEventDetails() {
        viewModelScope.launch {
            getEventDetailsUseCase.execute(DEFAULT_EVENT_ID)
                .collect { event ->
                    _uiState.update {
                        it.copy(
                            event = event.toEventDetailModelUI()
                        )
                    }
                }

            getUserUseCase.execute()
                .collect { user ->
                    _uiState.update {
                        it.copy(
                            userAsRegisteredPerson = RegisteredPersonModelUI(user.id, user.iconURL)
                        )
                    }
                }
        }
    }
}