package com.example.spa_wb_junior_devmeetingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.spa_wb_junior_devmeetingapp.ui.screens.CommunityDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.CommunityDetailsDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.CommunityScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.EventsAllDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.EventsAllScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.ProfileDestination
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
        startDestination = EventsAllDestination.route,
        modifier = Modifier
    ) {
        composable(route = EventsAllDestination.route) {
            EventsAllScreen(navController)
        }
        composable(route = CommunityDestination.route) {
            CommunityScreen(
                navController = navController,
                navigateToCommunityDetailItem = {
                    navController.navigate("${CommunityDetailsDestination.route}/${it}")
                }
            )
        }
        composable(route = ProfileDestination.route) {
            ProfileScreen(navController)
        }
    }
}