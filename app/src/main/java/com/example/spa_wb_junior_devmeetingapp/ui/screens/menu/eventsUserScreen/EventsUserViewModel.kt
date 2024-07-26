package com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.eventsUserScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.events.GetMyEventsListUseCase
import com.example.domain.usecases.events.GetMyEventsPastListUseCase
import com.example.spa_wb_junior_devmeetingapp.models.EventModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toEventModelUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

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
        getAllEvents()
    }

    private fun getAllEvents() {
        viewModelScope.launch {
            getMyEventsListUseCase.execute()
                .collect { events ->
                    _uiState.update {
                        it.copy(
                            listOfMeetingsScheduled = events.map { it.toEventModelUI() }
                        )
                    }
                }

            getMyEventsPastListUseCase.execute()
                .collect{ events ->
                    _uiState.update {
                        it.copy(
                            listOfMeetingsPast = events.map { it.toEventModelUI() }
                        )
                    }
                }
        }
    }

}