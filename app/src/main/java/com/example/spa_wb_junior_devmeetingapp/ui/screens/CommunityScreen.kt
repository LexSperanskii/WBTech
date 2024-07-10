package com.example.spa_wb_junior_devmeetingapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.mockData.MockCommunityItem
import com.example.spa_wb_junior_devmeetingapp.ui.mockData.mockListOfCommunities
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.CommunityCard
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.MySearchBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TopAppBarBackNameAction

object CommunityDestination : NavigationDestination {
    override val route = "community"
    override val title = R.string.community
}

@Composable
fun CommunityScreen(
    navController: NavHostController,
    navigateToCommunityDetailItem: (MockCommunityItem) -> Unit
){
    Scaffold(
        topBar = {
            TopAppBarBackNameAction(
                title = stringResource(id = CommunityDestination.title),
                isNavigateBack = false,
                isAdd = false
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { innerPadding ->
        CommunityBody(
            listOfCommunities = mockListOfCommunities,
            onCommunityItemClick = { navigateToCommunityDetailItem(it) },
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

@Composable
fun CommunityBody(
    listOfCommunities: List<MockCommunityItem>,
    onCommunityItemClick: (MockCommunityItem) -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        MySearchBar(
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
        ) {
            items (listOfCommunities){ communityItem ->
                CommunityCard(
                    communityName = communityItem.communityName,
                    communitySize = communityItem.communitySize,
                    communityIconURL = communityItem.communityIconURL,
                    onCommunityItemClick = { onCommunityItemClick(communityItem) }
                )
            }
        }
    }
}