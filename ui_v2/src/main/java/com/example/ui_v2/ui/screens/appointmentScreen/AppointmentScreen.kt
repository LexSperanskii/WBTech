package com.example.ui_v2.ui.screens.appointmentScreen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.navigation.NavigationDestination
import org.koin.androidx.compose.koinViewModel


internal object AppointmentScreenDestination : NavigationDestination {
    override val route = "appointment_screen"
}

@Composable
internal fun AppointmentScreen(
    navigateTo: () -> Unit,
    viewModel: AppointmentScreenViewModel = koinViewModel(),
) {
    val appointmentScreenUiState by viewModel.getAppointmentScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        AppointmentScreenBody(
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun AppointmentScreenBody(
    modifier: Modifier = Modifier,
) {

}