package com.example.ui_v2.ui.screens.mainScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.R
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.Banner
import com.example.ui_v2.ui.components.CommunitiesCarousel
import com.example.ui_v2.ui.components.EvensCarousel
import com.example.ui_v2.ui.components.EvensCarouselBlock
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
            isSortedScreen = mainScreenUiState.isSortedScreen,
            searchField = mainScreenUiState.searchField,
            onSearchFieldChange = { viewModel.onSearchFieldChange(it) },
            onClearIconClick = { viewModel.onClearIconClick() },
            onCancelClick = { viewModel.onCancelClick() },
            onUserIconClick = navigateToProfileScreen,
            myEventsList = mainScreenUiState.myEventsList,
            onEventCardClick = { navigateToEventScreen(it.id) },
            upcomingEventsList = mainScreenUiState.upcomingEventsList,
            infiniteEventsList = mainScreenUiState.infiniteEventsList,
            firstCommunitiesBlockText = mainScreenUiState.communitiesBlockText,
            firstCommunitiesBlockList = mainScreenUiState.communitiesList,
            myCommunitiesList = mainScreenUiState.myCommunitiesList,
            onCommunityButtonClick = { viewModel.onCommunityButtonClick(it) },
            onCommunityClick = { navigateToCommunityScreen(it.id) },
            secondCommunitiesBlockText = mainScreenUiState.popularCommunitiesBlockText,
            secondCommunitiesBlockList = mainScreenUiState.popularCommunitiesList,
            listOfTags = mainScreenUiState.listOfTags,
            listOfChosenTags = mainScreenUiState.listOfChosenTags,
            onTagClick = { viewModel.onTagClick(it) },
            onBannerTagClick = navigateToBannerScreen,
            listOfPeople = mainScreenUiState.listOfPeople,
            onPersonCardClick = { navigateToOtherUserScreen(it.id) },

            sortedEventsList = mainScreenUiState.myEventsList.take(3),
            sortedCommunitiesBlockText = mainScreenUiState.communitiesBlockText,
            sortedCommunitiesBlockList = mainScreenUiState.communitiesList,
            sortedBlockEventsList = mainScreenUiState.myEventsList,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun MainScreenBody(
    isSortedScreen: Boolean,
    searchField: String,
    onSearchFieldChange: (String) -> Unit,
    onClearIconClick: () -> Unit,
    onCancelClick: () -> Unit,
    onUserIconClick: () -> Unit,
    myEventsList: List<EventModelUI>,
    onEventCardClick: (EventModelUI) -> Unit,
    upcomingEventsList: List<EventModelUI>,
    infiniteEventsList: List<EventModelUI>,
    firstCommunitiesBlockText: String,
    firstCommunitiesBlockList: List<CommunityModelUI>,
    myCommunitiesList: List<CommunityModelUI>,
    onCommunityButtonClick: (CommunityModelUI) -> Unit,
    onCommunityClick: (CommunityModelUI) -> Unit,
    secondCommunitiesBlockText: String,
    secondCommunitiesBlockList: List<CommunityModelUI>,
    listOfTags: List<String>,
    listOfChosenTags: List<String>,
    onTagClick: (String) -> Unit,
    onBannerTagClick: () -> Unit,
    listOfPeople: List<UserModelUI>,
    onPersonCardClick: (UserModelUI) -> Unit,

    sortedEventsList: List<EventModelUI>,
    sortedCommunitiesBlockText: String,
    sortedCommunitiesBlockList: List<CommunityModelUI>,
    sortedBlockEventsList: List<EventModelUI>,
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
                isShowProfile = !isSortedScreen,
                modifier = Modifier
                    .padding(
                        horizontal = DevMeetingAppTheme.dimensions.paddingMedium
                    )
            )
        }
        when (isSortedScreen) {
            true -> {
                items(sortedEventsList) { event ->
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
                }
                item {
                    CommunitiesCarousel(
                        blockText = sortedCommunitiesBlockText,
                        communitiesList = sortedCommunitiesBlockList,
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
                    EvensCarouselBlock(
                        blockText = stringResource(id = R.string.upcoming_events),
                        blockEventsList = sortedBlockEventsList,
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
                        eventsList = myEventsList,
                        onEventCardClick = onEventCardClick,
                        contentPadding = PaddingValues(horizontal = DevMeetingAppTheme.dimensions.paddingMedium),
                        modifier = Modifier
                            .padding(
                                top = 20.dp
                            )
                    )
                }
                item {
                    EvensCarouselBlock(
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
                    CommunitiesCarousel(
                        blockText = firstCommunitiesBlockText,
                        communitiesList = firstCommunitiesBlockList,
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
                            CommunitiesCarousel(
                                blockText = secondCommunitiesBlockText,
                                communitiesList = secondCommunitiesBlockList,
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