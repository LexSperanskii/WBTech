package com.example.spa_wb_junior_devmeetingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.DeveloperDestination
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.DeveloperScreen
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.splashScreen.SplashScreen
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.splashScreen.SplashScreenDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.OldDesignNavHost


@Composable
internal fun NavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = SplashScreenDestination.route,
        modifier = Modifier
    ) {
        composable(route = SplashScreenDestination.route) {
            SplashScreen(navigateToStartScreen = {
                navController.navigate("old_design") {
                    popUpTo(SplashScreenDestination.route) {
                        inclusive = true
                    }
                }
            })
        }
        composable(route = DeveloperDestination.route) {
            DeveloperScreen()
        }
        composable(route = "old_design") {
            OldDesignNavHost()
        }
    }
}