package com.example.ui_v2.ui.screens.mainScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.navigation.NavigationDestination
import org.koin.androidx.compose.koinViewModel


internal object MainScreenDestination : NavigationDestination {
    override val route = "main_screen"
}

@Composable
internal fun MainScreen(
    navigateToLocationScreen: () -> Unit,
    viewModel: MainScreenViewModel = koinViewModel(),
) {
    val mainScreenUiState by viewModel.getMainScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        MainScreenBody(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun MainScreenBody(
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {

    }
}