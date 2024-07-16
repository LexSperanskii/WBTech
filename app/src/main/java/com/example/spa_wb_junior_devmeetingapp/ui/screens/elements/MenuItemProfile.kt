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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.mockData.PhoneNumber
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraDarkPurpleForBottomBar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.GrayForCommunityCard
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Metadata1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay

@Composable
fun MenuItemProfile(
    modifier: Modifier = Modifier,
    onProfileClick: () -> Unit,
    profileName: String,
    mobileNumber: PhoneNumber,
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
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.padding(start = 20.dp)
            ) {
                Text(
                    text = profileName,
                    fontSize = MaterialTheme.typography.BodyText1.fontSize,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = SFProDisplay,
                    color = ExtraDarkPurpleForBottomBar,
                    modifier = Modifier
                )
                Text(
                    text = formattedMobileNumber(mobileNumber),
                    fontSize = MaterialTheme.typography.Metadata1.fontSize,
                    fontWeight = FontWeight.Normal,
                    fontFamily = SFProDisplay,
                    color = GrayForCommunityCard,
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.forward),
                tint = ExtraDarkPurpleForBottomBar,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
fun formattedMobileNumber(mobileNumber: PhoneNumber): String {
    return when (mobileNumber.number.length) {
        10 -> buildString {
            append(mobileNumber.countryCode)
            append(" ")
            append(mobileNumber.number.substring(0, 3))
            append(" ")
            append(mobileNumber.number.substring(3, 6))
            append("-")
            append(mobileNumber.number.substring(6, 8))
            append("-")
            append(mobileNumber.number.substring(8))
        }
        else -> buildString {
            append(mobileNumber.countryCode)
            append(" ")
            append(mobileNumber.number)
        }
    }
}