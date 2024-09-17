package com.example.ui_v2.ui.screens.onboarding.interestsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.listOfTags.IInteractorGetListOfTags
import com.example.domain.interactors.listOfTags.IInteractorLoadListOfTags
import com.example.domain.interactors.myChosenTags.IInteractorAddToMyChosenTags
import com.example.domain.interactors.myChosenTags.IInteractorGetMyChosenTagsList
import com.example.domain.interactors.myChosenTags.IInteractorLoadMyChosenTagsList
import com.example.domain.interactors.myChosenTags.IInteractorRemoveFromMyChosenTags
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal data class InterestsScreenUiState(
    val listOfTags: List<String> = listOf(),
    val listOfChosenTags: List<String> = listOf(),
) {
    val isButtonEnabled: Boolean
        get() = listOfChosenTags.isNotEmpty()
}

internal class InterestsScreenViewModel(
    private val loadListOfTags: IInteractorLoadListOfTags,
    private val getListOfTags: IInteractorGetListOfTags,
    private val loadMyChosenTagsList: IInteractorLoadMyChosenTagsList,
    private val getMyChosenTagsList: IInteractorGetMyChosenTagsList,
    private val addToMyChosenTags: IInteractorAddToMyChosenTags,
    private val removeFromMyChosenTags: IInteractorRemoveFromMyChosenTags,
) : ViewModel() {

    private val _uiState = MutableStateFlow(InterestsScreenUiState())
    private val uiState: StateFlow<InterestsScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getDataForInterestsScreenUiState()
    }

    fun getInterestsScreenUiStateFlow(): StateFlow<InterestsScreenUiState> = uiState

    fun onTagClick(tag: String) {
        viewModelScope.launch {
            when (uiState.value.listOfChosenTags.contains(tag)) {
                true -> {
                    removeFromMyChosenTags.invoke(tag)
                }

                false -> {
                    addToMyChosenTags.invoke(tag)
                }
            }
        }
        loadData()
    }

    private fun loadData() {
        loadListOfTags.invoke()
        loadMyChosenTagsList.invoke()
    }

    private fun getDataForInterestsScreenUiState() {
        combine(
            getListOfTags.invoke(),
            getMyChosenTagsList.invoke()
        ) { listOfTags, myChosenTagsList ->
            _uiState.update { it ->
                it.copy(
                    listOfTags = listOfTags,
                    listOfChosenTags = myChosenTagsList
                )
            }
        }.launchIn(viewModelScope)
    }

}