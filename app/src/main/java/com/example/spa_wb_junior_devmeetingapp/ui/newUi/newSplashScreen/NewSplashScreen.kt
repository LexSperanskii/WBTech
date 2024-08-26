package com.example.spa_wb_junior_devmeetingapp.ui.newUi.newSplashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.ui_v2.ui.navigation.NewNavigationDestination
import org.koin.androidx.compose.koinViewModel

internal object NewSplashScreenDestination :
    com.example.ui_v2.ui.navigation.NewNavigationDestination {
    override val route = "new_splash_screen"
}

@Composable
internal fun NewSplashScreen(
    navigateToStartScreen: () -> Unit,
    viewModel: NewSplashScreenViewModel = koinViewModel(),
) {
    val splashScreenUiState by viewModel.getNewSplashScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    LaunchedEffect(splashScreenUiState) {
        when (splashScreenUiState.status) {
            NewSplashScreenStatus.Finished -> {
                navigateToStartScreen()
            }

            else -> {}
        }
    }
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.splash_screen_bg),
            contentDescription = "splash",
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(id = R.drawable.splash_screen_bg),
            contentDescription = "splash",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(horizontal = 28.dp)
                .fillMaxWidth()
                .align(Alignment.Center)
        ) {
            Image(
                painter = painterResource(id = R.drawable.splash_screen_fg1),
                contentDescription = "splash",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(126.dp)
                    .padding(bottom = 20.dp)
            )
            Image(
                painter = painterResource(id = R.drawable.splash_screen_fg2),
                contentDescription = "splash",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(320.dp)
            )
        }
    }
}