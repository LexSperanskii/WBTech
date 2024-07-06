package com.example.spa_wb_junior_devmeetingapp.ui.navigation

import android.util.Log
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
import com.example.spa_wb_junior_devmeetingapp.ui.screens.EventsAllDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.EventsAllScreen
import com.example.spa_wb_junior_devmeetingapp.ui.screens.MockCommunityItem
import com.example.spa_wb_junior_devmeetingapp.ui.screens.ProfileDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.ProfileScreen
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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
        startDestination = EventsAllDestination.route,
        modifier = Modifier
    ) {
        composable(route = EventsAllDestination.route) {
            EventsAllScreen(navController)
        }
        composable(route = CommunityDestination.route) {
            CommunityScreen(
                navController = navController,
                navigateToCommunityDetailItem = {
                    /**
                     * Сериализуем и кодируем в JSON наш объект, который мы хоти передать.
                     * Кодируем, тк JSON не поддерживает некоторые знаки в URL
                     * it - это наш объект MockCommunityItem
                     */
                    val communityJson  = Gson().toJson(it)
                    val encodedJson = URLEncoder.encode(communityJson , "UTF-8")
                    /**
                     * Конец блока сериализации
                     */
                    navController.navigate("${CommunityDetailsDestination.route}/${encodedJson}")
                }
            )
        }
        composable(
            route = CommunityDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(CommunityDetailsDestination.itemIdArg) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            /**
             * Блок для десериализации и декодирования объекта который хотим получить
             */
            val encodedJson = backStackEntry.arguments?.getString(CommunityDetailsDestination.itemIdArg)
            val communityJson = URLDecoder.decode(encodedJson, "UTF-8")
            val community = Gson().fromJson(communityJson, MockCommunityItem::class.java)
            /**
             * Конец блока десериализации
             */
            CommunityDetailsScreen(navController, community)
        }
        composable(route = ProfileDestination.route) {
            ProfileScreen(navController)
        }
    }
}