package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ui_v2.R
import com.example.ui_v2.models.CommunityDescriptionModelUI
import com.example.ui_v2.ui.theme.DevMeetingAppTheme


@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun CommunityDescriptionBlock(
    communityDescription: CommunityDescriptionModelUI,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(communityDescription.imageURL)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Crop,
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.profile_icon),
            modifier = Modifier
                .size(167.dp)
                .clip(RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium))
        )
        Text(
            text = communityDescription.name,
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.heading1,
            modifier = Modifier.padding(top = 8.dp)
        )
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            communityDescription.listOfTags.forEach {
                TagSmall(
                    tagText = it,
                    onTagClick = {},
                    isClicked = false
                )
            }
        }
    }
}