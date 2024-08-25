package com.example.spa_wb_junior_devmeetingapp.ui.oldUI.menu.profileScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.models.PhoneNumberModelUI
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.PersonAvatar
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.TopAppBarForProfile
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.elements.buttons.CustomSocialMedeaButtonOutlined
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DevMeetingAppTheme
import com.example.spa_wb_junior_devmeetingapp.ui.utils.UiUtils.formattedMobileNumber
import org.koin.androidx.compose.koinViewModel

internal object ProfileDestination : NavigationDestination {
    override val route = "profile"
    override val title = R.string.profile
}

internal enum class SocialMedia(val icon: Int) {
    Twitter(R.drawable.label_twitter),
    Instagram(R.drawable.label_instagram),
    LinkedIn(R.drawable.label_linkedin),
    Facebook(R.drawable.label_facebook)
}

@Composable
internal fun ProfileScreen(
    navController: NavHostController,
    viewModel: ProfileViewModel = koinViewModel()
) {

    val profileScreenUiState by viewModel.getProfileScreenUiStateFlow().collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBarForProfile(
                title = stringResource(id = ProfileDestination.title),
                onClickNavigateBack = { navController.popBackStack() },
                onEditClick = {}
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { innerPadding ->
        ProfileBody(
            name = profileScreenUiState.user.name,
            surname = profileScreenUiState.user.surname,
            mobileNumber = profileScreenUiState.user.phoneNumberModelUI,
            avatarURL = profileScreenUiState.user.iconURL,
            onSocialMedeaButtonClick = {},
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        )
    }
}

@Composable
internal fun ProfileBody(
    name: String,
    surname: String,
    mobileNumber: PhoneNumberModelUI,
    avatarURL : String?,
    onSocialMedeaButtonClick: (SocialMedia)->Unit,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        PersonAvatar(
            size = DevMeetingAppTheme.dimensions.avatarL,
            imageURL = avatarURL,
            isEdit = false,
            modifier = Modifier. padding(top = 136.dp)
        )
        Text(
            text = stringResource(id = R.string.name_surname,name,surname ),
            style = DevMeetingAppTheme.typography.heading2,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(top = 20.dp)
        )
        Text(
            text = formattedMobileNumber(mobileNumber),
            style = DevMeetingAppTheme.typography.subheading2,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(top = 4.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(top = 40.dp)
        ) {
            SocialMedia.entries.forEach { socialMedia ->
                CustomSocialMedeaButtonOutlined(
                    onClick = {onSocialMedeaButtonClick(socialMedia)},
                    modifier = Modifier,
                    pressedColor = DevMeetingAppTheme.colors.darkPurple,
                    contentColor = DevMeetingAppTheme.colors.purple,
                    icon = painterResource(id = socialMedia.icon)
                )
            }
        }
    }
}