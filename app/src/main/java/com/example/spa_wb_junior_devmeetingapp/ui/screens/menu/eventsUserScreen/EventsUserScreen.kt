package com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.eventsUserScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import com.example.spa_wb_junior_devmeetingapp.models.EventModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TopAppBarBackNameAction
import com.example.spa_wb_junior_devmeetingapp.ui.screens.events.eventsAllScreen.Events
import com.example.spa_wb_junior_devmeetingapp.ui.screens.events.eventsAllScreen.EventsAllTabs
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

object EventsUserDestination : NavigationDestination {
    override val route = "events_user"
    override val title = R.string.events_user
}

enum class EventsUserTabs(val text: String){
    Planned(text = "ЗАПЛАНИРОВАНО"),
    HasPassed(text = "УЖЕ ПРОШЛИ")
}

@Composable
fun EventsUserScreen(
    navController: NavHostController,
    navigateToEventDetailItem : (EventModelUI) -> Unit,
    viewModel: EventsUserViewModel = koinViewModel()
) {

    val eventsUserScreenUiState by viewModel.getEventsUserScreenUiStateFlow().collectAsState()

    Scaffold(
        topBar = {
            TopAppBarBackNameAction(
                title = stringResource(id = EventsUserDestination.title),
                isAddCapable = false,
                onClickNavigateBack = {navController.popBackStack()}
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { innerPadding ->
        EventsUserBody(
            listOfMeetingsScheduled = eventsUserScreenUiState.listOfMeetingsScheduled,
            listOfMeetingsPast = eventsUserScreenUiState.listOfMeetingsPast,
            navigateToEventDetailItem = navigateToEventDetailItem,
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
fun EventsUserBody(
    navigateToEventDetailItem : (EventModelUI) -> Unit,
    listOfMeetingsScheduled: List<EventModelUI>,
    listOfMeetingsPast: List<EventModelUI>,
    modifier: Modifier = Modifier
){
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { EventsUserTabs.entries.size})
    val selectedTabIndex by remember { derivedStateOf { pagerState.currentPage } }

    Column(
        modifier = modifier
    ) {
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
            EventsUserTabs.entries.forEachIndexed { index, currentTab ->
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
            when (EventsUserTabs.entries[page]) {
                EventsUserTabs.Planned -> Events(
                    listOfMeetings = listOfMeetingsScheduled,
                    onEventItemClick = { navigateToEventDetailItem(it) }
                )
                EventsUserTabs.HasPassed -> Events(
                    listOfMeetings = listOfMeetingsPast,
                    onEventItemClick = { navigateToEventDetailItem(it) }
                )
            }
        }
    }
}
