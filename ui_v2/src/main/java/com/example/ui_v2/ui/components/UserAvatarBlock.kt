package com.example.ui_v2.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ui_v2.R
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun UserAvatarBlock(
    avatarURL: String?,
    onCrossClick: () -> Unit,
    onDoneClick: () -> Unit,
    onChangePhotoClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = Modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(
                    vertical = 12.dp,
                    horizontal = DevMeetingAppTheme.dimensions.paddingMedium
                )
        ) {
            Icon(
                painter = painterResource(id = R.drawable.icon_cross),
                contentDescription = stringResource(id = R.string.icon),
                tint = DevMeetingAppTheme.colors.eventCardText,
                modifier = Modifier
                    .size(24.dp)
                    .clickable {
                        onCrossClick()
                    }
            )
            Icon(
                painter = painterResource(id = R.drawable.icon_check),
                contentDescription = stringResource(id = R.string.icon),
                tint = DevMeetingAppTheme.colors.buttonTextPurple,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onDoneClick() }
            )
        }
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(avatarURL)
                .crossfade(true)
                .build(),
            contentScale = ContentScale.Inside,
            error = painterResource(R.drawable.ic_broken_image),
            placeholder = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.profile_icon),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f)
        )
        TextButton(
            buttonText = stringResource(id = R.string.change_photo),
            onButtonClick = onChangePhotoClick,
            contentColor = DevMeetingAppTheme.colors.white,
            containerColor = DevMeetingAppTheme.colors.buttonTextPurple.copy(alpha = 0.3f),
            style = DevMeetingAppTheme.typography.bodyText2,
            shape = RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeSmall),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        )
    }
}
