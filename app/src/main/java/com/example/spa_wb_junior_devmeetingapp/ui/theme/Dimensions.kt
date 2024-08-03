package com.example.spa_wb_junior_devmeetingapp.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp

internal data class DevMeetingsAppDimensions(
    val avatarS: Dp,
    val avatarM: Dp,
    val avatarL: Dp,
)

internal val LocalDimensionsScheme = staticCompositionLocalOf {
    DevMeetingsAppDimensions(
        avatarS = Dp.Unspecified,
        avatarM = Dp.Unspecified,
        avatarL = Dp.Unspecified,
    )
}