package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
fun UserSocialNetworkBlock(
    firstSocialNetworkValue: String,
    onFirstSocialNetworkValueChange: (String) -> Unit,
    firstSocialNetworkURL: String?,
    firstSocialNetworkName: String,
    secondSocialNetworkValue: String,
    onSecondSocialNetworkValueChange: (String) -> Unit,
    secondSocialNetworkURL: String?,
    secondSocialNetworkName: String,
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
        UserSocialNetworksTextField(
            value = firstSocialNetworkValue,
            onValueChange = onFirstSocialNetworkValueChange,
            socialNetworkURL = secondSocialNetworkURL,
            socialNetworkName = secondSocialNetworkName,
            modifier = Modifier
                .padding(bottom = 8.dp)
        )
        UserSocialNetworksTextField(
            value = secondSocialNetworkValue,
            onValueChange = onSecondSocialNetworkValueChange,
            socialNetworkURL = firstSocialNetworkURL,
            socialNetworkName = firstSocialNetworkName,
            modifier = Modifier
        )
    }
}