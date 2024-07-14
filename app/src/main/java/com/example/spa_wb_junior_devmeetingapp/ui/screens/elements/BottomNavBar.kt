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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DeepBlueForBottomBar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraDarkPurpleForBottomBar
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
        containerColor = Color.White
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
                    indicatorColor = Color.Transparent
                ),
            )
        }
    }
}