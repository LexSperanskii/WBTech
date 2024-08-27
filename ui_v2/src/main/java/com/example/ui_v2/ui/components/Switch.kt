package com.example.ui_v2.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ui_v2.ui.theme.DevMeetingAppTheme


@Composable
internal fun CustomSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    thumbRadius: Dp = 10.dp,
    thumbColor: Color = DevMeetingAppTheme.colors.white,
    widthOfTrack: Dp = 48.dp,
    heightOfTrack: Dp = 24.dp,
    checkedTrackColor: Color = DevMeetingAppTheme.colors.buttonTextPurple,
    uncheckedTrackColor: Color = DevMeetingAppTheme.colors.toggleColor,
) {
    val thumbPosition by animateFloatAsState(targetValue = if (checked) 1f else 0f) // анимация положения круга
    val circleRadius = remember { thumbRadius } //радиус нашего круга
    val interactionSource =
        remember { MutableInteractionSource() } //отсдеживаем взимодействие пользователя с кнопкой
    val indent =
        (heightOfTrack - thumbRadius * 2) / 2 // считаем наш отступ от края. Он всегда будет таким же как отступ круга от верхней и нижней границы трека.
    val startPosition = thumbRadius + indent // задаем отступ круга от начала

    Box(
        modifier = modifier
            .size(width = widthOfTrack, height = heightOfTrack) //размер нашего контейнера
            .background(color = Color.Transparent)
            .clickable(
                onClick = { onCheckedChange(!checked) },
                interactionSource = interactionSource,
                indication = null //Убираем рипл эффект с Box
            )
    ) {
        Canvas(modifier = Modifier.matchParentSize()) {
            val trackBrush = if (checked) checkedTrackColor else uncheckedTrackColor

            drawRoundRect(
                color = trackBrush,
                size = Size(size.width, size.height),
                cornerRadius = CornerRadius(heightOfTrack.toPx()) // Округлые края, берем минимальное значение нашего прямоугольника,т.е высоту
            )

            val thumbOffset = calculateThumbOffset(
                start = startPosition.toPx(),
                stop = size.width - startPosition.toPx(),
                fraction = thumbPosition
            )

            drawCircle(
                color = thumbColor,
                radius = circleRadius.toPx(),
                center = Offset(x = thumbOffset, y = size.height / 2)
            )
        }
    }
}

private fun calculateThumbOffset(
    start: Float,
    stop: Float,
    fraction: Float,
): Float = start + (stop - start) * fraction


@Composable
internal fun ClassicSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Switch(
        checked = checked,
        enabled = true,
        colors = SwitchDefaults.colors(
            checkedThumbColor = DevMeetingAppTheme.colors.white,
            checkedTrackColor = DevMeetingAppTheme.colors.buttonTextPurple,
            uncheckedThumbColor = DevMeetingAppTheme.colors.white,
            uncheckedTrackColor = DevMeetingAppTheme.colors.toggleColor,
            uncheckedBorderColor = Color.Transparent
        ),
        onCheckedChange = onCheckedChange,
        thumbContent = {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .size(21.dp)
                    .background(DevMeetingAppTheme.colors.white)
            )
        },
        modifier = modifier
    )
}
