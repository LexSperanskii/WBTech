package com.example.ui_v2.ui.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.ui.ui.theme.DevMeetingAppTheme

@Composable
internal fun BackShareBar(
    barText: String,
    onArrowClick: () -> Unit,
    onShareClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Icon(
            painter = painterResource(id = R.drawable.backbar_arrow_left),
            contentDescription = stringResource(id = R.string.icon),
            tint = DevMeetingAppTheme.colors.buttonTextPurple,
            modifier = Modifier
                .size(24.dp, 18.dp)
                .clickable {
                    onArrowClick()
                }
        )
        Text(
            text = barText,
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.bodyText1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 12.dp)
        )
        Icon(
            painter = painterResource(id = R.drawable.icon_share),
            contentDescription = stringResource(id = R.string.icon),
            tint = DevMeetingAppTheme.colors.buttonTextPurple,
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    onShareClick()
                }
        )
    }
}

@Composable
internal fun BackBar(
    barText: String,
    onArrowClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Icon(
            painter = painterResource(id = R.drawable.backbar_arrow_left),
            contentDescription = stringResource(id = R.string.icon),
            tint = DevMeetingAppTheme.colors.buttonTextPurple,
            modifier = Modifier
                .size(24.dp, 18.dp)
                .clickable {
                    onArrowClick()
                }
        )
        Text(
            text = barText,
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.bodyText1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(start = 12.dp, end = 36.dp)
                .weight(1f)
        )
    }
}