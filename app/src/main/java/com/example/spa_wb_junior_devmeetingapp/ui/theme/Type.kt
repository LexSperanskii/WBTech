package com.example.spa_wb_junior_devmeetingapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.spa_wb_junior_devmeetingapp.R

/**
 * CustomTypography
 */

val SFProDisplay = FontFamily(
    Font(R.font.sf_pro_display_regular, FontWeight.Normal),
    Font(R.font.sf_pro_display_semibold, FontWeight.SemiBold),
    Font(R.font.sf_pro_display_bold, FontWeight.Bold),
)

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

val Typography.Heading1: TextStyle
    get() = TextStyle(
        fontSize = 32.sp,
    )
val Typography.Heading2: TextStyle
    get() = TextStyle(
        fontSize = 24.sp,
    )
val Typography.Subheading1: TextStyle
    get() = TextStyle(
        fontSize = 18.sp,
    )
val Typography.Subheading2: TextStyle
    get() = TextStyle(
        fontSize = 16.sp,
    )
val Typography.BodyText1: TextStyle
    get() = TextStyle(
        fontSize = 14.sp,
    )
val Typography.BodyText2: TextStyle
    get() = TextStyle(
        fontSize = 14.sp,
    )
val Typography.Metadata1: TextStyle
    get() = TextStyle(
        fontSize = 12.sp,
    )
val Typography.Metadata2: TextStyle
    get() = TextStyle(
        fontSize = 10.sp,
    )
val Typography.Metadata3: TextStyle
    get() = TextStyle(
        fontSize = 10.sp,
    )
