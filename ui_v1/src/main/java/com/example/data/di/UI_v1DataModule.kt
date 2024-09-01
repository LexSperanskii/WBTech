package com.example.data.di


import com.example.data.repositoriesImpl.CommunityRepositoryImplUiv1
import com.example.data.repositoriesImpl.CountriesRepositoryImplUiv1
import com.example.data.repositoriesImpl.EventRepositoryImplUiv1
import com.example.data.repositoriesImpl.UserRepositoryImplUiv1
import com.example.domain.repositories.Uiv1ICommunityRepository
import com.example.domain.repositories.Uiv1ICountriesRepository
import com.example.domain.repositories.Uiv1IEventRepository
import com.example.domain.repositories.Uiv1IUserRepository
import org.koin.dsl.module

internal val uiv1DataModule = module {

    single<Uiv1ICountriesRepository> {
        CountriesRepositoryImplUiv1(
            mock = get()
        )
    }

    single<Uiv1IUserRepository> {
        UserRepositoryImplUiv1(
            mock = get()
        )
    }

    single<Uiv1IEventRepository> {
        EventRepositoryImplUiv1(
            mock = get()
        )
    }

    single<Uiv1ICommunityRepository> {
        CommunityRepositoryImplUiv1(
            mock = get()
        )
    }

}