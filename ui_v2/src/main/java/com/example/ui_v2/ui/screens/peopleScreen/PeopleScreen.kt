package com.example.ui_v2.ui.screens.peopleScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.R
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.BackBar
import com.example.ui_v2.ui.components.PersonCard
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import org.koin.androidx.compose.koinViewModel


internal object PeopleScreenDestination : NavigationDestination {
    override val route = "people_screen"
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@Composable
internal fun PeopleScreen(
    onArrowBackClick: () -> Unit,
    navigateToPersonScreen: () -> Unit,
    viewModel: PeopleScreenViewModel = koinViewModel(),
) {
    val peopleScreenUiState by viewModel.getPeopleScreenUiStateFlow().collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        PeopleScreenBody(
            onArrowBackClick = onArrowBackClick,
            onPersonCardClick = navigateToPersonScreen,
            listOfUsers = peopleScreenUiState.listOfUsers,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun PeopleScreenBody(
    onArrowBackClick: () -> Unit,
    onPersonCardClick: () -> Unit,
    listOfUsers: List<UserModelUI>,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(
                start = DevMeetingAppTheme.dimensions.paddingMedium,
                end = DevMeetingAppTheme.dimensions.paddingMedium,
                top = 12.dp
            )
    ) {
        BackBar(
            barText = stringResource(id = R.string.go_to_the_meeting),
            onArrowClick = onArrowBackClick,
            modifier = Modifier
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = PaddingValues(
                top = 8.dp,
                bottom = 12.dp
            ),
            verticalArrangement = Arrangement.spacedBy(25.dp),
            horizontalArrangement = Arrangement.spacedBy(25.dp),
            modifier = Modifier
        ) {
            items(listOfUsers) { user ->
                PersonCard(
                    person = user,
                    onPersonCardClick = onPersonCardClick
                )
            }
        }
    }
}