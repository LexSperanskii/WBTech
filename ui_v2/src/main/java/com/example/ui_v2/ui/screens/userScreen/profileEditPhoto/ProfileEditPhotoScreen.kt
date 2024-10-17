package com.example.ui_v2.ui.screens.userScreen.profileEditPhoto

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.R
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.ButtonWithStatus
import com.example.ui_v2.ui.components.PersonAvatarForUserScreen
import com.example.ui_v2.ui.components.TextButton
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus
import org.koin.androidx.compose.koinViewModel


internal object ProfileEditPhotoScreenDestination : NavigationDestination {
    override val route = "delete_edit_photo_screen"
}

@Composable
internal fun ProfileEditPhotoScreen(
    navigateBack: () -> Unit,
    viewModel: ProfileEditPhotoScreenViewModel = koinViewModel(),
) {

    val profileEditPhotoScreenUiState by viewModel.getProfileEditPhotoScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        ProfileEditPhotoScreenBody(
            avatar = profileEditPhotoScreenUiState.avatar,
            onCrossClick = navigateBack,
            onChangePhotoClick = { viewModel.onChangePhotoClick() },
            isButtonSaveEnabled = profileEditPhotoScreenUiState.isButtonSaveEnabled,
            onButtonSaveClick = {
                viewModel.onButtonSaveClick()
                navigateBack()
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun ProfileEditPhotoScreenBody(
    avatar: String?,
    onCrossClick: () -> Unit,
    onChangePhotoClick: () -> Unit,
    isButtonSaveEnabled: Boolean,
    onButtonSaveClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(DevMeetingAppTheme.colors.black)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.icon_cross),
            contentDescription = stringResource(id = R.string.icon),
            tint = DevMeetingAppTheme.colors.eventCardText,
            modifier = Modifier
                .padding(
                    horizontal = 16.dp,
                    vertical = 20.dp
                )
                .size(24.dp)
                .clickable {
                    onCrossClick()
                }
        )
        PersonAvatarForUserScreen(
            imageURL = avatar,
            modifier = Modifier
                .padding(top = 140.dp)
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(
                    start = DevMeetingAppTheme.dimensions.paddingMedium,
                    end = DevMeetingAppTheme.dimensions.paddingMedium,
                    bottom = 28.dp
                )
        ) {
            TextButton(
                buttonText = stringResource(id = R.string.choose_another_photo),
                contentColor = DevMeetingAppTheme.colors.eventCardText,
                style = DevMeetingAppTheme.typography.bodyText1,
                onButtonClick = onChangePhotoClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = DevMeetingAppTheme.dimensions.paddingMedium)
            )
            ButtonWithStatus(
                notPressedText = stringResource(id = R.string.save),
                onClick = onButtonSaveClick,
                buttonStatus = ButtonStatus.Active,
                isButtonEnabled = isButtonSaveEnabled,
                modifier = Modifier
            )
        }
    }
}