package com.example.spa_wb_junior_devmeetingapp.ui.screens.communities.communityDetailScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.communities.GetCommunityDetailUseCase
import com.example.spa_wb_junior_devmeetingapp.models.CommunityDetailModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toCommunityDetailModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.DEFAULT_COMMUNITY_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

internal data class CommunityDetailScreenUiState(
    val communityDetail: CommunityDetailModelUI = CommunityDetailModelUI()
)

internal class CommunityDetailViewModel(
    private val getCommunityDetailUseCase: GetCommunityDetailUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(CommunityDetailScreenUiState())
    private val uiState: StateFlow<CommunityDetailScreenUiState> = _uiState.asStateFlow()

    init {
        getCommunityDetail()
    }

    fun getCommunityDetailScreenUiStateFlow(): StateFlow<CommunityDetailScreenUiState> = uiState

    private fun getCommunityDetail() {
        getCommunityDetailUseCase.execute(DEFAULT_COMMUNITY_ID)
            .onEach { communityDetail ->
                _uiState.update {
                    it.copy(
                        communityDetail = communityDetail.toCommunityDetailModelUI()
                    )
                }
            }.launchIn(viewModelScope)
    }
}