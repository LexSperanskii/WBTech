package com.example.ui_v2.ui.screens.eventScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.R
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.BackShareBar
import com.example.ui_v2.ui.components.EvensFixBlockCarousel
import com.example.ui_v2.ui.components.JoinEventButton
import com.example.ui_v2.ui.components.OrganizerBlock
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus
import org.koin.androidx.compose.koinViewModel


internal object EventScreenDestination : NavigationDestination {
    override val route = "event_screen"
}

@Composable
internal fun EventScreen(
    navigateTo: () -> Unit,
    viewModel: EventScreenViewModel = koinViewModel(),
) {
    val eventScreenUiState by viewModel.getEventScreenUiStateFlow().collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
//        EventScreenBody(
//            modifier = Modifier.padding(innerPadding)
//        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun EventScreenBody(
    backBarText: String,
    onArrowBackClick: () -> Unit,
    onShareClick: () -> Unit,

    nameOfCommunity: String,
    descriptionOfCommunity: String,
    communityImageURL: String,
    onCommunityClick: () -> Unit,
    onEventCardClick: (EventModelUI) -> Unit,
    otherCommunityEventsList: List<EventModelUI>,
    eventRestCapacity: Int,
    onJoinEventButtonClick: () -> Unit,
    joinEventButtonStatus: ButtonStatus,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(top = 12.dp),
        modifier = modifier
    ) {
        item {
            BackShareBar(
                barText = backBarText,
                onArrowClick = onArrowBackClick,
                onShareClick = onShareClick
            )
        }
        item {

        }
        item {
            OrganizerBlock(
                nameOfCommunity = nameOfCommunity,
                descriptionOfCommunity = descriptionOfCommunity,
                communityImageURL = communityImageURL,
                onCommunityClick = onCommunityClick,
                modifier = Modifier
                    .padding(
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
        stickyHeader {
            JoinEventButton(
                eventRestCapacity = eventRestCapacity,
                onButtonClick = onJoinEventButtonClick,
                buttonStatus = joinEventButtonStatus
            )
        }
    }
}