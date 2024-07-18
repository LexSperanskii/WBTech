package com.example.spa_wb_junior_devmeetingapp.ui.screens.eventDetailScreen

import androidx.lifecycle.ViewModel
import com.example.spa_wb_junior_devmeetingapp.data.mockData.IconURL4
import com.example.spa_wb_junior_devmeetingapp.data.mockData.mockAccountsIconsURLList1
import com.example.spa_wb_junior_devmeetingapp.model.EventItem
import com.example.spa_wb_junior_devmeetingapp.model.EventStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import org.threeten.bp.LocalDate

data class EventDetailScreenUiState(
    val event : EventItem = EventItem(),
    val participants : List<String> = listOf()
)

class EventDetailViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(EventDetailScreenUiState())
    private val uiState: StateFlow<EventDetailScreenUiState> = _uiState.asStateFlow()

    fun getEventDetailScreenUiStateFlow(): StateFlow<EventDetailScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                event = EventItem(
                    eventName = "Встреча разработчиков",
                    eventStatus = EventStatus.NONE,
                    eventDate = LocalDate.of(2023, 9, 12),
                    eventPlace = "Санкт-Петербруг",
                    eventCategory = listOf("Python", "Junior", "Moscow"),
                    eventIconURL = IconURL4,
                    eventIsScheduled = false
                ),
                participants = mockAccountsIconsURLList1
            )
        }
    }

    fun onGoToMeetingClick (){
        _uiState.update {
            it.copy(
                event = it.event.copy(eventIsScheduled = !it.event.eventIsScheduled)
            )
        }
    }

}