package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun TagBlock(
    listOfTags: List<String>,
    listOfChosenTags: List<String>,
    onTagClick: (String) -> Unit,
    modifier: Modifier = Modifier,
    blockText: String = stringResource(id = R.string.block_tag),
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        Text(
            text = blockText,
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.customH2
        )
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            listOfTags.forEach {
                TagMedium(
                    tagText = it,
                    onTagClick = { onTagClick(it) },
                    isClicked = listOfChosenTags.contains(it)
                )
            }
        }
    }
}