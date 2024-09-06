package com.example.ui_v2.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private val ColorScheme = DevMeetingsAppColorScheme(
    white = Color(0xFFFFFFFF),
    black = Color(0xFF000000),
    purple = Color(0xFF9A41FE),
    darkPurple = Color(0xFF660EC8),
    lightGray = Color(0xFFEDEDED),
    lightPurple = Color(0xFFF5ECFF),
    extraLightGray = Color(0xFFF7F7FC),
    gray = Color(0xFFADB5BD),
    lightDarkGray = Color(0xFFA4A4A4),
    grayForCommunityCard = Color(0xFFADB5BD),
    purpleForGroupedPeople = Color(0xFFD2D5F9),
    grayForTabs = Color(0xFF666666),
    extraDarkPurpleForBottomBar = Color(0xFF29183B),
    deepBlueForBottomBar = Color(0xFF2E3A59),
    dividerColor = Color(0xFFEDEDED),

    disabledButtonGray = Color(0xFFF6F6FA),
    disabledButtonTextGray = Color(0xFF9797AF),
    buttonTextPurple = Color(0xFF9A10F0),
    toggleColor = Color(0xFFEFEFEF),
    eventCardText = Color(0xFF76778E),
    incorrectPin = Color(0xFF5C93)
)

private val BrushScheme = DevMeetingsAppBrushScheme(
    buttonGradientPrimary = Brush.linearGradient(
        listOf(
            Color(0xFFED3CCA), Color(0xFFDF34D2), Color(0xFFD02BD9), Color(0xFFBF22E1),
            Color(0xFFAE1AE8), Color(0xFF9A10F0), Color(0xFF8306F7), Color(0xFF6600FF)
        )
    ),
    buttonGradientSecondary = Brush.linearGradient(
        listOf(
            Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC), Color(0xFFFBF0FD),
            Color(0xFFF9EFFD), Color(0xFFF8EEFE), Color(0xFFF6EEFE), Color(0xFFF4EDFF)
        )
    ),
    textFieldGradientNormal = Brush.horizontalGradient(
        listOf(
            Color(0xFFFFFFFF), Color(0xFFF6F6FA)
        )
    ),
    textFieldGradientError = Brush.horizontalGradient(
        listOf(
            Color(0xFFFFEEF4), Color(0xFFFFFFFF), Color(0x1AF0114C)
        )
    ),
    buttonCommunityCardGradient = Brush.horizontalGradient(
        listOf(
            Color(0xFFFEF1FB), Color(0xFFFDF1FC), Color(0xFFFCF0FC), Color(0xFFFBF0FD),
            Color(0xFFF9EFFD), Color(0xFFF8EEFE), Color(0xFFF6EEFE), Color(0xFFF4EDFF)
        )
    )
)

private val typography = DevMeetingsAppTypography(
    heading1 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        lineHeight = 34.sp,
        fontSize = 34.sp
    ),
    heading2 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        lineHeight = 26.sp,
        fontSize = 22.sp
    ),
    subheading1 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Normal,
        lineHeight = 22.sp,
        fontSize = 20.sp
    ),
    subheading2 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 22.sp,
        fontSize = 18.sp
    ),
    bodyText1 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        lineHeight = 22.sp,
        fontSize = 18.sp
    ),
    bodyText2 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp,
        fontSize = 16.sp
    ),
    metadata1 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        lineHeight = 16.sp,
        fontSize = 14.sp
    ),
    metadata2 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 16.sp,
        fontSize = 14.sp
    ),
    customH1 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 44.sp,
        fontSize = 50.sp
    ),
    customH2 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 26.sp,
        fontSize = 24.sp
    ),
    customH3 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.SemiBold,
        lineHeight = 49.sp,
        fontSize = 44.sp
    ),
    customH4 = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        lineHeight = 20.sp,
        fontSize = 24.sp
    ),
)
private val dimensions = DevMeetingsAppDimensions(
    avatarS = 50.dp,
    avatarM = 100.dp,
    avatarL = 200.dp,

    cornerShapeXSmall = 4.dp,
    cornerShapeSmall = 8.dp,
    cornerShapeMediumSmall = 12.dp,
    cornerShapeMedium = 16.dp,

    paddingMedium = 16.dp,
)

@Composable
fun DevMeetingAppTheme(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalColorScheme provides ColorScheme,
        LocalTypography provides typography,
        LocalDimensionsScheme provides dimensions,
        LocalBrushScheme provides BrushScheme
    ) {
        MaterialTheme(
            colorScheme = lightColorScheme(
                background = Color.White,
                surface = Color.White
            ),
            content = content
        )
    }
}

internal object DevMeetingAppTheme {
    val colors: DevMeetingsAppColorScheme
        @Composable get() = LocalColorScheme.current
    val typography: DevMeetingsAppTypography
        @Composable get() = LocalTypography.current
    val dimensions: DevMeetingsAppDimensions
        @Composable get() = LocalDimensionsScheme.current
    val brush: DevMeetingsAppBrushScheme
        @Composable get() = LocalBrushScheme.current
}