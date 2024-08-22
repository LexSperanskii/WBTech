package com.example.spa_wb_junior_devmeetingapp.ui.theme

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
    val metadata3: TextStyle,

    val newHeading1: TextStyle,
    val newHeading2: TextStyle,
    val newSubheading1: TextStyle,
    val newSubheading2: TextStyle,
    val newBodyText1: TextStyle,
    val newBodyText2: TextStyle,
    val newMetadata1: TextStyle,
    val newMetadata2: TextStyle,
    val customH1: TextStyle,
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
        metadata3 = TextStyle.Default,

        newHeading1 = TextStyle.Default,
        newHeading2 = TextStyle.Default,
        newSubheading1 = TextStyle.Default,
        newSubheading2 = TextStyle.Default,
        newBodyText1 = TextStyle.Default,
        newBodyText2 = TextStyle.Default,
        newMetadata1 = TextStyle.Default,
        newMetadata2 = TextStyle.Default,
        customH1 = TextStyle.Default,
    )
}
