package com.example.ui_v1.ui.splashScreen

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dotlottie.dlplayer.Mode
import com.example.ui_v1.R
import com.example.ui_v1.navigation.UIv1NavigationDestination
import com.example.ui_v1.ui.theme.DevMeetingAppTheme
import com.lottiefiles.dotlottie.core.compose.runtime.DotLottieController
import com.lottiefiles.dotlottie.core.compose.ui.DotLottieAnimation
import com.lottiefiles.dotlottie.core.util.DotLottieSource
import org.koin.androidx.compose.koinViewModel

internal object SplashScreenDestinationUIv1 : UIv1NavigationDestination {
    override val route = "splash_screen"
    override val title = R.string.splash_screen
}

@Composable
internal fun SplashScreen(
    navigateToStartScreen: () -> Unit,
    viewModel: SplashScreenViewModel = koinViewModel()
) {

    val splashScreenUiState by viewModel.getSplashScreenUiStateFlow().collectAsStateWithLifecycle()

    val dotLottieController = remember { DotLottieController() }


    LaunchedEffect(splashScreenUiState) {
        when (splashScreenUiState.status) {
            SplashScreenStatus.Finished -> {
                if (dotLottieController.isPlaying) {
                    dotLottieController.pause()
                }
                navigateToStartScreen()
            }

            else -> {}
        }
    }
    DotLottieAnimation(
        source = DotLottieSource.Asset("lottie_animation_splash_screen.json"),
        autoplay = true,
        loop = true,
        speed = 1f,
        useFrameInterpolation = false,
        playMode = Mode.FORWARD,
        controller = dotLottieController,
        modifier = Modifier.background(DevMeetingAppTheme.colors.purple)
    )
}

