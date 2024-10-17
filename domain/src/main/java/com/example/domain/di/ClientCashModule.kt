package com.example.domain.di

import com.example.domain.interactors.clientCash.IInteractorGetClientCash
import com.example.domain.interactors.clientCash.IInteractorSaveClientCash
import com.example.domain.interactors.clientCash.InteractorGetClientCashImpl
import com.example.domain.interactors.clientCash.InteractorSaveClientCashImpl
import org.koin.dsl.module

val clientCashModule = module {

    single<IInteractorGetClientCash> {
        InteractorGetClientCashImpl(
            clientCashRepository = get(),
            useCase = get(),
            networkRepository = get()
        )
    }
    single<IInteractorSaveClientCash> {
        InteractorSaveClientCashImpl(
            clientCashRepository = get()
        )
    }

}