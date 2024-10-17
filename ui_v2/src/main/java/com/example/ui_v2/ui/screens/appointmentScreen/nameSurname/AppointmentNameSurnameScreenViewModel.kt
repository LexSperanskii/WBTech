package com.example.ui_v2.ui.screens.appointmentScreen.nameSurname

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.client.setClientNotVerifiedName.IInteractorSetClientNotVerifiedName
import com.example.domain.interactors.eventDescription.IInteractorGetEventDescription
import com.example.domain.interactors.eventDescription.IInteractorLoadEventDescription
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

internal data class AppointmentNameSurnameScreenUiState(
    val event: EventDescriptionModelUI = EventDescriptionModelUI(),
    val nameSurnameValue: String = "",
) {
    val isNameSurnameValid: Boolean
        get() = nameSurnameValue.isNotBlank() && nameSurnameValue.length > 1
    val isButtonEnabled: Boolean
        get() = isNameSurnameValid
}

internal class AppointmentNameSurnameScreenViewModel(
    savedStateHandle: SavedStateHandle,
    private val mapper: IMapperDomainUI,
    private val loadEventDescription: IInteractorLoadEventDescription,
    private val getEventDescription: IInteractorGetEventDescription,
    private val setClientNotVerifiedName: IInteractorSetClientNotVerifiedName,
) : ViewModel() {

    private val eventId: String = try {
        checkNotNull(savedStateHandle[AppointmentDestination.itemIdArg])
    } catch (e: IllegalStateException) {
        throw IllegalArgumentException("Missing appointment ID", e)
    }

    private val _uiState = MutableStateFlow(AppointmentNameSurnameScreenUiState())
    private val uiState: StateFlow<AppointmentNameSurnameScreenUiState> = _uiState.asStateFlow()

    init {
        loadData()
        getDataAppointmentNameSurnameScreenUiState()
    }

    fun getAppointmentNameSurnameScreenUiStateFlow(): StateFlow<AppointmentNameSurnameScreenUiState> =
        uiState

    fun onNameSurnameChange(inputValue: String) {
        _uiState.update {
            it.copy(
                nameSurnameValue = inputValue,
            )
        }
    }

    fun onButtonClick() {
        setClientNotVerifiedName.invoke(uiState.value.nameSurnameValue)
    }

    private fun loadData() {
        loadEventDescription.invoke(eventId)
    }

    private fun getDataAppointmentNameSurnameScreenUiState() {
        getEventDescription.invoke()
            .onEach { eventDescription ->
                _uiState.update {
                    it.copy(
                        event = mapper.toEventDescriptionModelUI(eventDescription)
                    )
                }
            }
            .launchIn(viewModelScope)
    }
}