package com.example.ui_v2.ui.screens.mainScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.advertBlock.communitiesAdvertBlock.IInteractorGetCommunitiesAdvertBlock
import com.example.domain.interactors.advertBlock.communitiesAdvertBlock.IInteractorLoadCommunitiesAdvertBlock
import com.example.domain.interactors.advertBlock.eventsAdvertBlock.IInteractorGetEventsAdvertBlock
import com.example.domain.interactors.advertBlock.eventsAdvertBlock.IInteractorLoadEventsAdvertBlock
import com.example.domain.interactors.client.getClient.IInteractorGetClient
import com.example.domain.interactors.client.getClient.IInteractorLoadClient
import com.example.domain.interactors.client.myChosenTags.addToMyChosenTags.IInteractorAddToMyChosenTags
import com.example.domain.interactors.client.myChosenTags.removeFromMyChosenTags.IInteractorRemoveFromMyChosenTags
import com.example.domain.interactors.client.myCommunities.addToMyCommunities.IInteractorAddToMyCommunities
import com.example.domain.interactors.client.myCommunities.removeFromMyCommunities.IInteractorRemoveFromMyCommunities
import com.example.domain.interactors.listOfCommunities.IInteractorGetListOfCommunities
import com.example.domain.interactors.listOfCommunities.IInteractorLoadListOfCommunities
import com.example.domain.interactors.listOfEvents.IInteractorGetListOfEvents
import com.example.domain.interactors.listOfEvents.IInteractorLoadListOfEvents
import com.example.domain.interactors.listOfPeople.IInteractorGetListOfPeople
import com.example.domain.interactors.listOfPeople.IInteractorLoadListOfPeople
import com.example.domain.interactors.listOfSortedEvents.IInteractorGetListOfSortedEvents
import com.example.domain.interactors.listOfSortedEvents.IInteractorLoadListOfSortedEvents
import com.example.domain.interactors.listOfTags.IInteractorGetListOfTags
import com.example.domain.interactors.listOfTags.IInteractorLoadListOfTags
import com.example.ui_v2.models.ClientModelUI
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

internal data class MainScreenUiState(
    val isShowSortedScreen: Boolean = false,
    val searchField: String = "",
    val myCommunitiesList: List<CommunityModelUI> = listOf(),
    val relatedEventsList: List<EventModelUI> = listOf(),
    val upcomingEventsList: List<EventModelUI> = listOf(),
    val infiniteEventsList: List<EventModelUI> = listOf(),
    val sortedEventsList: List<EventModelUI> = listOf(),
    val allCommunitiesList: List<CommunityModelUI> = listOf(),
    val communitiesAdvertBlock: List<CommunitiesAdvertBlockModelUI> = listOf(),
    val eventsAdvertBlock: List<EventAdvertBlockModelUI> = listOf(),
    val listOfTags: List<String> = listOf(),
    val listOfChosenTags: List<String> = listOf(),
    val listOfPeople: List<UserModelUI> = listOf(),
    val client: ClientModelUI = ClientModelUI(),
)

internal class MainScreenViewModel(
    private val mapper: IMapperDomainUI,
    private val loadListOfEvents: IInteractorLoadListOfEvents,
    private val getListOfEvents: IInteractorGetListOfEvents,
    private val loadListOfSortedEvents: IInteractorLoadListOfSortedEvents,
    private val getListOfSortedEvents: IInteractorGetListOfSortedEvents,
    private val loadListOfCommunities: IInteractorLoadListOfCommunities,
    private val getListOfCommunities: IInteractorGetListOfCommunities,
    private val loadListOfTags: IInteractorLoadListOfTags,
    private val getListOfTags: IInteractorGetListOfTags,
    private val loadListOfPeople: IInteractorLoadListOfPeople,
    private val getListOfPeople: IInteractorGetListOfPeople,
    private val loadCommunitiesAdvertBlock: IInteractorLoadCommunitiesAdvertBlock,
    private val getCommunitiesAdvertBlock: IInteractorGetCommunitiesAdvertBlock,
    private val loadEventsAdvertBlock: IInteractorLoadEventsAdvertBlock,
    private val getEventsAdvertBlock: IInteractorGetEventsAdvertBlock,
    private val loadClient: IInteractorLoadClient,
    private val getClient: IInteractorGetClient,
    private val addToMyCommunities: IInteractorAddToMyCommunities,
    private val removeFromMyCommunities: IInteractorRemoveFromMyCommunities,
    private val addToMyChosenTags: IInteractorAddToMyChosenTags,
    private val removeFromMyChosenTags: IInteractorRemoveFromMyChosenTags,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainScreenUiState())
    private val uiState: StateFlow<MainScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getDataForMainScreenUiState()
    }

    fun getMainScreenUiStateFlow(): StateFlow<MainScreenUiState> = uiState

    fun onSearchFieldChange(search: String) {
        loadListOfSortedEvents.invoke(search)
        _uiState.update {
            it.copy(
                isShowSortedScreen = true,
                searchField = search
            )
        }
    }

    fun onClearIconClick() {
        loadListOfSortedEvents.invoke("")
        _uiState.update {
            it.copy(
                searchField = "",
            )
        }
    }

    fun onCancelClick() {
        _uiState.update {
            it.copy(
                isShowSortedScreen = false,
                searchField = ""
            )
        }
    }

    fun onCommunityButtonClick(community: CommunityModelUI) {
        when (uiState.value.myCommunitiesList.any { it.id == community.id }) {
            true -> {
                removeFromMyCommunities.invoke(community.id)
            }

            false -> {
                addToMyCommunities.invoke(community.id)
            }
        }
    }

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
        loadListOfEvents.invoke()
        loadListOfCommunities.invoke()
        loadListOfTags.invoke()
        loadListOfPeople.invoke()
        loadClient.invoke()
        loadCommunitiesAdvertBlock.invoke()
        loadEventsAdvertBlock.invoke()
    }

    private fun getDataForMainScreenUiState() {

        val combinedEventsAndCommunitiesFlow = combine(
            getListOfEvents.invoke(),
            getClient.invoke(),
            getListOfCommunities.invoke(),
            getListOfSortedEvents.invoke()
        ) { eventsList, client, listOfCommunities, listOfSortedEvents ->
            MainScreenUiState().copy(
                myCommunitiesList = client.clientCommunitiesList.map { mapper.toCommunityModelUI(it) },
                relatedEventsList = eventsList.map { mapper.toEventModelUI(it) },
                upcomingEventsList = eventsList.map { mapper.toEventModelUI(it) },
                infiniteEventsList = eventsList.map { mapper.toEventModelUI(it) },
                allCommunitiesList = listOfCommunities.map { mapper.toCommunityModelUI(it) },
                sortedEventsList = listOfSortedEvents.map { mapper.toEventModelUI(it) },
                listOfChosenTags = client.listOfClientTags
            )
        }
        val combinedPeopleTagsAdvertFlow = combine(
            getListOfPeople.invoke(),
            getListOfTags.invoke(),
            getEventsAdvertBlock.invoke(),
            getCommunitiesAdvertBlock.invoke()
        ) { listOfPeople, listOfTags, eventsAdvertBlock, communitiesAdvertBlock ->
            MainScreenUiState().copy(
                listOfPeople = listOfPeople.map { mapper.toUserModelUI(it) },
                listOfTags = listOfTags,
                communitiesAdvertBlock = communitiesAdvertBlock.map {
                    mapper.toCommunitiesAdvertBlockModelUI(
                        it
                    )
                },
                eventsAdvertBlock = eventsAdvertBlock.map { mapper.toEventAdvertBlockModelUI(it) }
            )
        }

        combinedEventsAndCommunitiesFlow.combine(
            combinedPeopleTagsAdvertFlow,
        ) { combinedEventsAndCommunities, combinedPeopleTagsAdvert ->
            _uiState.update { it ->
                it.copy(
                    myCommunitiesList = combinedEventsAndCommunities.myCommunitiesList,
                    relatedEventsList = combinedEventsAndCommunities.relatedEventsList,
                    upcomingEventsList = combinedEventsAndCommunities.upcomingEventsList,
                    infiniteEventsList = combinedEventsAndCommunities.infiniteEventsList,
                    allCommunitiesList = combinedEventsAndCommunities.allCommunitiesList,
                    sortedEventsList = combinedEventsAndCommunities.sortedEventsList,
                    listOfChosenTags = combinedEventsAndCommunities.listOfChosenTags,
                    listOfPeople = combinedPeopleTagsAdvert.listOfPeople,
                    listOfTags = combinedPeopleTagsAdvert.listOfTags,
                    communitiesAdvertBlock = combinedPeopleTagsAdvert.communitiesAdvertBlock,
                    eventsAdvertBlock = combinedPeopleTagsAdvert.eventsAdvertBlock
                )
            }
        }.launchIn(viewModelScope)
    }
}