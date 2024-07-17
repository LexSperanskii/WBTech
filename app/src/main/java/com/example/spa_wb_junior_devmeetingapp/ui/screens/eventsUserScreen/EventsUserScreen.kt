package com.example.spa_wb_junior_devmeetingapp.ui.screens.eventsUserScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
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
import androidx.navigation.NavHostController
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.data.mockData.mockEventsListUserPassed
import com.example.spa_wb_junior_devmeetingapp.data.mockData.mockEventsListUserPlanned
import com.example.spa_wb_junior_devmeetingapp.model.EventItem
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TopAppBarBackNameAction
import com.example.spa_wb_junior_devmeetingapp.ui.screens.eventsAllScreen.Events
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.GrayForTabs
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Purple
import kotlinx.coroutines.launch

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
    navigateToEventDetailItem : (EventItem) -> Unit
) {
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
    navigateToEventDetailItem : (EventItem) -> Unit,
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
                    color = Purple
                )
            },
            containerColor = Color.White,
            modifier = Modifier
        ) {
            EventsUserTabs.entries.forEachIndexed { index, currentTab ->
                Tab(
                    selected = selectedTabIndex == index,
                    selectedContentColor = Purple,
                    unselectedContentColor = GrayForTabs,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(currentTab.ordinal)
                        }
                    },
                    text = {
                        Text(
                            text = currentTab.text,
                            fontSize = MaterialTheme.typography.BodyText1.fontSize,
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
                    listOfMeetings = mockEventsListUserPlanned,
                    onEventItemClick = { navigateToEventDetailItem(it) }
                )
                1 -> Events(
                    listOfMeetings = mockEventsListUserPassed,
                    onEventItemClick = { navigateToEventDetailItem(it) }
                )
            }
        }
    }
}
