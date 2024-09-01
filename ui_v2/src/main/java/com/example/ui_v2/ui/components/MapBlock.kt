package com.example.ui_v2.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.models.MetroModelUI
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun MapBlock(
    address: String,
    metro: MetroModelUI,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = address,
            style = DevMeetingAppTheme.typography.customH2,
            color = DevMeetingAppTheme.colors.black,
            modifier = Modifier
                .padding(bottom = 2.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(2.dp),
            modifier = Modifier
                .padding(bottom = 10.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.metro),
                contentDescription = stringResource(id = R.string.icon),
                tint = metro.tint
            )
            Text(
                text = metro.name,
                style = DevMeetingAppTheme.typography.metadata1,
                color = DevMeetingAppTheme.colors.black
            )
        }
        Image(
            painter = painterResource(R.drawable.map),
            contentDescription = stringResource(id = R.string.icon),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(24.dp))
                .fillMaxWidth()
                .height(180.dp)
        )
    }
}