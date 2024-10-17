package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.example.ui_v2.R
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
fun UserSwitchBlock(
    showMyCommunitiesChecked: Boolean,
    onShowMyCommunitiesChange: (Boolean) -> Unit,

    showMyEventsChecked: Boolean,
    onShowMyEventsChange: (Boolean) -> Unit,

    applyNotificationsChecked: Boolean,
    onApplyNotificationsChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(DevMeetingAppTheme.dimensions.paddingMedium),
        modifier = modifier
            .padding(horizontal = DevMeetingAppTheme.dimensions.paddingMedium)
    ) {
        SwitchRow(
            text = stringResource(id = R.string.show_my_communities),
            checked = showMyCommunitiesChecked,
            onCheckedChange = onShowMyCommunitiesChange
        )
        SwitchRow(
            text = stringResource(id = R.string.show_my_events),
            checked = showMyEventsChecked,
            onCheckedChange = onShowMyEventsChange
        )
        SwitchRow(
            text = stringResource(id = R.string.apply_notifications),
            checked = applyNotificationsChecked,
            onCheckedChange = onApplyNotificationsChange,
            modifier = Modifier.padding(top = DevMeetingAppTheme.dimensions.paddingMedium)
        )
    }
}

@Composable
fun SwitchRow(
    text: String,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = text,
            color = DevMeetingAppTheme.colors.buttonTextPurple,
            style = DevMeetingAppTheme.typography.bodyText1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
        )
        CustomSwitch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}