package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraDarkPurpleForBottomBar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay

@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    onMenuItemClick: () -> Unit,
    menuItemIcon: Painter,
    menuItemName: String,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier
            .clickable { onMenuItemClick() }
            .heightIn(40.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Icon(
                painter = menuItemIcon,
                contentDescription = stringResource(id = R.string.menu_icon),
                tint = ExtraDarkPurpleForBottomBar,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = menuItemName,
                fontSize = MaterialTheme.typography.BodyText1.fontSize,
                fontWeight = FontWeight.SemiBold,
                fontFamily = SFProDisplay,
                color = ExtraDarkPurpleForBottomBar,
                modifier = Modifier.padding(6.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.forward),
                tint = ExtraDarkPurpleForBottomBar,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
@Composable
fun MenuItemForMyEvents(
    modifier: Modifier = Modifier,
    onMenuItemClick: () -> Unit,
    menuItemIcon: Painter,
    menuItemName: String,
) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = modifier
            .clickable { onMenuItemClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ){
            Icon(
                painter = menuItemIcon,
                contentDescription = stringResource(id = R.string.menu_icon),
                tint = ExtraDarkPurpleForBottomBar,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = menuItemName,
                fontSize = MaterialTheme.typography.BodyText1.fontSize,
                fontWeight = FontWeight.SemiBold,
                fontFamily = SFProDisplay,
                color = ExtraDarkPurpleForBottomBar,
                modifier = Modifier.padding(6.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.forward),
                tint = ExtraDarkPurpleForBottomBar,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}