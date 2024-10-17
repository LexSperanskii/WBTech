package com.example.ui_v2.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.ui.theme.DevMeetingAppTheme


@Composable
internal fun PersonCard(
    person: UserModelUI,
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
            .width(104.dp)
    ) {
        PersonAvatar(
            size = 104.dp,
            imageURL = person.imageURL,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Text(
            text = person.nameSurname,
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.bodyText1,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier.padding(vertical = 4.dp)
        )
        TagSmall(
            tagText = person.listOfTags.first(),
            onTagClick = {},
            isClicked = false
        )
    }
}