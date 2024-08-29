package com.example.ui_v2.ui.screens.peopleScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.navigation.NavigationDestination
import org.koin.androidx.compose.koinViewModel


internal object PeopleScreenDestination : NavigationDestination {
    override val route = "people_screen"
}

@Composable
internal fun PeopleScreen(
    navigateTo: () -> Unit,
    viewModel: PeopleScreenViewModel = koinViewModel(),
) {
    val peopleScreenUiState by viewModel.getPeopleScreenUiStateFlow().collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        PeopleScreenBody(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun PeopleScreenBody(
    modifier: Modifier = Modifier,
) {

}