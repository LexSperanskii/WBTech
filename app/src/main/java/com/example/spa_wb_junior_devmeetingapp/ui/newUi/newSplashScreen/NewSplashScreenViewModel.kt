package com.example.spa_wb_junior_devmeetingapp.ui.newUi.newSplashScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.SPLASH_SCREEN_DURATION
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


internal enum class NewSplashScreenStatus {
    Loading,
    Finished
}

internal data class NewSplashScreenUiState(
    val status: NewSplashScreenStatus = NewSplashScreenStatus.Loading,
)

internal class NewSplashScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(NewSplashScreenUiState())
    private val uiState: StateFlow<NewSplashScreenUiState> = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            delay(SPLASH_SCREEN_DURATION)
            _uiState.value = NewSplashScreenUiState(status = NewSplashScreenStatus.Finished)
        }
    }

    fun getNewSplashScreenUiStateFlow(): StateFlow<NewSplashScreenUiState> = uiState
}