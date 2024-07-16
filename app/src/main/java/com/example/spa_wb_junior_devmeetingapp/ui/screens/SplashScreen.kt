package com.example.spa_wb_junior_devmeetingapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.dotlottie.dlplayer.Mode
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Purple
import com.lottiefiles.dotlottie.core.compose.runtime.DotLottieController
import com.lottiefiles.dotlottie.core.compose.ui.DotLottieAnimation
import com.lottiefiles.dotlottie.core.util.DotLottieSource
import kotlinx.coroutines.delay

object SplashScreenDestination : NavigationDestination {
    override val route = "splash_screen"
    override val title = R.string.splash_screen
}

@Composable
fun SplashScreen(
    navigateToStartScreen: () -> Unit
) {
    val dotLottieController = remember { DotLottieController() }

    LaunchedEffect(dotLottieController) {
        delay(3000)
        dotLottieController.pause() // паузим чтобы не было фризов
        navigateToStartScreen()
    }
    DotLottieAnimation(
        source = DotLottieSource.Asset("lottie_animation_splash_screen.json"),
        autoplay = true,
        loop = true,
        speed = 1f,
        useFrameInterpolation = false,
        playMode = Mode.FORWARD,
        controller = dotLottieController,
        modifier = Modifier.background(Purple)
    )
}

