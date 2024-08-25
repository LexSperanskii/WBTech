package com.example.spa_wb_junior_devmeetingapp.ui.newUi.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.models.NewUserModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme


@Composable
internal fun PersonCard(
    person: NewUserModelUI,
    onPersonCardClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Card(
        onClick = onPersonCardClick,
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RectangleShape,
        modifier = modifier
    ) {
        NewPersonAvatar(
            size = 104.dp,
            imageURL = person.imageURL,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = person.name,
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.newBodyText1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        TagSmall(
            tagText = person.tag,
            onTagClick = {},
            isClicked = false
        )
    }
}