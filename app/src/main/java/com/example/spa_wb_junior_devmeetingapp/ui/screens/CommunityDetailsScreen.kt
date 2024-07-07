package com.example.spa_wb_junior_devmeetingapp.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.LightDarkGray
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Metadata1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay

object CommunityDetailsDestination : NavigationDestination {
    override val route = "community_details"
    override val title = R.string.community_details
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@Composable
fun CommunityDetailsScreen(
    navController: NavHostController,
    community: MockCommunityItem
) {
    //Если бы передавали простые значения через навигацию
//    val itemId = navController.currentBackStackEntry?.arguments?.getInt(CommunityDetailsDestination.itemIdArg)
    /**
     * Получааем пока не нужный аргумент из навигации
     */
    val ourCommunity = community

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    )
    { innerPadding ->
        CommunityDetailsBody(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(
                    start = 24.dp, end = 24.dp, top = 16.dp
                )
        )
    }
}

@Composable
fun CommunityDetailsBody(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = longText,
            fontSize = MaterialTheme.typography.Metadata1.fontSize,
            fontWeight = FontWeight.Normal,
            fontFamily = SFProDisplay,
            color = LightDarkGray,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .heightIn(min = 0.dp, max = 270.dp)
        )
        Text(
            text = stringResource(id = R.string.community_events),
            fontSize = MaterialTheme.typography.BodyText1.fontSize,
            fontWeight = FontWeight.SemiBold,
            fontFamily = SFProDisplay,
            color = LightDarkGray,
            modifier = Modifier.padding(top = 30.dp, bottom = 16.dp)
        )
        Events(
            listOfMeetings = mockEventsListAll,
            onEventItemClick = {}
        )
    }
}