package com.example.ui_v2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.ui_v2.ui.DeveloperDestination
import com.example.ui_v2.ui.DeveloperScreen
import com.example.ui_v2.ui.screens.SplashScreen.SplashScreen
import com.example.ui_v2.ui.screens.SplashScreen.SplashScreenDestination
import com.example.ui_v2.ui.screens.mainScreen.MainScreen
import com.example.ui_v2.ui.screens.mainScreen.MainScreenDestination
import com.example.ui_v2.ui.screens.onboarding.interestsScreen.InterestsScreen
import com.example.ui_v2.ui.screens.onboarding.interestsScreen.InterestsScreenDestination
import com.example.ui_v2.ui.screens.onboarding.locationScreen.LocationScreen
import com.example.ui_v2.ui.screens.onboarding.locationScreen.LocationScreenDestination


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
                navigateToLocationScreen = {
                    navController.navigate(LocationScreenDestination.route)
                }
            )
        }
        composable(route = LocationScreenDestination.route) {
            LocationScreen(
                navigateToMainScreen = {
                    navController.navigate(MainScreenDestination.route) {
                        popUpTo(InterestsScreenDestination.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }
        composable(route = MainScreenDestination.route) {
            MainScreen(
                navigateToOtherUserScreen = {},
                navigateToCommunityScreen = {},
                navigateToEventScreen = {},
                navigateToBannerScreen = {},
                navigateToProfileScreen = {},
            )
        }
    }
}