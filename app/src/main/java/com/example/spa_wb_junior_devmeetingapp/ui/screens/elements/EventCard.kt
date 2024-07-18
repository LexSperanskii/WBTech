package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme
import org.threeten.bp.LocalDate

@Composable
fun EventCard(
    eventName: String,
    eventStatus: String,
    eventDate: LocalDate,
    eventPlace:String,
    eventCategories: List<String>,
    eventIconURL: String,
    onEventItemClick : ()-> Unit,
    modifier: Modifier = Modifier,
    dividerColor: Color = DevMeetingAppTheme.colors.dividerColor,
    dividerThickness: Dp = DividerDefaults.Thickness,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier.clickable { onEventItemClick() }
    ) {
        Column {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ){
                Column(modifier = Modifier.widthIn(68.dp)) {
                    AsyncImage(
                        model = ImageRequest.Builder(context = LocalContext.current)
                            .data(eventIconURL)
                            .crossfade(true)
                            .build(),
                        contentScale = ContentScale.Crop,
                        error = painterResource(R.drawable.ic_broken_image),
                        placeholder = painterResource(R.drawable.loading_img),
                        contentDescription = stringResource(R.string.event_icon),
                        modifier = Modifier
                            .padding(4.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .size(48.dp),
                    )
                }
                Column(modifier = Modifier.weight(1f)) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 2.dp)
                    ) {
                        Text(
                            text = eventName,
                            style = DevMeetingAppTheme.typography.bodyText1,
                            modifier = Modifier
                                .align(Alignment.CenterVertically)
                                .weight(1f)
                        )
                        Text(
                            text = eventStatus,
                            style = DevMeetingAppTheme.typography.metadata2,
                            color = DevMeetingAppTheme.colors.lightDarkGray,
                            modifier = Modifier.padding(start = 8.dp)
                            )
                    }
                    Text(
                        text = stringResource(id = R.string.event_date_place,eventDate,eventPlace),
                        style = DevMeetingAppTheme.typography.metadata1,
                        color = DevMeetingAppTheme.colors.lightDarkGray,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                    LazyRow(
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        modifier = Modifier.padding(vertical = 4.dp)
                    ) {
                        items(eventCategories){ item ->
                            Box(
                                modifier = Modifier
                                    .clip(RoundedCornerShape(40.dp))
                                    .background(DevMeetingAppTheme.colors.lightPurple)
                                    .padding(horizontal = 8.dp, vertical = 2.dp)
                            ) {
                                Text(
                                    text = item,
                                    style = DevMeetingAppTheme.typography.metadata3,
                                    color = DevMeetingAppTheme.colors.darkPurple,
                                    lineHeight = 16.sp
                                )
                            }
                        }
                    }
                }
            }
            HorizontalDivider(
                thickness = dividerThickness,
                color = dividerColor,
                modifier = Modifier.padding(top = 16.dp)
            )
        }
    }
}