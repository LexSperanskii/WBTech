package com.example.spa_wb_junior_devmeetingapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.spa_wb_junior_devmeetingapp.ui.screens.CommunityDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.CommunityDetailsDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.CommunityDetailsScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.CommunityScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.EventDetailsDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.EventDetailsScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.EventsAllDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.EventsAllScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.EventsUserDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.EventsUserScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.FullScreenMapScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.MapDestination
import com.example.spa_wb_junior_devmeetingapp.ui.mockData.MockCommunityItem
import com.example.spa_wb_junior_devmeetingapp.ui.mockData.MockEventItem
import com.example.spa_wb_junior_devmeetingapp.ui.screens.MenuDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.MenuScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.ProfileDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.ProfileScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.SplashScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.SplashScreenDestination
import com.google.gson.Gson
import java.net.URLDecoder
import java.net.URLEncoder

/**
 * Provides Navigation graph for the application.
 */
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
            SplashScreen(navigateToStartScreen = {navController.navigate(EventsAllDestination.route)})
        }
        composable(route = EventsAllDestination.route) {
            EventsAllScreen(
                navController = navController,
                navigateToEventDetailItem = {
                    val eventJson  = Gson().toJson(it)
                    val encodedJson = URLEncoder.encode(eventJson , "UTF-8")
                    navController.navigate("${EventDetailsDestination.route}/${encodedJson}")
                }
            )
        }
        composable(route = CommunityDestination.route) {
            CommunityScreen(
                navController = navController,
                navigateToCommunityDetailItem = {
                    /*
                     * Сериализуем и кодируем в JSON наш объект, который мы хоти передать.
                     * Кодируем, тк JSON не поддерживает некоторые знаки в URL
                     * it - это наш объект MockCommunityItem
                     */
                    val communityJson  = Gson().toJson(it)
                    val encodedJson = URLEncoder.encode(communityJson , "UTF-8")

                    navController.navigate("${CommunityDetailsDestination.route}/${encodedJson}")
                }
            )
        }
        composable(route = MenuDestination.route) {
            MenuScreen(
                navController = navController,
                navigateToProfile = {navController.navigate(ProfileDestination.route)},
                navigateToUserEvents = {navController.navigate(EventsUserDestination.route)}
            )
        }
        composable(
            route = CommunityDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(CommunityDetailsDestination.itemIdArg) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            /*
             * Блок для десериализации и декодирования объекта который хотим получить
             */
            val encodedJson = backStackEntry.arguments?.getString(CommunityDetailsDestination.itemIdArg)
            val communityJson = URLDecoder.decode(encodedJson, "UTF-8")
            val community = Gson().fromJson(communityJson, MockCommunityItem::class.java)

            CommunityDetailsScreen(
                navController = navController,
                community = community,
                navigateToEventDetailItem = {
                    val eventJson  = Gson().toJson(it)
                    val encodedJson = URLEncoder.encode(eventJson , "UTF-8")
                    navController.navigate("${EventDetailsDestination.route}/${encodedJson}")
                }
            )
        }
        composable(route = EventsUserDestination.route) {
            EventsUserScreen(
                navController = navController,
                navigateToEventDetailItem = {
                    val eventJson  = Gson().toJson(it)
                    val encodedJson = URLEncoder.encode(eventJson , "UTF-8")
                    navController.navigate("${EventDetailsDestination.route}/${encodedJson}")
                }
            )
        }
        composable(
            route = EventDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(EventDetailsDestination.itemIdArg) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            val encodedJson = backStackEntry.arguments?.getString(EventDetailsDestination.itemIdArg)
            val communityJson = URLDecoder.decode(encodedJson, "UTF-8")
            val event = Gson().fromJson(communityJson, MockEventItem::class.java)
            EventDetailsScreen(
                navController = navController,
                event = event,
                navigateToFullScreenMap = {
                    navController.navigate(MapDestination.route)
                }
            )
        }
        composable(route = ProfileDestination.route) {
            ProfileScreen(navController = navController)
        }
        composable(route = MapDestination.route) {
            FullScreenMapScreen(navController = navController)
        }
    }
}