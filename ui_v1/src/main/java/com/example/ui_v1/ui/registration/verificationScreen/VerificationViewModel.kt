package com.example.ui_v1.ui.registration.verificationScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.user.Uiv1GetPinCodeVerificationUseCase
import com.example.domain.usecases.user.Uiv1GetUserPhoneNumberUseCase
import com.example.domain.usecases.user.Uiv1SetUserPinCodeUseCase
import com.example.ui_v1.models.PhoneNumberModelUI
import com.example.ui_v1.models.mapper.IMapperDomainUI
import com.example.ui_v1.utils.UiUtils.EMPTY_STRING
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
    private val uiv1GetUserPhoneNumberUseCase: Uiv1GetUserPhoneNumberUseCase,
    private val uiv1SetUserPinCodeUseCase: Uiv1SetUserPinCodeUseCase,
    private val uiv1GetPinCodeVerificationUseCase: Uiv1GetPinCodeVerificationUseCase,
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
            try {
                uiv1SetUserPinCodeUseCase.execute(pinCode)
                uiv1GetPinCodeVerificationUseCase.execute()
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
            } catch (e: Exception) {
                // TODO: handle
            }
        }
    }

    private fun getUserPhoneNumber() {
        uiv1GetUserPhoneNumberUseCase.execute()
            .onEach { phoneNumber ->
                _uiState.update {
                    it.copy(
                        phoneNumber = mapper.toPhoneNumberModelUI(phoneNumber)
                    )
                }
            }.launchIn(viewModelScope)
    }
}