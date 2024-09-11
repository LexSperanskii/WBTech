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
import com.example.ui_v2.models.CountryModelUI
import com.example.ui_v2.models.SocialMediaModelUI
import com.example.ui_v2.navigation.NavigationDestination
import com.example.ui_v2.ui.components.TextButton
import com.example.ui_v2.ui.components.UserAvatarBlock
import com.example.ui_v2.ui.components.UserInfoBlock
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
    onChangePhotoClick: () -> Unit,
    navigateToUserInsideScreen: () -> Unit,
    navigateToInterestsScreen: () -> Unit,
    navigateToDeleteProfile: () -> Unit,
    viewModel: ProfileEditScreenViewModel = koinViewModel(),
) {
    val profileEditScreenUiState by viewModel.getProfileEditScreenUiStateFlow()
        .collectAsStateWithLifecycle()

    Scaffold { innerPadding ->
        ProfileEditScreenBody(
            avatarURL = profileEditScreenUiState.avatarURL,
            onCrossClick = navigateBack,
            onDoneClick = {
                viewModel.safeNewSettings()
                navigateToUserInsideScreen()
            },
            onChangePhotoClick = onChangePhotoClick,
            nameSurnameValue = profileEditScreenUiState.nameSurname,
            isNameSurnameValid = profileEditScreenUiState.isNameSurnameValid,
            onNameSurnameChange = {
                viewModel.onNameSurnameChange(it)
            },
            number = profileEditScreenUiState.number,
            onNumberChange = {
                viewModel.onNumberChange(it)
            },
            countryCode = profileEditScreenUiState.countryCode,
            onCountryCodeChange = {
                viewModel.onCountryCodeChange(it)
            },
            listOfCountriesCodes = profileEditScreenUiState.listOfCountriesCodes,
            cityValue = profileEditScreenUiState.city,
            isCityValid = profileEditScreenUiState.isCityValid,
            onCityChange = {
                viewModel.onCityChange(it)
            },
            aboutUserValue = profileEditScreenUiState.aboutUser,
            isAboutUserValid = profileEditScreenUiState.isAboutUserValid,
            onAboutUserChange = {
                viewModel.onAboutUserChange(it)
            },
            listOfUserTags = profileEditScreenUiState.listOfUserTags,
            onTagChangeClick = {
                navigateToInterestsScreen()
            },
            listOfSocialMedia = profileEditScreenUiState.listOfSocialMedia,
            onSocialNetworkValueChange = { id, value ->
                viewModel.onSocialNetworkValueChange(id = id, value = value)
            },
            showMyCommunitiesChecked = profileEditScreenUiState.showMyCommunitiesChecked,
            onShowMyCommunitiesChange = {
                viewModel.onShowMyCommunitiesChange(it)
            },
            showMyEventsChecked = profileEditScreenUiState.showMyEventsChecked,
            onShowMyEventsChange = {
                viewModel.onShowMyEventsChange(it)
            },
            applyNotificationsChecked = profileEditScreenUiState.applyNotificationsChecked,
            onApplyNotificationsChange = {
                viewModel.onApplyNotificationsChange(it)
            },
            onDeleteProfileButtonClick = {
                navigateToDeleteProfile()
            },
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
    listOfSocialMedia: List<SocialMediaModelUI>,
    onSocialNetworkValueChange: (id: String, value: String) -> Unit,
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
            UserInfoBlock(
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
                listOfSocialMedia = listOfSocialMedia,
                onSocialNetworkValueChange = onSocialNetworkValueChange,
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