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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.CommunityCard
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.EventCard
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.MySearchBar

@Composable
fun CommunityScreen(
    navController: NavHostController
){
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
            CommunityBody(
                listOfCommunities = mockListOfCommunities
            )
        }
    }
}

@Composable
fun CommunityBody(
    listOfCommunities: List<MockCommunity>
){
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier
    ) {
        items (listOfCommunities){ community ->
            CommunityCard(
                communityName = community.communityName ,
                communitySize = community.communitySize,
                communityIconURL = community.communityIconURL,
            )
        }
    }
}