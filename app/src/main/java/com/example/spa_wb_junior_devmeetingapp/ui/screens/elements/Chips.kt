package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme

@Composable
fun CustomFilterChip(text : String) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text(text = text)
        },
        shape = RoundedCornerShape(40.dp),
        selected = selected,
        leadingIcon = {
            when (selected) {
                true -> Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
                false -> {
                    null
                }
            }
        },
        colors = FilterChipDefaults.filterChipColors(
            containerColor = DevMeetingAppTheme.colors.lightPurple,
            labelColor = DevMeetingAppTheme.colors.darkPurple,
            selectedContainerColor = DevMeetingAppTheme.colors.lightPurple,
            selectedLabelColor = DevMeetingAppTheme.colors.darkPurple,
            selectedLeadingIconColor = DevMeetingAppTheme.colors.darkPurple
            ),
        border = null
    )
}