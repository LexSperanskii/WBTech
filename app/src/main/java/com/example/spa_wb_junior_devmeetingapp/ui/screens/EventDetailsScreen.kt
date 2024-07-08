package com.example.spa_wb_junior_devmeetingapp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.mockData.MockEventItem
import com.example.spa_wb_junior_devmeetingapp.ui.mockData.longText
import com.example.spa_wb_junior_devmeetingapp.ui.mockData.mockAccountsIconsURLList1
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.OverlappingPeopleRow
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.buttons.CustomButton
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DarkPurple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.LightDarkGray
import com.example.spa_wb_junior_devmeetingapp.ui.theme.LightPurple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Metadata1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Metadata2
import com.example.spa_wb_junior_devmeetingapp.ui.theme.Purple
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay

object EventDetailsDestination : NavigationDestination {
    override val route = "event_details"
    override val title = R.string.events_details
    const val itemIdArg = "itemId"
    val routeWithArgs = "${route}/{$itemIdArg}"
}

@Composable
fun EventDetailsScreen(
    navController: NavHostController,
    navigateToFullScreenMap : () -> Unit,
    event: MockEventItem
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    )
    { innerPadding ->
        EventDetailsBody(
            event = event,
            accountsIconsURLList = mockAccountsIconsURLList1,
            onButtonClick = {},
            onMapClick = navigateToFullScreenMap,
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(
                    start = 24.dp, end = 24.dp, top = 16.dp, bottom = 20.dp
                )
        )
    }
}

@Composable
fun EventDetailsBody(
    event : MockEventItem,
    accountsIconsURLList: List<String>,
    onButtonClick : ()-> Unit,
    onMapClick : ()-> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        Text(
            text = stringResource(id = R.string.event_date_place,event.eventDate,event.eventPlace),
            fontSize = MaterialTheme.typography.BodyText1.fontSize,
            fontWeight = FontWeight.SemiBold,
            fontFamily = SFProDisplay,
            color = LightDarkGray,
            modifier = Modifier.padding(bottom = 2.dp)
        )
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            items(event.eventCategory){ item ->
                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(40.dp))
                        .background(LightPurple)
                        .padding(horizontal = 8.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = item,
                        fontSize = MaterialTheme.typography.Metadata2.fontSize,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = SFProDisplay,
                        color = DarkPurple,
                        lineHeight = 16.sp
                    )
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.map),
            contentDescription = stringResource(id = R.string.map),
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(2f)// Соотношение сторон 2:1 (ширина в два раза больше высоты)
                .clip(RoundedCornerShape(24.dp))
                .clickable { onMapClick() },
            contentScale = ContentScale.Crop
        )
        Text(
            text = longText,
            fontSize = MaterialTheme.typography.Metadata1.fontSize,
            fontWeight = FontWeight.Normal,
            fontFamily = SFProDisplay,
            color = LightDarkGray,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .padding(vertical = 20.dp)
                .heightIn(min = 0.dp, max = 172.dp)
        )
        OverlappingPeopleRow(
            accountsIconsURLList = accountsIconsURLList
        )
        Spacer(modifier = Modifier.weight(1f))
        CustomButton(
            text = stringResource(id = R.string.i_will_go_to_the_event),
            onClick = onButtonClick,
            pressedColor = DarkPurple,
            containerColor = Purple,
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        )
    }
}