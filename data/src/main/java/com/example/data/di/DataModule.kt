package com.example.data.di

import com.example.data.dataStore.IUserPreferences
import com.example.data.dataStore.UserPreferencesImpl
import com.example.data.repositoriesImpl.CommunityRepositoryImpl
import com.example.data.repositoriesImpl.CountriesRepositoryImpl
import com.example.data.repositoriesImpl.EventRepositoryImpl
import com.example.data.repositoriesImpl.UserRepositoryImpl
import com.example.domain.repositories.ICommunityRepository
import com.example.domain.repositories.ICountriesRepository
import com.example.domain.repositories.IEventRepository
import com.example.domain.repositories.IUserRepository
import org.koin.dsl.module

val dataModule = module {

    single<ICountriesRepository> {
        CountriesRepositoryImpl(
            mock = get()
        )
    }

    single<IUserRepository> {
        UserRepositoryImpl(
            mock = get()
        )
    }

    single<IEventRepository> {
        EventRepositoryImpl(
            mock = get()
        )
    }

    single<ICommunityRepository> {
        CommunityRepositoryImpl(
            mock = get()
        )
    }

    single<IUserPreferences> {
        UserPreferencesImpl(
            context = get()
        )
    }
}