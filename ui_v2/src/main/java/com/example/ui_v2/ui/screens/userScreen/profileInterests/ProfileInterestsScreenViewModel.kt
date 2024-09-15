package com.example.ui_v2.ui.screens.userScreen.profileInterests

import androidx.lifecycle.ViewModel
import com.example.ui_v2.models.mapper.IMapperDomainUI
import com.example.ui_v2.ui.utils.ButtonStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal data class ProfileInterestsScreenUiState(
    val listOfTags: List<String> = listOf(),
    val listOfChosenTags: List<String> = listOf(),
    val buttonStatus: ButtonStatus = ButtonStatus.Active,
) {
    val isButtonEnabled: Boolean
        get() = listOfChosenTags.isNotEmpty()
}

internal class ProfileInterestsScreenViewModel(
    private val mapper: IMapperDomainUI,
) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileInterestsScreenUiState())
    private val uiState: StateFlow<ProfileInterestsScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                listOfTags = mock.getListOfTags()
            )
        }
    }

    fun getProfileInterestsScreenUiStateFlow(): StateFlow<ProfileInterestsScreenUiState> = uiState

    fun onTagClick(tag: String) {
        _uiState.update { state ->
            state.copy(
                listOfChosenTags = when (state.listOfChosenTags.contains(tag)) {
                    true -> {
                        mock.removeFromMyChosenTags(tag)
                        state.listOfChosenTags.toMutableList().apply { remove(tag) }
                    }

                    else -> {
                        mock.addToMyChosenTags(tag)
                        state.listOfChosenTags.toMutableList().apply { add(tag) }
                    }
                }
            )
        }
    }

}