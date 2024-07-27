package com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.verificationScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecases.user.GetUserPhoneNumberUseCase
import com.example.domain.usecases.user.PinCodeVerificationUseCase
import com.example.spa_wb_junior_devmeetingapp.models.PhoneNumberModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toCountryModelUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.toPhoneNumberModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.EMPTY_STRING
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.PIN_CODE_LENGTH
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch


data class VerificationScreenUiState(
    val phoneNumber: PhoneNumberModelUI = PhoneNumberModelUI(),
    val pinCode: String = EMPTY_STRING,
)

class VerificationViewModel(
    private val getUserPhoneNumberUseCase: GetUserPhoneNumberUseCase,
    private val pinCodeVerificationUseCase: PinCodeVerificationUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(VerificationScreenUiState())
    private val uiState: StateFlow<VerificationScreenUiState> = _uiState.asStateFlow()

    fun getVerificationScreenUiStateFlow(): StateFlow<VerificationScreenUiState> = uiState

    init {
        getUserPhoneNumber()
    }

    private fun getUserPhoneNumber() {
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    phoneNumber = getUserPhoneNumberUseCase.execute().toPhoneNumberModelUI()
                )
            }
        }
    }

    fun onPinCodeChange(pinCode : String) {
        _uiState.update {
            it.copy(
                pinCode = pinCode
            )
        }
    }

    fun onDoneKeyboardPressed(navigate: () -> Unit) {
        val pinCode = _uiState.value.pinCode
        viewModelScope.launch {
            val isPinCodeValid = pinCodeVerificationUseCase.execute(pinCode.toInt())
            when(isPinCodeValid){
                true -> {
                    navigate()
                }
                else -> {
                    _uiState.update {
                        it.copy(
                            pinCode = EMPTY_STRING
                        )
                    }
                }
            }
        }
    }
}