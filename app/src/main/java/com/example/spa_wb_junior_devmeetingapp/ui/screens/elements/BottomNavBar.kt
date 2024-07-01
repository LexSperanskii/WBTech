package com.example.spa_wb_junior_devmeetingapp.ui.screens.elements

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.spa_wb_junior_devmeetingapp.ui.navigation.BottomNavItem
import com.example.spa_wb_junior_devmeetingapp.ui.theme.BodyText1
import com.example.spa_wb_junior_devmeetingapp.ui.theme.DeepBlueForBottomBar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.ExtraDarkPurpleForBottomBar
import com.example.spa_wb_junior_devmeetingapp.ui.theme.SFProDisplay

@Composable
fun BottomNavigationBar(navController: NavController) {

    var selectedTabIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    NavigationBar(
        containerColor = Color.White
    ) {
        // looping over each tab to generate the views and navigation for each item
        BottomNavItem.entries.forEachIndexed { index, tabBarItem ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    navController.navigate(tabBarItem.route)
                },
                icon = {
                    if (selectedTabIndex == index){
                        Column(
                            verticalArrangement = Arrangement.spacedBy(4.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = tabBarItem.title,
                                fontSize = MaterialTheme.typography.BodyText1.fontSize,
                                fontWeight = FontWeight.SemiBold,
                                fontFamily = SFProDisplay,
                                color = ExtraDarkPurpleForBottomBar
                            )
                            Box(
                                modifier = Modifier
                                    .size(4.dp)
                                    .background(ExtraDarkPurpleForBottomBar, shape = CircleShape)
                            )
                        }
                    } else {
                        Icon(
                            painter = painterResource(id = tabBarItem.icon),
                            contentDescription = tabBarItem.title,
                            tint = DeepBlueForBottomBar,
                            modifier = Modifier
                        )
                    }
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent // Прозрачный цвет для индикатора
                ),
            )
        }
    }
}