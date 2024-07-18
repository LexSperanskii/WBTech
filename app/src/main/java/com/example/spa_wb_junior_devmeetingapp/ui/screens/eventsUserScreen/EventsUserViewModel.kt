package com.example.spa_wb_junior_devmeetingapp.ui.screens.eventsUserScreen

import androidx.lifecycle.ViewModel
import com.example.spa_wb_junior_devmeetingapp.data.mockData.mockListEventsAll
import com.example.spa_wb_junior_devmeetingapp.model.EventItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.threeten.bp.LocalDate

data class EventsUserScreenUiState(
    val listOfMeetingsScheduled : List<EventItem> = listOf(),
    val listOfMeetingsPast : List<EventItem> = listOf(),
)

class EventsUserViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(EventsUserScreenUiState())
    private val uiState: StateFlow<EventsUserScreenUiState> = _uiState.asStateFlow()

    fun getEventsUserScreenUiStateFlow(): StateFlow<EventsUserScreenUiState> = uiState

    init {
        _uiState.update { it ->
            it.copy(
                listOfMeetingsScheduled = mockListEventsAll.filter { it.eventIsScheduled },
                listOfMeetingsPast = mockListEventsAll.filter {
                    it.eventIsScheduled && it.eventDate < LocalDate.of(2023,9,10)
                }
            )
        }
    }

}