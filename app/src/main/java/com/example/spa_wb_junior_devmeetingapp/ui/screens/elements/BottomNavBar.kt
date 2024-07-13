package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.CommunityDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.EventsAllDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.MenuDestination
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DeepBlueForBottomBar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraDarkPurpleForBottomBar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay

enum class BottomNavItem(
    val destination: NavigationDestination,
    @StringRes val title: Int,
    @DrawableRes val icon: Int
) {
    EVENTS(EventsAllDestination, R.string.events_all, R.drawable.bottom_bar_icon_meetings),
    COMMUNITY(CommunityDestination, R.string.community, R.drawable.bottom_bar_icon_communities),
    MENU(MenuDestination, R.string.more, R.drawable.bottom_bar_icon_more)
}
@Composable
fun BottomNavigationBar(navController: NavController) {

    NavigationBar(
        containerColor = Color.White
    ) {
        BottomNavItem.entries.forEach { bottomBarItem ->

//            val isSelected = navController.currentDestination?.route == bottomBarItem.destination.route
            val isSelected = navController.currentDestination?.hierarchy?.any { it.route == bottomBarItem.destination.route } ?: false

            NavigationBarItem(
                selected = isSelected,
                onClick = {
                    navController.navigate(bottomBarItem.destination.route) {
                        popUpTo(navController.graph.startDestinationId)
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    if (isSelected){
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = stringResource(id = bottomBarItem.title ),
                                fontSize = MaterialTheme.typography.BodyText1.fontSize,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = SFProDisplay,
                                color = ExtraDarkPurpleForBottomBar
                            )
                            Box(
                                modifier = Modifier
                                    .size(4.dp)
                                    .background(ExtraDarkPurpleForBottomBar, shape = CircleShape)
                            )
                        }
                    } else {
                        Icon(
                            painter = painterResource(id = bottomBarItem.icon),
                            contentDescription = stringResource(id = bottomBarItem.title ),
                            tint = DeepBlueForBottomBar,
                            modifier = Modifier
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent // Прозрачный цвет для индикатора
                ),
            )
        }
    }
}