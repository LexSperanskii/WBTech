package com.example.ui_v2.ui.screens.mainScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.R
import com.example.ui_v2.models.CommunitiesAdvertBlockModelUI
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.models.EventAdvertBlockModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.Banner
import com.example.ui_v2.ui.components.CommunitiesAdvertBlockCarousel
import com.example.ui_v2.ui.components.CommunitiesFixBlockCarousel
import com.example.ui_v2.ui.components.EvensAdvertBlockCarousel
import com.example.ui_v2.ui.components.EvensCarousel
import com.example.ui_v2.ui.components.EvensFixBlockCarousel
import com.example.ui_v2.ui.components.EventCard
import com.example.ui_v2.ui.components.PeopleCarousel
import com.example.ui_v2.ui.components.SearchFieldBar
import com.example.ui_v2.ui.components.TagBlock
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import org.koin.androidx.compose.koinViewModel


internal object MainScreenDestination : NavigationDestination {
    override val route = "main_screen"
}

@Composable
internal fun MainScreen(
    navigateToOtherUserScreen: (userId: String) -> Unit,
    navigateToCommunityScreen: (communityId: String) -> Unit,
    navigateToEventScreen: (eventId: String) -> Unit,
    navigateToBannerScreen: () -> Unit,
    navigateToProfileScreen: () -> Unit,
    viewModel: MainScreenViewModel = koinViewModel(),
) {
    val mainScreenUiState by viewModel.getMainScreenUiStateFlow().collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        MainScreenBody(
            isShowSortedScreen = mainScreenUiState.isShowSortedScreen,
            searchField = mainScreenUiState.searchField,
            onSearchFieldChange = { viewModel.onSearchFieldChange(it) },
            onClearIconClick = { viewModel.onClearIconClick() },
            onCancelClick = { viewModel.onCancelClick() },
            onUserIconClick = navigateToProfileScreen,
            onEventCardClick = { navigateToEventScreen(it.id) },
            onCommunityButtonClick = { viewModel.onCommunityButtonClick(it) },
            onCommunityClick = { navigateToCommunityScreen(it.id) },
            myCommunitiesList = mainScreenUiState.myCommunitiesList,
            primaryEventsList = mainScreenUiState.primaryEventsList,
            upcomingEventsList = mainScreenUiState.upcomingEventsList,
            infiniteEventsList = mainScreenUiState.infiniteEventsList,
            sortedEventsList = mainScreenUiState.sortedEventsList,
            allCommunitiesList = mainScreenUiState.allCommunitiesList,
            communitiesAdvertBlock1 = mainScreenUiState.communitiesAdvertBlock1,
            communitiesAdvertBlock2 = mainScreenUiState.communitiesAdvertBlock2,
            eventsAdvertBlock = mainScreenUiState.eventsAdvertBlock,
            listOfTags = mainScreenUiState.listOfTags,
            listOfChosenTags = mainScreenUiState.listOfChosenTags,
            onTagClick = { viewModel.onTagClick(it) },
            onBannerTagClick = navigateToBannerScreen,
            listOfPeople = mainScreenUiState.listOfPeople,
            onPersonCardClick = { navigateToOtherUserScreen(it.id) },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun MainScreenBody(
    isShowSortedScreen: Boolean,
    searchField: String,
    onSearchFieldChange: (String) -> Unit,
    onClearIconClick: () -> Unit,
    onCancelClick: () -> Unit,
    onUserIconClick: () -> Unit,
    onEventCardClick: (EventModelUI) -> Unit,
    onCommunityButtonClick: (CommunityModelUI) -> Unit,
    onCommunityClick: (CommunityModelUI) -> Unit,
    myCommunitiesList: List<CommunityModelUI>,
    primaryEventsList: List<EventModelUI>,
    upcomingEventsList: List<EventModelUI>,
    infiniteEventsList: List<EventModelUI>,
    sortedEventsList: List<EventModelUI>,
    allCommunitiesList: List<CommunityModelUI>,
    communitiesAdvertBlock1: CommunitiesAdvertBlockModelUI,
    communitiesAdvertBlock2: CommunitiesAdvertBlockModelUI,
    eventsAdvertBlock: EventAdvertBlockModelUI,
    listOfTags: List<String>,
    listOfChosenTags: List<String>,
    onTagClick: (String) -> Unit,
    onBannerTagClick: () -> Unit,
    listOfPeople: List<UserModelUI>,
    onPersonCardClick: (UserModelUI) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(vertical = 12.dp),
        modifier = modifier
    ) {
        item {
            SearchFieldBar(
                searchField = searchField,
                onSearchFieldChange = onSearchFieldChange,
                onClearIconClick = onClearIconClick,
                onUserIconClick = onUserIconClick,
                onCancelClick = onCancelClick,
                isShowProfile = !isShowSortedScreen,
                modifier = Modifier
                    .padding(
                        horizontal = DevMeetingAppTheme.dimensions.paddingMedium
                    )
            )
        }
        when (isShowSortedScreen) {
            true -> {
                items(sortedEventsList) { sortedEvent ->
                    EventCard(
                        event = sortedEvent,
                        onEventCardClick = { onEventCardClick(sortedEvent) },
                        modifier = Modifier
                            .padding(
                                start = DevMeetingAppTheme.dimensions.paddingMedium,
                                end = DevMeetingAppTheme.dimensions.paddingMedium,
                                top = 40.dp
                            )
                            .fillMaxWidth()
                    )
                }
                if (sortedEventsList.isEmpty()) {
                    item {
                        Text(
                            text = stringResource(id = R.string.nothing_found),
                            color = DevMeetingAppTheme.colors.eventCardText,
                            style = DevMeetingAppTheme.typography.customH2,
                            modifier = Modifier
                                .padding(
                                    start = DevMeetingAppTheme.dimensions.paddingMedium,
                                    end = DevMeetingAppTheme.dimensions.paddingMedium,
                                    top = 40.dp
                                )
                                .fillMaxWidth()
                        )
                    }
                }
                item {
                    CommunitiesFixBlockCarousel(
                        blockText = stringResource(id = R.string.communities),
                        communitiesList = allCommunitiesList,
                        myCommunitiesList = myCommunitiesList,
                        onCommunityButtonClick = onCommunityButtonClick,
                        onCommunityClick = onCommunityClick,
                        contentPadding = PaddingValues(horizontal = DevMeetingAppTheme.dimensions.paddingMedium),
                        modifier = Modifier
                            .padding(
                                top = 40.dp
                            )
                    )
                }
                item {
                    EvensAdvertBlockCarousel(
                        eventsAdvert = eventsAdvertBlock,
                        onEventCardClick = onEventCardClick,
                        contentPadding = PaddingValues(horizontal = DevMeetingAppTheme.dimensions.paddingMedium),
                        modifier = Modifier
                            .padding(
                                top = 40.dp
                            )
                    )
                }
            }

            else -> {
                item {
                    EvensCarousel(
                        eventsList = primaryEventsList,
                        onEventCardClick = onEventCardClick,
                        contentPadding = PaddingValues(horizontal = DevMeetingAppTheme.dimensions.paddingMedium),
                        modifier = Modifier
                            .padding(
                                top = 20.dp
                            )
                    )
                }
                item {
                    EvensFixBlockCarousel(
                        blockText = stringResource(id = R.string.upcoming_events),
                        blockEventsList = upcomingEventsList,
                        onEventCardClick = onEventCardClick,
                        contentPadding = PaddingValues(horizontal = DevMeetingAppTheme.dimensions.paddingMedium),
                        modifier = Modifier
                            .padding(
                                top = 40.dp
                            )
                    )
                }
                item {
                    CommunitiesAdvertBlockCarousel(
                        communitiesAdvert = communitiesAdvertBlock1,
                        myCommunitiesList = myCommunitiesList,
                        onCommunityButtonClick = onCommunityButtonClick,
                        onCommunityClick = onCommunityClick,
                        contentPadding = PaddingValues(horizontal = DevMeetingAppTheme.dimensions.paddingMedium),
                        modifier = Modifier
                            .padding(
                                top = 40.dp
                            )
                    )
                }
                item {
                    TagBlock(
                        blockText = stringResource(id = R.string.block_tag),
                        listOfTags = listOfTags,
                        listOfChosenTags = listOfChosenTags,
                        onTagClick = onTagClick,
                        modifier = Modifier
                            .padding(
                                start = DevMeetingAppTheme.dimensions.paddingMedium,
                                end = DevMeetingAppTheme.dimensions.paddingMedium,
                                top = 40.dp
                            )
                    )
                }
                itemsIndexed(infiniteEventsList) { index, event ->
                    EventCard(
                        event = event,
                        onEventCardClick = { onEventCardClick(event) },
                        modifier = Modifier
                            .padding(
                                start = DevMeetingAppTheme.dimensions.paddingMedium,
                                end = DevMeetingAppTheme.dimensions.paddingMedium,
                                top = 40.dp
                            )
                            .fillMaxWidth()
                    )
                    when (index) {
                        2 -> {
                            Banner(
                                onBannerTagClick = onBannerTagClick,
                                modifier = Modifier
                                    .padding(
                                        start = DevMeetingAppTheme.dimensions.paddingMedium,
                                        end = DevMeetingAppTheme.dimensions.paddingMedium,
                                        top = 40.dp
                                    )
                            )
                        }

                        5 -> {
                            PeopleCarousel(
                                blockText = stringResource(id = R.string.block_people),
                                listOfPeople = listOfPeople,
                                onPersonCardClick = onPersonCardClick,
                                contentPadding = PaddingValues(horizontal = DevMeetingAppTheme.dimensions.paddingMedium),
                                modifier = Modifier
                                    .padding(
                                        top = 40.dp
                                    )
                            )
                        }

                        8 -> {
                            CommunitiesAdvertBlockCarousel(
                                communitiesAdvert = communitiesAdvertBlock2,
                                myCommunitiesList = myCommunitiesList,
                                onCommunityButtonClick = onCommunityButtonClick,
                                onCommunityClick = onCommunityClick,
                                contentPadding = PaddingValues(horizontal = DevMeetingAppTheme.dimensions.paddingMedium),
                                modifier = Modifier
                                    .padding(
                                        top = 40.dp
                                    )
                            )
                        }
                    }
                }
            }
        }

    }
}