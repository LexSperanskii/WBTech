package com.example.ui_v2.ui.screens.mainScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.Banner
import com.example.ui_v2.ui.components.CommunitiesCarousel
import com.example.ui_v2.ui.components.EvensCarousel
import com.example.ui_v2.ui.components.EventCard
import com.example.ui_v2.ui.components.PeopleCarousel
import com.example.ui_v2.ui.components.SearchFieldBar
import com.example.ui_v2.ui.components.TagBlock
import com.example.ui_v2.ui.components.UpcomingEvensCarousel
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import org.koin.androidx.compose.koinViewModel


internal object MainScreenDestination : NavigationDestination {
    override val route = "main_screen"
}

@Composable
internal fun MainScreen(
    navigateTo: () -> Unit,
    viewModel: MainScreenViewModel = koinViewModel(),
) {
    val mainScreenUiState by viewModel.getMainScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        MainScreenBody(
            searchField =,
            onSearchFieldChange = { },
            onClearIconClick = { },
            onUserIconClick = { },
            onCancelClick = { },
            myEventsList =,
            onMyEventCardClick = { },
            upcomingEventsList =,
            onUpcomingEventCardClick = { },
            communitiesBlockText =,
            communitiesList =,
            isCommunityButtonClicked =,
            onCommunityButtonClick = { },
            onCommunityClick = { },
            listOfTags =,
            listOfChosenTags =,
            onTagClick = { },
            onBannerTagClick = { },
            listOfPeople =,
            onPersonCardClick = { },
            popularCommunitiesBlockText =,
            popularCommunitiesList =,
            isPopularCommunityButtonClicked =,
            onPopularCommunityButtonClick = { },
            onPopularCommunityClick = { },
            infiniteEventsList =,
            onInfiniteEventCardClick = { },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun MainScreenBody(
    searchField: String,
    onSearchFieldChange: (String) -> Unit,
    onClearIconClick: () -> Unit,
    onUserIconClick: () -> Unit,
    onCancelClick: () -> Unit,
    myEventsList: List<EventModelUI>,
    onMyEventCardClick: (EventModelUI) -> Unit,
    upcomingEventsList: List<EventModelUI>,
    onUpcomingEventCardClick: (EventModelUI) -> Unit,
    communitiesBlockText: String,
    communitiesList: List<CommunityModelUI>,
    isCommunityButtonClicked: Boolean,
    onCommunityButtonClick: (CommunityModelUI) -> Unit,
    onCommunityClick: (CommunityModelUI) -> Unit,
    listOfTags: List<String>,
    listOfChosenTags: List<String>,
    onTagClick: (String) -> Unit,
    onBannerTagClick: () -> Unit,
    listOfPeople: List<UserModelUI>,
    onPersonCardClick: (UserModelUI) -> Unit,
    popularCommunitiesBlockText: String,
    popularCommunitiesList: List<CommunityModelUI>,
    isPopularCommunityButtonClicked: Boolean,
    onPopularCommunityButtonClick: (CommunityModelUI) -> Unit,
    onPopularCommunityClick: (CommunityModelUI) -> Unit,
    infiniteEventsList: List<EventModelUI>,
    onInfiniteEventCardClick: (EventModelUI) -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        modifier = modifier
    ) {
        stickyHeader {
            SearchFieldBar(
                searchField = searchField,
                onSearchFieldChange = onSearchFieldChange,
                onClearIconClick = onClearIconClick,
                onUserIconClick = onUserIconClick,
                onCancelClick = onCancelClick,
                modifier = Modifier
                    .padding(horizontal = DevMeetingAppTheme.dimensions.paddingMedium)
            )
        }
        item {
            EvensCarousel(
                eventsList = myEventsList,
                onEventCardClick = onMyEventCardClick,
                modifier = Modifier
                    .padding(
                        start = DevMeetingAppTheme.dimensions.paddingMedium,
                        top = 20.dp
                    )
            )
        }
        item {
            UpcomingEvensCarousel(
                upcomingEventsList = upcomingEventsList,
                onUpcomingEventCardClick = onUpcomingEventCardClick,
                modifier = Modifier
                    .padding(
                        start = DevMeetingAppTheme.dimensions.paddingMedium,
                        top = 40.dp
                    )
            )
        }
        item {
            CommunitiesCarousel(
                blockText = communitiesBlockText,
                communitiesList = communitiesList,
                isCommunityButtonClicked = isCommunityButtonClicked,
                onCommunityButtonClick = onCommunityButtonClick,
                onCommunityClick = onCommunityClick,
                modifier = Modifier
                    .padding(
                        start = DevMeetingAppTheme.dimensions.paddingMedium,
                        top = 40.dp
                    )
            )
        }
        item {
            TagBlock(
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
                onEventCardClick = { onInfiniteEventCardClick(event) },
                modifier = Modifier
                    .padding(
                        start = DevMeetingAppTheme.dimensions.paddingMedium,
                        end = DevMeetingAppTheme.dimensions.paddingMedium,
                        top = 40.dp
                    )
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
                        listOfPeople = listOfPeople,
                        onPersonCardClick = onPersonCardClick,
                        modifier = Modifier
                            .padding(
                                start = DevMeetingAppTheme.dimensions.paddingMedium,
                                top = 40.dp
                            )
                    )
                }

                8 -> {
                    CommunitiesCarousel(
                        blockText = popularCommunitiesBlockText,
                        communitiesList = popularCommunitiesList,
                        isCommunityButtonClicked = isPopularCommunityButtonClicked,
                        onCommunityButtonClick = onPopularCommunityButtonClick,
                        onCommunityClick = onPopularCommunityClick,
                        modifier = Modifier
                            .padding(
                                start = DevMeetingAppTheme.dimensions.paddingMedium,
                                top = 40.dp
                            )
                    )
                }
            }
        }
        when (infiniteEventsList.size) {
            in 0..2 -> {
                item {
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
                item {
                    PeopleCarousel(
                        listOfPeople = listOfPeople,
                        onPersonCardClick = onPersonCardClick,
                        modifier = Modifier
                            .padding(
                                start = DevMeetingAppTheme.dimensions.paddingMedium,
                                top = 40.dp
                            )
                    )
                }
                item {
                    CommunitiesCarousel(
                        blockText = popularCommunitiesBlockText,
                        communitiesList = popularCommunitiesList,
                        isCommunityButtonClicked = isPopularCommunityButtonClicked,
                        onCommunityButtonClick = onPopularCommunityButtonClick,
                        onCommunityClick = onPopularCommunityClick,
                        modifier = Modifier
                            .padding(
                                start = DevMeetingAppTheme.dimensions.paddingMedium,
                                top = 40.dp
                            )
                    )
                }
            }

            in 3..5 -> {
                item {
                    PeopleCarousel(
                        listOfPeople = listOfPeople,
                        onPersonCardClick = onPersonCardClick,
                        modifier = Modifier
                            .padding(
                                start = DevMeetingAppTheme.dimensions.paddingMedium,
                                top = 40.dp
                            )
                    )
                }
                item {
                    CommunitiesCarousel(
                        blockText = popularCommunitiesBlockText,
                        communitiesList = popularCommunitiesList,
                        isCommunityButtonClicked = isPopularCommunityButtonClicked,
                        onCommunityButtonClick = onPopularCommunityButtonClick,
                        onCommunityClick = onPopularCommunityClick,
                        modifier = Modifier
                            .padding(
                                start = DevMeetingAppTheme.dimensions.paddingMedium,
                                top = 40.dp
                            )
                    )
                }
            }

            in 6..8 -> {
                item {
                    CommunitiesCarousel(
                        blockText = popularCommunitiesBlockText,
                        communitiesList = popularCommunitiesList,
                        isCommunityButtonClicked = isPopularCommunityButtonClicked,
                        onCommunityButtonClick = onPopularCommunityButtonClick,
                        onCommunityClick = onPopularCommunityClick,
                        modifier = Modifier
                            .padding(
                                start = DevMeetingAppTheme.dimensions.paddingMedium,
                                top = 40.dp
                            )
                    )
                }
            }
        }
    }
}