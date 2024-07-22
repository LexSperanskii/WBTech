package com.example.spa_wb_junior_devmeetingapp.di

import com.example.spa_wb_junior_devmeetingapp.models.mapper.Mapper
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

    single { Mapper() }

    viewModel<AuthenticationViewModel> {
        AuthenticationViewModel(
            mapper = get(),
            getAvailableCountriesListUseCase = get(),
            getAvailableCountyUseCase = get(),
            setUserPhoneNumberUseCase = get()
        )
    }

    viewModel<VerificationViewModel> {
        VerificationViewModel(
            mapper = get(),
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
            mapper = get(),
            getAllEventsUseCase = get(),
            getAllEventsActiveUseCase = get()
        )
    }

    viewModel<EventsUserViewModel> {
        EventsUserViewModel(
            mapper = get(),
            getMyEventsListUseCase = get(),
            getMyEventsPastListUseCase = get()
        )
    }

    viewModel<EventDetailViewModel> {
        EventDetailViewModel(
            mapper = get(),
            getEventDetailsUseCase = get()
        )
    }

    viewModel<CommunitiesViewModel> {
        CommunitiesViewModel(
            mapper = get(),
            getCommunitiesListUseCase = get()
        )
    }

    viewModel<CommunityDetailViewModel> {
        CommunityDetailViewModel(
            mapper = get(),
            getCommunityDetailUseCase = get()
        )
    }

    viewModel<MenuViewModel> {
        MenuViewModel(
            mapper = get(),
            getUserUseCase = get()
        )
    }

    viewModel<ProfileViewModel> {
        ProfileViewModel(
            mapper = get(),
            getUserUseCase = get()
        )
    }
    viewModel<SplashScreenViewModel> {
        SplashScreenViewModel()
    }
}