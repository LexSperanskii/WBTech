package com.example.spa_wb_junior_devmeetingapp.ui.newUi.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.ui_v2.models.NewEventModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme

@Composable
internal fun EvensCarousel(
    eventsList: List<com.example.ui_v2.models.NewEventModelUI>,
    onEventCardClick: (com.example.ui_v2.models.NewEventModelUI) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(eventsList) { event ->
            NewEventCard(
                event = event,
                onEventCardClick = { onEventCardClick(event) }
            )
        }
    }
}

@Composable
internal fun UpcomingEvensCarousel(
    eventsList: List<com.example.ui_v2.models.NewEventModelUI>,
    onEventCardClick: (com.example.ui_v2.models.NewEventModelUI) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.upcoming_meetings),
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.customH2
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(eventsList) { event ->
                NewEventCard(
                    event = event,
                    onEventCardClick = { onEventCardClick(event) },
                    eventCardWidth = 212.dp
                )
            }
        }
    }
}