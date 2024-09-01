package com.example.ui_v1.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
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
    dividerColor = Color(0xFFEDEDED)
)

private val typography = DevMeetingsAppTypography(
    heading1 = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp
    ),
    heading2 = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    subheading1 = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 18.sp
    ),
    subheading2 = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp
    ),
    bodyText1 = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    bodyText2 = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    metadata1 = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    metadata2 = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.Normal,
        fontSize = 10.sp
    ),
    metadata3 = TextStyle(
        fontFamily = SFProDisplay,
        fontWeight = FontWeight.SemiBold,
        fontSize = 10.sp
    )
)
private val dimensions = DevMeetingsAppDimensions(
    avatarS = 50.dp,
    avatarM = 100.dp,
    avatarL = 200.dp
)

@Composable
fun DevMeetingAppTheme(
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalColorScheme provides ColorScheme,
        LocalTypography provides typography,
        LocalDimensionsScheme provides dimensions
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
}