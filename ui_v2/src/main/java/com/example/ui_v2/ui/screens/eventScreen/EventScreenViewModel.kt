package com.example.ui_v2.ui.screens.eventScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.client.IInteractorGetClient
import com.example.domain.interactors.client.IInteractorLoadClient
import com.example.domain.interactors.eventDescription.IInteractorGetEventDescription
import com.example.domain.interactors.eventDescription.IInteractorLoadEventDescription
import com.example.domain.interactors.listOfEvents.IInteractorGetListOfEvents
import com.example.domain.interactors.listOfEvents.IInteractorLoadListOfEvents
import com.example.domain.interactors.myCommunities.IInteractorAddToMyCommunities
import com.example.domain.interactors.myCommunities.IInteractorRemoveFromMyCommunities
import com.example.domain.interactors.myEvents.IInteractorAddToMyEvents
import com.example.domain.interactors.myEvents.IInteractorRemoveFromMyEvents
import com.example.ui_v2.models.ClientModelUI
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
    val communityOtherEventsList: List<EventModelUI> = listOf(),
    val client: ClientModelUI = ClientModelUI(),
) {
    val isInMyCommunities: Boolean
        get() = client.clientCommunitiesList.any { it.id == eventDescription.organizer.id }
    val isInMyEvents: Boolean
        get() = client.clientEventsList.any { it.id == eventDescription.id }
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
    private val addToMyCommunities: IInteractorAddToMyCommunities,
    private val removeFromMyCommunities: IInteractorRemoveFromMyCommunities,
    private val loadListOfEvents: IInteractorLoadListOfEvents,
    private val getListOfEvents: IInteractorGetListOfEvents,
    private val addToMyEvents: IInteractorAddToMyEvents,
    private val removeFromMyEvents: IInteractorRemoveFromMyEvents,
    private val loadClient: IInteractorLoadClient,
    private val getClient: IInteractorGetClient,
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
        val eventOrganizerId = uiState.value.eventDescription.organizer.id
        val isInMyCommunities = uiState.value.isInMyCommunities
        viewModelScope.launch {
            when (isInMyCommunities) {
                true -> {
                    removeFromMyCommunities.invoke(eventOrganizerId)
                }

                false -> {
                    addToMyCommunities.invoke(eventOrganizerId)
                }
            }
            loadClient.invoke()
        }
    }

    fun onJoinEventButtonClick(navigateToAppointmentScreen: () -> Unit) {
        val uiState = uiState.value
        when (uiState.client.phoneNumber.number.isNotBlank()) {
            true -> {
                viewModelScope.launch {
                    val eventId = uiState.eventDescription.id
                    val isInMyEvents = uiState.isInMyEvents
                    when (isInMyEvents) {
                        true -> {
                            removeFromMyEvents.invoke(eventId)
                        }

                        false -> {
                            addToMyEvents.invoke(eventId)
                        }
                    }
                }
            }

            false -> {
                navigateToAppointmentScreen()
            }
        }

    }

    private fun loadData() {
        loadEventDescription.invoke(eventId)
        loadListOfEvents.invoke()
        loadClient.invoke()
    }

    private fun getDataEventScreenUiState() {
        combine(
            getEventDescription.invoke(),
            getListOfEvents.invoke(),
            getClient.invoke()
        ) { eventDescription, listOfEvents, client ->
            _uiState.update { it ->
                it.copy(
                    eventDescription = mapper.toEventDescriptionModelUI(eventDescription),
                    communityOtherEventsList = listOfEvents.map { mapper.toEventModelUI(it) },
                    client = mapper.toClientModelUI(client)
                )
            }
        }.launchIn(viewModelScope)
    }
}