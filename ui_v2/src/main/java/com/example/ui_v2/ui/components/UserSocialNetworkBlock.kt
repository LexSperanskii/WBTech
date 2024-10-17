package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.models.SocialMediaModelUI
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun UserSocialNetworkBlock(
    listOfSocialMedia: List<SocialMediaModelUI>,
    onSocialNetworkValueChange: (socialMediaID: String, value: String) -> Unit,
    onAddSocialNetworkClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(horizontal = DevMeetingAppTheme.dimensions.paddingMedium)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.social_networks),
                color = DevMeetingAppTheme.colors.black,
                style = DevMeetingAppTheme.typography.customH2,
                modifier = Modifier
            )
            IconButton(
                onClick = onAddSocialNetworkClick
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_plus),
                    contentDescription = stringResource(id = R.string.icon),
                    tint = DevMeetingAppTheme.colors.buttonTextPurple,
                    modifier = Modifier
                        .size(16.dp)
                )
            }
        }
        listOfSocialMedia.forEach { socialMedia ->
            UserSocialNetworksTextField(
                value = socialMedia.userNickname,
                onValueChange = {
                    onSocialNetworkValueChange(socialMedia.socialMediaId, it)
                },
                socialNetworkIcon = socialMedia.socialMediaIcon,
                socialNetworkPlaceholderName = socialMedia.socialMediaName,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
        }
    }
}