package com.example.spa_wb_junior_devmeetingapp.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavHost

@Composable
fun DevMeetingAppScreen(
    navController: NavHostController = rememberNavController()
) {
    NavHost(navController = navController)
}