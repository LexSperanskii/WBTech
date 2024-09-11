package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.models.SocialMediaModelUI
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun UserSocialNetworkBlock(
    listOfSocialMedia: List<SocialMediaModelUI>,
    onSocialNetworkValueChange: (id: String, value: String) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(horizontal = DevMeetingAppTheme.dimensions.paddingMedium)
    ) {
        Text(
            text = stringResource(id = R.string.social_networks),
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.customH2,
            modifier = Modifier
                .padding(bottom = 16.dp)
        )
        listOfSocialMedia.forEach { socialMedia ->
            UserSocialNetworksTextField(
                value = socialMedia.userNickname,
                onValueChange = {
                    onSocialNetworkValueChange(socialMedia.socialMediaId, it)
                },
                socialNetworkURL = socialMedia.socialMediaIconURL,
                socialNetworkName = socialMedia.socialMediaName,
                modifier = Modifier
                    .padding(bottom = 8.dp)
            )
        }
    }
}