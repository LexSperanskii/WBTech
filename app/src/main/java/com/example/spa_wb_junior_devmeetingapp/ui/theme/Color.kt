package com.example.spa_wb_junior_devmeetingapp.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class DevMeetingsAppColorScheme(
    val purple: Color,
    val darkPurple: Color,
    val lightGray: Color,
    val lightPurple: Color,
    val extraLightGray: Color,
    val gray: Color,
    val lightDarkGray: Color,
    val grayForCommunityCard: Color,
    val purpleForGroupedPeople: Color,
    val grayForTabs: Color,
    val extraDarkPurpleForBottomBar: Color,
    val deepBlueForBottomBar: Color,
    val dividerColor: Color
)

val LocalColorScheme = staticCompositionLocalOf{
    DevMeetingsAppColorScheme(
        purple = Color.Unspecified,
        darkPurple = Color.Unspecified,
        lightGray = Color.Unspecified,
        lightPurple = Color.Unspecified,
        extraLightGray = Color.Unspecified,
        gray = Color.Unspecified,
        lightDarkGray = Color.Unspecified,
        grayForCommunityCard = Color.Unspecified,
        purpleForGroupedPeople = Color.Unspecified,
        grayForTabs = Color.Unspecified,
        extraDarkPurpleForBottomBar = Color.Unspecified,
        deepBlueForBottomBar = Color.Unspecified,
        dividerColor = Color.Unspecified
    )
}
