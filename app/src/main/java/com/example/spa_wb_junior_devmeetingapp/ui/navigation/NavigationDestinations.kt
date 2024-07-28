package com.example.spa_wb_junior_devmeetingapp.ui.navigation


internal interface NavigationDestination {
    //Unique name to define the path for a composable
    val route: String
    //String resource id to that contains title to be displayed for the screen.
    val title: Int
}
