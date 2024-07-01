package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun CustomSocialMedeaButtonOutlined(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    pressedColor: Color,
    contentColor: Color,
    containerColor: Color = Color.Transparent,
    shape: Shape = RoundedCornerShape(25.dp),
    painter: Painter,
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
        Icon(
            painter = painter,
            contentDescription = "social media icon",
            modifier = Modifier
                .size(20.dp)
        )
    }
}