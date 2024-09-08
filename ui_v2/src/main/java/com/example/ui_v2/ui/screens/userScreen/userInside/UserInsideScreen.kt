package com.example.ui_v2.ui.screens.userScreen.userInside

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.R
import com.example.ui_v2.models.CommunityModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.models.UserModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.EvensFixBlockCarousel
import com.example.ui_v2.ui.components.TextButton
import com.example.ui_v2.ui.components.UserCommunitiesFixBlockCarousel
import com.example.ui_v2.ui.components.UserDescriptionBlockInside
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import org.koin.androidx.compose.koinViewModel


internal object UserInsideScreenDestination : NavigationDestination {
    override val route = "user_inside_screen"
}

@Composable
internal fun UserInsideScreen(
    navigateBack: () -> Unit,
    onEditClick: () -> Unit,
    onNetworkIconClick: (String?) -> Unit,
    navigateToEvent: (EventModelUI) -> Unit,
    navigateToCommunity: (CommunityModelUI) -> Unit,
    viewModel: UserInsideScreenViewModel = koinViewModel(),
) {
    val userInsideScreenUiState by viewModel.getUserInsideScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        UserInsideScreenBody(
            user = userInsideScreenUiState.user,
            onArrowClick = navigateBack,
            onEditClick = onEditClick,
            onNetworkIconClick = onNetworkIconClick,
            onEventCardClick = navigateToEvent,
            onCommunityClick = navigateToCommunity,
            onExitButtonClick = {},
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun UserInsideScreenBody(
    user: UserModelUI,
    onArrowClick: () -> Unit,
    onEditClick: () -> Unit,
    onNetworkIconClick: (String?) -> Unit,
    onEventCardClick: (EventModelUI) -> Unit,
    onCommunityClick: (CommunityModelUI) -> Unit,
    onExitButtonClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    LazyColumn(
        contentPadding = PaddingValues(
            bottom = 28.dp
        ),
        verticalArrangement = Arrangement.spacedBy(40.dp),
        modifier = modifier
    ) {
        item {
            UserDescriptionBlockInside(
                user = user,
                onArrowClick = onArrowClick,
                onEditClick = onEditClick,
                onNetworkIconClick = onNetworkIconClick,
                modifier = Modifier
            )
        }
        item {
            EvensFixBlockCarousel(
                blockText = stringResource(id = R.string.my_events),
                blockEventsList = user.userEventsList,
                onEventCardClick = onEventCardClick,
                contentPadding = PaddingValues(horizontal = DevMeetingAppTheme.dimensions.paddingMedium),
                modifier = Modifier
            )
        }
        item {
            UserCommunitiesFixBlockCarousel(
                communitiesList = user.userCommunitiesList,
                onCommunityClick = onCommunityClick,
                contentPadding = PaddingValues(horizontal = DevMeetingAppTheme.dimensions.paddingMedium),
                modifier = Modifier
                    .padding(
                        top = 40.dp
                    )
            )
        }
        item {
            TextButton(
                buttonText = stringResource(id = R.string.exit),
                onButtonClick = onExitButtonClick,
                contentColor = DevMeetingAppTheme.colors.eventCardText,
                modifier = Modifier
            )
        }
    }
}