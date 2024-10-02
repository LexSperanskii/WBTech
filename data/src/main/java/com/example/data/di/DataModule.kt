package com.example.data.di

import com.example.data.repositoriesImpl.NetworkClientRepositoryImpl
import com.example.data.repositoriesImpl.NetworkRepositoryImpl
import com.example.domain.repositories.INetworkClientRepository
import com.example.domain.repositories.INetworkRepository
import org.koin.dsl.module

val dataModule = module {

    single<INetworkRepository> {
        NetworkRepositoryImpl(
            mock = get()
        )
    }

    single<INetworkClientRepository> {
        NetworkClientRepositoryImpl(
            mock = get()
        )
    }

}