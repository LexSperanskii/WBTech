package com.example.ui_v1.ui.communities.communitiesScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.ui_v1.R
import com.example.ui_v1.models.UIv1CommunityModelUI
import com.example.ui_v1.navigation.UIv1NavigationDestination
import com.example.ui_v1.ui.elements.BottomNavigationBar
import com.example.ui_v1.ui.elements.CommunityCard
import com.example.ui_v1.ui.elements.MySearchBar
import com.example.ui_v1.ui.elements.TopAppBarBackNameAction
import org.koin.androidx.compose.koinViewModel

internal object CommunitiesDestinationUIv1 : UIv1NavigationDestination {
    override val route = "communities"
    override val title = R.string.communities
}

@Composable
internal fun CommunityScreen(
    navController: NavHostController,
    navigateToCommunityDetailItem: (Int) -> Unit,
    viewModel: CommunitiesViewModel = koinViewModel()
){

    val communitiesScreenUiState by viewModel.getCommunitiesScreenUiStateFlow().collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBarBackNameAction(
                title = stringResource(id = CommunitiesDestinationUIv1.title),
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
    listOfCommunities: List<UIv1CommunityModelUI>,
    onCommunityItemClick: (Int) -> Unit,
    searchField: String,
    onSearchFieldChange: (String) -> Unit,
    onDoneKeyboardPressed: () -> Unit,
    modifier: Modifier = Modifier,
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
                    onCommunityItemClick = { onCommunityItemClick(communityModelUI.id) }
                )
            }
        }
    }
}