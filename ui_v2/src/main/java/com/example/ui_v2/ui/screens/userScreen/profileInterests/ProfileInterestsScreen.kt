package com.example.ui_v2.ui.screens.userScreen.profileInterests

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.R
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.ButtonWithStatus
import com.example.ui_v2.ui.components.TagBig
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus
import org.koin.androidx.compose.koinViewModel

internal object ProfileInterestsScreenDestination : NavigationDestination {
    override val route = "profile_interests_screen"
}

@Composable
internal fun ProfileInterestsScreen(
    navigateBack: () -> Unit,
    viewModel: ProfileInterestsScreenViewModel = koinViewModel(),
) {
    val profileInterestsScreenUiState by viewModel.getProfileInterestsScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        ProfileInterestsScreenBody(
            listOfTags = profileInterestsScreenUiState.listOfTags,
            listOfChosenTags = profileInterestsScreenUiState.listOfChosenTags,
            onTagClick = {
                viewModel.onTagClick(it)
            },
            isButtonEnabled = profileInterestsScreenUiState.isButtonEnabled,
            onButtonClick = {
                //TODO
                navigateBack()
            },
            buttonStatus = profileInterestsScreenUiState.buttonStatus,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun ProfileInterestsScreenBody(
    listOfTags: List<String>,
    listOfChosenTags: List<String>,
    onTagClick: (String) -> Unit,
    isButtonEnabled: Boolean,
    onButtonClick: () -> Unit,
    buttonStatus: ButtonStatus,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            end = 16.dp,
            top = 20.dp,
            bottom = 28.dp
        )
    ) {
        Text(
            text = stringResource(id = R.string.interests),
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.customH1,
            modifier = Modifier
                .padding(bottom = 12.dp)
        )
        Text(
            text = stringResource(id = R.string.interests_description),
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.subheading1,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            item {
                FlowRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    listOfTags.forEach {
                        TagBig(
                            tagText = it,
                            onTagClick = { onTagClick(it) },
                            isClicked = listOfChosenTags.contains(it)
                        )
                    }
                }
            }
        }
        ButtonWithStatus(
            notPressedText = stringResource(id = R.string.safe),
            onClick = onButtonClick,
            buttonStatus = buttonStatus,
            isButtonEnabled = isButtonEnabled,
            modifier = Modifier
        )
    }
}
