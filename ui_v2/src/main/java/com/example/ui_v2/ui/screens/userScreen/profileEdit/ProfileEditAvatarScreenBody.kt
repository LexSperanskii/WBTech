package com.example.ui_v2.ui.screens.userScreen.profileEdit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.ui.components.ButtonWithStatus
import com.example.ui_v2.ui.components.PersonAvatarForUserScreen
import com.example.ui_v2.ui.components.TextButton
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus

@Composable
internal fun ProfileEditAvatarScreenBody(
    avatarURL: String?,
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
            imageURL = avatarURL,
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