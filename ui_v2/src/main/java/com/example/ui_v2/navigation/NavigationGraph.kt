package com.example.ui_v2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.navArgument
import com.example.ui_v2.ui.DeveloperDestination
import com.example.ui_v2.ui.DeveloperScreen
import com.example.ui_v2.ui.screens.SplashScreen.SplashScreen
import com.example.ui_v2.ui.screens.SplashScreen.SplashScreenDestination
import com.example.ui_v2.ui.screens.appointmentScreen.appointmentSplash.AppointmentSplashScreen
import com.example.ui_v2.ui.screens.appointmentScreen.appointmentSplash.AppointmentSplashScreenDestination
import com.example.ui_v2.ui.screens.appointmentScreen.nameSurname.AppointmentDestination
import com.example.ui_v2.ui.screens.appointmentScreen.nameSurname.AppointmentNameSurnameScreen
import com.example.ui_v2.ui.screens.appointmentScreen.nameSurname.AppointmentNameSurnameScreenDestination
import com.example.ui_v2.ui.screens.appointmentScreen.phoneNumber.AppointmentPhoneNumberScreen
import com.example.ui_v2.ui.screens.appointmentScreen.phoneNumber.AppointmentPhoneNumberScreenDestination
import com.example.ui_v2.ui.screens.appointmentScreen.verificationCode.AppointmentVerificationScreen
import com.example.ui_v2.ui.screens.appointmentScreen.verificationCode.AppointmentVerificationScreenDestination
import com.example.ui_v2.ui.screens.communityScreen.CommunityScreen
import com.example.ui_v2.ui.screens.communityScreen.CommunityScreenDestination
import com.example.ui_v2.ui.screens.eventScreen.EventScreen
import com.example.ui_v2.ui.screens.eventScreen.EventScreenDestination
import com.example.ui_v2.ui.screens.mainScreen.MainScreen
import com.example.ui_v2.ui.screens.mainScreen.MainScreenDestination
import com.example.ui_v2.ui.screens.onboarding.interestsScreen.InterestsScreen
import com.example.ui_v2.ui.screens.onboarding.interestsScreen.InterestsScreenDestination
import com.example.ui_v2.ui.screens.onboarding.locationScreen.LocationScreen
import com.example.ui_v2.ui.screens.onboarding.locationScreen.LocationScreenDestination
import com.example.ui_v2.ui.screens.peopleScreen.PeopleScreen
import com.example.ui_v2.ui.screens.peopleScreen.PeopleScreenDestination


@Composable
fun NavHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "${AppointmentDestination.route}/${"0"}",
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
                        popUpTo(InterestsScreenDestination.route)
                    }
                }
            )
        }
        composable(route = MainScreenDestination.route) {
            MainScreen(
                navigateToUserScreen = {},
                navigateToCommunityScreen = {
                    navController.navigate("${CommunityScreenDestination.route}/${it}")
                },
                navigateToEventScreen = {
                    navController.navigate("${EventScreenDestination.route}/${it}")
                },
                navigateToBannerScreen = {},
                navigateToProfileScreen = {},
            )
        }
        composable(
            route = EventScreenDestination.routeWithArgs,
            arguments = listOf(navArgument(EventScreenDestination.itemIdArg) {
                type = NavType.StringType
            })
        ) {
            EventScreen(
                navigateToEventScreen = {
                    navController.navigate("${EventScreenDestination.route}/${it}")
                },
                navigateToPeopleScreen = {
                    navController.navigate("${PeopleScreenDestination.route}/${it}")
                },
                navigateToCommunityScreen = {
                    navController.navigate("${CommunityScreenDestination.route}/${it}")
                },
                navigateBack = { navController.popBackStack() },
                onShareClick = {},
                onPitcherClick = {},
                navigateToAppointmentScreen = {
                    navController.navigate("${AppointmentDestination.route}/${it}")
                }
            )
        }
        composable(
            route = PeopleScreenDestination.routeWithArgs,
            arguments = listOf(navArgument(PeopleScreenDestination.itemIdArg) {
                type = NavType.StringType
            })
        ) {
            PeopleScreen(
                onArrowBackClick = { navController.popBackStack() },
                navigateToPersonScreen = { /*TODO*/ }
            )
        }
        composable(
            route = CommunityScreenDestination.routeWithArgs,
            arguments = listOf(navArgument(CommunityScreenDestination.itemIdArg) {
                type = NavType.StringType
            })
        ) {
            CommunityScreen(
                navigateToPeopleScreen = {
                    navController.navigate("${PeopleScreenDestination.route}/${it}")
                },
                navigateToEventScreen = {
                    navController.navigate("${EventScreenDestination.route}/${it}")
                },
                navigateBack = { navController.popBackStack() },
                onShareClick = {}
            )
        }
        navigation(
            route = AppointmentDestination.routeWithArgs,
            startDestination = AppointmentNameSurnameScreenDestination.route,
            arguments = listOf(navArgument(CommunityScreenDestination.itemIdArg) {
                type = NavType.StringType
            })
        ) {
            composable(
                route = AppointmentNameSurnameScreenDestination.route
            ) {
                AppointmentNameSurnameScreen(
                    navigateToAppointmentPhoneNumberScreen = {
                        navController.navigate(AppointmentPhoneNumberScreenDestination.route)
                    }
                )
            }
            composable(
                route = AppointmentPhoneNumberScreenDestination.route
            ) {
                AppointmentPhoneNumberScreen(
                    navigateToAppointmentVerificationScreen = {
                        navController.navigate(AppointmentVerificationScreenDestination.route)
                    }
                )
            }
            composable(
                route = AppointmentVerificationScreenDestination.route
            ) {
                AppointmentVerificationScreen(
                    navigateToAppointmentSplashScreen = {
                        navController.navigate(AppointmentSplashScreenDestination.route)
                    }
                )
            }
            composable(
                route = AppointmentSplashScreenDestination.route
            ) {
                AppointmentSplashScreen(
                    navigateToMyEvents = {},
                    navigateToFindOtherEvents = {}
                )
            }
        }
    }
}