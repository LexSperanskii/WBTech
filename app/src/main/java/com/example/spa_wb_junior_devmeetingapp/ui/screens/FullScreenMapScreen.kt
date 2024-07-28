package com.example.spa_wb_junior_devmeetingapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar

internal object MapDestination : NavigationDestination {
    override val route = "map"
    override val title = R.string.map
}

@Composable
internal fun FullScreenMapScreen(
    navController: NavHostController,
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { innerPadding ->
        FullScreenMapBody(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        )
    }
}

@Composable
internal fun FullScreenMapBody(
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.map),
            contentDescription = stringResource(id = R.string.map),
            modifier = Modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}