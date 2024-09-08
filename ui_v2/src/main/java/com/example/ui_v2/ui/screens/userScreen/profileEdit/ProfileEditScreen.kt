package com.example.ui_v2.ui.screens.userScreen.profileEdit

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
import com.example.ui_v2.models.CountryModelUI
import com.example.ui_v2.models.EventModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.TextButton
import com.example.ui_v2.ui.components.UserAvatarBlock
import com.example.ui_v2.ui.components.UserInfoClock
import com.example.ui_v2.ui.components.UserInterestsBlock
import com.example.ui_v2.ui.components.UserSocialNetworkBlock
import com.example.ui_v2.ui.components.UserSwitchBlock
import com.example.ui_v2.ui.theme.DevMeetingAppTheme
import org.koin.androidx.compose.koinViewModel


internal object ProfileEditScreenDestination : NavigationDestination {
    override val route = "profile_edit_screen"
}

@Composable
internal fun ProfileEditScreen(
    navigateBack: () -> Unit,
    onEditClick: () -> Unit,
    onNetworkIconClick: (String?) -> Unit,
    navigateToEvent: (EventModelUI) -> Unit,
    navigateToCommunity: (CommunityModelUI) -> Unit,
    viewModel: ProfileEditScreenViewModel = koinViewModel(),
) {
    val profileEditScreenUiState by viewModel.getProfileEditScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        ProfileEditScreenBody(
            avatarURL =,
            onCrossClick = { /*TODO*/ },
            onDoneClick = { /*TODO*/ },
            onChangePhotoClick = { /*TODO*/ },
            nameSurnameValue =,
            isNameSurnameValid =,
            onNameSurnameChange =,
            number =,
            onNumberChange =,
            countryCode =,
            onCountryCodeChange =,
            listOfCountriesCodes =,
            cityValue =,
            isCityValid =,
            onCityChange =,
            aboutUserValue =,
            isAboutUserValid =,
            onAboutUserChange =,
            listOfUserTags =,
            onTagChangeClick = { /*TODO*/ },
            firstSocialNetworkValue =,
            onFirstSocialNetworkValueChange =,
            firstSocialNetworkURL =,
            firstSocialNetworkName =,
            secondSocialNetworkValue =,
            onSecondSocialNetworkValueChange =,
            secondSocialNetworkURL =,
            secondSocialNetworkName =,
            showMyCommunitiesChecked =,
            onShowMyCommunitiesChange =,
            showMyEventsChecked =,
            onShowMyEventsChange =,
            applyNotificationsChecked =,
            onApplyNotificationsChange =,
            onDeleteProfileButtonClick = { /*TODO*/ },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun ProfileEditScreenBody(
    avatarURL: String?,
    onCrossClick: () -> Unit,
    onDoneClick: () -> Unit,
    onChangePhotoClick: () -> Unit,

    nameSurnameValue: String,
    isNameSurnameValid: Boolean,
    onNameSurnameChange: (String) -> Unit,
    number: String,
    onNumberChange: (String) -> Unit,
    countryCode: CountryModelUI,
    onCountryCodeChange: (CountryModelUI) -> Unit,
    listOfCountriesCodes: List<CountryModelUI>,
    cityValue: String,
    isCityValid: Boolean,
    onCityChange: (String) -> Unit,
    aboutUserValue: String,
    isAboutUserValid: Boolean,
    onAboutUserChange: (String) -> Unit,

    listOfUserTags: List<String>,
    onTagChangeClick: () -> Unit,

    firstSocialNetworkValue: String,
    onFirstSocialNetworkValueChange: (String) -> Unit,
    firstSocialNetworkURL: String?,
    firstSocialNetworkName: String,
    secondSocialNetworkValue: String,
    onSecondSocialNetworkValueChange: (String) -> Unit,
    secondSocialNetworkURL: String?,
    secondSocialNetworkName: String,

    showMyCommunitiesChecked: Boolean,
    onShowMyCommunitiesChange: (Boolean) -> Unit,
    showMyEventsChecked: Boolean,
    onShowMyEventsChange: (Boolean) -> Unit,
    applyNotificationsChecked: Boolean,
    onApplyNotificationsChange: (Boolean) -> Unit,

    onDeleteProfileButtonClick: () -> Unit,
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
            UserAvatarBlock(
                avatarURL = avatarURL,
                onCrossClick = onCrossClick,
                onDoneClick = onDoneClick,
                onChangePhotoClick = onChangePhotoClick
            )
        }
        item {
            UserInfoClock(
                nameSurnameValue = nameSurnameValue,
                isNameSurnameValid = isNameSurnameValid,
                onNameSurnameChange = onNameSurnameChange,
                number = number,
                onNumberChange = onNumberChange,
                countryCode = countryCode,
                onCountryCodeChange = onCountryCodeChange,
                listOfCountriesCodes = listOfCountriesCodes,
                cityValue = cityValue,
                isCityValid = isCityValid,
                onCityChange = onCityChange,
                aboutUserValue = aboutUserValue,
                isAboutUserValid = isAboutUserValid,
                onAboutUserChange = onAboutUserChange,
                modifier = Modifier
            )
        }
        item {
            UserInterestsBlock(
                listOfUserTags = listOfUserTags,
                onTagClick = onTagChangeClick,
                modifier = Modifier
            )
        }
        item {
            UserSocialNetworkBlock(
                firstSocialNetworkValue = firstSocialNetworkValue,
                onFirstSocialNetworkValueChange = onFirstSocialNetworkValueChange,
                firstSocialNetworkURL = firstSocialNetworkURL,
                firstSocialNetworkName = firstSocialNetworkName,
                secondSocialNetworkValue = secondSocialNetworkValue,
                onSecondSocialNetworkValueChange = onSecondSocialNetworkValueChange,
                secondSocialNetworkURL = secondSocialNetworkURL,
                secondSocialNetworkName = secondSocialNetworkName
            )
        }
        item {
            UserSwitchBlock(
                showMyCommunitiesChecked = showMyCommunitiesChecked,
                onShowMyCommunitiesChange = onShowMyCommunitiesChange,
                showMyEventsChecked = showMyEventsChecked,
                onShowMyEventsChange = onShowMyEventsChange,
                applyNotificationsChecked = applyNotificationsChecked,
                onApplyNotificationsChange = onApplyNotificationsChange
            )
        }
        item {
            TextButton(
                buttonText = stringResource(id = R.string.delete_profile),
                onButtonClick = onDeleteProfileButtonClick,
                contentColor = DevMeetingAppTheme.colors.red,
                modifier = Modifier
            )
        }
    }
}