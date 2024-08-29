package com.example.ui_v2.ui.screens.eventScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.navigation.NavigationDestination
import org.koin.androidx.compose.koinViewModel


internal object EventScreenDestination : NavigationDestination {
    override val route = "event_screen"
}

@Composable
internal fun EventScreen(
    navigateTo: () -> Unit,
    viewModel: EventScreenViewModel = koinViewModel(),
) {
    val eventScreenUiState by viewModel.getEventScreenUiStateFlow().collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        EventScreenBody(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun EventScreenBody(
    modifier: Modifier = Modifier,
) {

}