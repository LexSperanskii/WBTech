package com.example.ui_v2.ui.screens.onboarding.interestsScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.client.IInteractorGetClient
import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.interactors.client.oldSuspend.myChosenTags.IInteractorLoadAddToMyChosenTags
import com.example.domain.interactors.client.oldSuspend.myChosenTags.IInteractorLoadRemoveFromMyChosenTags
import com.example.domain.interactors.listOfTags.IInteractorGetListOfTags
import com.example.domain.interactors.listOfTags.IInteractorLoadListOfTags
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update

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
    private val loadClient: IInteractorLoadClient,
    private val getClient: IInteractorGetClient,
    private val addToMyChosenTags: IInteractorLoadAddToMyChosenTags,
    private val removeFromMyChosenTags: IInteractorLoadRemoveFromMyChosenTags,
) : ViewModel() {

    private val _uiState = MutableStateFlow(InterestsScreenUiState())
    private val uiState: StateFlow<InterestsScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getDataForInterestsScreenUiState()
    }

    fun getInterestsScreenUiStateFlow(): StateFlow<InterestsScreenUiState> = uiState

    fun onTagClick(tag: String) {
        when (uiState.value.listOfChosenTags.contains(tag)) {
            true -> {
                removeFromMyChosenTags.invoke(tag)
            }

            false -> {
                addToMyChosenTags.invoke(tag)
            }
        }
    }

    private fun loadData() {
        loadListOfTags.invoke()
        loadClient.invoke()
    }

    private fun getDataForInterestsScreenUiState() {
        combine(
            getListOfTags.invoke(),
            getClient.invoke()
        ) { listOfTags, client ->
            _uiState.update { it ->
                it.copy(
                    listOfTags = listOfTags,
                    listOfChosenTags = client.listOfClientTags
                )
            }
        }.launchIn(viewModelScope)
    }

}