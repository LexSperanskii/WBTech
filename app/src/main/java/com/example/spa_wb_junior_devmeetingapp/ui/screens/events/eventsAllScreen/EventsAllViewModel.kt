package com.example.spa_wb_junior_devmeetingapp.ui.screens.events.eventsAllScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.events.GetAllEventsActiveUseCase
import com.example.domain.usecases.events.GetAllEventsUseCase
import com.example.spa_wb_junior_devmeetingapp.models.EventModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toCommunityDetailModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toEventModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.DEFAULT_COMMUNITY_ID
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.EMPTY_STRING
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class EventsAllScreenUiState(
    val listOfMeetingsAll : List<EventModelUI> = listOf(),
    val listOfMeetingsActive : List<EventModelUI> = listOf(),
    val search : String = EMPTY_STRING,
)

class EventsAllViewModel(
    private val getAllEventsUseCase: GetAllEventsUseCase,
    private val getAllEventsActiveUseCase: GetAllEventsActiveUseCase,
): ViewModel() {

    private val _uiState = MutableStateFlow(EventsAllScreenUiState())
    private val uiState: StateFlow<EventsAllScreenUiState> = _uiState.asStateFlow()

    fun getEventsAllScreenUiStateFlow(): StateFlow<EventsAllScreenUiState> = uiState

    init {
        getAllEvents()
    }

    private fun getAllEvents() {
        viewModelScope.launch {
            getAllEventsUseCase.execute()
                .collect { events ->
                    _uiState.update {
                        it.copy(
                            listOfMeetingsAll = events.map { it.toEventModelUI() }
                        )
                    }
                }

            getAllEventsActiveUseCase.execute()
                .collect{ events ->
                    _uiState.update {
                        it.copy(
                            listOfMeetingsActive = events.map { it.toEventModelUI() }
                        )
                    }
                }
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