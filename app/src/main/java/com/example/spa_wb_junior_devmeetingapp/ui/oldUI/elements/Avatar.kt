package com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.DEFAULT_DIVIDER
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.ICON_OFFSET_X
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.ICON_OFFSET_Y

@Composable
internal fun PersonAvatar(
    size: Dp,
    isEdit: Boolean,
    imageURL: String?,
    onEditClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    defaultIcon: Painter = painterResource(id = R.drawable.icon_avatar_person),
    backgroundColor: Color = DevMeetingAppTheme.colors.extraLightGray
) {

    val iconScale = size.value / DEFAULT_DIVIDER // Коэффициент масштабирования иконки

    Box(modifier = modifier) {
        imageURL?.let { avatarURL ->
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(avatarURL)
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
        } ?: Box(
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
        if (isEdit) {
            IconButton(
                onClick = onEditClick,
                modifier = Modifier
                    .size(20.dp)
                    .align(Alignment.BottomEnd)
                    .offset(ICON_OFFSET_X.dp, ICON_OFFSET_Y.dp),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_avatar_plus_sign),
                    contentDescription = stringResource(id = R.string.icon),
                    modifier = Modifier

                )
            }
        }
    }
}

