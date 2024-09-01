package com.example.ui_v2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun MorePeople(
    quantity: Int,
    modifier: Modifier = Modifier,
    size: Dp = 48.dp,
) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .size(size)
            .background(DevMeetingAppTheme.colors.disabledButtonGray)
            .border(
                width = 2.dp,
                color = DevMeetingAppTheme.colors.white,
                shape = CircleShape
            )

    ) {
        Text(
            text = stringResource(id = R.string.number_of_people, quantity),
            style = DevMeetingAppTheme.typography.metadata1,
            color = DevMeetingAppTheme.colors.buttonTextPurple,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}