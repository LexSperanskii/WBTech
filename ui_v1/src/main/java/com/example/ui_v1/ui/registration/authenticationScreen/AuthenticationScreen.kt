package com.example.ui_v1.ui.registration.authenticationScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v1.R
import com.example.ui_v1.models.UIv1CountryModelUI
import com.example.ui_v1.navigation.UIv1NavigationDestination
import com.example.ui_v1.ui.elements.PhoneNumberInput
import com.example.ui_v1.ui.elements.TopAppBarBackNameAction
import com.example.ui_v1.ui.elements.buttons.CustomButton
import com.example.ui_v1.ui.theme.DevMeetingAppTheme
import org.koin.androidx.compose.koinViewModel

internal object AuthenticationDestinationUIv1 : UIv1NavigationDestination {
    override val route = "authentication"
    override val title = R.string.authentication
}

@Composable
internal fun AuthenticationScreen(
    navigateToVerificationScreen: () -> Unit,
    onClickNavigateBack: () -> Unit,
    viewModel: AuthenticationViewModel = koinViewModel(),
    ) {

    val authenticationUiState by viewModel.getAuthenticationScreenUiStateFlow().collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBarBackNameAction(
                title = "",
                isNavigateBack = true,
                onClickNavigateBack = onClickNavigateBack,
                isAddCapable = false
            )
        }
    ) { innerPadding ->
        AuthenticationBody(
            number = authenticationUiState.number,
            onNumberChange = { viewModel.changeNumber(it) },
            countryCode = authenticationUiState.country,
            onCountryCodeChange = { viewModel.changeCountryCode(it) },
            listOfCountriesCodes = authenticationUiState.listOfCountries,
            isForwardButtonEnabled = authenticationUiState.isButtonEnabled,
            onForwardButtonClick = {
                viewModel.onForwardButtonClick()
                navigateToVerificationScreen()
            },
            modifier = Modifier.padding(innerPadding)
            )
    }
}

@Composable
internal fun AuthenticationBody(
    number: String,
    onNumberChange: (String) -> Unit,
    countryCode: UIv1CountryModelUI,
    onCountryCodeChange: (UIv1CountryModelUI) -> Unit,
    onForwardButtonClick: () -> Unit,
    isForwardButtonEnabled: Boolean,
    listOfCountriesCodes: List<UIv1CountryModelUI>,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text(
            text = stringResource(id = R.string.enter_your_number),
            style = DevMeetingAppTheme.typography.heading2,
            modifier = Modifier.padding(top = 80.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(id = R.string.we_will_send_you_verification_code),
            style = DevMeetingAppTheme.typography.bodyText2,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 50.dp)
        )
        PhoneNumberInput(
            number = number,
            onNumberChange = onNumberChange,
            countryCode = countryCode,
            onCountryCodeChange = onCountryCodeChange,
            listOfCountriesCodes = listOfCountriesCodes,
            modifier = Modifier.padding(bottom = 70.dp)
        )
        CustomButton(
            onClick = onForwardButtonClick,
            pressedColor = DevMeetingAppTheme.colors.darkPurple,
            containerColor = DevMeetingAppTheme.colors.purple,
            enabled = isForwardButtonEnabled,
            text = stringResource(id = R.string.forward_button),
            textStyle = DevMeetingAppTheme.typography.subheading2,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        )
    }
}