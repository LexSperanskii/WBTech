package com.example.spa_wb_junior_devmeetingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.spa_wb_junior_devmeetingapp.ui.screens.communitiesScreen.CommunitiesDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.communityDetailScreen.CommunityDetailsDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.communityDetailScreen.CommunityDetailsScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.communitiesScreen.CommunityScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.eventDetailScreen.EventDetailsDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.eventDetailScreen.EventDetailsScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.eventsAllScreen.EventsAllDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.eventsAllScreen.EventsAllScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.eventsUserScreen.EventsUserDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.eventsUserScreen.EventsUserScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.FullScreenMapScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.MapDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.authenticationScreen.AuthenticationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.authenticationScreen.AuthenticationScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.DeveloperDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.DeveloperScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.menuScreen.MenuDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.menuScreen.MenuScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.profileScreen.ProfileDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.profileScreen.ProfileScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.registratinProfileScreen.RegistrationProfileDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.registratinProfileScreen.RegistrationProfileScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.splashScreen.SplashScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.splashScreen.SplashScreenDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.verificationScreen.VerificationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.verificationScreen.VerificationScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavItem
import com.google.gson.Gson


@Composable
fun NavHost(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = SplashScreenDestination.route,
        modifier = Modifier
    ) {
        composable(route = SplashScreenDestination.route) {
            SplashScreen(navigateToStartScreen = {
                navController.navigate("registration_tab"){
                    popUpTo(SplashScreenDestination.route){
                        inclusive = true
                    }
                }
            })
        }
        composable(route = DeveloperDestination.route) {
            DeveloperScreen()
        }
        navigation(
            startDestination = AuthenticationDestination.route,
            route = "registration_tab"
        ){
            composable(route = AuthenticationDestination.route) {
                AuthenticationScreen(
                    navigateToVerificationScreen = {
                        navController.navigate(VerificationDestination.route)
                    },
                    onClickNavigateBack = { navController.popBackStack() }
                )
            }
            composable(route = VerificationDestination.route) {
                VerificationScreen(
                    onClickNavigateBack = { navController.popBackStack() } ,
                    navigateToRegistrationProfile = {
                        navController.navigate(RegistrationProfileDestination.route)
                    }
                )
            }
            composable(route = RegistrationProfileDestination.route) {
                RegistrationProfileScreen(
                    onClickNavigateBack = { navController.popBackStack() },
                    navigateToEventsAllScreen = {
                        navController.navigate(BottomNavItem.Events.route) {
                            popUpTo("registration_tab") {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }
        navigation(
            startDestination = EventsAllDestination.route,
            route = BottomNavItem.Events.route
        ){
            composable(route = EventsAllDestination.route) {
                EventsAllScreen(
                    navController = navController,
                    navigateToEventDetailItem = {
                        navController.navigate("${BottomNavItem.Events.route}/${EventDetailsDestination.route}")
                    },
                    navigateToDeveloperScreen = {navController.navigate(DeveloperDestination.route)}
                )
            }
            composable(
                route = "${BottomNavItem.Events.route}/${EventDetailsDestination.route}"
            ) {
                EventDetailsScreen(
                    navController = navController,
                    navigateToFullScreenMap = {
                        navController.navigate("${BottomNavItem.Events.route}/${MapDestination.route}")
                    }
                )
            }
            composable(
                route = "${BottomNavItem.Events.route}/${MapDestination.route}")
            {
                FullScreenMapScreen(navController = navController)
            }
        }
        navigation(
            startDestination = CommunitiesDestination.route,
            route = BottomNavItem.Communities.route
        ){
            composable(route = CommunitiesDestination.route) {
                CommunityScreen(
                    navController = navController,
                    navigateToCommunityDetailItem = {
                        navController.navigate(CommunityDetailsDestination.route)
                    }
                )
            }
            composable(
                route = CommunityDetailsDestination.route
            ) {
                CommunityDetailsScreen(
                    navController = navController,
                    navigateToEventDetailItem = {
                        navController.navigate("${BottomNavItem.Communities.route}/${EventDetailsDestination.route}")
                    }
                )
            }
            composable(
                route = "${BottomNavItem.Communities.route}/${EventDetailsDestination.route}"
            ) {
                EventDetailsScreen(
                    navController = navController,
                    navigateToFullScreenMap = {
                        navController.navigate("${BottomNavItem.Communities.route}/${MapDestination.route}")
                    }
                )
            }
            composable(route = "${BottomNavItem.Communities.route}/${MapDestination.route}") {
                FullScreenMapScreen(navController = navController)
            }
        }
        navigation(
            startDestination = MenuDestination.route,
            route = BottomNavItem.Menu.route
        ){
            composable(route = MenuDestination.route) {
                MenuScreen(
                    navController = navController,
                    navigateToProfile = {navController.navigate(ProfileDestination.route)},
                    navigateToUserEvents = {navController.navigate(EventsUserDestination.route)}
                )
            }
            composable(route = ProfileDestination.route) {
                ProfileScreen(navController = navController)
            }
            composable(route = EventsUserDestination.route) {
                EventsUserScreen(
                    navController = navController,
                    navigateToEventDetailItem = {
                        navController.navigate("${BottomNavItem.Menu.route}/${EventDetailsDestination.route}")
                    }
                )
            }
            composable(
                route = "${BottomNavItem.Menu.route}/${EventDetailsDestination.route}"
            ) {
                EventDetailsScreen(
                    navController = navController,
                    navigateToFullScreenMap = {
                        navController.navigate("${BottomNavItem.Menu.route}/${MapDestination.route}")
                    }
                )
            }
            composable(route = "${BottomNavItem.Menu.route}/${MapDestination.route}") {
                FullScreenMapScreen(navController = navController)
            }
        }
    }
}