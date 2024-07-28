package com.example.spa_wb_junior_devmeetingapp.ui.screens.communities.communitiesScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.communities.GetCommunitiesListUseCase
import com.example.spa_wb_junior_devmeetingapp.models.CommunityModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toCommunityModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.EMPTY_STRING
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

data class CommunitiesScreenUiState(
    val search: String = EMPTY_STRING,
    val listOfCommunities: List<CommunityModelUI> = listOf()
)

class CommunitiesViewModel(
    private val getCommunitiesListUseCase: GetCommunitiesListUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(CommunitiesScreenUiState())
    private val uiState: StateFlow<CommunitiesScreenUiState> = _uiState.asStateFlow()

    init {
        getCommunitiesList()
    }

    fun getCommunitiesScreenUiStateFlow(): StateFlow<CommunitiesScreenUiState> = uiState

    fun onSearchChange(search: String) {
        _uiState.update {
            it.copy(
                search = search
            )
        }
    }

    private fun getCommunitiesList() {
        getCommunitiesListUseCase.execute()
            .onEach { communities ->
                _uiState.update {
                    it.copy(
                        listOfCommunities = communities.map { it.toCommunityModelUI() }
                    )
                }
            }.launchIn(viewModelScope)
    }
}