package com.example.spa_wb_junior_devmeetingapp.ui.screens.events.eventsAllScreen

import androidx.lifecycle.ViewModel
import com.example.domain.models.MockData
import com.example.spa_wb_junior_devmeetingapp.models.EventModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.Mapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class EventsAllScreenUiState(
    val listOfMeetingsAll : List<EventModelUI> = listOf(),
    val listOfMeetingsActive : List<EventModelUI> = listOf(),
    val search : String = "",
)

class EventsAllViewModel(
    private val mapper: Mapper
): ViewModel() {

    private val _uiState = MutableStateFlow(EventsAllScreenUiState())
    private val uiState: StateFlow<EventsAllScreenUiState> = _uiState.asStateFlow()

    fun getEventsAllScreenUiStateFlow(): StateFlow<EventsAllScreenUiState> = uiState

    init {
        _uiState.update { it ->
            it.copy(
                listOfMeetingsAll = MockData.getListOfEvents().map { mapper.mapEventToEventModelUI(it) },
                listOfMeetingsActive = MockData.getListOfEvents().map { mapper.mapEventToEventModelUI(it) }.filter { !it.isFinished }
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