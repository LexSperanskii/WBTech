package com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.eventsUserScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.events.GetMyEventsListUseCase
import com.example.domain.usecases.events.GetMyEventsPastListUseCase
import com.example.spa_wb_junior_devmeetingapp.models.EventModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.IMapperDomainUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update

internal data class EventsUserScreenUiState(
    val listOfMeetingsScheduled: List<EventModelUI> = listOf(),
    val listOfMeetingsPast: List<EventModelUI> = listOf(),
)

internal class EventsUserViewModel(
    private val mapper: IMapperDomainUI,
    private val getMyEventsListUseCase: GetMyEventsListUseCase,
    private val getMyEventsPastListUseCase: GetMyEventsPastListUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(EventsUserScreenUiState())
    private val uiState: StateFlow<EventsUserScreenUiState> = _uiState.asStateFlow()

    init {
        getAllEvents()
    }

    fun getEventsUserScreenUiStateFlow(): StateFlow<EventsUserScreenUiState> = uiState

    private fun getAllEvents() {
        combine(
            getMyEventsListUseCase.execute(),
            getMyEventsPastListUseCase.execute()
        ) { eventsMy, eventsMyPast ->
            _uiState.update {
                it.copy(
                    listOfMeetingsScheduled = eventsMy.map { mapper.toEventModelUI(it) },
                    listOfMeetingsPast = eventsMyPast.map { mapper.toEventModelUI(it) }
                )
            }
        }.launchIn(viewModelScope)
    }
}