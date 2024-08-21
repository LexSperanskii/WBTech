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

    val Newheading1: TextStyle,
    val Newheading2: TextStyle,
    val Newsubheading1: TextStyle,
    val Newsubheading2: TextStyle,
    val NewbodyText1: TextStyle,
    val NewbodyText2: TextStyle,
    val Newmetadata1: TextStyle,
    val Newmetadata2: TextStyle,
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

        Newheading1 = TextStyle.Default,
        Newheading2 = TextStyle.Default,
        Newsubheading1 = TextStyle.Default,
        Newsubheading2 = TextStyle.Default,
        NewbodyText1 = TextStyle.Default,
        NewbodyText2 = TextStyle.Default,
        Newmetadata1 = TextStyle.Default,
        Newmetadata2 = TextStyle.Default,
    )
}
