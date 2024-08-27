package com.example.ui_v2.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush

internal data class DevMeetingsAppBrushScheme(
    val buttonGradientPrimary: Brush,
    val buttonGradientSecondary: Brush,
    val textFieldGradientNormal: Brush,
    val textFieldGradientError: Brush,
    val buttonCommunityCardGradient: Brush,
)

internal val LocalBrushScheme = staticCompositionLocalOf {
    DevMeetingsAppBrushScheme(
        buttonGradientPrimary = Brush.horizontalGradient(),
        buttonGradientSecondary = Brush.horizontalGradient(),
        textFieldGradientNormal = Brush.horizontalGradient(),
        textFieldGradientError = Brush.horizontalGradient(),
        buttonCommunityCardGradient = Brush.horizontalGradient(),
    )
}