package com.example.ui_v1.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ui_v1.R
import com.example.ui_v1.models.UIv1CountryModelUI
import com.example.ui_v1.models.UIv1RegisteredPersonModelUI
import com.example.ui_v1.navigation.UIv1NavigationDestination
import com.example.ui_v1.ui.elements.CommunityCard
import com.example.ui_v1.ui.elements.CustomFilterChip
import com.example.ui_v1.ui.elements.EventCard
import com.example.ui_v1.ui.elements.MySearchBar
import com.example.ui_v1.ui.elements.OverlappingPeopleRow
import com.example.ui_v1.ui.elements.PersonAvatar
import com.example.ui_v1.ui.elements.PhoneNumberInput
import com.example.ui_v1.ui.elements.PinCodeInput
import com.example.ui_v1.ui.elements.TypographyItem
import com.example.ui_v1.ui.elements.TypographyRow
import com.example.ui_v1.ui.elements.buttons.CustomButton
import com.example.ui_v1.ui.elements.buttons.CustomButtonOutlined
import com.example.ui_v1.ui.elements.buttons.CustomButtonOutlinedRipple
import com.example.ui_v1.ui.elements.buttons.CustomButtonRipple
import com.example.ui_v1.ui.elements.buttons.CustomButtonText
import com.example.ui_v1.ui.theme.DevMeetingAppTheme

internal object DeveloperDestinationUIv1 : UIv1NavigationDestination {
    override val route = "developer"
    override val title = R.string.developer
}

@Composable
internal fun DeveloperScreen() {
    val typographyList = listOf(
        TypographyItem(
            style = DevMeetingAppTheme.typography.heading1,
            title = "Heading 1",
            subTitle = "SF Pro Display/32/Bold"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.heading2,
            title = "Heading 2",
            subTitle = "SF Pro Display/24/Bold"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.subheading1,
            title = "Subheading 1",
            subTitle = "SF Pro Display/18/SemiBold"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.subheading2,
            title = "Subheading 2",
            subTitle = "SF Pro Display/16/SemiBold"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.bodyText1,
            title = "Body Text 1",
            subTitle = "SF Pro Display/14/SemiBold"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.bodyText2,
            title = "Body Text 2",
            subTitle = "SF Pro Display/14/Regular"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.metadata1,
            title = "Metadata 1",
            subTitle = "SF Pro Display/12/Regular"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.metadata2,
            title = "Metadata 2",
            subTitle = "SF Pro Display/10/Regular"
        ),
        TypographyItem(
            style = DevMeetingAppTheme.typography.metadata3,
            title = "Metadata 3",
            subTitle = "SF Pro Display/10/SemiBold"
        )
    )
    val chipList = listOf(
        "Python",
        "Junior",
        "Moscow"
    )
    val listOfParticipantsForDevScreen = listOf(
        UIv1RegisteredPersonModelUI(
            0,
            "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        UIv1RegisteredPersonModelUI(
            1,
            "https://i.pinimg.com/564x/df/eb/ab/dfebab351d764bc388c05a5f866b46d4.jpg"
        ),
        UIv1RegisteredPersonModelUI(
            2,
            "https://i.pinimg.com/736x/62/e5/50/62e550bc4e1bcc5bfd75b26127e63b6a.jpg"
        ),
        UIv1RegisteredPersonModelUI(
            3,
            "https://i.pinimg.com/564x/f4/e0/c8/f4e0c8655494b4ed5fb490df336c5dcb.jpg"
        ),
        UIv1RegisteredPersonModelUI(
            4,
            "https://i.pinimg.com/564x/25/b9/d5/25b9d5877b216b9edd7fbdd93955d968.jpg"
        ),
        UIv1RegisteredPersonModelUI(
            5,
            "https://i.pinimg.com/564x/07/1e/f4/071ef43b8a3e3a3e32eba626da61faa9.jpg"
        )
    )
    val listOfParticipantsSmallForDevScreen = listOf(
        UIv1RegisteredPersonModelUI(
            0,
            "https://i.pinimg.com/564x/01/01/a5/0101a59c68793d844cc2d23e3cd26274.jpg"
        ),
        UIv1RegisteredPersonModelUI(
            1,
            "https://i.pinimg.com/564x/df/eb/ab/dfebab351d764bc388c05a5f866b46d4.jpg"
        ),
        UIv1RegisteredPersonModelUI(
            2,
            "https://i.pinimg.com/736x/62/e5/50/62e550bc4e1bcc5bfd75b26127e63b6a.jpg"
        )
    )
    val mockAvailableCountriesForDevScreen = listOf(
        UIv1CountryModelUI(
            "Russia",
            "+7",
            "https://i.pinimg.com/564x/42/8d/91/428d9169accc5277fc03a0c41394eb10.jpg"
        ),
        UIv1CountryModelUI(
            "Kazakhstan",
            "+7",
            "https://i.pinimg.com/564x/12/d9/f9/12d9f9633023c5f053a654da6035af7f.jpg"
        ),
        UIv1CountryModelUI(
            "UK",
            "+44",
            "https://i.pinimg.com/564x/aa/7d/c8/aa7dc8130b972fdd4837c19a189717fc.jpg"
        ),
        UIv1CountryModelUI(
            "China",
            "+86",
            "https://i.pinimg.com/564x/51/08/62/510862488ad2a8037423567218afe069.jpg"
        ),
        UIv1CountryModelUI(
            "Germany",
            "+49",
            "https://i.pinimg.com/564x/4c/b7/8b/4cb78bce83b82a83382d18d207423f48.jpg"
        )
    )

    var pinCode by remember { mutableStateOf("") }
    var countryCode by remember { mutableStateOf(mockAvailableCountriesForDevScreen[0]) }
    var phoneNumber by remember { mutableStateOf("") }

    var searchField by remember { mutableStateOf("") }

    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(24.dp)
        ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    PinCodeInput(
                        value = pinCode,
                        onValueChange = { pinCode = it },
                        onDoneKeyboardPressed = {}
                    )
                }
            }
            item {
                PhoneNumberInput(
                    number = phoneNumber,
                    onNumberChange = { phoneNumber = it },
                    countryCode = countryCode,
                    onCountryCodeChange = { countryCode = it },
                    listOfCountriesCodes = mockAvailableCountriesForDevScreen
                )
            }
            item {
                Text(text = "Ripple Effect Buttons")
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomButtonRipple(
                        onClick = {},
                        containerColor = DevMeetingAppTheme.colors.purple,
                        contentColor = Color.White,
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        rippleColor = DevMeetingAppTheme.colors.lightGray,
                        enabled = true,
                    )
                    CustomButtonOutlinedRipple(
                        onClick = {},
                        contentColor = DevMeetingAppTheme.colors.purple,
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        rippleColor = DevMeetingAppTheme.colors.lightGray,
                        enabled = true,
                        border = true
                    )
                    CustomButtonOutlinedRipple(
                        onClick = {},
                        contentColor = DevMeetingAppTheme.colors.purple,
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        rippleColor = DevMeetingAppTheme.colors.lightGray,
                        enabled = true,
                        border = false
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomButtonRipple(
                        onClick = {},
                        containerColor = DevMeetingAppTheme.colors.purple,
                        contentColor = Color.White,
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        rippleColor = DevMeetingAppTheme.colors.lightGray,
                        enabled = false,
                    )
                    CustomButtonOutlinedRipple(
                        onClick = {},
                        contentColor = DevMeetingAppTheme.colors.purple,
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        rippleColor = DevMeetingAppTheme.colors.lightGray,
                        enabled = false,
                        border = true
                    )
                    CustomButtonOutlinedRipple(
                        onClick = {},
                        contentColor = DevMeetingAppTheme.colors.purple,
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        rippleColor = DevMeetingAppTheme.colors.lightGray,
                        enabled = false,
                        border = false
                    )
                }
            }
            item {
                HorizontalDivider(
                    modifier = Modifier,
                    thickness = 2.dp,
                    color = Color.Black
                )
            }
            item {
                Text(text = "No Ripple Effect Buttons")
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomButton(
                        onClick = {},
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        containerColor = DevMeetingAppTheme.colors.purple,
                        contentColor = Color.White
                    )
                    CustomButtonOutlined(
                        onClick = {},
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        containerColor = Color.Transparent,
                        contentColor = DevMeetingAppTheme.colors.purple
                    )
                    CustomButtonText(
                        onClick = {},
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        contentColor = DevMeetingAppTheme.colors.purple
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    CustomButton(
                        onClick = {},
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        containerColor = DevMeetingAppTheme.colors.purple,
                        contentColor = Color.White,
                        enabled = false
                    )
                    CustomButtonOutlined(
                        onClick = {},
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        containerColor = Color.Transparent,
                        contentColor = DevMeetingAppTheme.colors.purple,
                        enabled = false
                    )
                    CustomButtonText(
                        onClick = {},
                        pressedColor = DevMeetingAppTheme.colors.darkPurple,
                        contentColor = DevMeetingAppTheme.colors.purple,
                        enabled = false
                    )
                }
            }
            item {
                typographyList.forEach {
                    TypographyRow(
                        style = it.style,
                        title = it.title,
                        subTitle = it.subTitle,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            }
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    PersonAvatar(
                        size = 200.dp,
                        imageURL = null,
                        isEdit = false
                    )
                    Image(
                        painter = painterResource(id = R.drawable.avatar_meeting),
                        contentDescription = "avatar meeting",
                        modifier = Modifier.size(48.dp),
                        contentScale = ContentScale.Fit
                    )
                }
            }
            item {
                MySearchBar(
                    value = searchField,
                    onValueChange = { searchField = it },
                    onDoneKeyboardPressed = {},
                    modifier = Modifier
                )
            }
            item {
                Row(
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    chipList.forEach {
                        CustomFilterChip(it)
                    }
                }
            }
            item {
                EventCard(
                    eventName = "Developer Meeting",
                    isEventFinished = true,
                    eventDate = "05.14.2023",
                    eventCity = "Москва",
                    eventCategories = listOf("Python", "Junior", "Moscow"),
                    eventIconURL = "",
                    onEventItemClick = {},
                    modifier = Modifier
                )
            }
            item {
                EventCard(
                    eventName = "Developer Meeting",
                    isEventFinished = false,
                    eventDate = "05.14.2023",
                    eventCity = "Москва",
                    eventCategories = listOf("Python", "Junior", "Moscow"),
                    eventIconURL = "",
                    onEventItemClick = {},
                    modifier = Modifier
                )
            }
            item {
                CommunityCard(
                    communityName = "Designa",
                    communitySize = 1000000,
                    communityIconURL = "",
                    onCommunityItemClick = {},
                    modifier = Modifier
                )
            }
            item {
                CommunityCard(
                    communityName = "Designa",
                    communitySize = 1,
                    communityIconURL = "",
                    onCommunityItemClick = {},
                    modifier = Modifier
                )
            }
            item {
                OverlappingPeopleRow(
                    participantsList = listOfParticipantsForDevScreen,
                    modifier = Modifier
                )
            }
            item {
                OverlappingPeopleRow(
                    participantsList = listOfParticipantsSmallForDevScreen,
                    modifier = Modifier
                )
            }
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    PersonAvatar(
                        size = 200.dp,
                        isEdit = false,
                        imageURL = null
                    )
                    PersonAvatar(
                        size = 100.dp,
                        isEdit = true,
                        imageURL = null
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
internal fun FirstScreenPreview() {
    DevMeetingAppTheme {
        Surface {
            DeveloperScreen()
        }
    }
}