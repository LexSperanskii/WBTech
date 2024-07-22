package com.example.data.di

import com.example.data.repositoriesImpl.CountriesRepositoryImpl
import com.example.data.repositoriesImpl.UserRepositoryImpl
import com.example.domain.repositories.ICountriesRepository
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
}