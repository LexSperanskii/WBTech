package com.example.spa_wb_junior_devmeetingapp.ui.screens.eventsAllScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.model.EventItem
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.EventCard
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.MySearchBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TopAppBarBackNameAction
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

object EventsAllDestination : NavigationDestination {
    override val route = "events_all"
    override val title = R.string.events_all
}

enum class EventsAllTabs(val text: String){
    AllMeetings(text = "ВСЕ ВСТРЕЧИ"),
    Active(text = "АКТИВНЫЕ")
}

@Composable
fun EventsAllScreen(
    navController: NavHostController,
    navigateToEventDetailItem : (EventItem) -> Unit,
    navigateToDeveloperScreen : () -> Unit,
    viewModel: EventsAllViewModel = koinViewModel()
) {

    val eventsAllScreenUiState by viewModel.getEventsAllScreenUiStateFlow().collectAsState()

    Scaffold(
        topBar = {
            TopAppBarBackNameAction(
                title = stringResource(id = EventsAllDestination.title),
                isNavigateBack = false,
                onAddCLick = navigateToDeveloperScreen
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { innerPadding ->
        EventsBody(
            navigateToEventDetailItem = navigateToEventDetailItem,
            searchField = eventsAllScreenUiState.search,
            onSearchFieldChange = {
                viewModel.onSearchChange(it)
            },
            onDoneKeyboardPressed = {},
            listOfMeetingsAll = eventsAllScreenUiState.listOfMeetingsAll,
            listOfMeetingsActive = eventsAllScreenUiState.listOfMeetingsActive,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 16.dp
                )
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EventsBody(
    navigateToEventDetailItem : (EventItem) -> Unit,
    searchField : String,
    onSearchFieldChange: (String) -> Unit,
    onDoneKeyboardPressed: () -> Unit,
    listOfMeetingsAll: List<EventItem>,
    listOfMeetingsActive: List<EventItem>,
    modifier: Modifier = Modifier
){
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { EventsAllTabs.entries.size})
    val selectedTabIndex by remember { derivedStateOf { pagerState.currentPage } }

    Column(
        modifier = modifier
    ) {
        MySearchBar(
            value = searchField ,
            onValueChange = onSearchFieldChange,
            onDoneKeyboardPressed = onDoneKeyboardPressed,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        TabRow(
            selectedTabIndex = selectedTabIndex,
            divider = {},
            indicator = { tabPositions ->
                TabRowDefaults.SecondaryIndicator(
                    modifier =  Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex]),
                    height = 2.dp,
                    color = DevMeetingAppTheme.colors.purple
                )
            },
            containerColor = Color.White,
            modifier = Modifier
        ) {
            EventsAllTabs.entries.forEachIndexed { index, currentTab ->
                Tab(
                    selected = selectedTabIndex == index,
                    selectedContentColor = DevMeetingAppTheme.colors.purple,
                    unselectedContentColor = DevMeetingAppTheme.colors.grayForTabs,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(currentTab.ordinal)
                        }
                    },
                    text = {
                        Text(
                            text = currentTab.text,
                            fontSize = DevMeetingAppTheme.typography.bodyText1.fontSize,
                            fontWeight = FontWeight.Medium,
                            fontFamily = FontFamily.SansSerif,
                            modifier = Modifier,
                        )
                    },
                    modifier = Modifier
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(top = 16.dp),
            modifier = Modifier
                .fillMaxSize()
        ) { page ->
            when (page) {
                0 -> Events(
                    listOfMeetings = listOfMeetingsAll,
                    onEventItemClick = { navigateToEventDetailItem(it) }
                )
                1 -> Events(
                    listOfMeetings = listOfMeetingsActive,
                    onEventItemClick = { navigateToEventDetailItem(it) }
                )
            }
        }
    }
}

@Composable
fun Events(
    listOfMeetings : List<EventItem>,
    onEventItemClick : (EventItem) -> Unit,
    modifier : Modifier = Modifier
){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items (listOfMeetings){ event ->
            EventCard(
                eventName = event.eventName,
                eventStatus = event.eventStatus.status,
                eventDate = event.eventDate,
                eventPlace = event.eventPlace,
                eventCategories = event.eventCategory,
                eventIconURL = event.eventIconURL,
                onEventItemClick  = { onEventItemClick(event) },
                modifier = Modifier
            )
        }
    }
}