package com.example.ui_v2.ui.components

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
import com.example.ui_v2.R
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun EvensCarousel(
    eventsList: List<EventModelUI>,
    onEventCardClick: (EventModelUI) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(eventsList) { event ->
            EventCard(
                event = event,
                onEventCardClick = { onEventCardClick(event) }
            )
        }
    }
}

@Composable
internal fun UpcomingEvensCarousel(
    upcomingEventsList: List<EventModelUI>,
    onUpcomingEventCardClick: (EventModelUI) -> Unit,
    modifier: Modifier = Modifier,
    blockText: String = stringResource(id = R.string.upcoming_events),
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        Text(
            text = blockText,
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.customH2
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(upcomingEventsList) { event ->
                EventCard(
                    event = event,
                    onEventCardClick = { onUpcomingEventCardClick(event) },
                    eventCardWidth = 212.dp
                )
            }
        }
    }
}