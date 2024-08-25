package com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme

internal data class TypographyItem(
    val style : TextStyle,
    val title: String,
    val subTitle: String
)

@Composable
internal fun TypographyRow(
    title: String,
    subTitle: String,
    style : TextStyle,
    modifier: Modifier = Modifier,
) {
    val text = "The quick brown fox jumps over the lazy dog"
    LazyRow(
        modifier = modifier
    ) {
        item {
            Column(
                modifier = Modifier
                    .padding(end = 16.dp)
                    .widthIn(180.dp) //устанавливает минимальную ширину колонки
            ) {
                Text(
                    text = title,
                    style = DevMeetingAppTheme.typography.subheading1,
                )
                Text(
                    text = subTitle,
                    style = DevMeetingAppTheme.typography.bodyText2,
                    color = DevMeetingAppTheme.colors.gray,
                )

            }
            Text(
                text = text,
                style = style,
            )
        }
    }
}
