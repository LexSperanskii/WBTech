package com.example.spa_wb_junior_devmeetingapp.ui.screens.communities.communityDetailScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.models.EventModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.EventCard
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TopAppBarBackNameAction
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme
import org.koin.androidx.compose.koinViewModel

object CommunityDetailsDestination : NavigationDestination {
    override val route = "community_details"
    override val title = R.string.community_details
}

@Composable
fun CommunityDetailsScreen(
    navController: NavHostController,
    navigateToEventDetailItem : (EventModelUI) -> Unit,
    viewModel: CommunityDetailViewModel = koinViewModel()
) {

    val communityDetailScreenUiState by viewModel.getCommunityDetailScreenUiStateFlow().collectAsState()

    Scaffold(
        topBar = {
            TopAppBarBackNameAction(
                title = communityDetailScreenUiState.nameOfCommunity,
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
            communityEventsList = communityDetailScreenUiState.communityEventsList ,
            description = communityDetailScreenUiState.description,
            navigateToEventDetailItem = navigateToEventDetailItem,
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
    navigateToEventDetailItem : (EventModelUI) -> Unit,
    description: String,
    communityEventsList : List<EventModelUI>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = description,
                style = DevMeetingAppTheme.typography.metadata1,
                color = DevMeetingAppTheme.colors.lightDarkGray,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .heightIn(min = 0.dp, max = 270.dp)
            )
        }
        item {
            Text(
                text = stringResource(id = R.string.community_events),
                style = DevMeetingAppTheme.typography.bodyText1,
                color = DevMeetingAppTheme.colors.lightDarkGray,
                modifier = Modifier.padding(top = 14.dp)
            )
        }
        items (communityEventsList){ event ->
            EventCard(
                eventName = event.name,
                isEventFinished = event.isFinished,
                eventDate = event.date,
                eventCity = event.city,
                eventCategories = event.category,
                eventIconURL = event.iconURL,
                onEventItemClick  = { navigateToEventDetailItem(event) },
                modifier = Modifier
            )
        }
    }
}