package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui_v2.R
import com.example.ui_v2.ui.theme.DevMeetingAppTheme

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun UserInterestsBlock(
    listOfUserTags: List<String>,
    onTagClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(horizontal = DevMeetingAppTheme.dimensions.paddingMedium)
    ) {
        Text(
            text = stringResource(id = R.string.interests),
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.customH2,
            modifier = Modifier
                .padding(bottom = 12.dp)
        )
        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            listOfUserTags.forEach {
                TagMedium(
                    tagText = it,
                    onTagClick = {},
                    isClicked = true
                )
            }
            TagMedium(
                tagText = stringResource(id = R.string.change),
                onTagClick = onTagClick,
                isClicked = false
            )
        }
    }
}
