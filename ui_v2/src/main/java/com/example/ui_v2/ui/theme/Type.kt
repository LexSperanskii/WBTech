package com.example.ui_v2.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle

internal data class DevMeetingsAppTypography(
    val heading1: TextStyle,
    val heading2: TextStyle,
    val subheading1: TextStyle,
    val subheading2: TextStyle,
    val bodyText1: TextStyle,
    val bodyText2: TextStyle,
    val metadata1: TextStyle,
    val metadata2: TextStyle,
    val customH1: TextStyle,
    val customH2: TextStyle,
    val customH3: TextStyle,
    val customH4: TextStyle,
)

internal val LocalTypography = staticCompositionLocalOf {
    DevMeetingsAppTypography(
        heading1 = TextStyle.Default,
        heading2 = TextStyle.Default,
        subheading1 = TextStyle.Default,
        subheading2 = TextStyle.Default,
        bodyText1 = TextStyle.Default,
        bodyText2 = TextStyle.Default,
        metadata1 = TextStyle.Default,
        metadata2 = TextStyle.Default,
        customH1 = TextStyle.Default,
        customH2 = TextStyle.Default,
        customH3 = TextStyle.Default,
        customH4 = TextStyle.Default,
    )
}
