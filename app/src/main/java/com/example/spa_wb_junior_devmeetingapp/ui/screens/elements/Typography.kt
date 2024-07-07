package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Subheading1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Gray

data class TypographyItem(
    val fontSize: TextUnit,
    val fontWeight: FontWeight,
    val title: String,
    val subTitle: String
)

@Composable
fun TypographyRow(
    title: String,
    subTitle: String,
    fontSize: TextUnit,
    modifier: Modifier = Modifier,
    fontWeight: FontWeight,
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
                    fontSize = MaterialTheme.typography.Subheading1.fontSize,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = SFProDisplay
                )
                Text(
                    text = subTitle,
                    fontSize = MaterialTheme.typography.titleSmall.fontSize,
                    color = Gray,
                    fontFamily = SFProDisplay
                )

            }
            Text(
                text = text,
                fontSize = fontSize,
                fontWeight = fontWeight,
                fontFamily = SFProDisplay
            )
        }
    }
}
