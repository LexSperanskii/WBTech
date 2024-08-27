package com.example.ui_v2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ui_v2.ui.DeveloperDestination
import com.example.ui_v2.ui.DeveloperScreen
import com.example.ui_v2.ui.SplashScreen.SplashScreen
import com.example.ui_v2.ui.SplashScreen.SplashScreenDestination
import com.example.ui_v2.ui.onboarding.interestsScreen.InterestsScreen
import com.example.ui_v2.ui.onboarding.interestsScreen.InterestsScreenDestination


@Composable
fun NavHost(
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