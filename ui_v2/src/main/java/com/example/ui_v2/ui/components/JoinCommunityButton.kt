package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus

@Composable
internal fun JoinCommunityButton(
    onButtonClick: () -> Unit,
    buttonStatus: ButtonStatus,
    isButtonEnabled: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        ButtonWithStatus(
            notPressedText = stringResource(id = R.string.subscribe),
            pressedText = stringResource(id = R.string.subscribed),
            onClick = onButtonClick,
            buttonStatus = buttonStatus,
            isButtonEnabled = isButtonEnabled,
            modifier = Modifier
        )
        when (buttonStatus) {
            ButtonStatus.Active, ButtonStatus.Loading -> {
                Text(
                    text = stringResource(id = R.string.community_button_text),
                    color = DevMeetingAppTheme.colors.buttonTextPurple,
                    style = DevMeetingAppTheme.typography.metadata1,
                    modifier = Modifier
                )
            }

            else -> {}
        }
    }
}