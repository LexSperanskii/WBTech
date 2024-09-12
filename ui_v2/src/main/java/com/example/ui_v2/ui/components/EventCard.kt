package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ui_v2.R
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun EventCard(
    event: EventModelUI,
    onEventCardClick: () -> Unit,
    modifier: Modifier = Modifier,
    eventCardWidth: Dp = 320.dp,
) {
    Card(
        onClick = onEventCardClick,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeSmall),
        modifier = modifier
            .width(eventCardWidth)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(event.imageURL)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.profile_icon),
            modifier = Modifier
                .fillMaxWidth()
                .height(180.dp)
                .clip(RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium))
        )
        Text(
            text = event.name,
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.heading1,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = stringResource(
                id = R.string.date_address,
                event.day,
                event.month,
                event.street,
                event.building
            ),
            color = DevMeetingAppTheme.colors.eventCardText,
            style = DevMeetingAppTheme.typography.metadata1,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(top = 2.dp)
        )
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            event.listOfTags.forEach {
                TagSmall(
                    tagText = it,
                    onTagClick = {},
                    isClicked = false
                )
            }
        }
    }
}