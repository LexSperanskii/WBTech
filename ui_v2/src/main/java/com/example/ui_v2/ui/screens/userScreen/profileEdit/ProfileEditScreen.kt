package com.example.ui_v2.ui.screens.userScreen.profileEdit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
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
            avatarURL = profileEditScreenUiState.clientCash.imageURL,
            onCrossClick = {
                navigateBack()
            },
            isCanSave = profileEditScreenUiState.isNumberValid &&
                    profileEditScreenUiState.isNameSurnameValid &&
                    profileEditScreenUiState.isCountryCodeValid,
            onDoneClick = {
                viewModel.saveNewSettings()
                navigateToUserInsideScreen()
            },
            onChangePhotoClick = {
                onChangePhotoClick()
            },
            nameSurnameValue = profileEditScreenUiState.clientCash.nameSurname,
            isNameSurnameValid = profileEditScreenUiState.isNameSurnameValid,
            onNameSurnameChange = {
                viewModel.onNameSurnameChange(it)
            },
            number = profileEditScreenUiState.clientCash.phoneNumber.number,
            onNumberChange = {
                viewModel.onNumberChange(it)
            },
            isNumberValid = profileEditScreenUiState.isNumberValid,
            isCountryCodeValid = profileEditScreenUiState.isCountryCodeValid,
            countryCode = profileEditScreenUiState.clientCash.phoneNumber.country,
            onCountryCodeChange = {
                viewModel.onCountryCodeChange(it)
            },
            listOfCountriesCodes = profileEditScreenUiState.listOfCountriesCodes,
            cityValue = profileEditScreenUiState.clientCash.city,
            isCityValid = profileEditScreenUiState.isCityValid,
            onCityChange = {
                viewModel.onCityChange(it)
            },
            descriptionValue = profileEditScreenUiState.clientCash.description,
            isDescriptionValid = profileEditScreenUiState.isDescriptionValid,
            onDescriptionChange = {
                viewModel.onDescriptionChange(it)
            },
            listOfUserTags = profileEditScreenUiState.clientCash.listOfClientTags,
            onTagChangeClick = {
                navigateToInterestsScreen()
            },
            listOfSocialMedia = profileEditScreenUiState.clientCash.listOfClientSocialMedia,
            onSocialNetworkValueChange = { socialMediaID, value ->
                viewModel.onSocialNetworkValueChange(socialMediaID = socialMediaID, value = value)
            },
            onAddSocialNetworkClick = {
                viewModel.onAddSocialNetworkClick()
            },
            showMyCommunitiesChecked = profileEditScreenUiState.clientCash.isShowMyCommunities,
            onShowMyCommunitiesChange = {
                viewModel.onShowMyCommunitiesChange(it)
            },
            showMyEventsChecked = profileEditScreenUiState.clientCash.isShowMyEvents,
            onShowMyEventsChange = {
                viewModel.onShowMyEventsChange(it)
            },
            applyNotificationsChecked = profileEditScreenUiState.clientCash.isApplyNotifications,
            onApplyNotificationsChange = {
                viewModel.onApplyNotificationsChange(it)
            },
            onDeleteProfileButtonClick = {
                navigateToDeleteProfile()
            },
            isShowDeleteButton = profileEditScreenUiState.isClientExist,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
internal fun ProfileEditScreenBody(
    avatarURL: String?,
    onCrossClick: () -> Unit,
    onDoneClick: () -> Unit,
    isCanSave: Boolean,
    onChangePhotoClick: () -> Unit,
    nameSurnameValue: String,
    isNameSurnameValid: Boolean,
    onNameSurnameChange: (String) -> Unit,
    number: String,
    onNumberChange: (String) -> Unit,
    isNumberValid: Boolean,
    isCountryCodeValid: Boolean,
    countryCode: CountryModelUI,
    onCountryCodeChange: (CountryModelUI) -> Unit,
    listOfCountriesCodes: List<CountryModelUI>,
    cityValue: String,
    isCityValid: Boolean,
    onCityChange: (String) -> Unit,
    descriptionValue: String,
    isDescriptionValid: Boolean,
    onDescriptionChange: (String) -> Unit,
    listOfUserTags: List<String>,
    onTagChangeClick: () -> Unit,
    listOfSocialMedia: List<SocialMediaModelUI>,
    onSocialNetworkValueChange: (socialMediaID: String, value: String) -> Unit,
    onAddSocialNetworkClick: () -> Unit,
    showMyCommunitiesChecked: Boolean,
    onShowMyCommunitiesChange: (Boolean) -> Unit,
    showMyEventsChecked: Boolean,
    onShowMyEventsChange: (Boolean) -> Unit,
    applyNotificationsChecked: Boolean,
    onApplyNotificationsChange: (Boolean) -> Unit,
    onDeleteProfileButtonClick: () -> Unit,
    isShowDeleteButton: Boolean,
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
                isCanSave = isCanSave,
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
                isNumberValid = isNumberValid,
                isCountryCodeValid = isCountryCodeValid,
                countryCode = countryCode,
                onCountryCodeChange = onCountryCodeChange,
                listOfCountriesCodes = listOfCountriesCodes,
                cityValue = cityValue,
                isCityValid = isCityValid,
                onCityChange = onCityChange,
                aboutUserValue = descriptionValue,
                isAboutUserValid = isDescriptionValid,
                onAboutUserChange = onDescriptionChange,
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
                onAddSocialNetworkClick = onAddSocialNetworkClick
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
        if (isShowDeleteButton) {
            item {
                TextButton(
                    buttonText = stringResource(id = R.string.delete_profile),
                    onButtonClick = onDeleteProfileButtonClick,
                    contentColor = DevMeetingAppTheme.colors.red,
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }
    }
}