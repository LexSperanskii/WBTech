package com.example.ui_v2.ui.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp

internal data class DevMeetingsAppDimensions(
    val avatarS: Dp,
    val avatarM: Dp,
    val avatarL: Dp,

    val cornerShapeXSmall: Dp,
    val cornerShapeSmall: Dp,
    val cornerShapeMediumSmall: Dp,
    val cornerShapeMedium: Dp,
)

internal val LocalDimensionsScheme = staticCompositionLocalOf {
    DevMeetingsAppDimensions(
        avatarS = Dp.Unspecified,
        avatarM = Dp.Unspecified,
        avatarL = Dp.Unspecified,

        cornerShapeXSmall = Dp.Unspecified,
        cornerShapeSmall = Dp.Unspecified,
        cornerShapeMediumSmall = Dp.Unspecified,
        cornerShapeMedium = Dp.Unspecified,
    )
}