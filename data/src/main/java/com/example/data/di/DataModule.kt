package com.example.data.di

import com.example.data.repositoriesImpl.DataStoreRepositoryImpl
import com.example.data.repositoriesImpl.NetworkRepositoryImpl
import com.example.domain.repositories.IDataStoreRepository
import com.example.domain.repositories.INetworkRepository
import org.koin.dsl.module

val dataModule = module {

    single<INetworkRepository> {
        NetworkRepositoryImpl(
            mock = get()
        )
    }

    single<IDataStoreRepository> {
        DataStoreRepositoryImpl(
            context = get()
        )
    }
}