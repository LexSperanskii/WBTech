package com.example.ui_v1.ui.communities.communitiesScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.communities.Uiv1GetCommunitiesListUseCase
import com.example.ui_v1.models.CommunityModelUI
import com.example.ui_v1.models.mapper.IMapperDomainUI
import com.example.ui_v1.utils.UiUtils.EMPTY_STRING
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

internal data class CommunitiesScreenUiState(
    val search: String = EMPTY_STRING,
    val listOfCommunities: List<CommunityModelUI> = listOf()
)

internal class CommunitiesViewModel(
    private val mapper: IMapperDomainUI,
    private val uiv1GetCommunitiesListUseCase: Uiv1GetCommunitiesListUseCase,
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
        uiv1GetCommunitiesListUseCase.execute()
            .onEach { communities ->
                _uiState.update {
                    it.copy(
                        listOfCommunities = communities.map { mapper.toCommunityModelUI(it) }
                    )
                }
            }.launchIn(viewModelScope)
    }
}