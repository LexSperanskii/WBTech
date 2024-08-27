package com.example.ui_v1.ui.communities.communityDetailScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.communities.Uiv1GetCommunityDetailUseCase
import com.example.ui_v1.models.CommunityDetailModelUI
import com.example.ui_v1.models.mapper.IMapperDomainUI
import com.example.ui_v1.utils.UiUtils.DEFAULT_ID
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
    savedStateHandle: SavedStateHandle,
    private val mapper: IMapperDomainUI,
    private val uiv1GetCommunityDetailUseCase: Uiv1GetCommunityDetailUseCase,
) : ViewModel() {

    private val communityId: Int = try {
        checkNotNull(savedStateHandle[CommunityDetailsDestination.itemIdArg])
    } catch (e: IllegalStateException) {
        // TODO: do state with error
        DEFAULT_ID
    }

    private val _uiState = MutableStateFlow(CommunityDetailScreenUiState())
    private val uiState: StateFlow<CommunityDetailScreenUiState> = _uiState.asStateFlow()

    init {
        getCommunityDetail()
    }

    fun getCommunityDetailScreenUiStateFlow(): StateFlow<CommunityDetailScreenUiState> = uiState

    private fun getCommunityDetail() {
        uiv1GetCommunityDetailUseCase.execute(communityId)
            .onEach { communityDetail ->
                _uiState.update {
                    it.copy(
                        communityDetail = mapper.toCommunityDetailModelUI(communityDetail)
                    )
                }
            }.launchIn(viewModelScope)
    }
}