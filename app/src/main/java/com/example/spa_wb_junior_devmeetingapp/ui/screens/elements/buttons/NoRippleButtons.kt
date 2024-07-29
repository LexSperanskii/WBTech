package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme

@Composable
internal fun CustomButton(
    pressedColor: Color,
    containerColor: Color,
    onClick: () -> Unit,
    text: String = "Button",
    modifier: Modifier = Modifier,
    contentColor: Color = Color.White,
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(30.dp),
    textStyle: TextStyle = DevMeetingAppTheme.typography.subheading2,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = when (isPressed) {
                true -> {
                    pressedColor
                }
                false -> {
                    containerColor
                }
            },
            contentColor = contentColor,
            disabledContainerColor = containerColor.copy(alpha = 0.5f),
            disabledContentColor = contentColor
        ),
        interactionSource = interactionSource,
    ) {
        Text(
            text = text,
            style = textStyle,
        )
    }
}

@Composable
internal fun CustomButtonOutlined(
    pressedColor: Color,
    contentColor: Color,
    onClick: () -> Unit,
    text: String = "Button",
    modifier: Modifier = Modifier,
    containerColor: Color = Color.Transparent,
    shape: Shape = RoundedCornerShape(30.dp),
    enabled: Boolean = true,
    textStyle: TextStyle = DevMeetingAppTheme.typography.subheading2,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    OutlinedButton(
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        modifier = modifier,
        border = BorderStroke(
            width = 2.dp, color = when {
                !enabled -> {
                    contentColor.copy(alpha = 0.5f)
                }
                isPressed -> {
                    pressedColor
                }
                else -> {
                    contentColor
                }
            }
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = when(isPressed){
                true -> {
                    pressedColor
                }
                false -> {
                    contentColor
                }
            },
            disabledContainerColor = containerColor,
            disabledContentColor = contentColor.copy(alpha = 0.5f)
        ),
        interactionSource = interactionSource
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}

@Composable
internal fun CustomButtonText(
    pressedColor: Color,
    contentColor: Color,
    onClick: () -> Unit,
    text: String = "Button",
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(30.dp),
    enabled: Boolean = true,
    textStyle: TextStyle = DevMeetingAppTheme.typography.subheading2,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    TextButton(
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = when (isPressed) {
                true -> {
                    pressedColor
                }

                false -> {
                    contentColor
                }
            },
            containerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            disabledContentColor = contentColor.copy(alpha = 0.5f)
        ),
        interactionSource = interactionSource
    ) {
        Text(
            text = text,
            style = textStyle
        )
    }
}