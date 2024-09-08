package com.example.ui_v2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus

@Composable
internal fun JoinEventButton(
    eventRestCapacity: Int,
    onButtonClick: () -> Unit,
    buttonStatus: ButtonStatus,
    isButtonEnabled: Boolean,
    modifier: Modifier = Modifier,
    shadowElevation: Dp = 8.dp,
) {
    Box(
        modifier = Modifier
            .drawBehind {
                val shadowBrush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF949393),
                        Color(0xFFA8A8A8),
                        Color(0xFFB8B6B6),
                        Color(0xFFC9C8C8),
                        Color(0xFFD8D7D7),
                        Color(0xFFE2E1E1),
                        Color(0xFFEEEDED),
                        Color(0xFFF8F7F7)
                    ),
                    start = Offset(0f, size.height), // Начальная точка градиента (внизу)
                    end = Offset(0f, 0f) // Конечная точка градиента (вверху)
                )
                val elevation = shadowElevation.toPx()
                drawRoundRect(
                    brush = shadowBrush,
                    topLeft = Offset(0f, -elevation),
                    size = Size(size.width, size.height + elevation),
                    cornerRadius = CornerRadius(
                        (24.dp - shadowElevation).toPx(),
                        (24.dp - shadowElevation).toPx()
                    )
                )
            }
    ) {
        Box(
            modifier = modifier
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp
                    )
                )
                .background(DevMeetingAppTheme.colors.white)
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(
                        horizontal = DevMeetingAppTheme.dimensions.paddingMedium,
                        vertical = 10.dp
                    )
            ) {
                when (buttonStatus) {
                    ButtonStatus.Active, ButtonStatus.Loading -> {
                        CustomButtonText(
                            eventRestCapacity = eventRestCapacity
                        )
                    }
                    else -> {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.icon_check),
                                contentDescription = stringResource(id = R.string.icon),
                                tint = DevMeetingAppTheme.colors.goToEventGreen,
                                modifier = Modifier
                                    .padding(end = 4.dp)
                                    .size(14.dp)
                            )
                            Text(
                                text = stringResource(id = R.string.you_go),
                                color = DevMeetingAppTheme.colors.goToEventGreen,
                                style = DevMeetingAppTheme.typography.bodyText1,
                                modifier = Modifier
                            )
                        }

                    }
                }

                ButtonWithStatus(
                    notPressedText = stringResource(id = R.string.book_appointment),
                    pressedText = stringResource(id = R.string.book_appointment_confirmed),
                    onClick = onButtonClick,
                    buttonStatus = buttonStatus,
                    isButtonEnabled = isButtonEnabled,
                    modifier = Modifier
                        .padding(bottom = 14.dp)
                )
            }
        }
    }
}

@Composable
private fun CustomButtonText(
    eventRestCapacity: Int,
) {
    Text(
        text = when (eventRestCapacity) {
            0 -> {
                stringResource(id = R.string.no_spare_place)
            }

            else -> {
                LocalContext.current.resources.getQuantityString(
                    R.plurals.event_people_count,
                    eventRestCapacity,
                    eventRestCapacity
                )
            }
        },
        color = DevMeetingAppTheme.colors.buttonTextPurple,
        style = DevMeetingAppTheme.typography.metadata1,
        modifier = Modifier
    )
}