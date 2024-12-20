package com.example.ui_v1.ui.elements

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.ui_v1.R
import com.example.ui_v1.ui.theme.DevMeetingAppTheme


internal enum class BottomNavItem(val route: String, @StringRes val title: Int, @DrawableRes val icon: Int) {
    Events (route = "events_tab", title = R.string.events_all, icon = R.drawable.bottom_bar_icon_meetings),
    Communities (route = "communities_tab", title = R.string.communities, icon = R.drawable.bottom_bar_icon_communities),
    Menu (route = "menu_tab", title = R.string.more, icon = R.drawable.bottom_bar_icon_more)
}

@Composable
internal fun BottomNavigationBar(navController: NavController) {

    NavigationBar(
        tonalElevation = 0.dp,
        modifier = Modifier.height(86.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        BottomNavItem.entries.forEach { bottomBarItem ->

            val isSelected = currentDestination?.hierarchy?.any { it.route == bottomBarItem.route } == true

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(bottomBarItem.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    NameAndDotBottomNavBarIcon(
                        isSelected = isSelected,
                        bottomBarItem = bottomBarItem
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
            )
        }
    }
}

@Composable
internal fun NameAndDotBottomNavBarIcon(
    isSelected : Boolean,
    bottomBarItem: BottomNavItem
){
    when(isSelected){
        true -> {
            Column(
                verticalArrangement = Arrangement.spacedBy(4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = bottomBarItem.title ),
                    style = DevMeetingAppTheme.typography.bodyText1,
                    color = DevMeetingAppTheme.colors.extraDarkPurpleForBottomBar
                )
                Box(
                    modifier = Modifier
                        .size(4.dp)
                        .clip(CircleShape)
                        .background(DevMeetingAppTheme.colors.extraDarkPurpleForBottomBar)
                )
            }
        }
        else -> {
            Icon(
                painter = painterResource(id = bottomBarItem.icon),
                contentDescription = stringResource(id = bottomBarItem.title ),
                tint = DevMeetingAppTheme.colors.deepBlueForBottomBar,
                modifier = Modifier
            )
        }
    }
}
