package com.example.spa_wb_junior_devmeetingapp.ui.screens.splashScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.SPLASH_SCREEN_DURATION
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

    init {
        viewModelScope.launch {
            delay(SPLASH_SCREEN_DURATION)
            _uiState.value = SplashScreenUiState(status = SplashScreenStatus.Finished)
        }
    }

    fun getSplashScreenUiStateFlow(): StateFlow<SplashScreenUiState> = uiState
}