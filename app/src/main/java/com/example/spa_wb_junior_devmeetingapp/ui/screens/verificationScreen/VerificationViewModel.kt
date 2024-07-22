package com.example.spa_wb_junior_devmeetingapp.ui.screens.verificationScreen

import androidx.lifecycle.ViewModel
import com.example.domain.models.MockData
import com.example.spa_wb_junior_devmeetingapp.models.Mapper
import com.example.spa_wb_junior_devmeetingapp.models.PhoneNumberModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.PIN_CODE_LENGTH
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


data class VerificationScreenUiState(
    val phoneNumber: PhoneNumberModelUI = PhoneNumberModelUI(),
    val pinCode: String = "",
)

class VerificationViewModel(
    private val mapper: Mapper
) : ViewModel() {

    private val _uiState = MutableStateFlow(VerificationScreenUiState())
    private val uiState: StateFlow<VerificationScreenUiState> = _uiState.asStateFlow()

    fun getVerificationScreenUiStateFlow(): StateFlow<VerificationScreenUiState> = uiState

    init {
        _uiState.update {
            it.copy(
                phoneNumber = mapper.mapPhoneNumberToPhoneNumberModelUI(MockData.getUserPhoneNumber())
            )
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
        val pinCodeLength = _uiState.value.pinCode.length
        when (pinCodeLength) {
            PIN_CODE_LENGTH -> {
                navigate()
            }

            else -> {}
        }
    }
}