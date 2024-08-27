package com.example.spa_wb_junior_devmeetingapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.ui_v2.navigation.NavHost

@Composable
fun DevMeetingAppScreen(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController)
}