package com.example.spa_wb_junior_devmeetingapp.ui.oldUI

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.spa_wb_junior_devmeetingapp.ui.DeveloperDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.communities.communitiesScreen.CommunitiesDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.communities.communitiesScreen.CommunityScreen
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.communities.communityDetailScreen.CommunityDetailsDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.communities.communityDetailScreen.CommunityDetailsScreen
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.BottomNavItem
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.events.eventDetailScreen.EventDetailsDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.events.eventDetailScreen.EventDetailsScreen
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.events.eventDetailScreen.FullScreenMapScreen
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.events.eventDetailScreen.MapDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.events.eventsAllScreen.EventsAllDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.events.eventsAllScreen.EventsAllScreen
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.menu.eventsUserScreen.EventsUserDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.menu.eventsUserScreen.EventsUserScreen
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.menu.menuScreen.MenuDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.menu.menuScreen.MenuScreen
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.menu.profileScreen.ProfileDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.menu.profileScreen.ProfileScreen
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.registration.authenticationScreen.AuthenticationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.registration.authenticationScreen.AuthenticationScreen
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.registration.registratinProfileScreen.RegistrationProfileDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.registration.registratinProfileScreen.RegistrationProfileScreen
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.registration.verificationScreen.VerificationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.registration.verificationScreen.VerificationScreen
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.splashScreen.SplashScreen
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.splashScreen.SplashScreenDestination


@Composable
fun OldDesignNavHost() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = SplashScreenDestination.route,
        modifier = Modifier
    ) {
        composable(route = SplashScreenDestination.route) {
            SplashScreen(navigateToStartScreen = {
                navController.navigate("registration_tab") {
                    popUpTo(SplashScreenDestination.route) {
                        inclusive = true
                    }
                }
            })
        }
        registrationNav(navController = navController)
        eventsNav(navController = navController)
        communitiesNav(navController = navController)
        menuNav(navController = navController)
    }
}

internal fun NavGraphBuilder.registrationNav(navController: NavHostController) {
    navigation(
        startDestination = AuthenticationDestination.route,
        route = "registration_tab"
    ) {
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
                onClickNavigateBack = { navController.popBackStack() },
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
}

internal fun NavGraphBuilder.eventsNav(navController: NavHostController) {
    navigation(
        startDestination = EventsAllDestination.route,
        route = BottomNavItem.Events.route
    ) {
        composable(route = EventsAllDestination.route) {
            EventsAllScreen(
                navController = navController,
                navigateToEventDetailItem = {
                    navController.navigate("${BottomNavItem.Events.route}/${EventDetailsDestination.route}/${it}")
                },
                navigateToDeveloperScreen = { navController.navigate(DeveloperDestination.route) }
            )
        }
        composable(
            route = "${BottomNavItem.Events.route}/${EventDetailsDestination.routeWithArgs}",
            arguments = listOf(navArgument(EventDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            EventDetailsScreen(
                navController = navController,
                navigateToFullScreenMap = {
                    navController.navigate("${BottomNavItem.Events.route}/${MapDestination.route}")
                }
            )
        }
        composable(
            route = "${BottomNavItem.Events.route}/${MapDestination.route}"
        )
        {
            FullScreenMapScreen(navController = navController)
        }
    }
}

internal fun NavGraphBuilder.communitiesNav(navController: NavHostController) {
    navigation(
        startDestination = CommunitiesDestination.route,
        route = BottomNavItem.Communities.route
    ) {
        composable(route = CommunitiesDestination.route) {
            CommunityScreen(
                navController = navController,
                navigateToCommunityDetailItem = {
                    navController.navigate("${CommunityDetailsDestination.route}/${it}")
                }
            )
        }
        composable(
            route = CommunityDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(CommunityDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            CommunityDetailsScreen(
                navController = navController,
                navigateToEventDetailItem = {
                    navController.navigate("${BottomNavItem.Communities.route}/${EventDetailsDestination.route}/${it}")
                }
            )
        }
        composable(
            route = "${BottomNavItem.Communities.route}/${EventDetailsDestination.routeWithArgs}",
            arguments = listOf(navArgument(EventDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
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
}

internal fun NavGraphBuilder.menuNav(navController: NavHostController) {
    navigation(
        startDestination = MenuDestination.route,
        route = BottomNavItem.Menu.route
    ) {
        composable(route = MenuDestination.route) {
            MenuScreen(
                navController = navController,
                navigateToProfile = { navController.navigate(ProfileDestination.route) },
                navigateToUserEvents = { navController.navigate(EventsUserDestination.route) }
            )
        }
        composable(route = ProfileDestination.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = EventsUserDestination.route) {
            EventsUserScreen(
                navController = navController,
                navigateToEventDetailItem = {
                    navController.navigate("${BottomNavItem.Menu.route}/${EventDetailsDestination.route}/${it}")
                }
            )
        }
        composable(
            route = "${BottomNavItem.Menu.route}/${EventDetailsDestination.routeWithArgs}",
            arguments = listOf(navArgument(EventDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
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