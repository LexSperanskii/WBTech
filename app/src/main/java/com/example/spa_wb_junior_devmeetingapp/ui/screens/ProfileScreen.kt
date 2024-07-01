package com.example.spa_wb_junior_devmeetingapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
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
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.PersonAvatar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons.CustomSocialMedeaButtonOutlined
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DarkPurple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraLightGray
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Heading2
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Purple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Subheading2

enum class SocialMedia(val icon: Int) {
    Twitter(R.drawable.twitter_lable),
    Instagram(R.drawable.insta_lable),
    LinkedIn(R.drawable.linkedin_lable),
    Facebook(R.drawable.facebook_lable)
}

@Composable
fun ProfileScreen(
    onClick: () -> Unit = {}
) {
    Scaffold(
        bottomBar = {}
    ) { innerPadding ->
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(innerPadding).fillMaxWidth(),
        ) {
            item {
                PersonAvatar(
                    size = 200.dp,
                    isEdit = false,
                    backgroundColor = ExtraLightGray,
                    painter = painterResource(id = R.drawable.avatar_person),
                    modifier = Modifier. padding(top = 136.dp)
                )
            }
            item {
                Text(
                    text = "Иван Иванов",
                    fontSize = MaterialTheme.typography.Heading2.fontSize,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = SFProDisplay,
                    modifier = Modifier.padding(top = 20.dp)
                )
            }
            item {
                Text(
                    text = "+7 999 999-99-99",
                    fontSize = MaterialTheme.typography.Subheading2.fontSize,
                    fontWeight = FontWeight.Normal,
                    fontFamily = SFProDisplay,
                    modifier = Modifier.padding(top = 4.dp)
                )
            }
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(top = 40.dp)
                ) {
                    for (socialMedia in SocialMedia.entries) {
                        CustomSocialMedeaButtonOutlined(
                            onClick = onClick,
                            modifier = Modifier,
                            pressedColor = DarkPurple,
                            contentColor = Purple,
                            painter = painterResource(id = socialMedia.icon)
                        )
                    }
                }
            }
        }
    }
}
