package com.example.spa_wb_junior_devmeetingapp.ui.screens.splashScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


enum class SplashScreenStatus {
    Loading,
    Finished
}

data class SplashScreenUiState(
    val status: SplashScreenStatus = SplashScreenStatus.Loading
)

class SplashScreenViewModel() : ViewModel() {

    private val _uiState = MutableStateFlow(SplashScreenUiState())
    private val uiState: StateFlow<SplashScreenUiState> = _uiState.asStateFlow()

    fun getSplashScreenUiStateFlow(): StateFlow<SplashScreenUiState> = uiState

    init {
        viewModelScope.launch {
            delay(3000)
            _uiState.value = SplashScreenUiState(status = SplashScreenStatus.Finished)
        }
    }
}