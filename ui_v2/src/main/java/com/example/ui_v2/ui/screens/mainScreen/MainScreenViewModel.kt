package com.example.ui_v2.ui.screens.mainScreen

import androidx.lifecycle.ViewModel
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.ui.utils.NewUIMockData
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal data class MainScreenUiState(
    val isSortedScreen: Boolean = false,
    val searchField: String = "",
    val myEventsList: List<EventModelUI> = listOf(),
    val upcomingEventsList: List<EventModelUI> = listOf(),
    val communitiesBlockText: String = "",
    val communitiesList: List<CommunityModelUI> = listOf(),
    val myCommunitiesList: List<CommunityModelUI> = listOf(),
    val isCommunityButtonClicked: Boolean = false,
    val listOfTags: List<String> = listOf(),
    val listOfChosenTags: List<String> = listOf(),
    val listOfPeople: List<UserModelUI> = listOf(),
    val popularCommunitiesBlockText: String = "",
    val popularCommunitiesList: List<CommunityModelUI> = listOf(),
    val isPopularCommunityButtonClicked: Boolean = false,
    val infiniteEventsList: List<EventModelUI> = listOf(),
)

internal class MainScreenViewModel(
    private val mock: NewUIMockData,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenUiState())
    private val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                searchField = "",
                myEventsList = mock.listOfMyEvents(),
                upcomingEventsList = mock.listOfMyEvents(),
                communitiesBlockText = mock.personalCommunities1.nameOfBlock,
                communitiesList = mock.personalCommunities1.listOfCommunities,
                listOfTags = mock.listOfTags().take((7..mock.listOfTags().size).random()),
                listOfPeople = mock.listOfPeople(),
                popularCommunitiesBlockText = mock.personalCommunities2.nameOfBlock,
                popularCommunitiesList = mock.personalCommunities2.listOfCommunities,
                infiniteEventsList = mock.listOfMyEvents()
            )
        }
    }

    fun getMainScreenUiStateFlow(): StateFlow<MainScreenUiState> = uiState

    fun onSearchFieldChange(search: String) {
        when (search.isNotBlank()) {
            true -> {
                _uiState.update {
                    it.copy(
                        isSortedScreen = true,
                        searchField = search,
                    )
                }
            }

            else -> {
                _uiState.update {
                    it.copy(
                        isSortedScreen = false,
                        searchField = search,
                    )
                }
            }
        }

    }

    fun onClearIconClick() {
        _uiState.update {
            it.copy(
                isSortedScreen = false,
                searchField = "",
            )
        }
    }

    fun onCancelClick() {
        _uiState.update {
            it.copy(
                isSortedScreen = false,
            )
        }
    }

    fun onCommunityButtonClick(community: CommunityModelUI) {
        val newMyCommunities = uiState.value.myCommunitiesList.toMutableList()
        when (newMyCommunities.contains(community)) {
            true -> {
                newMyCommunities.remove(community)
            }

            else -> {
                newMyCommunities.add(community)
            }
        }
        _uiState.update {
            it.copy(
                myCommunitiesList = newMyCommunities
            )
        }
    }

    fun onTagClick(tag: String) {
        val newMyTags = uiState.value.listOfChosenTags.toMutableList()
        when (newMyTags.contains(tag)) {
            true -> {
                newMyTags.remove(tag)
            }

            else -> {
                newMyTags.add(tag)
            }
        }
        _uiState.update {
            it.copy(
                listOfChosenTags = newMyTags
            )
        }
    }
}