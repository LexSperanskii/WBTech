package com.example.ui_v2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus

@Composable
internal fun ButtonWithStatus(
    notPressedText: String,
    pressedText: String,
    isButtonEnabled: Boolean,
    onClick: () -> Unit,
    buttonStatus: ButtonStatus,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        enabled = isButtonEnabled,
        shape = RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .background(
                brush = when (buttonStatus) {
                    ButtonStatus.Active, ButtonStatus.Loading -> {
                        DevMeetingAppTheme.brush.buttonGradientPrimary
                    }

                    else -> {
                        DevMeetingAppTheme.brush.buttonGradientSecondary
                    }
                },
                shape = RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium)
            ),
        colors = ButtonDefaults.buttonColors(
            contentColor = when (buttonStatus) {
                ButtonStatus.Pressed -> {
                    DevMeetingAppTheme.colors.buttonTextPurple
                }
                else -> {
                    DevMeetingAppTheme.colors.white
                }
            },
            containerColor = Color.Transparent,
            disabledContainerColor = DevMeetingAppTheme.colors.disabledButtonGray,
            disabledContentColor = DevMeetingAppTheme.colors.disabledButtonTextGray
        ),
    ) {
        ButtonContent(
            notPressedText = notPressedText,
            pressedText = pressedText,
            buttonStatus = buttonStatus
        )
    }
}

@Composable
private fun ButtonContent(
    notPressedText: String,
    pressedText: String,
    buttonStatus: ButtonStatus,
) {
    when (buttonStatus) {
        ButtonStatus.Active -> {
            Text(
                text = notPressedText,
                style = DevMeetingAppTheme.typography.subheading2
            )
        }

        ButtonStatus.Pressed -> {
            Text(
                text = pressedText,
                style = DevMeetingAppTheme.typography.subheading2
            )
        }
        ButtonStatus.Loading -> {
            CircularProgressIndicator(
                strokeWidth = 2.dp,
                color = DevMeetingAppTheme.colors.white,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}