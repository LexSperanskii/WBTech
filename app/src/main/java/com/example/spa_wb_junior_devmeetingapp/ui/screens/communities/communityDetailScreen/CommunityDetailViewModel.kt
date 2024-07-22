package com.example.spa_wb_junior_devmeetingapp.ui.screens.communities.communityDetailScreen

import androidx.lifecycle.ViewModel
import com.example.domain.usecases.communities.GetCommunityDetailUseCase
import com.example.spa_wb_junior_devmeetingapp.models.CommunityDetailModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toCommunityDetailModelUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class CommunityDetailScreenUiState(
    val communityDetail : CommunityDetailModelUI = CommunityDetailModelUI()
)

class CommunityDetailViewModel(
    private val getCommunityDetailUseCase: GetCommunityDetailUseCase,
): ViewModel() {

    private val _uiState = MutableStateFlow(CommunityDetailScreenUiState())
    private val uiState: StateFlow<CommunityDetailScreenUiState> = _uiState.asStateFlow()

    fun getCommunityDetailScreenUiStateFlow(): StateFlow<CommunityDetailScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                communityDetail = getCommunityDetailUseCase.execute().toCommunityDetailModelUI()
            )
        }
    }

}