package com.example.spa_wb_junior_devmeetingapp.ui.newUi.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme


@Composable
internal fun NewCommunityCard(
    communityURL: String,
    communityName: String,
    isClicked: Boolean,
    onCommunityButtonClick: () -> Unit,
    onCommunityClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = onCommunityClick,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RectangleShape,
        modifier = modifier
            .width(104.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(communityURL)
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
            text = communityName,
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.newMetadata2,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier
                .padding(vertical = 4.dp)
        )
        ButtonForCommunityCard(
            isClicked = isClicked,
            onCommunityButtonClick = onCommunityButtonClick,
        )
    }
}

@Composable
internal fun ButtonForCommunityCard(
    isClicked: Boolean,
    onCommunityButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .clip(RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMediumSmall))
            .clickable { onCommunityButtonClick() }
            .then(
                when (isClicked) {
                    true -> {
                        Modifier.background(color = DevMeetingAppTheme.colors.buttonTextPurple)
                    }

                    else -> {
                        Modifier.background(brush = DevMeetingAppTheme.brush.buttonCommunityCardGradient)
                    }
                }
            )
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Icon(
            painter = when (isClicked) {
                true -> {
                    painterResource(id = R.drawable.icon_check)
                }

                else -> {
                    painterResource(id = R.drawable.icon_plus)
                }
            },
            contentDescription = stringResource(id = R.string.button),
            tint = when (isClicked) {
                true -> {
                    DevMeetingAppTheme.colors.white
                }

                else -> {
                    DevMeetingAppTheme.colors.buttonTextPurple
                }
            },
            modifier = Modifier.size(21.dp)
        )
    }
}