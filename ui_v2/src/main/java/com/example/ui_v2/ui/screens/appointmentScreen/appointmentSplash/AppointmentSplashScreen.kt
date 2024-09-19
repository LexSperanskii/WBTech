package com.example.ui_v2.ui.screens.appointmentScreen.appointmentSplash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.R
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.ButtonWithStatus
import com.example.ui_v2.ui.components.TextButton
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus
import org.koin.androidx.compose.koinViewModel


internal object AppointmentSplashScreenDestination : NavigationDestination {
    override val route = "appointment_splash_screen"
}

@Composable
internal fun AppointmentSplashScreen(
    navigateToMyEvents: () -> Unit,
    navigateToFindOtherEvents: () -> Unit,
    viewModel: AppointmentSplashScreenViewModel = koinViewModel(),
) {
    val appointmentSplashScreenUiState by viewModel.getAppointmentSplashScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        AppointmentSplashScreenBody(
            event = appointmentSplashScreenUiState.event,
            onMyEventsButtonClick = navigateToMyEvents,
            onFindOtherEventsButtonClick = navigateToFindOtherEvents,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun AppointmentSplashScreenBody(
    event: EventDescriptionModelUI,
    onMyEventsButtonClick: () -> Unit,
    onFindOtherEventsButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.appointment_splash_background),
            contentDescription = stringResource(id = R.string.icon),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = modifier
                .padding(
                    top = 20.dp,
                    bottom = 28.dp,
                    start = DevMeetingAppTheme.dimensions.paddingMedium,
                    end = DevMeetingAppTheme.dimensions.paddingMedium
                )
        ) {
            Text(
                text = stringResource(id = R.string.signed_up),
                style = DevMeetingAppTheme.typography.customH3,
                color = DevMeetingAppTheme.colors.white,
                modifier = Modifier
                    .padding(bottom = 14.dp)
            )
            Text(
                text = stringResource(
                    id = R.string.signed_up_info,
                    event.name,
                    event.day,
                    event.month,
                    event.time,
                    event.street,
                    event.building
                ),
                style = DevMeetingAppTheme.typography.customH4,
                color = DevMeetingAppTheme.colors.white,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.weight(1f))

            TextButton(
                buttonText = stringResource(id = R.string.events_user),
                onButtonClick = onMyEventsButtonClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
            )
            ButtonWithStatus(
                notPressedText = stringResource(id = R.string.signed_up_button),
                isButtonEnabled = true,
                onClick = onFindOtherEventsButtonClick,
                buttonStatus = ButtonStatus.Active
            )
        }
    }
}