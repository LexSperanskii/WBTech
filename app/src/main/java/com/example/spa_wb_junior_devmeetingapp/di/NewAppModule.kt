package com.example.spa_wb_junior_devmeetingapp.di

import com.example.spa_wb_junior_devmeetingapp.ui.newUi.newSplashScreen.NewSplashScreenViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.newUi.onboarding.interestsScreen.InterestsScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val newAppModule = module {
    viewModelOf(::NewSplashScreenViewModel)
    viewModelOf(::InterestsScreenViewModel)
}