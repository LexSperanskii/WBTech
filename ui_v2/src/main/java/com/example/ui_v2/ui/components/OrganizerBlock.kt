package com.example.ui_v2.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ui_v2.R
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun OrganizerBlock(
    nameOfCommunity: String,
    descriptionOfCommunity: String,
    communityImageURL: String,
    onCommunityClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.organizer),
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.customH2,
            modifier = Modifier
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium))
                .clickable { onCommunityClick() }
        ) {
            Column {
                Text(
                    text = nameOfCommunity,
                    color = DevMeetingAppTheme.colors.black,
                    style = DevMeetingAppTheme.typography.metadata1,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                Text(
                    text = descriptionOfCommunity,
                    color = DevMeetingAppTheme.colors.black,
                    style = DevMeetingAppTheme.typography.metadata1,
                    modifier = Modifier
                )
            }
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(communityImageURL)
                    .crossfade(true)
                    .build(),
                contentScale = ContentScale.Crop,
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = stringResource(R.string.profile_icon),
                modifier = Modifier
                    .clip(RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium))
                    .size(104.dp)
            )
        }
    }
}