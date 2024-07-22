package com.example.spa_wb_junior_devmeetingapp.ui.screens.communityDetailScreen

import androidx.lifecycle.ViewModel
import com.example.domain.models.MockData
import com.example.spa_wb_junior_devmeetingapp.models.EventModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.Mapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CommunityDetailScreenUiState(
    val nameOfCommunity: String = "",
    val description : String = "",
    val communityEventsList : List<EventModelUI> = listOf()
)

class CommunityDetailViewModel(
    private val mapper: Mapper
): ViewModel() {

    private val _uiState = MutableStateFlow(CommunityDetailScreenUiState())
    private val uiState: StateFlow<CommunityDetailScreenUiState> = _uiState.asStateFlow()

    fun getCommunityDetailScreenUiStateFlow(): StateFlow<CommunityDetailScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                nameOfCommunity = MockData.getCommunity().name,
                description = MockData.getCommunity().description,
                communityEventsList = MockData.getCommunity().events.map{mapper.mapEventToEventModelUI(it)}
            )
        }
    }

}