package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.newUi

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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme

internal val buttonGradientPrimary = Brush.horizontalGradient(
    listOf(
        Color(0xFFED3CCA), Color(0xFFDF34D2), Color(0xFFD02BD9), Color(0xFFBF22E1),
        Color(0xFFAE1AE8), Color(0xFF9A10F0), Color(0xFF8306F7), Color(0xFF6600FF)
    )
)
internal val buttonGradientSecondary = Brush.horizontalGradient(
    listOf(
        Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC), Color(0xFFFBF0FD),
        Color(0xFFF9EFFD), Color(0xFFF8EEFE), Color(0xFFF6EEFE), Color(0xFFF4EDFF)
    )
)

internal enum class ButtonStatus {
    NotPressed,
    Loading,
    Pressed
}

@Composable
internal fun ButtonWithStatus(
    text: String,
    enabled: Boolean,
    onClick: () -> Unit,
    buttonStatus: ButtonStatus,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(16.dp),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .background(
                brush = when (buttonStatus) {
                    ButtonStatus.NotPressed, ButtonStatus.Loading -> {
                        buttonGradientPrimary
                    }

                    ButtonStatus.Pressed -> {
                        buttonGradientSecondary
                    }
                },
                shape = RoundedCornerShape(16.dp)
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
        ContentForButton(
            text = text,
            buttonStatus = buttonStatus
        )
    }
}

@Composable
internal fun ContentForButton(
    text: String,
    buttonStatus: ButtonStatus
) {
    when (buttonStatus) {
        ButtonStatus.NotPressed, ButtonStatus.Pressed -> {
            Text(
                text = text,
                style = DevMeetingAppTheme.typography.subheading1
            )
        }

        ButtonStatus.Loading -> {
            CircularProgressIndicator(
                modifier = Modifier.size(20.dp),
                strokeWidth = 2.dp,
                color = DevMeetingAppTheme.colors.white
            )
        }
    }
}