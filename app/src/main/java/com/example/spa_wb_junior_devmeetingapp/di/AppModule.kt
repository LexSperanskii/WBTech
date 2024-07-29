package com.example.spa_wb_junior_devmeetingapp.di

import com.example.spa_wb_junior_devmeetingapp.models.mapper.IMapperDomainUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.MapperDomainUI
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
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<IMapperDomainUI> {
        MapperDomainUI()
    }
    viewModelOf(::AuthenticationViewModel)
    viewModelOf(::VerificationViewModel)
    viewModelOf(::RegistrationProfileViewModel)
    viewModelOf(::EventsAllViewModel)
    viewModelOf(::EventsUserViewModel)
    viewModelOf(::EventDetailViewModel)
    viewModelOf(::CommunitiesViewModel)
    viewModelOf(::CommunityDetailViewModel)
    viewModelOf(::MenuViewModel)
    viewModelOf(::ProfileViewModel)
    viewModelOf(::SplashScreenViewModel)
}