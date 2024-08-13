package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.newUi

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme


@Composable
fun TagBig(
    tagText: String,
    onTagClick: () -> Unit,
    isClicked: Boolean,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 16.sp
) {
    Box(
        modifier = modifier
            .clickable { onTagClick() }
            .clip(RoundedCornerShape(8.dp))
            .background(
                color = when (isClicked) {
                    true -> {
                        DevMeetingAppTheme.colors.buttonTextPurple
                    }

                    else -> {
                        DevMeetingAppTheme.colors.disabledButtonGray
                    }
                }
            )
            .padding(8.dp)
    ) {
        Text(
            text = tagText,
            color = when (isClicked) {
                true -> {
                    DevMeetingAppTheme.colors.disabledButtonGray
                }

                else -> {
                    DevMeetingAppTheme.colors.buttonTextPurple
                }
            },
            fontWeight = FontWeight.Medium,
            fontSize = fontSize,
            modifier = Modifier
        )
    }
}

@Composable
fun TagSmall(
    tagText: String,
    onTagClick: () -> Unit,
    isClicked: Boolean,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = 14.sp
) {
    Box(
        modifier = modifier
            .clickable { onTagClick() }
            .clip(RoundedCornerShape(8.dp))
            .background(
                color = when (isClicked) {
                    true -> {
                        DevMeetingAppTheme.colors.buttonTextPurple
                    }

                    else -> {
                        DevMeetingAppTheme.colors.disabledButtonGray
                    }
                }
            )
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = tagText,
            color = when (isClicked) {
                true -> {
                    DevMeetingAppTheme.colors.disabledButtonGray
                }

                else -> {
                    DevMeetingAppTheme.colors.buttonTextPurple
                }
            },
            fontWeight = FontWeight.Medium,
            fontSize = fontSize,
            modifier = Modifier
        )
    }
}