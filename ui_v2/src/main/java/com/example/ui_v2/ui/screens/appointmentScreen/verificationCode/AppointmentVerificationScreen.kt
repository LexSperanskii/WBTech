package com.example.ui_v2.ui.screens.appointmentScreen.verificationCode

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.R
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.models.PhoneNumberModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.AppointmentHeader
import com.example.ui_v2.ui.components.ButtonWithStatus
import com.example.ui_v2.ui.components.CountdownButton
import com.example.ui_v2.ui.components.PinCodeTextField
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus
import com.example.ui_v2.ui.utils.UiUtils.formattedMobileNumber
import org.koin.androidx.compose.koinViewModel


internal object AppointmentVerificationScreenDestination : NavigationDestination {
    override val route = "appointment_verification_screen"
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@Composable
internal fun AppointmentVerificationScreen(
    navigateToAppointmentSplashScreen: (eventId: String) -> Unit,
    onCrossClick: () -> Unit,
    viewModel: AppointmentVerificationScreenViewModel = koinViewModel(),
) {
    val appointmentVerificationScreenUiState by viewModel.getAppointmentVerificationScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    LaunchedEffect(key1 = appointmentVerificationScreenUiState.isPinCodeValid) {
        if (appointmentVerificationScreenUiState.isPinCodeValid) {
            viewModel.setVerifiedClientNameAndPhoneNumber()
            navigateToAppointmentSplashScreen(appointmentVerificationScreenUiState.event.id)
        }
    }

    Scaffold { innerPadding ->
        AppointmentVerificationScreenBody(
            event = appointmentVerificationScreenUiState.event,
            onCrossClick = onCrossClick,
            pinCode = appointmentVerificationScreenUiState.pinCode,
            isPinCodeValid = appointmentVerificationScreenUiState.isPinCodeFieldStateValid,
            onPinCodeChange = {
                viewModel.onPinCodeChange(it)
            },
            phoneNumber = appointmentVerificationScreenUiState.clientNotVerifiedPhoneNumber,
            countdown = appointmentVerificationScreenUiState.countdown,
            isCountdownEnabled = appointmentVerificationScreenUiState.isCountdownEnabled,
            onCountdownClick = {
                viewModel.startCountdown()
            },
            isButtonEnabled = appointmentVerificationScreenUiState.isButtonEnabled,
            onButtonClick = {
                viewModel.onButtonClick()
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun AppointmentVerificationScreenBody(
    event: EventDescriptionModelUI,
    onCrossClick: () -> Unit,
    pinCode: String,
    isPinCodeValid: Boolean,
    onPinCodeChange: (String) -> Unit,
    phoneNumber: PhoneNumberModelUI,
    countdown: Int,
    isCountdownEnabled: Boolean,
    onCountdownClick: () -> Unit,
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

        PinCodeTextField(
            value = pinCode,
            isValid = isPinCodeValid,
            onValueChange = onPinCodeChange,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        when (isPinCodeValid) {
            true -> {
                Text(
                    text = stringResource(
                        id = R.string.pin_code_number,
                        formattedMobileNumber(phoneNumber)
                    ),
                    style = DevMeetingAppTheme.typography.metadata1,
                    color = DevMeetingAppTheme.colors.eventCardText,
                    modifier = Modifier
                )
            }
            false -> {
                Text(
                    text = stringResource(id = R.string.incorrect_pin),
                    style = DevMeetingAppTheme.typography.metadata1,
                    color = DevMeetingAppTheme.colors.incorrectPin,
                    modifier = Modifier
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        CountdownButton(
            countdown = countdown,
            isButtonEnabled = isCountdownEnabled,
            onClick = onCountdownClick,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(bottom = 24.dp)
        )

        ButtonWithStatus(
            notPressedText = stringResource(id = R.string.submit_confirm),
            isButtonEnabled = isButtonEnabled,
            onClick = onButtonClick,
            buttonStatus = ButtonStatus.Active
        )
    }

}