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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.data.mockData.Country
import com.example.spa_wb_junior_devmeetingapp.data.mockData.countryList
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

object AuthenticationDestination : NavigationDestination {
    override val route = "authentication"
    override val title = R.string.authentication
}

@Composable
fun AuthenticationScreen(
    navigateToVerificationScreen: () -> Unit,
    onClickNavigateBack: () -> Unit
) {

    var countryCode by remember { mutableStateOf(countryList[0]) }
    var phoneNumber by remember { mutableStateOf("") }

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
            modifier = Modifier.padding(innerPadding),
            phoneNumber = phoneNumber,
            onPhoneNumberChange = { phoneNumber = it },
            countryCode = countryCode,
            onCountryCodeChange = { countryCode = it },
            onForwardButtonClick = navigateToVerificationScreen,
            isForwardButtonEnabled = phoneNumber.length == 10
        )
    }
}

@Composable
fun AuthenticationBody(
    phoneNumber: String,
    onPhoneNumberChange: (String) -> Unit,
    countryCode: Country,
    onCountryCodeChange: (Country) -> Unit,
    onForwardButtonClick: () -> Unit,
    isForwardButtonEnabled:Boolean,
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
            phoneNumber = phoneNumber,
            onPhoneNumberChange = onPhoneNumberChange,
            countryCode = countryCode,
            onCountryCodeChange = onCountryCodeChange,
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