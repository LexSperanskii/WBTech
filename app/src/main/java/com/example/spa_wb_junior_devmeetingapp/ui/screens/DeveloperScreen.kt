package com.example.spa_wb_junior_devmeetingapp.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.AvatarColumn
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons.CustomButton
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons.CustomButtonOutlined
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons.CustomButtonText
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons.CustomButtonRipple
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons.CustomButtonOutlinedRipple
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.CustomFilterChip
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.MySearchBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.CommunityCard
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.EventCard
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.OverlappingPeopleRow
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.PersonAvatar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TypographyItem
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TypographyRow
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText2
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DarkPurple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Heading1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Heading2
import com.example.spa_wb_junior_devmeetingapp.ui.theme.LightGray
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Metadata1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Metadata2
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Metadata3
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Purple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SpA_WB_Junior_DevMeetingAppTheme
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Subheading1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Subheading2

@Composable
fun DeveloperScreen() {
    val typographyList = listOf(
        TypographyItem(
            fontSize = MaterialTheme.typography.Heading1.fontSize,
            fontWeight = FontWeight.Bold,
            title = "Heading 1",
            subTitle = "SF Pro Display/32/Bold"
        ),
        TypographyItem(
            fontSize = MaterialTheme.typography.Heading2.fontSize,
            fontWeight = FontWeight.Bold,
            title = "Heading 2",
            subTitle = "SF Pro Display/24/Bold"
        ),
        TypographyItem(
            fontSize = MaterialTheme.typography.Subheading1.fontSize,
            fontWeight = FontWeight.SemiBold,
            title = "Subheading 1",
            subTitle = "SF Pro Display/18/SemiBold"
        ),
        TypographyItem(
            fontSize = MaterialTheme.typography.Subheading2.fontSize,
            fontWeight = FontWeight.SemiBold,
            title = "Subheading 2",
            subTitle = "SF Pro Display/16/SemiBold"
        ),
        TypographyItem(
            fontSize = MaterialTheme.typography.BodyText1.fontSize,
            fontWeight = FontWeight.SemiBold,
            title = "Body Text 1",
            subTitle = "SF Pro Display/14/SemiBold"
        ),
        TypographyItem(
            fontSize = MaterialTheme.typography.BodyText2.fontSize,
            fontWeight = FontWeight.Normal,
            title = "Body Text 2",
            subTitle = "SF Pro Display/14/Regular"
        ),
        TypographyItem(
            fontSize = MaterialTheme.typography.Metadata1.fontSize,
            fontWeight = FontWeight.Normal,
            title = "Metadata 1",
            subTitle = "SF Pro Display/12/Regular"
        ),
        TypographyItem(
            fontSize = MaterialTheme.typography.Metadata2.fontSize,
            fontWeight = FontWeight.Normal,
            title = "Metadata 2",
            subTitle = "SF Pro Display/10/Regular"
        ),
        TypographyItem(
            fontSize = MaterialTheme.typography.Metadata3.fontSize,
            fontWeight = FontWeight.SemiBold,
            title = "Metadata 3",
            subTitle = "SF Pro Display/10/SemiBold"
        )
    )
    val chipList = listOf(
        "Python",
        "Junior",
        "Moscow"
    )
    val mockList1 = MutableList(50) { R.drawable.pepa }
    mockList1.add(2, R.drawable.avatar_meeting)
    mockList1.add(4, R.drawable.avatar_community)
    val mockList2 = MutableList(4) { R.drawable.pepa }
    Scaffold(
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(16.dp)
        ) {
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
                        containerColor = Purple,
                        contentColor = Color.White,
                        pressedColor = DarkPurple,
                        rippleColor = LightGray,
                        enabled = true,
                    )
                    CustomButtonOutlinedRipple(
                        onClick = {},
                        contentColor = Purple,
                        pressedColor = DarkPurple,
                        rippleColor = LightGray,
                        enabled = true,
                        border = true
                    )
                    CustomButtonOutlinedRipple(
                        onClick = {},
                        contentColor = Purple,
                        pressedColor = DarkPurple,
                        rippleColor = LightGray,
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
                        containerColor = Purple,
                        contentColor = Color.White,
                        pressedColor = DarkPurple,
                        rippleColor = LightGray,
                        enabled = false,
                    )
                    CustomButtonOutlinedRipple(
                        onClick = {},
                        contentColor = Purple,
                        pressedColor = DarkPurple,
                        rippleColor = LightGray,
                        enabled = false,
                        border = true
                    )
                    CustomButtonOutlinedRipple(
                        onClick = {},
                        contentColor = Purple,
                        pressedColor = DarkPurple,
                        rippleColor = LightGray,
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
                ){
                    CustomButton(
                        onClick = {},
                        pressedColor = DarkPurple,
                        containerColor = Purple,
                        contentColor = Color.White
                    )
                    CustomButtonOutlined(
                        onClick = {},
                        pressedColor = DarkPurple,
                        containerColor = Color. Transparent,
                        contentColor = Purple
                    )
                    CustomButtonText(
                        onClick = {},
                        pressedColor = DarkPurple,
                        containerColor = Color. Transparent,
                        contentColor = Purple
                    )
                }
            }
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    CustomButton(
                        onClick = {},
                        pressedColor = DarkPurple,
                        containerColor = Purple,
                        contentColor = Color.White,
                        enabled = false
                    )
                    CustomButtonOutlined(
                        onClick = {},
                        pressedColor = DarkPurple,
                        containerColor = Color. Transparent,
                        contentColor = Purple,
                        enabled = false
                    )
                    CustomButtonText(
                        onClick = {},
                        pressedColor = DarkPurple,
                        containerColor = Color.Transparent,
                        contentColor = Purple,
                        enabled = false
                    )
                }
            }
            item {
                typographyList.forEach{
                    TypographyRow(
                        title = it.title,
                        subTitle = it.subTitle,
                        fontSize = it.fontSize,
                        fontWeight = it.fontWeight,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                }
            }
            item {
                AvatarColumn(modifier = Modifier)
            }
            item {
                MySearchBar(modifier = Modifier)
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
                    nameOfMeeting = "Developer Meeting",
                    statusOfMeeting = "Закончилась",
                    date = "13.09.2024",
                    place = "Москва",
                    listOfCategory = listOf("Python", "Junior", "Moscow"),
                    modifier = Modifier
                )
            }
            item {
                EventCard(
                    nameOfMeeting = "Developer Meeting",
                    statusOfMeeting = "",
                    date = "14.09.2024",
                    place = "Москва",
                    listOfCategory = listOf("Python", "Junior", "Moscow"),
                    modifier = Modifier
                )
            }
            item {
                CommunityCard(
                    nameOfCommunity = "Designa",
                    sizeOfCommunity = 1000000,
                    modifier = Modifier
                )
            }
            item {
                CommunityCard(
                    nameOfCommunity = "Designa",
                    sizeOfCommunity = 1,
                    modifier = Modifier
                )
            }
            item {
                OverlappingPeopleRow(
                    accountsList = mockList1,
                    modifier = Modifier
                )
            }
            item {
                OverlappingPeopleRow(
                    accountsList = mockList2,
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
                    )
                    PersonAvatar(
                        size = 100.dp,
                        isEdit = true,
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    SpA_WB_Junior_DevMeetingAppTheme {
        Surface() {
            DeveloperScreen()
        }
    }
}