package com.example.ui_v2.ui.screens.communityScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.R
import com.example.ui_v2.models.CommunityDescriptionModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.BackShareBar
import com.example.ui_v2.ui.components.CommunityDescriptionBlock
import com.example.ui_v2.ui.components.EvensFixBlockCarousel
import com.example.ui_v2.ui.components.EventCard
import com.example.ui_v2.ui.components.JoinCommunityButton
import com.example.ui_v2.ui.components.OverlappingBlock
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus
import org.koin.androidx.compose.koinViewModel


internal object CommunityScreenDestination : NavigationDestination {
    override val route = "community_screen"
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@Composable
internal fun CommunityScreen(
    navigateToPeopleScreen: (communityId: String) -> Unit,
    navigateToEventScreen: (eventId: String) -> Unit,
    navigateBack: () -> Unit,
    onShareClick: (eventId: String) -> Unit,
    viewModel: CommunityScreenViewModel = koinViewModel(),
) {
    val communityScreenUiState by viewModel.getCommunityScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        CommunityScreenBody(
            communityDescription = communityScreenUiState.communityDescription,
            onArrowBackClick = navigateBack,
            onShareClick = { onShareClick(communityScreenUiState.communityDescription.id) },
            onParticipantsRowClick = { navigateToPeopleScreen(communityScreenUiState.communityDescription.id) },
            onSubscribeButtonClick = { viewModel.onSubscribeButtonClick() },
            subscribeButtonStatus = communityScreenUiState.buttonStatus,
            isSubscribeButtonEnabled = communityScreenUiState.isSubscribeButtonEnabled,
            onEventCardClick = { navigateToEventScreen(it.id) },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun CommunityScreenBody(
    communityDescription: CommunityDescriptionModelUI,
    onArrowBackClick: () -> Unit,
    onShareClick: () -> Unit,
    onParticipantsRowClick: () -> Unit,
    onSubscribeButtonClick: () -> Unit,
    subscribeButtonStatus: ButtonStatus,
    isSubscribeButtonEnabled: Boolean,
    onEventCardClick: (EventModelUI) -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(
                top = 12.dp
            )
    ) {
        BackShareBar(
            barText = communityDescription.name,
            onArrowClick = onArrowBackClick,
            onShareClick = onShareClick,
            modifier = Modifier
                .padding(
                    horizontal = DevMeetingAppTheme.dimensions.paddingMedium
                )
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
                CommunityDescriptionBlock(
                    communityDescription = communityDescription,
                    modifier = Modifier
                        .padding(
                            horizontal = DevMeetingAppTheme.dimensions.paddingMedium
                        )
                )
            }
            item {
                JoinCommunityButton(
                    onButtonClick = onSubscribeButtonClick,
                    buttonStatus = subscribeButtonStatus,
                    isButtonEnabled = isSubscribeButtonEnabled,
                    modifier = Modifier
                        .padding(
                            start = DevMeetingAppTheme.dimensions.paddingMedium,
                            end = DevMeetingAppTheme.dimensions.paddingMedium,
                            top = 32.dp
                        )
                )
            }
            item {
                Text(
                    text = communityDescription.description,
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
                OverlappingBlock(
                    blockText = stringResource(id = R.string.subscribers),
                    participantsList = communityDescription.listOfParticipants,
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
                Text(
                    text = stringResource(id = R.string.meetups),
                    style = DevMeetingAppTheme.typography.customH2,
                    color = DevMeetingAppTheme.colors.black,
                    modifier = Modifier
                        .padding(
                            start = DevMeetingAppTheme.dimensions.paddingMedium,
                            end = DevMeetingAppTheme.dimensions.paddingMedium,
                            top = 32.dp
                        )
                )
            }
            items(communityDescription.listOfEvents) { event ->
                EventCard(
                    event = event,
                    onEventCardClick = { onEventCardClick(event) },
                    modifier = Modifier
                        .padding(
                            start = DevMeetingAppTheme.dimensions.paddingMedium,
                            end = DevMeetingAppTheme.dimensions.paddingMedium,
                            top = 16.dp
                        )
                        .fillMaxWidth()
                )
            }
            item {
                EvensFixBlockCarousel(
                    blockText = stringResource(id = R.string.past_meetups),
                    style = DevMeetingAppTheme.typography.heading1,
                    blockEventsList = communityDescription.listOfPastEvents,
                    onEventCardClick = onEventCardClick,
                    contentPadding = PaddingValues(horizontal = DevMeetingAppTheme.dimensions.paddingMedium),
                    modifier = Modifier
                        .padding(
                            top = 32.dp
                        )
                )
            }
        }
    }
}