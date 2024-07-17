package com.example.spa_wb_junior_devmeetingapp.ui.screens.authenticationScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.model.Country
import com.example.spa_wb_junior_devmeetingapp.model.PhoneNumber
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.PhoneNumberInput
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TopAppBarBackNameAction
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons.CustomButton
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DarkPurple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Heading2
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Purple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Subheading2
import org.koin.androidx.compose.koinViewModel

object AuthenticationDestination : NavigationDestination {
    override val route = "authentication"
    override val title = R.string.authentication
}

@Composable
fun AuthenticationScreen(
    navigateToVerificationScreen: (PhoneNumber) -> Unit,
    onClickNavigateBack: () -> Unit,
    viewModel: AuthenticationViewModel = koinViewModel(),
    ) {

    val authenticationUiState by viewModel.getAuthenticationScreenUiStateFlow().collectAsState()

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
            number = authenticationUiState.phoneNumber.number,
            onNumberChange = { viewModel.changeNumber(it) },
            countryCode = authenticationUiState.country,
            onCountryCodeChange = { viewModel.changeCountryCode(it) },
            listOfCountriesCodes = authenticationUiState.listOfCountries,
            isForwardButtonEnabled = authenticationUiState.isButtonEnabled,
            onForwardButtonClick = {navigateToVerificationScreen(authenticationUiState.phoneNumber)},
            modifier = Modifier.padding(innerPadding)
            )
    }
}

@Composable
fun AuthenticationBody(
    number: String,
    onNumberChange: (String) -> Unit,
    countryCode: Country,
    onCountryCodeChange: (Country) -> Unit,
    onForwardButtonClick: () -> Unit,
    isForwardButtonEnabled:Boolean,
    listOfCountriesCodes:  List<Country>,
    modifier: Modifier = Modifier
    ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().padding(24.dp)
    ) {
        Text(
            text = stringResource(id = R.string.enter_your_number),
            fontSize = MaterialTheme.typography.Heading2.fontSize,
            fontWeight = FontWeight.Bold,
            fontFamily = SFProDisplay,
            modifier = Modifier.padding(top = 80.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(id = R.string.we_will_send_you_verification_code),
            fontSize = MaterialTheme.typography.BodyText1.fontSize,
            fontWeight = FontWeight.Normal,
            fontFamily = SFProDisplay,
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
            pressedColor = DarkPurple,
            containerColor = Purple,
            enabled = isForwardButtonEnabled,
            text = stringResource(id = R.string.forward_button),
            fontSize = MaterialTheme.typography.Subheading2.fontSize,
            fontWeight = FontWeight.SemiBold,
            fontFamily = SFProDisplay,
            modifier = Modifier.fillMaxWidth().height(52.dp)
        )

    }
}