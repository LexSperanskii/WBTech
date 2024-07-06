package com.example.spa_wb_junior_devmeetingapp.ui.screens

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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.EventsAllTabs
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.EventCard
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.MySearchBar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.GrayForTabs
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Purple
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun EventsAllScreen(
    navController: NavHostController
) {
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = { EventsAllTabs.entries.size})
    val selectedTabIndex by remember { derivedStateOf { pagerState.currentPage } }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(
                    start = 24.dp,
                    end = 24.dp,
                    top = 16.dp
                )
        ) {
            MySearchBar(
                modifier = Modifier.padding(bottom = 16.dp)
            )
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
                EventsAllTabs.entries.forEachIndexed { index, currentTab ->
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
                    0 -> EventsAllBody(
                        listOfMeetings = mockListOfEvents
                    )
                    1 -> Stab()
                }
            }
        }
    }
}

@Composable
fun EventsAllBody(
    listOfMeetings: List<MockEvent>
){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
    ) {
        items (listOfMeetings){ event ->
            EventCard(
                eventName = event.eventName,
                eventStatus = event.eventStatus.status,
                eventDate = event.eventDate,
                eventPlace = event.eventPlace,
                eventCategories = event.eventCategory,
                eventIconURL = event.eventIconURL,
                modifier = Modifier
            )
        }
    }
}