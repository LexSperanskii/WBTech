package com.example.ui_v2.ui.screens.profileScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.navigation.NavigationDestination
import org.koin.androidx.compose.koinViewModel


internal object ProfileScreenDestination : NavigationDestination {
    override val route = "profile_screen"
}

@Composable
internal fun ProfileScreen(
    navigateTo: () -> Unit,
    viewModel: ProfileScreenViewModel = koinViewModel(),
) {
    val appointmentScreenUiState by viewModel.getProfileScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        ProfileScreenBody(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun ProfileScreenBody(
    modifier: Modifier = Modifier,
) {

}