package com.example.ui_v2.ui.screens.userScreen.deleteProfile

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.ui_v2.R
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.ButtonWithStatus
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import com.example.ui_v2.ui.utils.ButtonStatus
import org.koin.androidx.compose.koinViewModel


internal object DeleteProfileScreenDestination : NavigationDestination {
    override val route = "delete_profile_screen"
}

@Composable
internal fun DeleteProfileScreen(
    navigateBack: () -> Unit,
    onDeleteClick: () -> Unit,
    onNoNeedClick: () -> Unit,
    viewModel: DeleteProfileScreenViewModel = koinViewModel(),
) {
    val deleteProfileScreenUiState by viewModel.getDeleteProfileScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        DeleteProfileScreenBody(
            onCrossClick = navigateBack,
            onDeleteClick = onDeleteClick,
            onNoNeedClick = onNoNeedClick,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun DeleteProfileScreenBody(
    onCrossClick: () -> Unit,
    onDeleteClick: () -> Unit,
    onNoNeedClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
            .padding(
                top = 20.dp,
                bottom = 28.dp,
                start = DevMeetingAppTheme.dimensions.paddingMedium,
                end = DevMeetingAppTheme.dimensions.paddingMedium
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(bottom = 14.dp)
        ) {
            Text(
                text = stringResource(id = R.string.delete_profile_header),
                style = DevMeetingAppTheme.typography.customH3,
                color = DevMeetingAppTheme.colors.black,
                modifier = Modifier
                    .weight(1f)
            )
            Icon(
                painter = painterResource(id = R.drawable.icon_cross),
                contentDescription = stringResource(id = R.string.icon),
                tint = DevMeetingAppTheme.colors.disabledButtonTextGray,
                modifier = Modifier
                    .size(28.dp)
                    .clickable {
                        onCrossClick()
                    }
            )
        }
        Text(
            text = stringResource(R.string.delete_profile_description),
            color = DevMeetingAppTheme.colors.black,
            style = DevMeetingAppTheme.typography.subheading1,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.weight(1f))

        ButtonWithStatus(
            notPressedText = stringResource(id = R.string.delete_profile_delete),
            isButtonEnabled = true,
            onClick = onDeleteClick,
            buttonStatus = ButtonStatus.Pressed
        )
        ButtonWithStatus(
            notPressedText = stringResource(id = R.string.delete_profile_no_need),
            isButtonEnabled = true,
            onClick = onNoNeedClick,
            buttonStatus = ButtonStatus.Active
        )
    }

}