package com.example.ui_v2.ui.screens.communityScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.navigation.NavigationDestination
import org.koin.androidx.compose.koinViewModel


internal object CommunityScreenDestination : NavigationDestination {
    override val route = "community_screen"
}

@Composable
internal fun CommunityScreen(
    navigateTo: () -> Unit,
    viewModel: CommunityScreenViewModel = koinViewModel(),
) {
    val communityScreenUiState by viewModel.getCommunityScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        CommunityScreenBody(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun CommunityScreenBody(
    modifier: Modifier = Modifier,
) {

}