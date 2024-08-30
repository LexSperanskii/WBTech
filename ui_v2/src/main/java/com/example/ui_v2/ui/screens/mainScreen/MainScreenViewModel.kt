package com.example.ui_v2.ui.screens.mainScreen

import androidx.lifecycle.ViewModel
import com.example.ui_v2.models.CommunitiesAdvertBlockModelUI
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.models.EventAdvertBlockModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.ui.utils.NewUIMockData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal data class MainScreenUiState(
    val isShowSortedScreen: Boolean = false,
    val searchField: String = "",
    val myCommunitiesList: List<CommunityModelUI> = listOf(),
    val primaryEventsList: List<EventModelUI> = listOf(),
    val upcomingEventsList: List<EventModelUI> = listOf(),
    val infiniteEventsList: List<EventModelUI> = listOf(),
    val sortedEventsList: List<EventModelUI> = listOf(),
    val allCommunitiesList: List<CommunityModelUI> = listOf(),
    val communitiesAdvertBlock1: CommunitiesAdvertBlockModelUI = CommunitiesAdvertBlockModelUI(),
    val communitiesAdvertBlock2: CommunitiesAdvertBlockModelUI = CommunitiesAdvertBlockModelUI(),
    val eventsAdvertBlock: EventAdvertBlockModelUI = EventAdvertBlockModelUI(),
    val listOfTags: List<String> = listOf(),
    val listOfChosenTags: List<String> = listOf(),
    val listOfPeople: List<UserModelUI> = listOf(),
)

internal class MainScreenViewModel(
    private val mock: NewUIMockData,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenUiState())
    private val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                myCommunitiesList = mock.getMyCommunitiesList(),
                primaryEventsList = mock.listOfMyEvents().take(10),
                upcomingEventsList = mock.listOfMyEvents().take(10),
                infiniteEventsList = mock.listOfMyEvents(),
                allCommunitiesList = mock.allCommunitiesList(),
                communitiesAdvertBlock1 = mock.communitiesAdvertBlock1,
                communitiesAdvertBlock2 = mock.communitiesAdvertBlock2,
                eventsAdvertBlock = mock.eventsAdvertBlock,
                listOfTags = mock.listOfTags(),
                listOfChosenTags = mock.getMyChosenTags(),
                listOfPeople = mock.listOfPeople()
            )
        }
    }

    fun getMainScreenUiStateFlow(): StateFlow<MainScreenUiState> = uiState

    fun onSearchFieldChange(search: String) {
        _uiState.update {
            it.copy(
                isShowSortedScreen = when (search.isBlank()) {
                    true -> {
                        false
                    }

                    else -> {
                        sortEventList(search)
                        true
                    }
                },
                searchField = search,
            )
        }
    }

    fun onClearIconClick() {
        _uiState.update {
            it.copy(
                searchField = "",
            )
        }
        sortEventList("")
    }

    fun onCancelClick() {
        _uiState.update {
            it.copy(
                isShowSortedScreen = false,
                searchField = ""
            )
        }
    }

    private fun sortEventList(search: String) {
        _uiState.update { it ->
            it.copy(
                sortedEventsList = it.infiniteEventsList.filter {
                    it.name.contains(
                        search,
                        ignoreCase = true
                    )
                }
            )
        }
    }

    fun onCommunityButtonClick(community: CommunityModelUI) {
        _uiState.update { state ->
            state.copy(
                myCommunitiesList = when (state.myCommunitiesList.any { it.id == community.id }) {
                    true -> {
                        mock.removeFromMyCommunities(community)
                        state.myCommunitiesList.toMutableList().apply { remove(community) }
                    }

                    else -> {
                        mock.addToMyCommunities(community)
                        state.myCommunitiesList.toMutableList().apply { add(community) }
                    }
                }
            )
        }
    }

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