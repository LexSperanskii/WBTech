package com.example.ui_v2.ui.screens.onboarding.interestsScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
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

internal object InterestsScreenDestination : NavigationDestination {
    override val route = "interests_screen"
}

@Composable
internal fun InterestsScreen(
    navigateToLocationScreen: () -> Unit,
    viewModel: InterestsScreenViewModel = koinViewModel(),
) {
    val interestsScreenUiState by viewModel.getInterestsScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        InterestsScreenBody(
            listOfTags = interestsScreenUiState.listOfTags,
            listOfChosenTags = interestsScreenUiState.listOfChosenTags,
            onTagClick = {
                viewModel.onTagClick(it)
            },
            isButtonEnabled = interestsScreenUiState.isButtonEnabled,
            onButtonClick = {
                navigateToLocationScreen()
            },
            onTellLaterClick = { /*TODO*/ },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
internal fun InterestsScreenBody(
    listOfTags: List<String>,
    listOfChosenTags: List<String>,
    onTagClick: (String) -> Unit,
    isButtonEnabled: Boolean,
    onButtonClick: () -> Unit,
    onTellLaterClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val interactionSource = remember { MutableInteractionSource() }
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
            buttonStatus = ButtonStatus.Active,
            isButtonEnabled = isButtonEnabled,
            modifier = Modifier
                .padding(
                    top = 24.dp,
                    bottom = 16.dp
                )
        )
        Text(
            text = stringResource(id = R.string.interests_button_tell_later),
            color = DevMeetingAppTheme.colors.eventCardText,
            style = DevMeetingAppTheme.typography.bodyText1,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onTellLaterClick
                )
        )
    }
}