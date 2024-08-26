package com.example.ui_v1.ui.elements.buttons

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material.ripple.RippleAlpha
import androidx.compose.material.ripple.RippleTheme
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ui_v1.R
import com.example.ui_v1.ui.theme.DevMeetingAppTheme


internal class CustomRippleTheme : RippleTheme {
    @Composable
    @ReadOnlyComposable
    override fun defaultColor() = LocalContentColor.current

    @Composable
    @ReadOnlyComposable
    override fun rippleAlpha() = RippleAlpha(
        draggedAlpha = 0.0f,
        focusedAlpha = 0.0f,
        hoveredAlpha = 0.0f,
        pressedAlpha = 1f,
    )
}

@Composable
internal fun CustomButtonRipple(
    containerColor: Color,
    contentColor: Color,
    pressedColor: Color,
    rippleColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String = stringResource(id = R.string.button),
    shape: Shape = RoundedCornerShape(30.dp),
    rippleSize: Dp = 8.dp,
    enabled:Boolean = true,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    CompositionLocalProvider(LocalRippleTheme provides CustomRippleTheme())
    {
        Box( //Общий Box для того чтобы задать размер для ripple. Это нужно чтобы эффект ripple не затемнял кнопку
            modifier = Modifier
                .clip(shape)

        ) {
            Box( //Box для ripple который повторяет размеры родителя.
                modifier = Modifier
                    .matchParentSize()
                    .clip(shape)
                    .clickable(
                        onClick = onClick,
                        enabled = enabled,
                        interactionSource = interactionSource,
                        indication = rememberRipple(
                            color = rippleColor
                        )
                    )
            )
            Box( //Box который задает размеры родителя, чтобы ripple выходил на 8 dp за кнопку
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(shape)
                    .padding(rippleSize)
            ) {
                Text(  //Овальный контур кнопки с текстом
                    text = text,
                    color = contentColor,
                    style = DevMeetingAppTheme.typography.subheading2,
                    modifier = modifier
                        .clip(shape)
                        .background(
                            when {
                                !enabled -> {
                                    containerColor.copy(alpha = 0.5f)
                                }

                                isPressed -> {
                                    pressedColor
                                }

                                else -> {
                                    containerColor
                                }
                            }
                        )
                        .padding(
                            vertical = 8.dp,
                            horizontal = 24.dp
                        )
                )
            }
        }
    }
}

@Composable
internal fun CustomButtonOutlinedRipple(
    contentColor: Color,
    pressedColor: Color,
    rippleColor: Color,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String = stringResource(id = R.string.button),
    containerColor: Color = Color.Transparent,
    shape: Shape = RoundedCornerShape(30.dp),
    rippleSize: Dp = 8.dp,
    enabled: Boolean = true,
    border: Boolean = false,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()

    CompositionLocalProvider(LocalRippleTheme provides CustomRippleTheme())
    {
        Box( //Общий Box для того чтобы задать размер для ripple. Это нужно чтобы эффект ripple не затемнял кнопку
            modifier = Modifier
                .clip(shape)
        ) {
            Box( //Box для ripple который повторяет размеры родителя
                modifier = Modifier
                    .matchParentSize()
                    .clip(shape)
                    .clickable(
                        onClick = onClick,
                        enabled = enabled,
                        interactionSource = interactionSource,
                        indication = rememberRipple(
                            color = rippleColor
                        )
                    )
            )
            Box( //Box который задает размеры родителя, чтобы ripple выходил на 8 dp за кнопку
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(shape)
                    .padding(rippleSize)
            ) {
                Text(  //Овальный контур кнопки с текстом
                    text = text,
                    color = when {
                        !enabled -> contentColor.copy(alpha = 0.5f)
                        isPressed -> pressedColor
                        else -> contentColor
                    },
                    style = DevMeetingAppTheme.typography.subheading2,
                    modifier = modifier
                        .clip(shape)
                        .background(containerColor)
                        .let {
                            if (border) it.border(
                                BorderStroke(
                                    width = 2.dp,
                                    color = when {
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
                                ), shape
                            )
                            else it
                        }
                        .padding(
                            vertical = 8.dp,
                            horizontal = 24.dp
                        )
                )
            }
        }
    }
}


