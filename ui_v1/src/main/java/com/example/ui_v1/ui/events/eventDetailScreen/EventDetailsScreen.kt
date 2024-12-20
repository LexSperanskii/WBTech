package com.example.ui_v1.ui.events.eventDetailScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.ui_v1.R
import com.example.ui_v1.models.UIv1EventDetailModelUI
import com.example.ui_v1.models.UIv1RegisteredPersonModelUI
import com.example.ui_v1.navigation.UIv1NavigationDestination
import com.example.ui_v1.ui.elements.BottomNavigationBar
import com.example.ui_v1.ui.elements.OverlappingPeopleRow
import com.example.ui_v1.ui.elements.TopAppBarForEventDetails
import com.example.ui_v1.ui.elements.buttons.CustomButtonForEvent
import com.example.ui_v1.ui.theme.DevMeetingAppTheme
import org.koin.androidx.compose.koinViewModel

internal object EventDetailsDestinationUIv1 : UIv1NavigationDestination {
    override val route = "event_details"
    override val title = R.string.events_details
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@Composable
internal fun EventDetailsScreen(
    navController: NavHostController,
    navigateToFullScreenMap : () -> Unit,
    viewModel: EventDetailViewModel = koinViewModel()
) {

    val eventDetailScreenUiState by viewModel.getEventDetailScreenUiStateFlow().collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBarForEventDetails(
                title = eventDetailScreenUiState.event.name,
                onClickNavigateBack = {navController.popBackStack()},
                isStatusPlanned = eventDetailScreenUiState.isUserInParticipants,
                onStatusCLick = {
                    viewModel.onGoToMeetingClick()
                }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    )
    { innerPadding ->
        EventDetailsBody(
            event = eventDetailScreenUiState.event,
            participantsList = eventDetailScreenUiState.event.listOfParticipants,
            onButtonClick = {
                viewModel.onGoToMeetingClick()
            },
            isUserInParticipants = eventDetailScreenUiState.isUserInParticipants,
            enabled = !eventDetailScreenUiState.event.isFinished,
            onMapClick = navigateToFullScreenMap,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(
                    start = 24.dp, end = 24.dp, top = 16.dp, bottom = 20.dp
                )
        )
    }
}

@Composable
internal fun EventDetailsBody(
    event: UIv1EventDetailModelUI,
    participantsList: List<UIv1RegisteredPersonModelUI>,
    onButtonClick: () -> Unit,
    onMapClick: () -> Unit,
    isUserInParticipants: Boolean,
    enabled: Boolean,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        item {
            Text(
                text = stringResource(id = R.string.event_date_place, event.date,event.address),
                style = DevMeetingAppTheme.typography.bodyText1,
                color = DevMeetingAppTheme.colors.lightDarkGray,
                modifier = Modifier.padding(bottom = 2.dp)
            )
        }
        item {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                items(event.category){ item ->
                    Box(
                        modifier = Modifier
                            .clip(RoundedCornerShape(40.dp))
                            .background(DevMeetingAppTheme.colors.lightPurple)
                            .padding(horizontal = 8.dp, vertical = 2.dp)
                    ) {
                        Text(
                            text = item,
                            style = DevMeetingAppTheme.typography.metadata3,
                            color = DevMeetingAppTheme.colors.darkPurple,
                            lineHeight = 16.sp
                        )
                    }
                }
            }
        }
        item {
            Image(
                painter = painterResource(id = R.drawable.map),
                contentDescription = stringResource(id = R.string.map),
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(2f)
                    .clip(RoundedCornerShape(24.dp))
                    .clickable { onMapClick() },
                contentScale = ContentScale.Crop
            )
        }
        item {
            Text(
                text = event.description,
                style = DevMeetingAppTheme.typography.metadata1,
                color = DevMeetingAppTheme.colors.lightDarkGray,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier
                    .padding(vertical = 20.dp)
                    .heightIn(min = 0.dp, max = 172.dp)
            )
        }
        item {
            OverlappingPeopleRow(
                participantsList = participantsList,
                modifier = Modifier.padding(bottom = 13.dp)
            )
        }
        item {
            CustomButtonForEvent(
                isUserInParticipants = isUserInParticipants,
                enabled = enabled,
                onButtonClick = onButtonClick
            )
        }
    }
}