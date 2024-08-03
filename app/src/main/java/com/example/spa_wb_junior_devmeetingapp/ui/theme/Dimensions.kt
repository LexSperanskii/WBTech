package com.example.spa_wb_junior_devmeetingapp.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp

internal data class DevMeetingsAppDimensions(
    val small: Dp,
    val medium: Dp,
    val large: Dp,
    val avatarS: Dp,
    val avatarM: Dp,
    val avatarL: Dp,
)

internal val LocalDimensionsScheme = staticCompositionLocalOf {
    DevMeetingsAppDimensions(
        small = Dp.Unspecified,
        medium = Dp.Unspecified,
        large = Dp.Unspecified,
        avatarS = Dp.Unspecified,
        avatarM = Dp.Unspecified,
        avatarL = Dp.Unspecified,
    )
}