package com.example.spa_wb_junior_devmeetingapp.ui.screens.communities.communitiesScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.models.CommunityModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.CommunityCard
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.MySearchBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TopAppBarBackNameAction
import org.koin.androidx.compose.koinViewModel

internal object CommunitiesDestination : NavigationDestination {
    override val route = "communities"
    override val title = R.string.communities
}

@Composable
internal fun CommunityScreen(
    navController: NavHostController,
    navigateToCommunityDetailItem: () -> Unit,
    viewModel: CommunitiesViewModel = koinViewModel()
){

    val communitiesScreenUiState by viewModel.getCommunitiesScreenUiStateFlow().collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBarBackNameAction(
                title = stringResource(id = CommunitiesDestination.title),
                isNavigateBack = false,
                isAddCapable = false
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { innerPadding ->

        CommunityBody(
            listOfCommunities = communitiesScreenUiState.listOfCommunities,
            onCommunityItemClick = navigateToCommunityDetailItem,
            searchField = communitiesScreenUiState.search,
            onSearchFieldChange = {
                viewModel.onSearchChange(it)
            },
            onDoneKeyboardPressed = {},
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
internal fun CommunityBody(
    listOfCommunities: List<CommunityModelUI>,
    onCommunityItemClick: () -> Unit,
    searchField : String,
    onSearchFieldChange: (String) -> Unit,
    onDoneKeyboardPressed: () -> Unit,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
    ) {
        MySearchBar(
            value = searchField ,
            onValueChange = onSearchFieldChange,
            onDoneKeyboardPressed = onDoneKeyboardPressed,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
        ) {
            items (listOfCommunities) { communityModelUI ->
                CommunityCard(
                    communityName = communityModelUI.name,
                    communitySize = communityModelUI.size,
                    communityIconURL = communityModelUI.iconURL,
                    onCommunityItemClick = onCommunityItemClick
                )
            }
        }
    }
}