package com.example.ui_v2.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun AppointmentHeader(
    event: EventDescriptionModelUI,
    onCrossClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(bottom = 14.dp)
        ) {
            Text(
                text = stringResource(id = R.string.appointment_title),
                style = DevMeetingAppTheme.typography.customH3,
                color = DevMeetingAppTheme.colors.black,
                modifier = Modifier
                    .weight(1f)
            )
            Icon(
                painter = painterResource(id = R.drawable.icon_cross),
                contentDescription = stringResource(id = R.string.icon),
                tint = DevMeetingAppTheme.colors.disabledButtonTextGray,
                modifier = Modifier
                    .size(28.dp)
                    .clickable {
                        onCrossClick()
                    }
            )
        }
        Text(
            text = stringResource(
                id = R.string.appointment_header_date_address,
                event.name,
                event.day,
                event.month,
                event.street,
                event.building
            ),
            color = DevMeetingAppTheme.colors.eventCardText,
            style = DevMeetingAppTheme.typography.subheading1,
            modifier = Modifier
        )
    }
}