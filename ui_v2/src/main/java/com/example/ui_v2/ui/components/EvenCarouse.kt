package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.ui_v2.models.EventAdvertBlockModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun EvensCarousel(
    eventsList: List<EventModelUI>,
    onEventCardClick: (EventModelUI) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    LazyRow(
        contentPadding = contentPadding,
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(eventsList) { event ->
            EventCard(
                event = event,
                onEventCardClick = { onEventCardClick(event) },
                modifier = Modifier
            )
        }
    }
}

@Composable
internal fun EvensAdvertBlockCarousel(
    eventsAdvert: EventAdvertBlockModelUI,
    onEventCardClick: (EventModelUI) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        Text(
            text = eventsAdvert.nameOfBlock,
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.heading1,
            modifier = Modifier
                .padding(contentPadding)
        )
        LazyRow(
            contentPadding = contentPadding,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(eventsAdvert.listOfEvents) { event ->
                EventCard(
                    event = event,
                    onEventCardClick = { onEventCardClick(event) },
                    eventCardWidth = 212.dp,
                    modifier = Modifier
                )
            }
        }
    }
}

@Composable
internal fun EvensFixBlockCarousel(
    blockText: String,
    blockEventsList: List<EventModelUI>,
    onEventCardClick: (EventModelUI) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    style: TextStyle = DevMeetingAppTheme.typography.customH2,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        Text(
            text = blockText,
            color = DevMeetingAppTheme.colors.black,
            style = style,
            modifier = Modifier
                .padding(contentPadding)
        )
        LazyRow(
            contentPadding = contentPadding,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(blockEventsList) { event ->
                EventCard(
                    event = event,
                    onEventCardClick = { onEventCardClick(event) },
                    eventCardWidth = 212.dp,
                    modifier = Modifier
                )
            }
        }
    }
}

