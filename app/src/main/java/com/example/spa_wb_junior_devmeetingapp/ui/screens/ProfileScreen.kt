package com.example.spa_wb_junior_devmeetingapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.PersonAvatar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TopAppBarForProfile
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons.CustomSocialMedeaButtonOutlined
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DarkPurple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Heading2
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Purple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Subheading2

object ProfileDestination : NavigationDestination {
    override val route = "profile"
    override val title = R.string.profile
}

enum class SocialMedia(val icon: Int) {
    Twitter(R.drawable.label_twitter),
    Instagram(R.drawable.label_instagram),
    LinkedIn(R.drawable.label_linkedin),
    Facebook(R.drawable.label_facebook)
}

@Composable
fun ProfileScreen(
    navController: NavHostController
) {
    Scaffold(
        topBar = {
            TopAppBarForProfile(
                title = stringResource(id = ProfileDestination.title),
                onClickNavigateBack = {navController.popBackStack()},
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
            name = "Иван Иванов",
            mobileNumber = "+7 999 999-99-99",
            onSocialMedeaButtonClick = {},
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxWidth()
        )
    }
}

@Composable
fun ProfileBody(
    name: String,
    mobileNumber: String,
    onSocialMedeaButtonClick: (SocialMedia)->Unit,
    modifier: Modifier = Modifier
){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        PersonAvatar(
            size = 200.dp,
            isEdit = false,
            modifier = Modifier. padding(top = 136.dp)
        )
        Text(
            text = name,
            fontSize = MaterialTheme.typography.Heading2.fontSize,
            fontWeight = FontWeight.SemiBold,
            fontFamily = SFProDisplay,
            modifier = Modifier.padding(top = 20.dp)
        )
        Text(
            text = mobileNumber,
            fontSize = MaterialTheme.typography.Subheading2.fontSize,
            fontWeight = FontWeight.Normal,
            fontFamily = SFProDisplay,
            modifier = Modifier.padding(top = 4.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.padding(top = 40.dp)
        ) {
            for (socialMedia in SocialMedia.entries) {
                CustomSocialMedeaButtonOutlined(
                    onClick = {onSocialMedeaButtonClick(socialMedia)},
                    modifier = Modifier,
                    pressedColor = DarkPurple,
                    contentColor = Purple,
                    painter = painterResource(id = socialMedia.icon)
                )
            }
        }
    }
}
