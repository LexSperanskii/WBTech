package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay


sealed class BottomNavItem(val route: String, @StringRes val title: Int, @DrawableRes val icon: Int) {
    data object Events : BottomNavItem("events_tab",R.string.events_all, R.drawable.bottom_bar_icon_meetings)
    data object Communities : BottomNavItem("communities_tab", R.string.communities, R.drawable.bottom_bar_icon_communities)
    data object Menu : BottomNavItem("menu_tab",  R.string.more, R.drawable.bottom_bar_icon_more)
}
val items = listOf(
    BottomNavItem.Events,
    BottomNavItem.Communities,
    BottomNavItem.Menu
)

@Composable
fun BottomNavigationBar(navController: NavController) {

    NavigationBar(
        tonalElevation = 0.dp,
        modifier = Modifier.height(86.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        items.forEach { bottomBarItem ->

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
                        false -> {
                            Icon(
                                painter = painterResource(id = bottomBarItem.icon),
                                contentDescription = stringResource(id = bottomBarItem.title ),
                                tint = DevMeetingAppTheme.colors.deepBlueForBottomBar,
                                modifier = Modifier
                            )
                        }
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
            )
        }
    }
}