package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ui_v2.R
import com.example.ui_v2.models.CommunitiesAdvertBlockModelUI
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun CommunitiesAdvertBlockCarousel(
    communitiesAdvert: CommunitiesAdvertBlockModelUI,
    myCommunitiesList: List<CommunityModelUI>,
    onCommunityButtonClick: (CommunityModelUI) -> Unit,
    onCommunityClick: (CommunityModelUI) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        Text(
            text = communitiesAdvert.nameOfBlock,
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.customH2,
            modifier = Modifier
                .padding(contentPadding)
        )
        LazyRow(
            contentPadding = contentPadding,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(communitiesAdvert.listOfCommunities) { community ->
                CommunityCard(
                    community = community,
                    isCommunityButtonClicked = myCommunitiesList.contains(community),
                    onCommunityButtonClick = { onCommunityButtonClick(community) },
                    onCommunityClick = { onCommunityClick(community) })
            }
        }
    }
}

@Composable
internal fun CommunitiesFixBlockCarousel(
    blockText: String,
    communitiesList: List<CommunityModelUI>,
    myCommunitiesList: List<CommunityModelUI>,
    onCommunityButtonClick: (CommunityModelUI) -> Unit,
    onCommunityClick: (CommunityModelUI) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        Text(
            text = blockText,
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.customH2,
            modifier = Modifier
                .padding(contentPadding)
        )
        LazyRow(
            contentPadding = contentPadding,
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(communitiesList) { community ->
                CommunityCard(
                    community = community,
                    isCommunityButtonClicked = myCommunitiesList.contains(community),
                    onCommunityButtonClick = { onCommunityButtonClick(community) },
                    onCommunityClick = { onCommunityClick(community) })
            }
        }
    }
}

@Composable
internal fun UserCommunitiesFixBlockCarousel(
    communitiesList: List<CommunityModelUI>,
    onCommunityClick: (CommunityModelUI) -> Unit,
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(0.dp),
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        Text(
            text = stringResource(id = R.string.my_communities),
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.customH2,
            modifier = Modifier
                .padding(contentPadding)
        )
        when (communitiesList.isEmpty()) {
            true -> {
                Text(
                    text = stringResource(id = R.string.no_communities),
                    color = DevMeetingAppTheme.colors.eventCardText,
                    style = DevMeetingAppTheme.typography.subheading1,
                    modifier = Modifier
                        .padding(contentPadding)
                )
            }

            else -> {
                LazyRow(
                    contentPadding = contentPadding,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    items(communitiesList) { community ->
                        CommunityCardNoButton(
                            community = community,
                            onCommunityClick = { onCommunityClick(community) })
                    }
                }
            }
        }
    }
}

@Composable
internal fun CommunityCardNoButton(
    community: CommunityModelUI,
    onCommunityClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = onCommunityClick,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMediumSmall),
        modifier = modifier
            .width(104.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(community.imageURL)
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
        Text(
            text = community.name,
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.metadata2,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier
                .padding(vertical = 4.dp)
        )
    }
}