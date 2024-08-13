package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.newUi

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.PersonAvatar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme


@Composable
fun PersonCard(
    avatarURL: String,
    personName: String,
    tagText: String,
    isTagClicked: Boolean,
    onPersonCardClick: () -> Unit,
    onTagClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        onClick = onPersonCardClick,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        modifier = modifier
    ) {
        PersonAvatar(
            size = 104.dp,
            isEdit = false,
            imageURL = avatarURL,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = personName,
            color = DevMeetingAppTheme.colors.black,
            fontSize = DevMeetingAppTheme.typography.subheading1.fontSize,
            fontFamily = DevMeetingAppTheme.typography.subheading1.fontFamily,
            fontWeight = FontWeight.Medium,
            lineHeight = 22.sp,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        TagSmall(
            tagText = tagText,
            onTagClick = onTagClick,
            isClicked = isTagClicked
        )
    }
}