package com.example.ui_v2.ui.screens.appointmentScreen.phoneNumber

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
import com.example.ui_v2.models.CountryModelUI
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.AppointmentHeader
import com.example.ui_v2.ui.components.ButtonWithStatus
import com.example.ui_v2.ui.components.PhoneNumberInput
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus
import org.koin.androidx.compose.koinViewModel


internal object AppointmentPhoneNumberScreenDestination : NavigationDestination {
    override val route = "appointment_phone_number_screen"
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@Composable
internal fun AppointmentPhoneNumberScreen(
    navigateToAppointmentVerificationScreen: (eventId: String) -> Unit,
    onCrossClick: () -> Unit,
    viewModel: AppointmentPhoneNumberScreenViewModel = koinViewModel(),
) {
    val appointmentPhoneNumberScreenUiState by viewModel.getAppointmentPhoneNumberScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        AppointmentPhoneNumberScreenBody(
            event = appointmentPhoneNumberScreenUiState.event,
            onCrossClick = onCrossClick,
            number = appointmentPhoneNumberScreenUiState.number,
            onNumberChange = {
                viewModel.onNumberChange(it)
            },
            countryCode = appointmentPhoneNumberScreenUiState.countryCode,
            onCountryCodeChange = {
                viewModel.onCountryCodeChange(it)
            },
            listOfCountriesCodes = appointmentPhoneNumberScreenUiState.listOfCountriesCodes,
            onButtonClick = {
                viewModel.onButtonClick()
                navigateToAppointmentVerificationScreen(appointmentPhoneNumberScreenUiState.event.id)
            },
            isButtonEnabled = appointmentPhoneNumberScreenUiState.isButtonEnabled,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun AppointmentPhoneNumberScreenBody(
    event: EventDescriptionModelUI,
    onCrossClick: () -> Unit,
    number: String,
    onNumberChange: (String) -> Unit,
    countryCode: CountryModelUI,
    onCountryCodeChange: (CountryModelUI) -> Unit,
    listOfCountriesCodes: List<CountryModelUI>,
    onButtonClick: () -> Unit,
    isButtonEnabled: Boolean,
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
        PhoneNumberInput(
            number = number,
            onNumberChange = onNumberChange,
            countryCode = countryCode,
            onCountryCodeChange = onCountryCodeChange,
            listOfCountriesCodes = listOfCountriesCodes
        )
        Spacer(modifier = Modifier.weight(1f))
        ButtonWithStatus(
            notPressedText = stringResource(id = R.string.get_code),
            isButtonEnabled = isButtonEnabled,
            onClick = onButtonClick,
            buttonStatus = ButtonStatus.Active
        )
    }

}