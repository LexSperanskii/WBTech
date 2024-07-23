package com.example.spa_wb_junior_devmeetingapp.di

import com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.authenticationScreen.AuthenticationViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.communities.communitiesScreen.CommunitiesViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.communities.communityDetailScreen.CommunityDetailViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.events.eventDetailScreen.EventDetailViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.events.eventsAllScreen.EventsAllViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.eventsUserScreen.EventsUserViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.menuScreen.MenuViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.menu.profileScreen.ProfileViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.registratinProfileScreen.RegistrationProfileViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.splashScreen.SplashScreenViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.screens.registration.verificationScreen.VerificationViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<AuthenticationViewModel> {
        AuthenticationViewModel(
            getAvailableCountriesListUseCase = get(),
            getAvailableCountyUseCase = get(),
            setUserPhoneNumberUseCase = get()
        )
    }

    viewModel<VerificationViewModel> {
        VerificationViewModel(
            getUserPhoneNumberUseCase = get()
        )
    }

    viewModel<RegistrationProfileViewModel> {
        RegistrationProfileViewModel(
            getUserAvatarUseCase = get(),
            setUserNameUseCase = get(),
            setUserSurnameUseCase = get(),
            setUserAvatarUseCase = get()
        )
    }

    viewModel<EventsAllViewModel> {
        EventsAllViewModel(
            getAllEventsUseCase = get(),
            getAllEventsActiveUseCase = get()
        )
    }

    viewModel<EventsUserViewModel> {
        EventsUserViewModel(
            getMyEventsListUseCase = get(),
            getMyEventsPastListUseCase = get()
        )
    }

    viewModel<EventDetailViewModel> {
        EventDetailViewModel(
            getEventDetailsUseCase = get()
        )
    }

    viewModel<CommunitiesViewModel> {
        CommunitiesViewModel(
            getCommunitiesListUseCase = get()
        )
    }

    viewModel<CommunityDetailViewModel> {
        CommunityDetailViewModel(
            getCommunityDetailUseCase = get()
        )
    }

    viewModel<MenuViewModel> {
        MenuViewModel(
            getUserUseCase = get()
        )
    }

    viewModel<ProfileViewModel> {
        ProfileViewModel(
            getUserUseCase = get()
        )
    }
    viewModel<SplashScreenViewModel> {
        SplashScreenViewModel()
    }
}