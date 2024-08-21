package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.newUi

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme

@Composable
fun MorePeople(
    quantity: Int,
) {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(48.dp)
            .background(DevMeetingAppTheme.colors.disabledButtonGray)
    ) {
        Text(
            text = stringResource(id = R.string.number_of_people, quantity),
            style = DevMeetingAppTheme.typography.Newmetadata1,
            color = DevMeetingAppTheme.colors.buttonTextPurple,
            modifier = Modifier.align(Alignment.Center)
        )
    }
}