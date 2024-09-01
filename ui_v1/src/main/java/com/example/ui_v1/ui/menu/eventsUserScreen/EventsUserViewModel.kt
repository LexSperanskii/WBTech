package com.example.ui_v1.ui.menu.eventsUserScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.events.Uiv1GetMyEventsListUseCase
import com.example.domain.usecases.events.Uiv1GetMyEventsPastListUseCase
import com.example.ui_v1.models.UIv1EventModelUI
import com.example.ui_v1.models.mapper.UIv1IMapperDomainUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update

internal data class EventsUserScreenUiState(
    val listOfMeetingsScheduled: List<UIv1EventModelUI> = listOf(),
    val listOfMeetingsPast: List<UIv1EventModelUI> = listOf(),
)

internal class EventsUserViewModel(
    private val mapper: UIv1IMapperDomainUI,
    private val uiv1GetMyEventsListUseCase: Uiv1GetMyEventsListUseCase,
    private val uiv1GetMyEventsPastListUseCase: Uiv1GetMyEventsPastListUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(EventsUserScreenUiState())
    private val uiState: StateFlow<EventsUserScreenUiState> = _uiState.asStateFlow()

    init {
        getAllEvents()
    }

    fun getEventsUserScreenUiStateFlow(): StateFlow<EventsUserScreenUiState> = uiState

    private fun getAllEvents() {
        combine(
            uiv1GetMyEventsListUseCase.execute(),
            uiv1GetMyEventsPastListUseCase.execute()
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