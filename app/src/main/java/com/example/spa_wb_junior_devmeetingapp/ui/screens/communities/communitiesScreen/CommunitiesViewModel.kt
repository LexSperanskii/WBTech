package com.example.spa_wb_junior_devmeetingapp.ui.screens.communities.communitiesScreen

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.communities.GetCommunitiesListUseCase
import com.example.spa_wb_junior_devmeetingapp.models.CommunityModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toCommunityModelUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CommunitiesScreenUiState(
    val search : String = "",
    val listOfCommunities : List<CommunityModelUI> = listOf()
)

class CommunitiesViewModel(
    private val getCommunitiesListUseCase: GetCommunitiesListUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(CommunitiesScreenUiState())
    private val uiState: StateFlow<CommunitiesScreenUiState> = _uiState.asStateFlow()

    fun getCommunitiesScreenUiStateFlow(): StateFlow<CommunitiesScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                listOfCommunities = getCommunitiesListUseCase.execute().map { it.toCommunityModelUI() }
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