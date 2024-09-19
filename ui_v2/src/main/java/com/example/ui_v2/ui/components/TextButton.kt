package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun TextButton(
    buttonText: String,
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: TextStyle = DevMeetingAppTheme.typography.bodyText1,
    contentColor: Color = DevMeetingAppTheme.colors.buttonTextPurple,
    containerColor: Color = Color.Transparent,
    shape: Shape = RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium),

    ) {
    Box(
        modifier = modifier
    ) {
        Button(
            onClick = onButtonClick,
            enabled = true,
            shape = shape,
            modifier = Modifier
                .align(Alignment.Center),
            colors = ButtonDefaults.buttonColors(
                contentColor = contentColor,
                containerColor = containerColor
            ),
        ) {
            Text(
                text = buttonText,
                style = style,
                modifier = Modifier
            )
        }
    }
}