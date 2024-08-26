package com.example.ui_v2.di

import com.example.ui_v2.ui.ui.newSplashScreen.SplashScreenViewModel
import com.example.ui_v2.ui.ui.onboarding.interestsScreen.InterestsScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val ui_v2Module = module {
    viewModelOf(::SplashScreenViewModel)
    viewModelOf(::InterestsScreenViewModel)
}