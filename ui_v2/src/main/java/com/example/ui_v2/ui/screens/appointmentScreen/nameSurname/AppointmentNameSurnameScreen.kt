package com.example.ui_v2.ui.screens.appointmentScreen.nameSurname

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.R
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.AppointmentHeader
import com.example.ui_v2.ui.components.ButtonWithStatus
import com.example.ui_v2.ui.components.NameSurnameTextField
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus
import org.koin.androidx.compose.koinViewModel

internal object AppointmentDestination : NavigationDestination {
    override val route = "appointment"
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

internal object AppointmentNameSurnameScreenDestination : NavigationDestination {
    override val route = "appointment_name_surname_screen"
}

@Composable
internal fun AppointmentNameSurnameScreen(
    navigateToAppointmentPhoneNumberScreen: (eventId: String) -> Unit,
    onCrossClick: () -> Unit,
    viewModel: AppointmentNameSurnameScreenViewModel = koinViewModel(),
) {
    val appointmentNameSurnameScreenUiState by viewModel.getAppointmentNameSurnameScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        AppointmentNameSurnameScreenBody(
            event = appointmentNameSurnameScreenUiState.event,
            onCrossClick = onCrossClick,
            nameSurnameValue = appointmentNameSurnameScreenUiState.nameSurnameValue,
            isNameSurnameValid = appointmentNameSurnameScreenUiState.isNameSurnameValid,
            onNameSurnameChange = {
                viewModel.onNameSurnameChange(it)
            },
            isButtonEnabled = appointmentNameSurnameScreenUiState.isButtonEnabled,
            onButtonClick = {
                viewModel.onButtonClick()
                navigateToAppointmentPhoneNumberScreen(appointmentNameSurnameScreenUiState.event.id)
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun AppointmentNameSurnameScreenBody(
    event: EventDescriptionModelUI,
    onCrossClick: () -> Unit,
    nameSurnameValue: String,
    isNameSurnameValid: Boolean,
    onNameSurnameChange: (String) -> Unit,
    isButtonEnabled: Boolean,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(
                top = 20.dp,
                bottom = 28.dp,
                start = DevMeetingAppTheme.dimensions.paddingMedium,
                end = DevMeetingAppTheme.dimensions.paddingMedium
            )
    ) {
        AppointmentHeader(
            event = event,
            onCrossClick = onCrossClick,
            modifier = Modifier
                .padding(bottom = 24.dp)
        )
        NameSurnameTextField(
            value = nameSurnameValue,
            isValid = isNameSurnameValid,
            onValueChange = onNameSurnameChange
        )
        Spacer(modifier = Modifier.weight(1f))
        ButtonWithStatus(
            notPressedText = stringResource(id = R.string.proceed),
            isButtonEnabled = isButtonEnabled,
            onClick = onButtonClick,
            buttonStatus = ButtonStatus.Active
        )
    }

}