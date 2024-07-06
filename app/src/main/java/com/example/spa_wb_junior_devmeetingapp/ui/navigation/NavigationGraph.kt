package com.example.spa_wb_junior_devmeetingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.spa_wb_junior_devmeetingapp.ui.screens.CommunityScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.EventsAllScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.ProfileScreen

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun NavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Meetings.route,
        modifier = Modifier
    ) {
        composable(route = BottomNavItem.Meetings.route) {
            EventsAllScreen(navController)
        }
        composable(route = BottomNavItem.Communities.route) {
            CommunityScreen(navController)
        }
        composable(route = BottomNavItem.Additional.route) {
            ProfileScreen(navController)
        }
    }
}