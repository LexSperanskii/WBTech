package com.example.domain.di

import com.example.domain.usecases.communities.GetCommunitiesListUseCase
import com.example.domain.usecases.communities.GetCommunitiesListUseCaseImpl
import com.example.domain.usecases.communities.GetCommunityDetailUseCase
import com.example.domain.usecases.communities.GetCommunityDetailUseCaseImpl
import com.example.domain.usecases.events.AddUserAsParticipantUseCase
import com.example.domain.usecases.events.AddUserAsParticipantUseCaseImpl
import com.example.domain.usecases.events.RemoveUserAsParticipantUseCase
import com.example.domain.usecases.events.RemoveUserAsParticipantUseCaseImpl
import org.koin.dsl.module


val communitiesModule = module {

    single<GetCommunitiesListUseCase> {
        GetCommunitiesListUseCaseImpl(communityRepository = get())
    }
    single<GetCommunityDetailUseCase> {
        GetCommunityDetailUseCaseImpl(communityRepository = get())
    }
    single<AddUserAsParticipantUseCase> {
        AddUserAsParticipantUseCaseImpl(eventRepository = get())
    }
    single<RemoveUserAsParticipantUseCase> {
        RemoveUserAsParticipantUseCaseImpl(eventRepository = get())
    }

}
