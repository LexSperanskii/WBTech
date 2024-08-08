package com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.verificationScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.user.GetPinCodeVerificationUseCase
import com.example.domain.usecases.user.GetUserPhoneNumberUseCase
import com.example.domain.usecases.user.SetUserPinCodeUseCase
import com.example.spa_wb_junior_devmeetingapp.models.PhoneNumberModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.IMapperDomainUI
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.EMPTY_STRING
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


internal data class VerificationScreenUiState(
    val phoneNumber: PhoneNumberModelUI = PhoneNumberModelUI(),
    val pinCode: String = EMPTY_STRING,
)

internal class VerificationViewModel(
    private val mapper: IMapperDomainUI,
    private val getUserPhoneNumberUseCase: GetUserPhoneNumberUseCase,
    private val setUserPinCodeUseCase: SetUserPinCodeUseCase,
    private val getPinCodeVerificationUseCase: GetPinCodeVerificationUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(VerificationScreenUiState())
    private val uiState: StateFlow<VerificationScreenUiState> = _uiState.asStateFlow()

    init {
        getUserPhoneNumber()
    }

    fun getVerificationScreenUiStateFlow(): StateFlow<VerificationScreenUiState> = uiState

    fun onPinCodeChange(pinCode: String) {
        _uiState.update {
            it.copy(
                pinCode = pinCode
            )
        }
    }

    fun onDoneKeyboardPressed(navigate: () -> Unit) {
        val pinCode = uiState.value.pinCode
        viewModelScope.launch {
            setUserPinCodeUseCase.execute(pinCode)
            getPinCodeVerificationUseCase.execute()
                .collect { response ->
                    when (response) {
                        true -> {
                            navigate()
                            _uiState.update { it.copy(pinCode = EMPTY_STRING) }
                        }

                        else -> {
                            _uiState.update { it.copy(pinCode = EMPTY_STRING) }
                        }
                    }
                }
        }
    }

    private fun getUserPhoneNumber() {
        getUserPhoneNumberUseCase.execute()
            .onEach { phoneNumber ->
                _uiState.update {
                    it.copy(
                        phoneNumber = mapper.toPhoneNumberModelUI(phoneNumber)
                    )
                }
            }.launchIn(viewModelScope)
    }
}