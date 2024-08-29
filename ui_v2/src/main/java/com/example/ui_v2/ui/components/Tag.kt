package com.example.ui_v2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun TagBig(
    tagText: String,
    onTagClick: () -> Unit,
    isClicked: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeSmall))
            .clickable { onTagClick() }
            .background(
                color = when (isClicked) {
                    true -> {
                        DevMeetingAppTheme.colors.buttonTextPurple
                    }

                    else -> {
                        DevMeetingAppTheme.colors.disabledButtonGray
                    }
                }
            )
            .padding(
                horizontal = 12.dp,
                vertical = 10.dp
            )
    ) {
        Text(
            text = tagText,
            color = when (isClicked) {
                true -> {
                    DevMeetingAppTheme.colors.disabledButtonGray
                }

                else -> {
                    DevMeetingAppTheme.colors.buttonTextPurple
                }
            },
            style = DevMeetingAppTheme.typography.heading2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
        )
    }
}

@Composable
internal fun TagMedium(
    tagText: String,
    onTagClick: () -> Unit,
    isClicked: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeSmall))
            .clickable { onTagClick() }
            .background(
                color = when (isClicked) {
                    true -> {
                        DevMeetingAppTheme.colors.buttonTextPurple
                    }

                    else -> {
                        DevMeetingAppTheme.colors.disabledButtonGray
                    }
                }
            )
            .padding(8.dp)
    ) {
        Text(
            text = tagText,
            color = when (isClicked) {
                true -> {
                    DevMeetingAppTheme.colors.disabledButtonGray
                }

                else -> {
                    DevMeetingAppTheme.colors.buttonTextPurple
                }
            },
            style = DevMeetingAppTheme.typography.bodyText2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
        )
    }
}

@Composable
internal fun TagSmall(
    tagText: String,
    onTagClick: () -> Unit,
    isClicked: Boolean,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeSmall))
            .clickable { onTagClick() }
            .background(
                color = when (isClicked) {
                    true -> {
                        DevMeetingAppTheme.colors.buttonTextPurple
                    }

                    else -> {
                        DevMeetingAppTheme.colors.disabledButtonGray
                    }
                }
            )
            .padding(horizontal = 6.dp, vertical = 2.dp)
    ) {
        Text(
            text = tagText,
            color = when (isClicked) {
                true -> {
                    DevMeetingAppTheme.colors.disabledButtonGray
                }

                else -> {
                    DevMeetingAppTheme.colors.buttonTextPurple
                }
            },
            style = DevMeetingAppTheme.typography.metadata1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
        )
    }
}

@Composable
internal fun BannerTag(
    tagText: String,
    onBannerTagClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeSmall))
            .clickable { onBannerTagClick() }
            .background(brush = DevMeetingAppTheme.brush.buttonGradientSecondary)
            .padding(
                horizontal = 12.dp,
                vertical = 8.dp
            )
    ) {
        Text(
            text = tagText,
            color = DevMeetingAppTheme.colors.buttonTextPurple,
            style = DevMeetingAppTheme.typography.bodyText2,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
        )
    }
}