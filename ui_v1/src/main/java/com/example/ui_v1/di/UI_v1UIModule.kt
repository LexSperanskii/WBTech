package com.example.ui_v1.di

import com.example.ui_v1.models.mapper.UIv1IMapperDomainUI
import com.example.ui_v1.models.mapper.UIv1MapperDomainUI
import com.example.ui_v1.ui.communities.communitiesScreen.CommunitiesViewModel
import com.example.ui_v1.ui.communities.communityDetailScreen.CommunityDetailViewModel
import com.example.ui_v1.ui.events.eventDetailScreen.EventDetailViewModel
import com.example.ui_v1.ui.events.eventsAllScreen.EventsAllViewModel
import com.example.ui_v1.ui.menu.eventsUserScreen.EventsUserViewModel
import com.example.ui_v1.ui.menu.menuScreen.MenuViewModel
import com.example.ui_v1.ui.menu.profileScreen.ProfileViewModel
import com.example.ui_v1.ui.registration.authenticationScreen.AuthenticationViewModel
import com.example.ui_v1.ui.registration.registratinProfileScreen.RegistrationProfileViewModel
import com.example.ui_v1.ui.registration.verificationScreen.VerificationViewModel
import com.example.ui_v1.ui.splashScreen.SplashScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

internal val uiv1UIModule = module {
    single<UIv1IMapperDomainUI> {
        UIv1MapperDomainUI()
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