package com.example.spa_wb_junior_devmeetingapp.ui.newUi.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.models.NewCommunityModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme

@Composable
internal fun CommunitiesCarousel(
    blockText: String,
    communitiesList: List<NewCommunityModelUI>,
    isCommunityButtonClicked: Boolean,
    onCommunityButtonClick: (NewCommunityModelUI) -> Unit,
    onCommunityClick: (NewCommunityModelUI) -> Unit,
    modifier: Modifier = Modifier,
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
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            items(communitiesList) { community ->
                NewCommunityCard(
                    community = community,
                    isCommunityButtonClicked = isCommunityButtonClicked,
                    onCommunityButtonClick = { onCommunityButtonClick(community) },
                    onCommunityClick = { onCommunityClick(community) })
            }
        }
    }
}