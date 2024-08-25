package com.example.spa_wb_junior_devmeetingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.spa_wb_junior_devmeetingapp.ui.DeveloperDestination
import com.example.spa_wb_junior_devmeetingapp.ui.DeveloperScreen
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.newSplashScreen.NewSplashScreen
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.newSplashScreen.NewSplashScreenDestination
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.onboarding.interestsScreen.InterestsScreen
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.onboarding.interestsScreen.InterestsScreenDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.OldDesignNavHost


@Composable
internal fun NavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = DeveloperDestination.route,
        modifier = Modifier
    ) {
        composable(route = DeveloperDestination.route) {
            DeveloperScreen()
        }
        composable(route = NewSplashScreenDestination.route) {
            NewSplashScreen(navigateToStartScreen = {
                navController.navigate(InterestsScreenDestination.route) {
                    popUpTo(NewSplashScreenDestination.route) {
                        inclusive = true
                    }
                }
            })
        }

        composable(route = InterestsScreenDestination.route) {
            InterestsScreen(
                navigateToLocationScreen = {}
            )
        }

        composable(route = "old_design") {
            OldDesignNavHost()
        }
    }
}