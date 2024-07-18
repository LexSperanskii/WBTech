package com.example.spa_wb_junior_devmeetingapp.ui.screens.communitiesScreen

import androidx.lifecycle.ViewModel
import com.example.spa_wb_junior_devmeetingapp.data.mockData.mockListOfCommunities
import com.example.spa_wb_junior_devmeetingapp.model.CommunityItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CommunitiesScreenUiState(
    val search : String = "",
    val listOfCommunities : List<CommunityItem> = listOf()
)

class CommunitiesViewModel(): ViewModel() {

    private val _uiState = MutableStateFlow(CommunitiesScreenUiState())
    private val uiState: StateFlow<CommunitiesScreenUiState> = _uiState.asStateFlow()

    fun getCommunitiesScreenUiStateFlow(): StateFlow<CommunitiesScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                listOfCommunities = mockListOfCommunities
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