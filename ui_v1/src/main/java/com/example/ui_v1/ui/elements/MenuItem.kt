package com.example.ui_v1.ui.elements

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.ui_v1.R
import com.example.ui_v1.ui.theme.DevMeetingAppTheme

@Composable
internal fun MenuItem(
    onMenuItemClick: () -> Unit,
    menuItemIcon: Painter,
    menuItemName: String,
    modifier: Modifier = Modifier
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
                tint = DevMeetingAppTheme.colors.extraDarkPurpleForBottomBar,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = menuItemName,
                style = DevMeetingAppTheme.typography.bodyText1,
                color = DevMeetingAppTheme.colors.extraDarkPurpleForBottomBar,
                modifier = Modifier.padding(6.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.forward),
                tint = DevMeetingAppTheme.colors.extraDarkPurpleForBottomBar,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}
@Composable
internal fun MenuItemForMyEvents(
    onMenuItemClick: () -> Unit,
    menuItemIcon: Painter,
    menuItemName: String,
    modifier: Modifier = Modifier
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
                tint = DevMeetingAppTheme.colors.extraDarkPurpleForBottomBar,
                modifier = Modifier.size(24.dp)
            )
            Text(
                text = menuItemName,
                style = DevMeetingAppTheme.typography.bodyText1,
                color = DevMeetingAppTheme.colors.extraDarkPurpleForBottomBar,
                modifier = Modifier.padding(6.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                contentDescription = stringResource(id = R.string.forward),
                tint = DevMeetingAppTheme.colors.extraDarkPurpleForBottomBar,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}