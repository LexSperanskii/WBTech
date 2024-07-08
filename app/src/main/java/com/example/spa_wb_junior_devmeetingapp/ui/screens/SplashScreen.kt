package com.example.spa_wb_junior_devmeetingapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Purple

object SplashScreenDestination : NavigationDestination {
    override val route = "splash_screen"
    override val title = R.string.splash_screen
}

@Composable
fun SplashScreen(
    navigateToStartScreen:() -> Unit
) {
    Box(
        modifier = Modifier
            . fillMaxSize()
            . background(Purple)
    ) {
        val composition by rememberLottieComposition(LottieCompositionSpec. RawRes(R.raw.lottie_animation_splash_screen))
        val logoAnimationState =
            animateLottieCompositionAsState(composition = composition)
        LottieAnimation(
            composition = composition,
            progress = { logoAnimationState. progress }
        )
        if (logoAnimationState. isAtEnd && logoAnimationState. isPlaying) {
            navigateToStartScreen()
        }
    }
}