package com.example.ui_v2.ui.screens.appointmentScreen.nameSurname

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.interactors.client.IInteractorSetClientNotVerifiedName
import com.example.domain.interactors.eventDescription.IInteractorGetEventDescription
import com.example.domain.interactors.eventDescription.IInteractorLoadEventDescription
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.models.mapper.IMapperDomainUI
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_ID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal data class AppointmentNameSurnameScreenUiState(
    val event: EventDescriptionModelUI = EventDescriptionModelUI(),
    val nameSurnameValue: String = "",
    val isNameSurnameValid: Boolean = true,
) {
    val isButtonEnabled: Boolean
        get() = nameSurnameValue.isNotBlank() && isNameSurnameValid
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
        // TODO: do state with error
        DEFAULT_ID
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
                isNameSurnameValid = inputValue.isNotBlank() && inputValue.length > 1
            )
        }
    }

    fun onButtonClick() {
        val nameSurname = uiState.value.nameSurnameValue
        viewModelScope.launch {
            setClientNotVerifiedName.invoke(nameSurname)
        }
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