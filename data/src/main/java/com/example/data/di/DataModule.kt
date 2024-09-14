package com.example.data.di

import com.example.data.dataStore.IUserPreferences
import com.example.data.dataStore.UserPreferencesImpl
import com.example.data.repositoriesImpl.NetworkRepositoryImpl
import com.example.domain.repositories.INetworkRepository
import org.koin.dsl.module

val dataModule = module {

    single<INetworkRepository> {
        NetworkRepositoryImpl(
            mock = get()
        )
    }

    single<IUserPreferences> {
        UserPreferencesImpl(
            context = get()
        )
    }
}