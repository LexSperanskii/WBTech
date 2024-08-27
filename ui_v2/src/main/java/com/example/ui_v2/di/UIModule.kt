package com.example.ui_v2.di

import com.example.ui_v2.ui.SplashScreen.SplashScreenViewModel
import com.example.ui_v2.ui.onboarding.interestsScreen.InterestsScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    viewModelOf(::SplashScreenViewModel)
    viewModelOf(::InterestsScreenViewModel)
}