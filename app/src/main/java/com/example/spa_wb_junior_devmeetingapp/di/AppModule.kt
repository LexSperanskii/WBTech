package com.example.spa_wb_junior_devmeetingapp.di

import com.example.spa_wb_junior_devmeetingapp.ui.screens.authenticationScreen.AuthenticationViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.communitiesScreen.CommunitiesViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.communityDetailScreen.CommunityDetailViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.eventDetailScreen.EventDetailViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.eventsAllScreen.EventsAllViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.eventsUserScreen.EventsUserViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.menuScreen.MenuViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.profileScreen.ProfileViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.registratinProfileScreen.RegistrationProfileViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.splashScreen.SplashScreenViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.verificationScreen.VerificationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<AuthenticationViewModel> {
        AuthenticationViewModel()
    }

    viewModel<VerificationViewModel> {
        VerificationViewModel()
    }

    viewModel<RegistrationProfileViewModel> {
        RegistrationProfileViewModel()
    }

    viewModel<EventsAllViewModel> {
        EventsAllViewModel()
    }

    viewModel<EventsUserViewModel> {
        EventsUserViewModel()
    }

    viewModel<EventDetailViewModel> {
        EventDetailViewModel()
    }

    viewModel<CommunitiesViewModel> {
        CommunitiesViewModel()
    }

    viewModel<CommunityDetailViewModel> {
        CommunityDetailViewModel()
    }

    viewModel<MenuViewModel> {
        MenuViewModel()
    }

    viewModel<ProfileViewModel> {
        ProfileViewModel()
    }
    viewModel<SplashScreenViewModel> {
        SplashScreenViewModel()
    }
}