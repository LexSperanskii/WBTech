package com.example.spa_wb_junior_devmeetingapp.ui.navigation

import com.example.spa_wb_junior_devmeetingapp.R

enum class BottomNavItem(
    val route: String,
    val title: String,
    val icon: Int,
){
    Meetings(route = "Встречи",title = "Встречи", icon = R.drawable.bottom_bar_icon_meetings),
    Communities(route = "Сообщества", title = "Сообщества", icon = R.drawable.bottom_bar_icon_communities),
    Additional(route = "Еще",title = "Еще", icon = R.drawable.bottom_bar_icon_more)
}

enum class EventsAllTabs(val text: String){
    AllMeetings(text = "ВСЕ ВСТРЕЧИ"),
    Active(text = "АКТИВНЫЕ")
}

enum class EventsUserTabs(val text: String){
    Planned(text = "ЗАПЛАНИРОВАНО"),
    HasPassed(text = "УЖЕ ПРОШЛИ")
}