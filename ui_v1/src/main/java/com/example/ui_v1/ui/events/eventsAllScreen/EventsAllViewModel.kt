package com.example.ui_v1.ui.events.eventsAllScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.events.GetAllEventsActiveUseCase
import com.example.domain.usecases.events.GetAllEventsUseCase
import com.example.ui_v1.models.EventModelUI
import com.example.ui_v1.models.mapper.IMapperDomainUI
import com.example.ui_v1.utils.UiUtils.EMPTY_STRING
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update

internal data class EventsAllScreenUiState(
    val listOfMeetingsAll: List<EventModelUI> = listOf(),
    val listOfMeetingsActive: List<EventModelUI> = listOf(),
    val search: String = EMPTY_STRING,
)

internal class EventsAllViewModel(
    private val mapper: IMapperDomainUI,
    private val getAllEventsUseCase: GetAllEventsUseCase,
    private val getAllEventsActiveUseCase: GetAllEventsActiveUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(EventsAllScreenUiState())
    private val uiState: StateFlow<EventsAllScreenUiState> = _uiState.asStateFlow()

    init {
        getAllEvents()
    }

    fun getEventsAllScreenUiStateFlow(): StateFlow<EventsAllScreenUiState> = uiState

    fun onSearchChange(search: String) {
        _uiState.update {
            it.copy(
                search = search
            )
        }
    }

    private fun getAllEvents() {
        combine(
            getAllEventsUseCase.execute(),
            getAllEventsActiveUseCase.execute()
        ) { eventsAll, eventsActive ->
            _uiState.update {
                it.copy(
                    listOfMeetingsAll = eventsAll.map { mapper.toEventModelUI(it) },
                    listOfMeetingsActive = eventsActive.map { mapper.toEventModelUI(it) }
                )
            }
        }.launchIn(viewModelScope)
    }
}