package com.example.ui_v2.navigation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
import com.example.ui_v2.ui.screens.onboarding.interestsScreen.OnboardingDestination
import com.example.ui_v2.ui.screens.onboarding.locationScreen.LocationScreen
import com.example.ui_v2.ui.screens.onboarding.locationScreen.LocationScreenDestination
import com.example.ui_v2.ui.screens.participantsScreen.ParticipantsScreen
import com.example.ui_v2.ui.screens.participantsScreen.ParticipantsScreenDestination
import com.example.ui_v2.ui.screens.userScreen.deleteProfile.DeleteProfileScreen
import com.example.ui_v2.ui.screens.userScreen.deleteProfile.DeleteProfileScreenDestination
import com.example.ui_v2.ui.screens.userScreen.profileEdit.ProfileEditScreen
import com.example.ui_v2.ui.screens.userScreen.profileEdit.ProfileEditScreenDestination
import com.example.ui_v2.ui.screens.userScreen.profileEditPhoto.ProfileEditPhotoScreen
import com.example.ui_v2.ui.screens.userScreen.profileEditPhoto.ProfileEditPhotoScreenDestination
import com.example.ui_v2.ui.screens.userScreen.profileInterests.ProfileInterestsScreen
import com.example.ui_v2.ui.screens.userScreen.profileInterests.ProfileInterestsScreenDestination
import com.example.ui_v2.ui.screens.userScreen.userInside.UserInsideScreen
import com.example.ui_v2.ui.screens.userScreen.userInside.UserInsideScreenDestination
import com.example.ui_v2.ui.screens.userScreen.userInside.UserProfileDestination
import com.example.ui_v2.ui.screens.userScreen.userOutside.UserOutsideScreen
import com.example.ui_v2.ui.screens.userScreen.userOutside.UserOutsideScreenDestination


@Composable
fun NavHost(
    navController: NavHostController,
) {
    val activity = (LocalContext.current as? Activity)
    NavHost(
        navController = navController,
        startDestination = SplashScreenDestination.route,
        modifier = Modifier
    ) {
        composable(route = DeveloperDestination.route) {
            DeveloperScreen()
        }
        composable(route = SplashScreenDestination.route) {
            SplashScreen(navigateToStartScreen = {
                navController.navigate(OnboardingDestination.route) {
                    popUpTo(SplashScreenDestination.route) {
                        inclusive = true
                    }
                }
            })
        }
        navigation(
            route = OnboardingDestination.route,
            startDestination = InterestsScreenDestination.route
        ) {
            composable(route = InterestsScreenDestination.route) {
                InterestsScreen(
                    navigateToLocationScreen = {
                        navController.navigate(LocationScreenDestination.route)
                    },
                    onTellLaterClick = {
                        navController.navigate(LocationScreenDestination.route)
                    }
                )
            }
            composable(route = LocationScreenDestination.route) {
                LocationScreen(
                    navigateToMainScreen = {
                        navController.navigate(MainScreenDestination.route) {
                            popUpTo(OnboardingDestination.route) {
                                inclusive = true
                            }
                        }
                    }
                )
            }
        }
        composable(route = MainScreenDestination.route) {
            MainScreen(
                navigateToUserScreen = {
                    navController.navigate("${UserOutsideScreenDestination.route}/${it}")
                },
                navigateToCommunityScreen = {
                    navController.navigate("${CommunityScreenDestination.route}/${it}")
                },
                navigateToEventScreen = {
                    navController.navigate("${EventScreenDestination.route}/${it}")
                },
                navigateToBannerScreen = {},
                navigateToProfileScreen = {
                    navController.navigate(UserProfileDestination.route)
                }
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
                    navController.navigate("${ParticipantsScreenDestination.route}/${it}")
                },
                navigateToCommunityScreen = {
                    navController.navigate("${CommunityScreenDestination.route}/${it}")
                },
                navigateBack = { navController.popBackStack() },
                onShareClick = {},
                onPitcherClick = {
                    navController.navigate("${UserOutsideScreenDestination.route}/${it}")
                },
                navigateToAppointmentScreen = {
                    navController.navigate("${AppointmentDestination.route}/${it}")
                }
            )
        }
        composable(
            route = ParticipantsScreenDestination.routeWithArgs,
            arguments = listOf(navArgument(ParticipantsScreenDestination.itemIdArg) {
                type = NavType.StringType
            })
        ) {
            ParticipantsScreen(
                onArrowBackClick = { navController.popBackStack() },
                navigateToPersonScreen = {
                    navController.navigate("${UserOutsideScreenDestination.route}/${it}")
                }
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
                    navController.navigate("${ParticipantsScreenDestination.route}/${it}")
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
            arguments = listOf(navArgument(AppointmentDestination.itemIdArg) {
                type = NavType.StringType
            })
        ) {
            composable(route = AppointmentNameSurnameScreenDestination.route) {
                AppointmentNameSurnameScreen(
                    navigateToAppointmentPhoneNumberScreen = {
                        navController.navigate("${AppointmentPhoneNumberScreenDestination.route}/${it}")
                    },
                    onCrossClick = {
                        navController.popBackStack(
                            AppointmentDestination.routeWithArgs,
                            inclusive = true
                        )
                    }
                )
            }
            composable(
                route = AppointmentPhoneNumberScreenDestination.routeWithArgs,
                arguments = listOf(navArgument(AppointmentPhoneNumberScreenDestination.itemIdArg) {
                    type = NavType.StringType
                })
            ) {
                AppointmentPhoneNumberScreen(
                    navigateToAppointmentVerificationScreen = {
                        navController.navigate("${AppointmentVerificationScreenDestination.route}/${it}")
                    },
                    onCrossClick = {
                        navController.popBackStack(
                            AppointmentDestination.routeWithArgs,
                            inclusive = true
                        )
                    }
                )
            }
            composable(
                route = AppointmentVerificationScreenDestination.routeWithArgs,
                arguments = listOf(navArgument(AppointmentVerificationScreenDestination.itemIdArg) {
                    type = NavType.StringType
                })
            ) {
                AppointmentVerificationScreen(
                    navigateToAppointmentSplashScreen = {
                        navController.navigate("${AppointmentSplashScreenDestination.route}/${it}")
                    },
                    onCrossClick = {
                        navController.popBackStack(
                            AppointmentDestination.routeWithArgs,
                            inclusive = true
                        )
                    }
                )
            }
            composable(
                route = AppointmentSplashScreenDestination.routeWithArgs,
                arguments = listOf(navArgument(AppointmentVerificationScreenDestination.itemIdArg) {
                    type = NavType.StringType
                })
            ) {
                AppointmentSplashScreen(
                    navigateToMyEvents = {
                        navController.navigate(UserProfileDestination.route) {
                            popUpTo(AppointmentDestination.routeWithArgs) {
                                inclusive = true
                            }
                        }
                    },
                    navigateToFindOtherEvents = {
                        navController.navigate(MainScreenDestination.route) {
                            popUpTo(AppointmentDestination.routeWithArgs) {
                                inclusive = true
                            }
                        }
                    }
                )
                BackHandler {
                    navController.popBackStack(
                        AppointmentDestination.routeWithArgs,
                        inclusive = true
                    )
                }
            }
        }
        composable(
            route = UserOutsideScreenDestination.routeWithArgs,
            arguments = listOf(navArgument(UserOutsideScreenDestination.itemIdArg) {
                type = NavType.StringType
            })
        ) {
            UserOutsideScreen(
                navigateBack = { navController.popBackStack() },
                onShareClick = {},
                onNetworkIconClick = {},
                navigateToEvent = {
                    navController.navigate("${EventScreenDestination.route}/${it}")
                },
                navigateToCommunity = {
                    navController.navigate("${CommunityScreenDestination.route}/${it}")
                }
            )
        }
        navigation(
            route = UserProfileDestination.route,
            startDestination = UserInsideScreenDestination.route
        ) {
            composable(
                route = UserInsideScreenDestination.route
            ) {
                UserInsideScreen(
                    navigateBack = {
                        navController.navigate(MainScreenDestination.route) {
                            popUpTo(MainScreenDestination.route) {
                                inclusive = true
                            }
                        }
                    },
                    onEditClick = { isClientRegistered ->
                        navController.navigate(ProfileEditScreenDestination.route) {
                            when (isClientRegistered) {
                                true -> {}
                                false -> {
                                    popUpTo(UserProfileDestination.route) {
                                        inclusive = true
                                    }
                                }
                            }

                        }
                    },
                    onNetworkIconClick = {},
                    navigateToEvent = {
                        navController.navigate("${EventScreenDestination.route}/${it}")
                    },
                    navigateToCommunity = {
                        navController.navigate("${CommunityScreenDestination.route}/${it}")
                    },
                    navigateOnExit = {
                        activity?.finish()
                    }
                )
                BackHandler {
                    navController.navigate(MainScreenDestination.route) {
                        popUpTo(MainScreenDestination.route) {
                            inclusive = true
                        }
                    }
                }
            }
            composable(
                route = ProfileEditScreenDestination.route
            ) {
                ProfileEditScreen(
                    navigateBack = { navController.popBackStack() },
                    onChangePhotoClick = {
                        navController.navigate(ProfileEditPhotoScreenDestination.route)
                    },
                    navigateToUserInsideScreen = {
                        navController.navigate(UserProfileDestination.route) {
                            popUpTo(UserProfileDestination.route)
                        }
                    },
                    navigateToDeleteProfile = {
                        navController.navigate(DeleteProfileScreenDestination.route)
                    },
                    navigateToInterestsScreen = {
                        navController.navigate(ProfileInterestsScreenDestination.route)
                    }
                )
            }
            composable(
                route = ProfileInterestsScreenDestination.route
            ) {
                ProfileInterestsScreen(
                    navigateBack = { navController.popBackStack() }
                )
            }
            composable(
                route = ProfileEditPhotoScreenDestination.route
            ) {
                ProfileEditPhotoScreen(
                    navigateBack = { navController.popBackStack() }
                )
            }
            composable(
                route = DeleteProfileScreenDestination.route
            ) {
                DeleteProfileScreen(
                    navigateBack = {
                        navController.navigate(UserProfileDestination.route) {
                            popUpTo(UserProfileDestination.route)
                        }
                    },
                    navigateOnDeleteClick = {
                        navController.navigate(OnboardingDestination.route) {
                            popUpTo(0)
                        }
                    },
                    navigateOnNoNeedClick = {
                        navController.navigate(UserProfileDestination.route) {
                            popUpTo(UserProfileDestination.route)
                        }
                    }
                )
                BackHandler {
                    navController.navigate(UserProfileDestination.route) {
                        popUpTo(UserProfileDestination.route)
                    }
                }
            }
        }
    }
}