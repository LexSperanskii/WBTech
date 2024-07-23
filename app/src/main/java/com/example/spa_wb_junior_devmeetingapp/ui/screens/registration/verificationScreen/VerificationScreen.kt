package com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.verificationScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.models.PhoneNumberModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.PinCodeInput
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TopAppBarBackNameAction
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons.CustomButtonText
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.formattedMobileNumber
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme
import org.koin.androidx.compose.koinViewModel

object VerificationDestination : NavigationDestination {
    override val route = "verification"
    override val title = R.string.verification
}

@Composable
fun VerificationScreen(
    onClickNavigateBack: () -> Unit,
    navigateToRegistrationProfile: () -> Unit,
    viewModel: VerificationViewModel = koinViewModel()
) {

    val verificationScreenUiState by viewModel.getVerificationScreenUiStateFlow().collectAsState()


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
        VerificationBody(
            phoneNumber = verificationScreenUiState.phoneNumber,
            picCode = verificationScreenUiState.pinCode,
            onPinCodeChange = {
                viewModel.onPinCodeChange(it)
            },
            onDoneKeyboardPressed = {
                viewModel.onDoneKeyboardPressed { navigateToRegistrationProfile() }
            },
            onRequestButtonClick = {},
            isRequestButtonEnabled = true,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun VerificationBody(
    phoneNumber: PhoneNumberModelUI,
    picCode: String,
    onPinCodeChange: (String) -> Unit,
    onDoneKeyboardPressed: () -> Unit,
    onRequestButtonClick: () -> Unit,
    isRequestButtonEnabled: Boolean,
    modifier: Modifier = Modifier,
    ) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        Text(
            text = stringResource(id = R.string.enter_your_code),
            style = DevMeetingAppTheme.typography.heading2,
            modifier = Modifier.padding(top = 80.dp, bottom = 8.dp)
        )
        Text(
            text = stringResource(id = R.string.sent_you_verification_code, formattedMobileNumber(phoneNumber)),
            style = DevMeetingAppTheme.typography.bodyText2,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 50.dp)
        )
        PinCodeInput(
            value = picCode,
            onValueChange = onPinCodeChange,
            onDoneKeyboardPressed = onDoneKeyboardPressed,
            modifier = Modifier.padding(bottom = 70.dp)
        )
        CustomButtonText(
            onClick = onRequestButtonClick,
            pressedColor = DevMeetingAppTheme.colors.darkPurple,
            contentColor = DevMeetingAppTheme.colors.purple,
            enabled = isRequestButtonEnabled,
            text = stringResource(id = R.string.request_code_again),
            textStyle = DevMeetingAppTheme.typography.subheading2,
            modifier = Modifier
                .padding(horizontal = 64.dp)
                .fillMaxWidth()
                .height(52.dp)
        )
    }
}