package com.example.ui_v1.ui.elements

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui_v1.R
import com.example.ui_v1.ui.theme.DevMeetingAppTheme

@Composable
internal fun CustomFilterChip(text : String) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text(text = text)
        },
        shape = RoundedCornerShape(40.dp),
        selected = selected,
        leadingIcon = {
            selected.takeIf { it }?.let { // Используем takeIf для проверки selected
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = stringResource(id = R.string.chip),
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
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