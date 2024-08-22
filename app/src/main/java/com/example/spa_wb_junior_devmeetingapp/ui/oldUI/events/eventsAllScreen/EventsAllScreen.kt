package com.example.spa_wb_junior_devmeetingapp.ui.oldUI.events.eventsAllScreen

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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.models.EventModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.EventCard
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.MySearchBar
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.TopAppBarBackNameAction
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

internal object EventsAllDestination : NavigationDestination {
    override val route = "events_all"
    override val title = R.string.events_all
}

internal enum class EventsAllTabs(val text: String){
    AllMeetings(text = "ВСЕ ВСТРЕЧИ"),
    Active(text = "АКТИВНЫЕ")
}

@Composable
internal fun EventsAllScreen(
    navController: NavHostController,
    navigateToEventDetailItem: (Int) -> Unit,
    navigateToDeveloperScreen : () -> Unit,
    viewModel: EventsAllViewModel = koinViewModel()
) {

    val eventsAllScreenUiState by viewModel.getEventsAllScreenUiStateFlow().collectAsStateWithLifecycle()

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
internal fun EventsBody(
    navigateToEventDetailItem: (Int) -> Unit,
    searchField : String,
    onSearchFieldChange: (String) -> Unit,
    onDoneKeyboardPressed: () -> Unit,
    listOfMeetingsAll: List<EventModelUI>,
    listOfMeetingsActive: List<EventModelUI>,
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
            when (EventsAllTabs.entries[page]) {
                EventsAllTabs.AllMeetings -> Events(
                    listOfMeetings = listOfMeetingsAll,
                    onEventItemClick =  navigateToEventDetailItem
                )
                EventsAllTabs.Active -> Events(
                    listOfMeetings = listOfMeetingsActive,
                    onEventItemClick = navigateToEventDetailItem
                )
            }
        }
    }
}

@Composable
internal fun Events(
    listOfMeetings : List<EventModelUI>,
    onEventItemClick: (Int) -> Unit,
    modifier : Modifier = Modifier
){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.fillMaxSize()
    ) {
        items (listOfMeetings){ event ->
            EventCard(
                eventName = event.name,
                isEventFinished = event.isFinished,
                eventDate = event.date,
                eventCity = event.city,
                eventCategories = event.category,
                eventIconURL = event.iconURL,
                onEventItemClick = { onEventItemClick(event.id) },
                modifier = Modifier
            )
        }
    }
}