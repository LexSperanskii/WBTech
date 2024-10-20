package com.example.ui_v1.ui.registration.registratinProfileScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v1.R
import com.example.ui_v1.navigation.UIv1NavigationDestination
import com.example.ui_v1.ui.elements.CustomTextField
import com.example.ui_v1.ui.elements.PersonAvatar
import com.example.ui_v1.ui.elements.TopAppBarBackNameAction
import com.example.ui_v1.ui.elements.buttons.CustomButton
import com.example.ui_v1.ui.theme.DevMeetingAppTheme
import org.koin.androidx.compose.koinViewModel

internal object RegistrationProfileDestinationUIv1 : UIv1NavigationDestination {
    override val route = "registration_profile"
    override val title = R.string.profile
}

@Composable
internal fun RegistrationProfileScreen(
    onClickNavigateBack: () -> Unit,
    navigateToEventsAllScreen: () -> Unit,
    viewModel: RegistrationProfileViewModel = koinViewModel()
) {

    val registrationProfileScreenUiState by viewModel.getRegistrationProfileScreenUiStateFlow().collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBarBackNameAction(
                title = stringResource(id = RegistrationProfileDestinationUIv1.title),
                isNavigateBack = true,
                onClickNavigateBack = onClickNavigateBack,
                isAddCapable = false
            )
        }
    ) { innerPadding ->
        RegistrationProfileScreenBody(
            name = registrationProfileScreenUiState.name,
            onNameChange = {
                viewModel.onNameChange(it)
            },
            surname = registrationProfileScreenUiState.surname,
            onSurnameChange = {
                viewModel.onSurnameChange(it)
            },
            isButtonSafeEnabled = registrationProfileScreenUiState.isButtonEnabled,
            avatarURL = registrationProfileScreenUiState.avatarURL ,
            onEditAvatarClick = {viewModel.onAvatarEditButtonClick()},
            onButtonSafeClick = {
                viewModel.inButtonSaveClick()
                navigateToEventsAllScreen()
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun RegistrationProfileScreenBody(
    name: String,
    onNameChange: (String) -> Unit,
    surname: String,
    onSurnameChange: (String) -> Unit,
    onButtonSafeClick: () -> Unit,
    avatarURL: String?,
    onEditAvatarClick: () -> Unit,
    isButtonSafeEnabled:Boolean,
    modifier: Modifier = Modifier
    ) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        PersonAvatar(
            size = DevMeetingAppTheme.dimensions.avatarM,
            isEdit = true,
            imageURL = avatarURL,
            onEditClick = onEditAvatarClick,
            modifier = Modifier.padding(top = 46.dp, bottom = 31.dp)
        )
        CustomTextField(
            value = name,
            placeholder = stringResource(id = R.string.name_required),
            onValueChange = onNameChange,
            modifier = Modifier.padding(bottom = 12.dp)
        )
        CustomTextField(
            value = surname,
            placeholder = stringResource(id = R.string.surname_optional),
            onValueChange = onSurnameChange,
            modifier = Modifier.padding(bottom = 56.dp)
        )
        CustomButton(
            onClick = onButtonSafeClick,
            pressedColor = DevMeetingAppTheme.colors.darkPurple,
            containerColor = DevMeetingAppTheme.colors.purple,
            enabled = isButtonSafeEnabled,
            text = stringResource(id = R.string.safe),
            textStyle = DevMeetingAppTheme.typography.subheading2,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        )

    }
}