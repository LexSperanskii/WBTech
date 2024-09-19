package com.example.ui_v2.di

import com.example.ui_v2.models.mapper.IMapperDomainUI
import com.example.ui_v2.models.mapper.MapperDomainUIImpl
import com.example.ui_v2.ui.screens.SplashScreen.SplashScreenViewModel
import com.example.ui_v2.ui.screens.appointmentScreen.appointmentSplash.AppointmentSplashScreenViewModel
import com.example.ui_v2.ui.screens.appointmentScreen.nameSurname.AppointmentNameSurnameScreenViewModel
import com.example.ui_v2.ui.screens.appointmentScreen.phoneNumber.AppointmentPhoneNumberScreenViewModel
import com.example.ui_v2.ui.screens.appointmentScreen.verificationCode.AppointmentVerificationScreenViewModel
import com.example.ui_v2.ui.screens.communityScreen.CommunityScreenViewModel
import com.example.ui_v2.ui.screens.eventScreen.EventScreenViewModel
import com.example.ui_v2.ui.screens.mainScreen.MainScreenViewModel
import com.example.ui_v2.ui.screens.onboarding.interestsScreen.InterestsScreenViewModel
import com.example.ui_v2.ui.screens.onboarding.locationScreen.LocationScreenViewModel
import com.example.ui_v2.ui.screens.participantsScreen.ParticipantsScreenViewModel
import com.example.ui_v2.ui.screens.userScreen.deleteProfile.DeleteProfileScreenViewModel
import com.example.ui_v2.ui.screens.userScreen.profileEdit.ProfileEditScreenViewModel
import com.example.ui_v2.ui.screens.userScreen.profileEditPhoto.ProfileEditPhotoScreenViewModel
import com.example.ui_v2.ui.screens.userScreen.profileInterests.ProfileInterestsScreenViewModel
import com.example.ui_v2.ui.screens.userScreen.userInside.UserInsideScreenViewModel
import com.example.ui_v2.ui.screens.userScreen.userOutside.UserOutsideScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val uiModule = module {
    single<IMapperDomainUI> {
        MapperDomainUIImpl()
    }
    viewModelOf(::SplashScreenViewModel)
    viewModelOf(::InterestsScreenViewModel)
    viewModelOf(::LocationScreenViewModel)
    viewModelOf(::MainScreenViewModel)
    viewModelOf(::EventScreenViewModel)
    viewModelOf(::ParticipantsScreenViewModel)
    viewModelOf(::CommunityScreenViewModel)
    viewModelOf(::AppointmentNameSurnameScreenViewModel)
    viewModelOf(::AppointmentPhoneNumberScreenViewModel)
    viewModelOf(::AppointmentVerificationScreenViewModel)
    viewModelOf(::AppointmentSplashScreenViewModel)
    viewModelOf(::UserOutsideScreenViewModel)
    viewModelOf(::UserInsideScreenViewModel)
    viewModelOf(::ProfileEditScreenViewModel)
    viewModelOf(::ProfileInterestsScreenViewModel)
    viewModelOf(::DeleteProfileScreenViewModel)
    viewModelOf(::ProfileEditPhotoScreenViewModel)
}