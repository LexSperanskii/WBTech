package com.example.ui_v2.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun OrganizerBlock(
    orgCommunity: CommunityModelUI,
    isInMyCommunities: Boolean,
    onCommunityClick: () -> Unit,
    onCommunityButtonClick: () -> Unit,
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
                .clickable { onCommunityClick() }
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 10.dp)
            ) {
                Text(
                    text = orgCommunity.name,
                    color = DevMeetingAppTheme.colors.black,
                    style = DevMeetingAppTheme.typography.metadata1,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier
                )
                Text(
                    text = orgCommunity.description,
                    color = DevMeetingAppTheme.colors.black,
                    style = DevMeetingAppTheme.typography.metadata1,
                    modifier = Modifier
                )
            }
            Box(
                modifier = Modifier
                    .size(104.dp)
                    .clip(RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium))
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(orgCommunity.imageURL)
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.Crop,
                    error = painterResource(R.drawable.ic_broken_image),
                    placeholder = painterResource(R.drawable.loading_img),
                    contentDescription = stringResource(R.string.profile_icon),
                    modifier = Modifier
                        .fillMaxSize()
                )
                ButtonForCommunityCard(
                    isClicked = isInMyCommunities,
                    onCommunityButtonClick = onCommunityButtonClick,
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .offset(x = 8.dp, y = (-8).dp)
                )
            }
        }
    }
}