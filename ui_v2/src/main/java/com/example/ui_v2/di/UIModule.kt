package com.example.ui_v2.di

import com.example.ui_v2.ui.screens.SplashScreen.SplashScreenViewModel
import com.example.ui_v2.ui.screens.appointmentScreen.AppointmentScreenViewModel
import com.example.ui_v2.ui.screens.communityScreen.CommunityScreenViewModel
import com.example.ui_v2.ui.screens.eventScreen.EventScreenViewModel
import com.example.ui_v2.ui.screens.mainScreen.MainScreenViewModel
import com.example.ui_v2.ui.screens.onboarding.interestsScreen.InterestsScreenViewModel
import com.example.ui_v2.ui.screens.onboarding.locationScreen.LocationScreenViewModel
import com.example.ui_v2.ui.screens.peopleScreen.PeopleScreenViewModel
import com.example.ui_v2.ui.screens.profileScreen.ProfileScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::SplashScreenViewModel)
    viewModelOf(::InterestsScreenViewModel)
    viewModelOf(::LocationScreenViewModel)
    viewModelOf(::MainScreenViewModel)
    viewModelOf(::EventScreenViewModel)
    viewModelOf(::PeopleScreenViewModel)
    viewModelOf(::CommunityScreenViewModel)
    viewModelOf(::AppointmentScreenViewModel)
    viewModelOf(::ProfileScreenViewModel)
}