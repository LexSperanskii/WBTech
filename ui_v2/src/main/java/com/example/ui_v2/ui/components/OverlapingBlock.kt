package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.ui_v2.R
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@Composable
internal fun OverlappingBlock(
    participantsList: List<UserModelUI>,
    onOverlappingRowClick: () -> Unit,
    modifier: Modifier = Modifier,
    blockText: String = stringResource(id = R.string.participants),
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(DevMeetingAppTheme.dimensions.paddingMedium),
        modifier = modifier
            .fillMaxWidth()
    ) {
        Text(
            text = blockText,
            style = DevMeetingAppTheme.typography.customH2,
            color = DevMeetingAppTheme.colors.black,
            modifier = Modifier
        )
        when (participantsList.isEmpty()) {
            true -> {
                Text(
                    text = stringResource(id = R.string.no_participants),
                    color = DevMeetingAppTheme.colors.eventCardText,
                    style = DevMeetingAppTheme.typography.bodyText1,
                    modifier = Modifier
                )
            }

            else -> {
                OverlappingPeopleRow(
                    participantsList = participantsList,
                    onOverlappingRowClick = onOverlappingRowClick,
                    reverse = true
                )
            }
        }
    }
}