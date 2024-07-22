package com.example.spa_wb_junior_devmeetingapp.ui.screens.communitiesScreen

import androidx.lifecycle.ViewModel
import com.example.domain.models.Community
import com.example.domain.models.MockData
import com.example.spa_wb_junior_devmeetingapp.models.Mapper
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CommunitiesScreenUiState(
    val search : String = "",
    val listOfCommunities : List<Community> = listOf()
)

class CommunitiesViewModel(
    private val mapper: Mapper
) : ViewModel() {

    private val _uiState = MutableStateFlow(CommunitiesScreenUiState())
    private val uiState: StateFlow<CommunitiesScreenUiState> = _uiState.asStateFlow()

    fun getCommunitiesScreenUiStateFlow(): StateFlow<CommunitiesScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                listOfCommunities = MockData.getListOfCommunities()
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