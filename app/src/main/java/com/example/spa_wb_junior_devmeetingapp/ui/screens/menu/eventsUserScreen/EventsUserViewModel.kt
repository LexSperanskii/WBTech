package com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.eventsUserScreen

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.events.GetMyEventsListUseCase
import com.example.domain.usecases.events.GetMyEventsPastListUseCase
import com.example.spa_wb_junior_devmeetingapp.models.EventModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toEventModelUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class EventsUserScreenUiState(
    val listOfMeetingsScheduled : List<EventModelUI> = listOf(),
    val listOfMeetingsPast : List<EventModelUI> = listOf(),
)

class EventsUserViewModel(
    private val getMyEventsListUseCase: GetMyEventsListUseCase,
    private val getMyEventsPastListUseCase: GetMyEventsPastListUseCase,
): ViewModel() {

    private val _uiState = MutableStateFlow(EventsUserScreenUiState())
    private val uiState: StateFlow<EventsUserScreenUiState> = _uiState.asStateFlow()

    fun getEventsUserScreenUiStateFlow(): StateFlow<EventsUserScreenUiState> = uiState

    init {
        _uiState.update { it ->
            it.copy(
                listOfMeetingsScheduled = getMyEventsListUseCase.execute().map { it.toEventModelUI() },
                listOfMeetingsPast = getMyEventsPastListUseCase.execute().map { it.toEventModelUI() }
            )
        }
    }

}