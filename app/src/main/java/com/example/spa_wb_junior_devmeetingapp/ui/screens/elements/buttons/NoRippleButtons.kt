package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Subheading2

@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    pressedColor: Color,
    containerColor: Color,
    contentColor: Color = Color.White,
    text: String = "Button",
    enabled: Boolean = true,
    shape: Shape = RoundedCornerShape(30.dp),
    fontSize: TextUnit = MaterialTheme.typography.Subheading2.fontSize,
    fontWeight: FontWeight = FontWeight.SemiBold,
    fontFamily: FontFamily = SFProDisplay,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    Button(
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isPressed) pressedColor else containerColor,
            contentColor = contentColor,
            disabledContainerColor = containerColor.copy(alpha = 0.5f),
            disabledContentColor = contentColor
        ),
        interactionSource = interactionSource,
    ) {
        Text(
            text = text,
            fontSize = fontSize,
            fontWeight = fontWeight,
            fontFamily = fontFamily
        )
    }
}

@Composable
fun CustomButtonOutlined(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    pressedColor: Color,
    contentColor: Color,
    containerColor: Color = Color.Transparent,
    text: String = "Button",
    shape: Shape = RoundedCornerShape(30.dp),
    enabled: Boolean = true
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
                !enabled  -> contentColor.copy(alpha = 0.5f)
                isPressed -> pressedColor
                else -> contentColor
            }
        ),
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = if (isPressed) pressedColor else contentColor,
            disabledContainerColor = containerColor,
            disabledContentColor = contentColor.copy(alpha = 0.5f)
        ),
        interactionSource = interactionSource
    ) {
        Text(text = text)
    }
}

@Composable
fun CustomButtonText(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    pressedColor: Color,
    contentColor: Color,
    containerColor: Color = Color.Transparent,
    text: String = "Button",
    shape: Shape = RoundedCornerShape(30.dp),
    enabled: Boolean = true
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    TextButton(
        onClick = onClick,
        enabled = enabled,
        shape = shape,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = if (isPressed) pressedColor else contentColor,
            containerColor = containerColor,
            disabledContainerColor = containerColor,
            disabledContentColor = contentColor.copy(alpha = 0.5f)
        ),
        interactionSource = interactionSource
    ) {
        Text(text = text)
    }
}