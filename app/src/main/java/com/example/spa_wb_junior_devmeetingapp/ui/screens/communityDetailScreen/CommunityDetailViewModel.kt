package com.example.spa_wb_junior_devmeetingapp.ui.screens.communityDetailScreen

import androidx.lifecycle.ViewModel
import com.example.spa_wb_junior_devmeetingapp.models.EventModelUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CommunityDetailScreenUiState(
    val description : String = "",
    val communityEventsList : List<EventModelUI> = listOf()
)

class CommunityDetailViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(CommunityDetailScreenUiState())
    private val uiState: StateFlow<CommunityDetailScreenUiState> = _uiState.asStateFlow()

    fun getCommunityDetailScreenUiStateFlow(): StateFlow<CommunityDetailScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                description = longText,
                communityEventsList = mockListEventsAll.filter { it.communityId == 3 }
            )
        }
    }

}