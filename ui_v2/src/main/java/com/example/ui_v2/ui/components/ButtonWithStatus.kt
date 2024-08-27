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

internal enum class ButtonStatus {
    NotPressed,
    Loading,
    Pressed
}

@Composable
internal fun ButtonWithStatus(
    text: String,
    isEnabled: Boolean,
    onClick: () -> Unit,
    buttonStatus: ButtonStatus,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        enabled = isEnabled,
        shape = RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .background(
                brush = when (buttonStatus) {
                    ButtonStatus.NotPressed, ButtonStatus.Loading -> {
                        DevMeetingAppTheme.brush.buttonGradientPrimary
                    }

                    ButtonStatus.Pressed -> {
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
            text = text,
            buttonStatus = buttonStatus
        )
    }
}

@Composable
private fun ButtonContent(
    text: String,
    buttonStatus: ButtonStatus,
) {
    when (buttonStatus) {
        ButtonStatus.NotPressed, ButtonStatus.Pressed -> {
            Text(
                text = text,
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