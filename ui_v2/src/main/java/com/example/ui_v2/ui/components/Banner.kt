package com.example.ui_v2.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun Banner(
    onBannerTagClick: () -> Unit,
    modifier: Modifier = Modifier,
    bannerText: String = stringResource(id = R.string.tell_about_interests),
    tagText: String = stringResource(id = R.string.select_interests),
) {
    Card(
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        modifier = modifier
            .background(
                brush = DevMeetingAppTheme.brush.buttonGradientPrimary,
                shape = RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium)
            )
            .fillMaxWidth()
    ) {
        Box(modifier = Modifier) {
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.banner_arrow_left),
                    contentDescription = stringResource(id = R.string.icon),
                    tint = Color.Unspecified,
                    modifier = Modifier
                        .offset(x = 16.dp)
                )
                Icon(
                    painter = painterResource(id = R.drawable.banner_arrow_right),
                    contentDescription = stringResource(id = R.string.icon),
                    tint = Color.Unspecified,
                    modifier = Modifier
                )
            }
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .width(224.dp)
            ) {
                Text(
                    text = bannerText,
                    color = DevMeetingAppTheme.colors.white,
                    style = DevMeetingAppTheme.typography.metadata1,
                    modifier = Modifier.padding(bottom = 14.dp)
                )
                BannerTag(
                    tagText = tagText,
                    onBannerTagClick = onBannerTagClick
                )
            }
        }
    }
}