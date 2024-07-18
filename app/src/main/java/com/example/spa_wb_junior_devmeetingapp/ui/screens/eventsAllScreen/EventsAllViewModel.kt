package com.example.spa_wb_junior_devmeetingapp.ui.screens.eventsAllScreen

import androidx.lifecycle.ViewModel
import com.example.spa_wb_junior_devmeetingapp.data.mockData.mockListEventsAll
import com.example.spa_wb_junior_devmeetingapp.model.EventItem
import com.example.spa_wb_junior_devmeetingapp.model.EventStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.threeten.bp.LocalDate

data class EventsAllScreenUiState(
    val listOfMeetingsAll : List<EventItem> = listOf(),
    val listOfMeetingsActive : List<EventItem> = listOf(),
    val search : String = "",
)

class EventsAllViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(EventsAllScreenUiState())
    private val uiState: StateFlow<EventsAllScreenUiState> = _uiState.asStateFlow()

    fun getEventsAllScreenUiStateFlow(): StateFlow<EventsAllScreenUiState> = uiState

    init {
        _uiState.update { it ->
            it.copy(
                listOfMeetingsAll = mockListEventsAll,
                listOfMeetingsActive = mockListEventsAll.filter {
                    it.eventStatus == EventStatus.NONE && it.eventDate == LocalDate.of(2023,9,10)
                }
            )
        }
    }

    fun onSearchChange(search: String) {
        _uiState.update {
            it.copy(
                search = search
            )
        }
    }
}