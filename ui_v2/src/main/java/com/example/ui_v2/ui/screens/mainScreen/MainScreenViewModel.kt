package com.example.ui_v2.ui.screens.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.advertBlock.IInteractorGetCommunitiesAdvertBlock
import com.example.domain.interactors.advertBlock.IInteractorGetEventsAdvertBlock
import com.example.domain.interactors.listOfCommunities.IInteractorGetListOfCommunities
import com.example.domain.interactors.listOfCommunities.IInteractorLoadListOfCommunities
import com.example.domain.interactors.listOfEvents.IInteractorGetListOfEvents
import com.example.domain.interactors.listOfEvents.IInteractorLoadListOfEvents
import com.example.domain.interactors.listOfPeople.IInteractorGetListOfPeople
import com.example.domain.interactors.listOfPeople.IInteractorLoadListOfPeople
import com.example.domain.interactors.listOfTags.IInteractorGetListOfTags
import com.example.domain.interactors.listOfTags.IInteractorLoadListOfTags
import com.example.domain.interactors.myChosenTags.IInteractorAddToMyChosenTags
import com.example.domain.interactors.myChosenTags.IInteractorGetMyChosenTagsList
import com.example.domain.interactors.myChosenTags.IInteractorLoadMyChosenTagsList
import com.example.domain.interactors.myChosenTags.IInteractorRemoveFromMyChosenTags
import com.example.domain.interactors.myCommunities.IInteractorAddToMyCommunities
import com.example.domain.interactors.myCommunities.IInteractorGetMyCommunitiesList
import com.example.domain.interactors.myCommunities.IInteractorLoadMyCommunitiesList
import com.example.domain.interactors.myCommunities.IInteractorRemoveFromMyCommunities
import com.example.ui_v2.models.CommunitiesAdvertBlockModelUI
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.models.EventAdvertBlockModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal data class MainScreenUiState(
    val isShowSortedScreen: Boolean = false,
    val searchField: String = "",
    val myCommunitiesList: List<CommunityModelUI> = listOf(),
    val relatedEventsList: List<EventModelUI> = listOf(),
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
    private val mapper: IMapperDomainUI,
    private val loadListOfEvents: IInteractorLoadListOfEvents,
    private val getListOfEvents: IInteractorGetListOfEvents,
    private val loadMyCommunitiesList: IInteractorLoadMyCommunitiesList,
    private val getMyCommunitiesList: IInteractorGetMyCommunitiesList,
    private val loadListOfCommunities: IInteractorLoadListOfCommunities,
    private val getListOfCommunities: IInteractorGetListOfCommunities,
    private val getCommunitiesAdvertBlock: IInteractorGetCommunitiesAdvertBlock,
    private val getEventsAdvertBlock: IInteractorGetEventsAdvertBlock,
    private val loadListOfTags: IInteractorLoadListOfTags,
    private val getListOfTags: IInteractorGetListOfTags,
    private val loadMyChosenTagsList: IInteractorLoadMyChosenTagsList,
    private val getMyChosenTagsList: IInteractorGetMyChosenTagsList,
    private val loadListOfPeople: IInteractorLoadListOfPeople,
    private val getListOfPeople: IInteractorGetListOfPeople,
    private val addToMyCommunities: IInteractorAddToMyCommunities,
    private val removeFromMyCommunities: IInteractorRemoveFromMyCommunities,
    private val addToMyChosenTags: IInteractorAddToMyChosenTags,
    private val removeFromMyChosenTags: IInteractorRemoveFromMyChosenTags,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenUiState())
    private val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getMainScreen()
        getAdvertBlocks()
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
        viewModelScope.launch {
            when (uiState.value.myCommunitiesList.any { it.id == community.id }) {
                true -> {
                    addToMyCommunities.invoke(community.id)
                }

                false -> {
                    removeFromMyCommunities.invoke(community.id)
                }
            }
        }
    }

    fun onTagClick(tag: String) {
        viewModelScope.launch {
            when (uiState.value.listOfChosenTags.contains(tag)) {
                true -> {
                    addToMyChosenTags.invoke(tag)
                }

                false -> {
                    removeFromMyChosenTags.invoke(tag)
                }
            }
        }
    }

    private fun getMainScreen() {
        val combinedFlow = combine(
            getListOfEvents.invoke(),
            getMyCommunitiesList.invoke(),
            getListOfCommunities.invoke(),
            getListOfTags.invoke(),
            getMyChosenTagsList.invoke(),
        ) { eventsList, myCommunitiesList, listOfCommunities, listOfTags, myChosenTagsList ->
            MainScreenUiState().copy(
                myCommunitiesList = myCommunitiesList.map { mapper.toCommunityModelUI(it) },
                relatedEventsList = eventsList.map { mapper.toEventModelUI(it) },
                upcomingEventsList = eventsList.map { mapper.toEventModelUI(it) },
                infiniteEventsList = eventsList.map { mapper.toEventModelUI(it) },
                allCommunitiesList = listOfCommunities.map { mapper.toCommunityModelUI(it) },
                listOfTags = listOfTags,
                listOfChosenTags = myChosenTagsList
            )
        }

        combinedFlow.combine(
            getListOfPeople.invoke()
        ) { combinedData, listOfPeople ->
            _uiState.update { it ->
                it.copy(
                    myCommunitiesList = combinedData.myCommunitiesList,
                    relatedEventsList = combinedData.relatedEventsList,
                    upcomingEventsList = combinedData.upcomingEventsList,
                    infiniteEventsList = combinedData.infiniteEventsList,
                    allCommunitiesList = combinedData.allCommunitiesList,
                    listOfTags = combinedData.listOfTags,
                    listOfChosenTags = combinedData.listOfChosenTags,
                    listOfPeople = listOfPeople.map { mapper.toUserModelUI(it) }
                )
            }
        }.launchIn(viewModelScope)
    }

    private fun loadData() {
        loadMyCommunitiesList.invoke()
        loadListOfEvents.invoke()
        loadListOfCommunities.invoke()
        loadListOfTags.invoke()
        loadMyChosenTagsList.invoke()
        loadListOfPeople.invoke()
    }

    private fun getAdvertBlocks() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    communitiesAdvertBlock1 = mapper.toCommunitiesAdvertBlockModelUI(
                        getCommunitiesAdvertBlock.invoke("0")
                    ),
                    communitiesAdvertBlock2 = mapper.toCommunitiesAdvertBlockModelUI(
                        getCommunitiesAdvertBlock.invoke("1")
                    ),
                    eventsAdvertBlock = mapper.toEventAdvertBlockModelUI(
                        getEventsAdvertBlock.invoke(
                            "0"
                        )
                    ),
                )
            }
        }
    }
}