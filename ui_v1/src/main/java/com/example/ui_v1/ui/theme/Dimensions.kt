package com.example.ui_v1.ui.theme

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