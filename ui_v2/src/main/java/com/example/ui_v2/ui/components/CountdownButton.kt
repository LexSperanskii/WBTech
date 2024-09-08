package com.example.ui_v2.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.ui_v2.R
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun CountdownButton(
    countdown: Int,
    isButtonEnabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        enabled = isButtonEnabled,
        shape = RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium),
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = DevMeetingAppTheme.colors.buttonTextPurple,
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = DevMeetingAppTheme.colors.eventCardText
        ),
    ) {
        Text(
            text = when (countdown > 1) {
                true -> {
                    stringResource(id = R.string.pin_code_countdown, countdown)
                }

                else -> {
                    stringResource(id = R.string.get_new_pin_code)
                }
            },
            style = DevMeetingAppTheme.typography.bodyText1,
            modifier = Modifier
        )
    }
}