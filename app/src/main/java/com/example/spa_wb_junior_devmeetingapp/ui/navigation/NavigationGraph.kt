package com.example.spa_wb_junior_devmeetingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.spa_wb_junior_devmeetingapp.ui.screens.communities.communitiesScreen.CommunitiesDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.communities.communityDetailScreen.CommunityDetailsDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.communities.communityDetailScreen.CommunityDetailsScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.communities.communitiesScreen.CommunityScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.events.eventDetailScreen.EventDetailsDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.events.eventDetailScreen.EventDetailsScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.events.eventsAllScreen.EventsAllDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.events.eventsAllScreen.EventsAllScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.eventsUserScreen.EventsUserDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.eventsUserScreen.EventsUserScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.FullScreenMapScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.MapDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.authenticationScreen.AuthenticationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.authenticationScreen.AuthenticationScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.DeveloperDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.DeveloperScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.menuScreen.MenuDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.menuScreen.MenuScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.profileScreen.ProfileDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.profileScreen.ProfileScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.registratinProfileScreen.RegistrationProfileDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.registratinProfileScreen.RegistrationProfileScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.splashScreen.SplashScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.splashScreen.SplashScreenDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.verificationScreen.VerificationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.verificationScreen.VerificationScreen
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