package com.example.spa_wb_junior_devmeetingapp.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.spa_wb_junior_devmeetingapp.R
import com.example.spa_wb_junior_devmeetingapp.ui.mockData.PhoneNumber
import com.example.spa_wb_junior_devmeetingapp.ui.mockData.mockAccountName
import com.example.spa_wb_junior_devmeetingapp.ui.mockData.mockAccountNumber
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.NavigationDestination
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.BottomNavigationBar
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.MenuItem
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.MenuItemForMyEvents
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.MenuItemProfile
import com.example.spa_wb_junior_devmeetingapp.ui.screens.elements.TopAppBarBackNameAction
import com.example.spa_wb_junior_devmeetingapp.ui.theme.LightGray

object MenuDestination : NavigationDestination {
    override val route = "menu"
    override val title = R.string.more
}

@Composable
fun MenuScreen(
    navController: NavHostController,
    navigateToProfile: () -> Unit,
    navigateToUserEvents: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBarBackNameAction(
                title = stringResource(id = MenuDestination.title),
                isNavigateBack = false,
                isAddCapable = false
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController
            )
        }
    ) { innerPadding ->
        MenuBody(
            modifier = Modifier.padding(innerPadding),
            onProfileClick = navigateToProfile,
            profileName = mockAccountName,
            profilePhoneNumber = mockAccountNumber,
            onMyEventsClick = navigateToUserEvents,
            onThemeClick = {},
            onNotificationsClick = {},
            onSecurityClick = {},
            onStorageAndAssetsClick = {},
            onHelpClick = {},
            onInviteFriendClick = {}
        )
    }
}

@Composable
fun MenuBody(
    onProfileClick : ()->Unit,
    profileName : String,
    profilePhoneNumber: PhoneNumber,
    onMyEventsClick: () -> Unit,
    onThemeClick: () -> Unit,
    onNotificationsClick: () -> Unit,
    onSecurityClick: () -> Unit,
    onStorageAndAssetsClick: () -> Unit,
    onHelpClick: () -> Unit,
    onInviteFriendClick: () -> Unit,
    modifier: Modifier = Modifier
    ){
    LazyColumn(
        modifier = modifier
    ) {
        item {
            MenuItemProfile(
                onProfileClick = onProfileClick,
                profileName = profileName,
                mobileNumber = profilePhoneNumber,
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
        item {
            MenuItemForMyEvents(
                onMenuItemClick = onMyEventsClick,
                menuItemIcon = painterResource(id = R.drawable.bottom_bar_icon_meetings),
                menuItemName = stringResource(id = R.string.my_events),
                modifier = Modifier.padding(bottom = 8.dp)

            )
        }
        item {
            MenuItem(
                onMenuItemClick = onThemeClick,
                menuItemIcon = painterResource(id = R.drawable.icon_theme),
                menuItemName = stringResource(id = R.string.my_theme),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
        item {
            MenuItem(
                onMenuItemClick = onNotificationsClick,
                menuItemIcon = painterResource(id = R.drawable.icon_notifications),
                menuItemName = stringResource(id = R.string.my_notifications),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            )
        }
        item {
            MenuItem(
                onMenuItemClick = onSecurityClick,
                menuItemIcon = painterResource(id = R.drawable.icon_security),
                menuItemName = stringResource(id = R.string.my_security),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            )
        }
        item {
            MenuItem(
                onMenuItemClick = onStorageAndAssetsClick,
                menuItemIcon = painterResource(id = R.drawable.icon_storage),
                menuItemName = stringResource(id = R.string.my_storage),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            )
        }
        item {
            HorizontalDivider(
                thickness = 1.dp,
                color = LightGray,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            )
        }
        item {
            MenuItem(
                onMenuItemClick = onHelpClick,
                menuItemIcon = painterResource(id = R.drawable.icon_help),
                menuItemName = stringResource(id = R.string.my_help),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            )
        }
        item {
            MenuItem(
                onMenuItemClick = onInviteFriendClick,
                menuItemIcon = painterResource(id = R.drawable.icon_invite),
                menuItemName = stringResource(id = R.string.my_invite),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            )
        }
    }
}