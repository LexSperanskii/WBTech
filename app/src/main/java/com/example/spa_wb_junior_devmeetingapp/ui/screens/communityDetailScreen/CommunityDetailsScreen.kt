package com.example.spa_wb_junior_devmeetingapp.ui.screens.communityDetailScreen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.example.spa_wb_junior_devmeetingapp.data.mockData.MockCommunityItem
import com.example.spa_wb_junior_devmeetingapp.data.mockData.MockEventItem
import com.example.spa_wb_junior_devmeetingapp.data.mockData.longText
import com.example.spa_wb_junior_devmeetingapp.data.mockData.mockEventsListAll
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.EventCard
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TopAppBarBackNameAction
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
    community: MockCommunityItem,
    navigateToEventDetailItem : (MockEventItem) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBarBackNameAction(
                title = stringResource(id = CommunityDetailsDestination.title),
                isAddCapable = false,
                onClickNavigateBack = {navController.popBackStack()}
            )
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    )
    { innerPadding ->
        CommunityDetailsBody(
            navigateToEventDetailItem = navigateToEventDetailItem,
            eventsListAll = mockEventsListAll ,
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
    navigateToEventDetailItem : (MockEventItem) -> Unit,
    eventsListAll : List<MockEventItem>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
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
        }
        item {
            Text(
                text = stringResource(id = R.string.community_events),
                fontSize = MaterialTheme.typography.BodyText1.fontSize,
                fontWeight = FontWeight.SemiBold,
                fontFamily = SFProDisplay,
                color = LightDarkGray,
                modifier = Modifier.padding(top = 30.dp, bottom = 16.dp)
            )
        }
        items (eventsListAll){ event ->
            EventCard(
                eventName = event.eventName,
                eventStatus = event.eventStatus.status,
                eventDate = event.eventDate,
                eventPlace = event.eventPlace,
                eventCategories = event.eventCategory,
                eventIconURL = event.eventIconURL,
                onEventItemClick  = { navigateToEventDetailItem(event) },
                modifier = Modifier
            )
        }
    }
}