package com.example.spa_wb_junior_devmeetingapp.di

import com.example.spa_wb_junior_devmeetingapp.models.mapper.IMapperDomainUI
import com.example.spa_wb_junior_devmeetingapp.models.mapper.MapperDomainUI
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.communities.communitiesScreen.CommunitiesViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.communities.communityDetailScreen.CommunityDetailViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.events.eventDetailScreen.EventDetailViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.events.eventsAllScreen.EventsAllViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.menu.eventsUserScreen.EventsUserViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.menu.menuScreen.MenuViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.menu.profileScreen.ProfileViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.registration.authenticationScreen.AuthenticationViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.registration.registratinProfileScreen.RegistrationProfileViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.registration.verificationScreen.VerificationViewModel
import com.example.spa_wb_junior_devmeetingapp.ui.oldUI.splashScreen.SplashScreenViewModel
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