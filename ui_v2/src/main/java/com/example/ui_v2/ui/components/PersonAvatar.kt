package com.example.ui_v2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ui_v2.R
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.UiUtils.DEFAULT_DIVIDER


@Composable
internal fun PersonAvatar(
    size: Dp,
    imageURL: String?,
    modifier: Modifier = Modifier,
    defaultIcon: Painter = painterResource(id = R.drawable.icon_avatar_person),
    backgroundColor: Color = DevMeetingAppTheme.colors.extraLightGray,
) {

    val iconScale = size.value / DEFAULT_DIVIDER // Коэффициент масштабирования иконки

    Box(modifier = modifier) {
        when (!imageURL.isNullOrEmpty()) {
            true -> {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(imageURL)
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.Crop,
                    error = painterResource(R.drawable.ic_broken_image),
                    placeholder = painterResource(R.drawable.loading_img),
                    contentDescription = stringResource(R.string.profile_icon),
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(size)
                        .clip(CircleShape)
                )
            }

            false -> {
                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(size)
                        .background(backgroundColor)
                ) {
                    Icon(
                        painter = defaultIcon,
                        contentDescription = stringResource(id = R.string.icon),
                        modifier = Modifier
                            .align(Alignment.Center)
                            .scale(iconScale)
                    )
                }
            }
        }
    }
}

@Composable
internal fun PersonAvatarForUserScreen(
    imageURL: String?,
    modifier: Modifier = Modifier,
    size: Dp = 200.dp,
    defaultIcon: Painter = painterResource(id = R.drawable.icon_avatar_person),
    backgroundColor: Color = DevMeetingAppTheme.colors.extraLightGray,
) {
    val iconScale = size.value / DEFAULT_DIVIDER
    Box(modifier = modifier) {
        when (!imageURL.isNullOrEmpty()) {
            true -> {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(imageURL)
                        .crossfade(true)
                        .build(),
                    contentScale = ContentScale.Crop,
                    error = painterResource(R.drawable.ic_broken_image),
                    placeholder = painterResource(R.drawable.loading_img),
                    contentDescription = stringResource(R.string.profile_icon),
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                )
            }

            else -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .clip(CircleShape)
                            .size(size)
                            .background(backgroundColor)
                    ) {
                        Icon(
                            painter = defaultIcon,
                            contentDescription = stringResource(id = R.string.icon),
                            modifier = Modifier
                                .align(Alignment.Center)
                                .scale(iconScale)
                        )
                    }
                }
            }
        }
    }
}