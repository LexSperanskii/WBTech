package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme

@Composable
fun CustomButtonForEvent(
    isUserInParticipants: Boolean,
    enabled: Boolean,
    onButtonClick: ()-> Unit
) {
    when (isUserInParticipants) {
        true -> {
            CustomButtonOutlined(
                text = stringResource(id = R.string.i_will_go_next_time),
                onClick = onButtonClick,
                pressedColor = DevMeetingAppTheme.colors.darkPurple,
                contentColor = DevMeetingAppTheme.colors.purple,
                enabled = enabled,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            )
        }

        else -> {
            CustomButton(
                text = stringResource(id = R.string.i_will_go_to_the_event),
                onClick = onButtonClick,
                pressedColor = DevMeetingAppTheme.colors.darkPurple,
                containerColor = DevMeetingAppTheme.colors.purple,
                enabled = enabled,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            )
        }
    }
}