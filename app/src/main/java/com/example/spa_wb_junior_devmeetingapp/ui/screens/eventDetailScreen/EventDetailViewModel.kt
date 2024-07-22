package com.example.spa_wb_junior_devmeetingapp.ui.screens.eventDetailScreen

import androidx.lifecycle.ViewModel
import com.example.domain.models.MockData
import com.example.spa_wb_junior_devmeetingapp.models.EventDetailModelUI
import com.example.spa_wb_junior_devmeetingapp.models.Mapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class EventDetailScreenUiState(
    val event : EventDetailModelUI = EventDetailModelUI()
)

class EventDetailViewModel(
    private val mapper: Mapper
): ViewModel() {

    private val _uiState = MutableStateFlow(EventDetailScreenUiState())
    private val uiState: StateFlow<EventDetailScreenUiState> = _uiState.asStateFlow()

    fun getEventDetailScreenUiStateFlow(): StateFlow<EventDetailScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                event = mapper.mapEventDetailToEventDetailModelUI(MockData.getEventDetail())
            )
        }
    }

    fun onGoToMeetingClick (){
        _uiState.update {
            it.copy(
                event = it.event.copy( isUserInParticipants = !it.event.isUserInParticipants)
            )
        }
    }

}