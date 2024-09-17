package com.example.ui_v2.ui.screens.appointmentScreen.appointmentSplash

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.eventDescription.IInteractorGetEventDescription
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update


internal data class AppointmentSplashScreenUiState(
    val event: EventDescriptionModelUI = EventDescriptionModelUI(),
)

internal class AppointmentSplashScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val mapper: IMapperDomainUI,
//    private val loadEventDescription: IInteractorLoadEventDescription,
    private val getEventDescription: IInteractorGetEventDescription,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AppointmentSplashScreenUiState())
    private val uiState: StateFlow<AppointmentSplashScreenUiState> = _uiState.asStateFlow()

//    private val eventId: String = try {
//        checkNotNull(savedStateHandle[AppointmentDestination.itemIdArg])
//    } catch (e: IllegalStateException) {
//        // TODO: do state with error
//        DEFAULT_ID
//    }

    init {
        loadData()
        getDataAppointmentSplashScreenUiState()
    }

    fun getAppointmentSplashScreenUiStateFlow(): StateFlow<AppointmentSplashScreenUiState> = uiState

    private fun loadData() {
//        loadEventDescription.invoke(eventId)
    }

    private fun getDataAppointmentSplashScreenUiState() {
        getEventDescription.invoke()
            .onEach { eventDescription ->
                _uiState.update { it ->
                    it.copy(
                        event = mapper.toEventDescriptionModelUI(eventDescription)
                    )
                }
            }
            .launchIn(viewModelScope)
    }
}