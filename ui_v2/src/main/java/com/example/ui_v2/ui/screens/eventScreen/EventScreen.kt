package com.example.ui_v2.ui.screens.eventScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.R
import com.example.ui_v2.models.EventDescriptionModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.BackShareBar
import com.example.ui_v2.ui.components.EvensFixBlockCarousel
import com.example.ui_v2.ui.components.EventDescriptionBlock
import com.example.ui_v2.ui.components.JoinEventButton
import com.example.ui_v2.ui.components.MapBlock
import com.example.ui_v2.ui.components.OrganizerBlock
import com.example.ui_v2.ui.components.OverlappingBlock
import com.example.ui_v2.ui.components.PitcherBlock
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus
import org.koin.androidx.compose.koinViewModel


internal object EventScreenDestination : NavigationDestination {
    override val route = "event_screen"
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@Composable
internal fun EventScreen(
    navigateToEventScreen: (eventId: String) -> Unit,
    navigateToPeopleScreen: (eventId: String) -> Unit,
    navigateToCommunityScreen: (communityId: String) -> Unit,
    navigateBack: () -> Unit,
    navigateToAppointmentScreen: (eventId: String) -> Unit,
    onShareClick: (eventId: String) -> Unit,
    onPitcherClick: (userId: String) -> Unit,
    viewModel: EventScreenViewModel = koinViewModel(),
) {
    val eventScreenUiState by viewModel.getEventScreenUiStateFlow().collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        EventScreenBody(
            eventDescription = eventScreenUiState.eventDescription,
            onArrowBackClick = navigateBack,
            onShareClick = { onShareClick(eventScreenUiState.eventDescription.id) },
            onPitcherClick = { onPitcherClick(eventScreenUiState.eventDescription.pitcher.id) },
            onParticipantsRowClick = { navigateToPeopleScreen(eventScreenUiState.eventDescription.id) },
            isInMyCommunities = eventScreenUiState.isInMyCommunities,
            onCommunityClick = { navigateToCommunityScreen(eventScreenUiState.eventDescription.organizer.id) },
            onCommunityButtonClick = { viewModel.onCommunityButtonClick() },
            otherCommunityEventsList = eventScreenUiState.otherCommunityEventsList,
            onEventCardClick = { navigateToEventScreen(it.id) },
            onJoinEventButtonClick = {
                viewModel.onJoinEventButtonClick()
                navigateToAppointmentScreen(eventScreenUiState.eventDescription.id)
            },
            joinEventButtonStatus = eventScreenUiState.buttonStatus,
            isJoinEventButtonEnabled = eventScreenUiState.isJoinEventButtonEnabled,
            modifier = Modifier
                .padding(innerPadding)
        )
    }
}

@Composable
internal fun EventScreenBody(
    eventDescription: EventDescriptionModelUI,
    onArrowBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onPitcherClick: () -> Unit,
    onParticipantsRowClick: () -> Unit,
    isInMyCommunities: Boolean,
    onCommunityClick: () -> Unit,
    onCommunityButtonClick: () -> Unit,
    otherCommunityEventsList: List<EventModelUI>,
    onEventCardClick: (EventModelUI) -> Unit,
    onJoinEventButtonClick: () -> Unit,
    joinEventButtonStatus: ButtonStatus,
    isJoinEventButtonEnabled: Boolean,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(top = 12.dp)
    ) {
        BackShareBar(
            barText = eventDescription.name,
            onArrowClick = onArrowBackClick,
            onShareClick = onShareClick,
            modifier = Modifier.padding(horizontal = DevMeetingAppTheme.dimensions.paddingMedium)
        )
        LazyColumn(
            contentPadding = PaddingValues(
                top = 8.dp,
                bottom = 28.dp
            ),
            modifier = Modifier
                .weight(1f)
        ) {
            item {
                EventDescriptionBlock(
                    eventDescription = eventDescription,
                    modifier = Modifier
                        .padding(
                            horizontal = DevMeetingAppTheme.dimensions.paddingMedium
                        )
                )
            }
            item {
                Text(
                    text = eventDescription.description,
                    style = DevMeetingAppTheme.typography.metadata1,
                    color = DevMeetingAppTheme.colors.black,
                    modifier = Modifier
                        .padding(
                            start = DevMeetingAppTheme.dimensions.paddingMedium,
                            end = DevMeetingAppTheme.dimensions.paddingMedium,
                            top = 32.dp
                        )
                )
            }
            item {
                PitcherBlock(
                    pitcher = eventDescription.pitcher,
                    onPitcherClick = onPitcherClick,
                    modifier = Modifier
                        .padding(
                            start = DevMeetingAppTheme.dimensions.paddingMedium,
                            end = DevMeetingAppTheme.dimensions.paddingMedium,
                            top = 32.dp
                        )
                )
            }
            item {
                MapBlock(
                    address = stringResource(
                        id = R.string.event_address,
                        eventDescription.city,
                        eventDescription.street,
                        eventDescription.building
                    ),
                    metro = eventDescription.metroStation,
                    modifier = Modifier
                        .padding(
                            start = DevMeetingAppTheme.dimensions.paddingMedium,
                            end = DevMeetingAppTheme.dimensions.paddingMedium,
                            top = 32.dp
                        )
                )
            }
            item {
                OverlappingBlock(
                    participantsList = eventDescription.listOfParticipants,
                    onOverlappingRowClick = onParticipantsRowClick,
                    modifier = Modifier
                        .padding(
                            start = DevMeetingAppTheme.dimensions.paddingMedium,
                            end = DevMeetingAppTheme.dimensions.paddingMedium,
                            top = 32.dp
                        )
                )
            }
            item {
                OrganizerBlock(
                    orgCommunity = eventDescription.organizer,
                    isInMyCommunities = isInMyCommunities,
                    onCommunityClick = onCommunityClick,
                    onCommunityButtonClick = onCommunityButtonClick,
                    modifier = Modifier
                        .padding(
                            start = DevMeetingAppTheme.dimensions.paddingMedium,
                            end = DevMeetingAppTheme.dimensions.paddingMedium,
                            top = 32.dp
                        )
                )
            }
            item {
                EvensFixBlockCarousel(
                    blockText = stringResource(id = R.string.other_community_meetups),
                    blockEventsList = otherCommunityEventsList,
                    onEventCardClick = onEventCardClick,
                    contentPadding = PaddingValues(horizontal = DevMeetingAppTheme.dimensions.paddingMedium),
                    modifier = Modifier
                        .padding(
                            top = 32.dp
                        )
                )
            }
        }
        JoinEventButton(
            eventRestCapacity = eventDescription.availableCapacity,
            onButtonClick = onJoinEventButtonClick,
            buttonStatus = joinEventButtonStatus,
            isButtonEnabled = isJoinEventButtonEnabled,
            modifier = Modifier
        )
    }
}