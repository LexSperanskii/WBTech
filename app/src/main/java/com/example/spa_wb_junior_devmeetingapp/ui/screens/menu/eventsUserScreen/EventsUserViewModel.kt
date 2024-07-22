package com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.eventsUserScreen

import androidx.lifecycle.ViewModel
import com.example.domain.models.MockData
import com.example.spa_wb_junior_devmeetingapp.models.EventModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.Mapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class EventsUserScreenUiState(
    val listOfMeetingsScheduled : List<EventModelUI> = listOf(),
    val listOfMeetingsPast : List<EventModelUI> = listOf(),
)

class EventsUserViewModel(
    private val mapper: Mapper
): ViewModel() {

    private val _uiState = MutableStateFlow(EventsUserScreenUiState())
    private val uiState: StateFlow<EventsUserScreenUiState> = _uiState.asStateFlow()

    fun getEventsUserScreenUiStateFlow(): StateFlow<EventsUserScreenUiState> = uiState

    init {
        _uiState.update { it ->
            it.copy(
                listOfMeetingsScheduled = MockData.getListOfEvents().map { mapper.mapEventToEventModelUI(it) },
                listOfMeetingsPast = MockData.getListOfEvents().map { mapper.mapEventToEventModelUI(it) }.filter { it.isFinished }
            )
        }
    }

}