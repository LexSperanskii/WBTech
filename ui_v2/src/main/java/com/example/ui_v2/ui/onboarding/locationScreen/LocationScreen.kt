package com.example.ui_v2.ui.onboarding.locationScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.R
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import org.koin.androidx.compose.koinViewModel

internal object LocationScreenDestination : NavigationDestination {
    override val route = "location_screen"
}

@Composable
internal fun LocationScreen(
    navigateToMainScreen: () -> Unit,
    viewModel: LocationScreenViewModel = koinViewModel(),
) {
    val locationScreenUiState by viewModel.getLocationScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        LocationScreenBody(
            onButtonClick = navigateToMainScreen,
            modifier = Modifier.padding(innerPadding)
        )
    }

}

@Composable
internal fun LocationScreenBody(
    onButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
    latitude: Double = 59.934997,
    longitude: Double = 30.330624,
) {
    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.map),
            contentDescription = stringResource(id = R.string.map),
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Button(
            onClick = onButtonClick,
            shape = RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Transparent
            ),
            modifier = modifier
                .align(Alignment.BottomCenter)
                .padding(
                    horizontal = 10.dp
                )
                .fillMaxWidth()
                .background(
                    brush = DevMeetingAppTheme.brush.buttonGradientPrimary,
                    shape = RoundedCornerShape(DevMeetingAppTheme.dimensions.cornerShapeMedium)
                )

        ) {
            Text(
                text = "Подтвердить координаты\n${latitude} , ${longitude}\nи перейти дальше",
                color = DevMeetingAppTheme.colors.white,
                textAlign = TextAlign.Center,
                style = DevMeetingAppTheme.typography.subheading1
            )
        }
    }

}