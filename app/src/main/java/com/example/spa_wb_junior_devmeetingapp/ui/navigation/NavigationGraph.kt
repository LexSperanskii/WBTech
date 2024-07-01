package com.example.spa_wb_junior_devmeetingapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.spa_wb_junior_devmeetingapp.ui.screens.DeveloperScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.ListOfMeetingsAllScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.ListOfMeetingsUserScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.ProfileScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar

/**
 * Provides Navigation graph for the application.
 */
@Composable
fun NavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = BottomNavItem.Meetings.route,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(route = BottomNavItem.Meetings.route) {
                ListOfMeetingsAllScreen()
            }
            composable(route = BottomNavItem.Communities.route) {
                ListOfMeetingsUserScreen()
            }
            composable(route = BottomNavItem.Additional.route) {
                ProfileScreen()
            }
        }
    }
}