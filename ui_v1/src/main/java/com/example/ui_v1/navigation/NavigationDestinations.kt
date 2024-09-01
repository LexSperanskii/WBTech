package com.example.ui_v1.navigation

internal interface UIv1NavigationDestination {
    //Unique name to define the path for a composable
    val route: String

    //String resource id to that contains title to be displayed for the screen.
    val title: Int
}
