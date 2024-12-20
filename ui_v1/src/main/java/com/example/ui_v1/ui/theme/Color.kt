package com.example.ui_v1.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal data class DevMeetingsAppColorScheme(
    val white: Color,
    val black: Color,
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
    val dividerColor: Color,
)

internal val LocalColorScheme = staticCompositionLocalOf {
    DevMeetingsAppColorScheme(
        white = Color.Unspecified,
        black = Color.Unspecified,
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
        dividerColor = Color.Unspecified,
    )
}
