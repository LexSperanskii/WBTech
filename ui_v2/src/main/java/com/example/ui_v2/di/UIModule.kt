package com.example.ui_v2.di

import com.example.ui_v2.ui.screens.SplashScreen.SplashScreenViewModel
import com.example.ui_v2.ui.screens.onboarding.interestsScreen.InterestsScreenViewModel
import com.example.ui_v2.ui.screens.onboarding.locationScreen.LocationScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::SplashScreenViewModel)
    viewModelOf(::InterestsScreenViewModel)
    viewModelOf(::LocationScreenViewModel)
}