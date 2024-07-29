package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.models.PhoneNumberModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.formattedMobileNumber
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme

@Composable
internal fun MenuItemProfile(
    onProfileClick: () -> Unit,
    profileName: String,
    profileSurname: String,
    mobileNumber: PhoneNumberModelUI,
    avatarURL: String?,
    modifier: Modifier = Modifier
    ) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier
            .clickable { onProfileClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ){
            PersonAvatar(
                size = 50.dp,
                isEdit = false,
                imageURL = avatarURL
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.name_surname, profileName, profileSurname),
                    style = DevMeetingAppTheme.typography.bodyText1,
                    color = DevMeetingAppTheme.colors.extraDarkPurpleForBottomBar,
                    modifier = Modifier
                )
                Text(
                    text =  formattedMobileNumber(mobileNumber),
                    style = DevMeetingAppTheme.typography.metadata1,
                    color = DevMeetingAppTheme.colors.grayForCommunityCard,
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.forward),
                tint = DevMeetingAppTheme.colors.extraDarkPurpleForBottomBar,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
