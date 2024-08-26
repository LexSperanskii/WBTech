package com.example.ui_v2.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ui_v2.ui.ui.DeveloperDestination
import com.example.ui_v2.ui.ui.DeveloperScreen
import com.example.ui_v2.ui.ui.newSplashScreen.SplashScreen
import com.example.ui_v2.ui.ui.newSplashScreen.SplashScreenDestination
import com.example.ui_v2.ui.ui.onboarding.interestsScreen.InterestsScreen
import com.example.ui_v2.ui.ui.onboarding.interestsScreen.InterestsScreenDestination


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
        composable(route = SplashScreenDestination.route) {
            SplashScreen(navigateToStartScreen = {
                navController.navigate(InterestsScreenDestination.route) {
                    popUpTo(SplashScreenDestination.route) {
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
    }
}