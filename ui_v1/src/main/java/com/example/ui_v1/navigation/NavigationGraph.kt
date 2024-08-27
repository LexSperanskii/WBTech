package com.example.ui_v1.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.example.ui_v1.ui.DeveloperDestinationUIv1
import com.example.ui_v1.ui.DeveloperScreen
import com.example.ui_v1.ui.communities.communitiesScreen.CommunitiesDestinationUIv1
import com.example.ui_v1.ui.communities.communitiesScreen.CommunityScreen
import com.example.ui_v1.ui.communities.communityDetailScreen.CommunityDetailsDestinationUIv1
import com.example.ui_v1.ui.communities.communityDetailScreen.CommunityDetailsScreen
import com.example.ui_v1.ui.elements.BottomNavItem
import com.example.ui_v1.ui.events.eventDetailScreen.EventDetailsDestinationUIv1
import com.example.ui_v1.ui.events.eventDetailScreen.EventDetailsScreen
import com.example.ui_v1.ui.events.eventDetailScreen.FullScreenMapScreen
import com.example.ui_v1.ui.events.eventDetailScreen.MapDestinationUIv1
import com.example.ui_v1.ui.events.eventsAllScreen.EventsAllDestinationUIv1
import com.example.ui_v1.ui.events.eventsAllScreen.EventsAllScreen
import com.example.ui_v1.ui.menu.eventsUserScreen.EventsUserDestinationUIv1
import com.example.ui_v1.ui.menu.eventsUserScreen.EventsUserScreen
import com.example.ui_v1.ui.menu.menuScreen.MenuDestinationUIv1
import com.example.ui_v1.ui.menu.menuScreen.MenuScreen
import com.example.ui_v1.ui.menu.profileScreen.ProfileDestinationUIv1
import com.example.ui_v1.ui.menu.profileScreen.ProfileScreen
import com.example.ui_v1.ui.registration.authenticationScreen.AuthenticationDestinationUIv1
import com.example.ui_v1.ui.registration.authenticationScreen.AuthenticationScreen
import com.example.ui_v1.ui.registration.registratinProfileScreen.RegistrationProfileDestinationUIv1
import com.example.ui_v1.ui.registration.registratinProfileScreen.RegistrationProfileScreen
import com.example.ui_v1.ui.registration.verificationScreen.VerificationDestinationUIv1
import com.example.ui_v1.ui.registration.verificationScreen.VerificationScreen
import com.example.ui_v1.ui.splashScreen.SplashScreen
import com.example.ui_v1.ui.splashScreen.SplashScreenDestinationUIv1


@Composable
fun NavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = SplashScreenDestinationUIv1.route,
        modifier = Modifier
    ) {
        composable(route = DeveloperDestinationUIv1.route) {
            DeveloperScreen()
        }
        composable(route = SplashScreenDestinationUIv1.route) {
            SplashScreen(navigateToStartScreen = {
                navController.navigate("registration_tab") {
                    popUpTo(SplashScreenDestinationUIv1.route) {
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
        startDestination = AuthenticationDestinationUIv1.route,
        route = "registration_tab"
    ) {
        composable(route = AuthenticationDestinationUIv1.route) {
            AuthenticationScreen(
                navigateToVerificationScreen = {
                    navController.navigate(VerificationDestinationUIv1.route)
                },
                onClickNavigateBack = { navController.popBackStack() }
            )
        }
        composable(route = VerificationDestinationUIv1.route) {
            VerificationScreen(
                onClickNavigateBack = { navController.popBackStack() },
                navigateToRegistrationProfile = {
                    navController.navigate(RegistrationProfileDestinationUIv1.route)
                }
            )
        }
        composable(route = RegistrationProfileDestinationUIv1.route) {
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
        startDestination = EventsAllDestinationUIv1.route,
        route = BottomNavItem.Events.route
    ) {
        composable(route = EventsAllDestinationUIv1.route) {
            EventsAllScreen(
                navController = navController,
                navigateToEventDetailItem = {
                    navController.navigate("${BottomNavItem.Events.route}/${EventDetailsDestinationUIv1.route}/${it}")
                },
                navigateToDeveloperScreen = { }//navController.navigate(DeveloperDestination.route) }
            )
        }
        composable(
            route = "${BottomNavItem.Events.route}/${EventDetailsDestinationUIv1.routeWithArgs}",
            arguments = listOf(navArgument(EventDetailsDestinationUIv1.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            EventDetailsScreen(
                navController = navController,
                navigateToFullScreenMap = {
                    navController.navigate("${BottomNavItem.Events.route}/${MapDestinationUIv1.route}")
                }
            )
        }
        composable(
            route = "${BottomNavItem.Events.route}/${MapDestinationUIv1.route}"
        )
        {
            FullScreenMapScreen(navController = navController)
        }
    }
}

internal fun NavGraphBuilder.communitiesNav(navController: NavHostController) {
    navigation(
        startDestination = CommunitiesDestinationUIv1.route,
        route = BottomNavItem.Communities.route
    ) {
        composable(route = CommunitiesDestinationUIv1.route) {
            CommunityScreen(
                navController = navController,
                navigateToCommunityDetailItem = {
                    navController.navigate("${CommunityDetailsDestinationUIv1.route}/${it}")
                }
            )
        }
        composable(
            route = CommunityDetailsDestinationUIv1.routeWithArgs,
            arguments = listOf(navArgument(CommunityDetailsDestinationUIv1.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            CommunityDetailsScreen(
                navController = navController,
                navigateToEventDetailItem = {
                    navController.navigate("${BottomNavItem.Communities.route}/${EventDetailsDestinationUIv1.route}/${it}")
                }
            )
        }
        composable(
            route = "${BottomNavItem.Communities.route}/${EventDetailsDestinationUIv1.routeWithArgs}",
            arguments = listOf(navArgument(EventDetailsDestinationUIv1.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            EventDetailsScreen(
                navController = navController,
                navigateToFullScreenMap = {
                    navController.navigate("${BottomNavItem.Communities.route}/${MapDestinationUIv1.route}")
                }
            )
        }
        composable(route = "${BottomNavItem.Communities.route}/${MapDestinationUIv1.route}") {
            FullScreenMapScreen(navController = navController)
        }
    }
}

internal fun NavGraphBuilder.menuNav(navController: NavHostController) {
    navigation(
        startDestination = MenuDestinationUIv1.route,
        route = BottomNavItem.Menu.route
    ) {
        composable(route = MenuDestinationUIv1.route) {
            MenuScreen(
                navController = navController,
                navigateToProfile = { navController.navigate(ProfileDestinationUIv1.route) },
                navigateToUserEvents = { navController.navigate(EventsUserDestinationUIv1.route) }
            )
        }
        composable(route = ProfileDestinationUIv1.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = EventsUserDestinationUIv1.route) {
            EventsUserScreen(
                navController = navController,
                navigateToEventDetailItem = {
                    navController.navigate("${BottomNavItem.Menu.route}/${EventDetailsDestinationUIv1.route}/${it}")
                }
            )
        }
        composable(
            route = "${BottomNavItem.Menu.route}/${EventDetailsDestinationUIv1.routeWithArgs}",
            arguments = listOf(navArgument(EventDetailsDestinationUIv1.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            EventDetailsScreen(
                navController = navController,
                navigateToFullScreenMap = {
                    navController.navigate("${BottomNavItem.Menu.route}/${MapDestinationUIv1.route}")
                }
            )
        }
        composable(route = "${BottomNavItem.Menu.route}/${MapDestinationUIv1.route}") {
            FullScreenMapScreen(navController = navController)
        }
    }
}