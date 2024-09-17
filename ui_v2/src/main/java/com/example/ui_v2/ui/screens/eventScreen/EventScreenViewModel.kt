package com.example.ui_v2.ui.screens.eventScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.eventDescription.IInteractorGetEventDescription
import com.example.domain.interactors.eventDescription.IInteractorLoadEventDescription
import com.example.domain.interactors.listOfEvents.IInteractorGetListOfEvents
import com.example.domain.interactors.listOfEvents.IInteractorLoadListOfEvents
import com.example.domain.interactors.myCommunities.IInteractorAddToMyCommunities
import com.example.domain.interactors.myCommunities.IInteractorGetMyCommunitiesList
import com.example.domain.interactors.myCommunities.IInteractorLoadMyCommunitiesList
import com.example.domain.interactors.myCommunities.IInteractorRemoveFromMyCommunities
import com.example.domain.interactors.myEvents.IInteractorAddToMyEvents
import com.example.domain.interactors.myEvents.IInteractorGetMyEventsList
import com.example.domain.interactors.myEvents.IInteractorLoadMyEventsList
import com.example.domain.interactors.myEvents.IInteractorRemoveFromMyEvents
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import com.example.ui_v2.ui.utils.ButtonStatus
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


internal data class EventScreenUiState(
    val eventDescription: EventDescriptionModelUI = EventDescriptionModelUI(),
    val myCommunitiesList: List<CommunityModelUI> = listOf(),
    val myEventsList: List<EventModelUI> = listOf(),
    val communityOtherEventsList: List<EventModelUI> = listOf(),
) {
    val isInMyCommunities: Boolean
        get() = myCommunitiesList.any { it.id == eventDescription.organizer.id }
    val isInMyEvents: Boolean
        get() = myEventsList.any { it.id == eventDescription.id }
    val buttonStatus: ButtonStatus
        get() = when (isInMyEvents) {
            true -> {
                ButtonStatus.Pressed
            }

            false -> {
                ButtonStatus.Active
            }
        }
    val isJoinEventButtonEnabled: Boolean
        get() = eventDescription.availableCapacity > 0
}

internal class EventScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val mapper: IMapperDomainUI,
    private val loadEventDescription: IInteractorLoadEventDescription,
    private val getEventDescription: IInteractorGetEventDescription,
    private val loadMyCommunitiesList: IInteractorLoadMyCommunitiesList,
    private val getMyCommunitiesList: IInteractorGetMyCommunitiesList,
    private val addToMyCommunities: IInteractorAddToMyCommunities,
    private val removeFromMyCommunities: IInteractorRemoveFromMyCommunities,
    private val loadListOfEvents: IInteractorLoadListOfEvents,
    private val getListOfEvents: IInteractorGetListOfEvents,
    private val loadMyEventsList: IInteractorLoadMyEventsList,
    private val getMyEventsList: IInteractorGetMyEventsList,
    private val addToMyEvents: IInteractorAddToMyEvents,
    private val removeFromMyEvents: IInteractorRemoveFromMyEvents,
) : ViewModel() {

    private val eventId: String = try {
        checkNotNull(savedStateHandle[EventScreenDestination.itemIdArg])
    } catch (e: IllegalStateException) {
        // TODO: do state with error
        DEFAULT_ID
    }

    private val _uiState = MutableStateFlow(EventScreenUiState())
    private val uiState: StateFlow<EventScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getDataEventScreenUiState()
    }

    fun getEventScreenUiStateFlow(): StateFlow<EventScreenUiState> = uiState

    fun onCommunityButtonClick() {
        viewModelScope.launch {
            val eventOrganizerId = uiState.value.eventDescription.organizer.id
            val isInMyCommunities = uiState.value.isInMyCommunities
            when (isInMyCommunities) {
                true -> {
                    addToMyCommunities.invoke(eventOrganizerId)
                }

                false -> {
                    removeFromMyCommunities.invoke(eventOrganizerId)
                }
            }
        }
    }

    fun onJoinEventButtonClick() {
        viewModelScope.launch {
            val eventId = uiState.value.eventDescription.id
            val isInMyEvents = uiState.value.isInMyEvents
            when (isInMyEvents) {
                true -> {
                    addToMyEvents.invoke(eventId)
                }

                false -> {
                    removeFromMyEvents.invoke(eventId)
                }
            }
        }
    }

    private fun loadData() {
        loadEventDescription.invoke(eventId)
        loadMyCommunitiesList.invoke()
        loadListOfEvents.invoke()
        loadMyEventsList.invoke()
    }

    private fun getDataEventScreenUiState() {
        combine(
            getEventDescription.invoke(),
            getMyCommunitiesList.invoke(),
            getListOfEvents.invoke(),
            getMyEventsList.invoke()
        ) { eventDescription, myCommunitiesList, listOfEvents, myEventsList ->
            _uiState.update { it ->
                it.copy(
                    eventDescription = mapper.toEventDescriptionModelUI(eventDescription),
                    myCommunitiesList = myCommunitiesList.map { mapper.toCommunityModelUI(it) },
                    communityOtherEventsList = listOfEvents.map { mapper.toEventModelUI(it) },
                    myEventsList = myEventsList.map { mapper.toEventModelUI(it) }
                )
            }
        }.launchIn(viewModelScope)
    }
}