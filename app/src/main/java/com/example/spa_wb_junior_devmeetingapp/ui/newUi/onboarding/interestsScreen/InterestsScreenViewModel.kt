package com.example.spa_wb_junior_devmeetingapp.ui.newUi.onboarding.interestsScreen

import androidx.lifecycle.ViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.components.ButtonStatus
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

internal data class InterestsScreenUiState(
    val listOfTags: List<String> = listOf(),
    val listOfChosenTags: List<String> = listOf(),
    val buttonStatus: ButtonStatus = ButtonStatus.NotPressed,
) {
    val isButtonEnabled: Boolean
        get() = listOfChosenTags.isNotEmpty()
}

internal class InterestsScreenViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(InterestsScreenUiState())
    private val uiState: StateFlow<InterestsScreenUiState> = _uiState.asStateFlow()

    init {
        _uiState.update {
            it.copy(
                listOfTags = listOf(
                    "Дизайн",
                    "Разработка",
                    "Продакт Менеджмент",
                    "Проджект менеджмент",
                    "Backend", "Frontend", "Mobile",
                    "Тестирование", "Продажи", "Бизнес",
                    "Безопасность", "Web", "Девопс", "Маркетинг", "Аналитика"
                ),
            )
        }
    }

    fun getInterestsScreenUiStateFlow(): StateFlow<InterestsScreenUiState> = uiState

    fun onTagClick(tag: String) {
        _uiState.update { currentState ->
            val updatedList = currentState.listOfChosenTags.toMutableList().apply {
                when (this.contains(tag)) {
                    true -> {
                        remove(tag)
                    }

                    else -> {
                        add(tag)
                    }
                }
            }
            currentState.copy(listOfChosenTags = updatedList)
        }
    }

}