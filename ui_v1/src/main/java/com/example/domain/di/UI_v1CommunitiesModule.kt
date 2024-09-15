package com.example.domain.di

import com.example.domain.usecase.communities.Uiv1GetCommunitiesListUseCase
import com.example.domain.usecase.communities.Uiv1GetCommunitiesListUseCaseImpl
import com.example.domain.usecase.communities.Uiv1GetCommunityDetailUseCase
import com.example.domain.usecase.communities.Uiv1GetCommunityDetailUseCaseImpl
import com.example.domain.usecase.events.Uiv1AddUserAsParticipantUseCase
import com.example.domain.usecase.events.Uiv1AddUserAsParticipantUseCaseImpl
import com.example.domain.usecase.events.Uiv1RemoveUserAsParticipantUseCase
import com.example.domain.usecase.events.Uiv1RemoveUserAsParticipantUseCaseImpl
import org.koin.dsl.module


internal val uiv1CommunitiesModule = module {

    single<Uiv1GetCommunitiesListUseCase> {
        Uiv1GetCommunitiesListUseCaseImpl(communityRepository = get())
    }
    single<Uiv1GetCommunityDetailUseCase> {
        Uiv1GetCommunityDetailUseCaseImpl(communityRepository = get())
    }
    single<Uiv1AddUserAsParticipantUseCase> {
        Uiv1AddUserAsParticipantUseCaseImpl(eventRepository = get())
    }
    single<Uiv1RemoveUserAsParticipantUseCase> {
        Uiv1RemoveUserAsParticipantUseCaseImpl(eventRepository = get())
    }

}
