package com.example.ui_v2.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.models.ClientModelUI
import com.example.ui_v2.models.SocialMediaModelUI
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.ui.theme.DevMeetingAppTheme


@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun UserDescriptionBlockOutside(
    user: UserModelUI,
    onArrowClick: () -> Unit,
    onShareClick: () -> Unit,
    onNetworkIconClick: (SocialMediaModelUI) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 20.dp)
        ) {
            PersonAvatarForUserScreen(
                imageURL = user.imageURL
            )
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
                    painter = painterResource(id = R.drawable.backbar_arrow_left),
                    contentDescription = stringResource(id = R.string.icon),
                    tint = DevMeetingAppTheme.colors.buttonTextPurple,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(12.dp, 18.dp)
                        .clickable {
                            onArrowClick()
                        }
                )
                Icon(
                    painter = painterResource(id = R.drawable.icon_share),
                    contentDescription = stringResource(id = R.string.icon),
                    tint = DevMeetingAppTheme.colors.buttonTextPurple,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { onShareClick() }
                )
            }
        }
        if (user.nameSurname.isNotBlank()) {
            Text(
                text = user.nameSurname,
                color = DevMeetingAppTheme.colors.black,
                style = DevMeetingAppTheme.typography.customH3,
                modifier = Modifier.padding(
                    start = DevMeetingAppTheme.dimensions.paddingMedium,
                    end = DevMeetingAppTheme.dimensions.paddingMedium,
                    bottom = 8.dp
                )
            )
        }
        if (user.city.isNotBlank()) {
            Text(
                text = user.city,
                color = DevMeetingAppTheme.colors.black,
                style = DevMeetingAppTheme.typography.metadata2,
                modifier = Modifier
                    .padding(
                        start = DevMeetingAppTheme.dimensions.paddingMedium,
                        end = DevMeetingAppTheme.dimensions.paddingMedium,
                        bottom = 2.dp
                    )
            )
        }
        if (user.description.isNotBlank()) {
            Text(
                text = user.description,
                color = DevMeetingAppTheme.colors.black,
                style = DevMeetingAppTheme.typography.metadata1,
                modifier = Modifier
                    .padding(
                        start = DevMeetingAppTheme.dimensions.paddingMedium,
                        end = DevMeetingAppTheme.dimensions.paddingMedium,
                        bottom = 16.dp
                    )
            )
        }
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .padding(horizontal = DevMeetingAppTheme.dimensions.paddingMedium)
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            user.listOfTags.forEach {
                TagSmall(
                    tagText = it,
                    onTagClick = {},
                    isClicked = false
                )
            }
        }
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(horizontal = DevMeetingAppTheme.dimensions.paddingMedium)
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            user.listOfSocialMedia.forEach { socialMedia ->
                NetworkIcon(
                    networkIcon = socialMedia.socialMediaIcon,
                    onNetworkIconClick = { onNetworkIconClick(socialMedia) }
                )
            }
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun UserDescriptionBlockInside(
    user: ClientModelUI,
    listOfSocialMedia: List<SocialMediaModelUI>,
    onArrowClick: () -> Unit,
    onEditClick: () -> Unit,
    onNetworkIconClick: (SocialMediaModelUI) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Box(
            modifier = Modifier
                .padding(bottom = 20.dp)
        ) {
            PersonAvatarForUserScreen(
                imageURL = user.imageURL
            )
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
                    painter = painterResource(id = R.drawable.backbar_arrow_left),
                    contentDescription = stringResource(id = R.string.icon),
                    tint = DevMeetingAppTheme.colors.buttonTextPurple,
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(12.dp, 18.dp)
                        .clickable {
                            onArrowClick()
                        }
                )
                Icon(
                    painter = painterResource(id = R.drawable.icon_edit),
                    contentDescription = stringResource(id = R.string.icon),
                    tint = DevMeetingAppTheme.colors.buttonTextPurple,
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { onEditClick() }
                )
            }
        }
        if (user.nameSurname.isNotBlank()) {
            Text(
                text = user.nameSurname,
                color = DevMeetingAppTheme.colors.black,
                style = DevMeetingAppTheme.typography.customH3,
                modifier = Modifier.padding(
                    start = DevMeetingAppTheme.dimensions.paddingMedium,
                    end = DevMeetingAppTheme.dimensions.paddingMedium,
                    bottom = if (user.nameSurname.isNotBlank()) 8.dp else 0.dp
                )
            )
        }
        if (user.city.isNotBlank()) {
            Text(
                text = user.city,
                color = DevMeetingAppTheme.colors.black,
                style = DevMeetingAppTheme.typography.metadata2,
                modifier = Modifier
                    .padding(
                        start = DevMeetingAppTheme.dimensions.paddingMedium,
                        end = DevMeetingAppTheme.dimensions.paddingMedium,
                        bottom = if (user.city.isNotBlank()) 2.dp else 0.dp
                    )
            )
        }
        if (user.description.isNotBlank()) {
            Text(
                text = user.description,
                color = DevMeetingAppTheme.colors.black,
                style = DevMeetingAppTheme.typography.metadata1,
                modifier = Modifier
                    .padding(
                        start = DevMeetingAppTheme.dimensions.paddingMedium,
                        end = DevMeetingAppTheme.dimensions.paddingMedium,
                        bottom = 16.dp
                    )
            )
        }
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(6.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp),
            modifier = Modifier
                .padding(horizontal = DevMeetingAppTheme.dimensions.paddingMedium)
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            user.listOfTags.forEach {
                TagSmall(
                    tagText = it,
                    onTagClick = {},
                    isClicked = false
                )
            }
        }
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(horizontal = DevMeetingAppTheme.dimensions.paddingMedium)
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        ) {
            listOfSocialMedia.forEach { socialMedia ->
                NetworkIcon(
                    networkIcon = socialMedia.socialMediaIcon,
                    onNetworkIconClick = { onNetworkIconClick(socialMedia) }
                )
            }
        }
    }
}