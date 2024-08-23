package com.example.spa_wb_junior_devmeetingapp.ui.newUi.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme

@Composable
internal fun NetworkIcon(
    @DrawableRes
    networkIcon: Int,
    onNetworkIconClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMediumSmall))
            .size(52.dp)
            .clickable { onNetworkIconClick() }
            .background(DevMeetingAppTheme.colors.buttonTextPurple)
    ) {
        Icon(
            painter = painterResource(id = networkIcon),
            contentDescription = stringResource(id = R.string.icon),
            tint = DevMeetingAppTheme.colors.white,
            modifier = Modifier
                .size(32.dp)
                .align(Alignment.Center)
        )
    }
}