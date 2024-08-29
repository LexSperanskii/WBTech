package com.example.ui_v2.ui.screens.mainScreen

import androidx.lifecycle.ViewModel
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.UserModelUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal data class MainScreenUiState(
    val searchField: String = "",
    val myEventsList: List<EventModelUI> = listOf(),
    val upcomingEventsList: List<EventModelUI> = listOf(),
    val communitiesBlockText: String = "",
    val communitiesList: String = "",
    val isCommunityButtonClicked: Boolean = false,
    val listOfTags: List<String> = listOf(),
    val listOfChosenTags: List<String> = listOf(),
    val listOfPeople: List<UserModelUI> = listOf(),
    val popularCommunitiesBlockText: String = "",
    val popularCommunitiesList: String = "",
    val isPopularCommunityButtonClicked: Boolean = false,
    val infiniteEventsList: List<EventModelUI> = listOf(),
)

internal class MainScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenUiState())
    private val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                searchField = "",
                myEventsList =,
                upcomingEventsList =,
                communitiesBlockText =,
                communitiesList =,
                isCommunityButtonClicked =,
                listOfTags =,
                listOfChosenTags =,
                listOfPeople =,
                popularCommunitiesBlockText =,
                popularCommunitiesList =,
                isPopularCommunityButtonClicked =,
                infiniteEventsList =,
            )
        }
    }

    fun getMainScreenUiStateFlow(): StateFlow<MainScreenUiState> = uiState

}