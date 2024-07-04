package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.os.LocaleListCompat
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.GrayForCommunityCard
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Metadata1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

@Composable
fun CommunityCard(
    nameOfCommunity: String,
    sizeOfCommunity: Int,
    painter: Painter = painterResource(id = R.drawable.avatar_community),
    dividerColor: Color = DividerDefaults.color,
    dividerThickness: Dp = DividerDefaults.Thickness,
    modifier: Modifier = Modifier
) {

    val locale = LocaleListCompat.getDefault().get(0) // Получаем локаль из настроек телефона
    val symbols = DecimalFormatSymbols(locale)
    symbols.groupingSeparator = ' ' // Устанавливаем пробел как разделитель тысяч
    val formatter = DecimalFormat("#,###", symbols) // Используем DecimalFormat с пробелом
    val formattedNumber = formatter.format(sizeOfCommunity)

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier
    ) {
        Column {
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp)
            ){
                Column(modifier = Modifier.widthIn(68.dp)) {
                    Image(
                        painter = painter,
                        contentDescription = "avatar meeting",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .padding(4.dp)
                            .size(48.dp),
                    )
                }
                Column {
                    Text(
                        text = nameOfCommunity,
                        fontSize = MaterialTheme.typography.BodyText1.fontSize,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = SFProDisplay,
                        modifier = Modifier.padding(bottom = 2.dp)
                    )
                    Text(
                        text = LocalContext.current.resources.getQuantityString  (
                            R.plurals.community_people_count,
                            sizeOfCommunity,
                            formattedNumber
                        ),
                        fontSize = MaterialTheme.typography.Metadata1.fontSize,
                        fontWeight = FontWeight.Normal,
                        fontFamily = SFProDisplay,
                        color = GrayForCommunityCard,
                        modifier = Modifier
                    )
                }
            }
            HorizontalDivider(
                thickness = dividerThickness,
                color = dividerColor,
                modifier = Modifier.padding(top = 12.dp)
            )
        }
    }
}